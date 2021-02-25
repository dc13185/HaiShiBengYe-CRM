package com.ruoyi.busi.qutsourcing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.busi.Constant;
import com.ruoyi.busi.cost.domain.BusiOutsourcingCost;
import com.ruoyi.busi.cost.service.IBusiOutsourcingCostService;
import com.ruoyi.busi.domain.BusiMotor;
import com.ruoyi.busi.mapper.BusiPriceDetailsMapper;
import com.ruoyi.busi.outsourcing.domain.BusiOutsourcing;
import com.ruoyi.busi.outsourcing.service.IBusiOutsourcingService;
import com.ruoyi.busi.service.IBusiMotorService;
import com.ruoyi.busi.service.IBusiQuotationService;
import com.ruoyi.common.utils.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.busi.qutsourcing.domain.BusiOutsourcingDetails;
import com.ruoyi.busi.qutsourcing.service.IBusiOutsourcingDetailsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 外购报价明细Controller
 *
 * @author ruoyi
 * @date 2021-01-30
 */
@Controller
@RequestMapping("/busi/outsourcing/details")
public class BusiOutsourcingDetailsController extends BaseController
{
    private String prefix = "busi/outsourcing/details";

    @Autowired
    private IBusiOutsourcingService busiOutsourcingService;

    @Autowired
    private IBusiOutsourcingDetailsService busiOutsourcingDetailsService;

    @Autowired
    private IBusiMotorService busiMotorService;

    @Autowired
    private BusiPriceDetailsMapper busiPriceDetailsMapper;

    @Autowired
    private IBusiOutsourcingCostService busiOutsourcingCostService;

    @RequiresPermissions("busi:details:view")
    @GetMapping()
    public String details(String quotationId,ModelMap modelMap)
    {
        modelMap.put("quotationId",quotationId);
        return prefix + "/details";
    }

    /**
     * 查询外购报价明细列表
     */
    @RequiresPermissions("busi:details:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiOutsourcingDetails busiOutsourcingDetails)
    {
        startPage();
        List<BusiOutsourcingDetails> list = busiOutsourcingDetailsService.selectBusiOutsourcingDetailsList(busiOutsourcingDetails);
        return getDataTable(list);
    }

    /**
     * 导出外购报价明细列表
     */
    @RequiresPermissions("busi:details:export")
    @Log(title = "外购报价明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiOutsourcingDetails busiOutsourcingDetails)
    {
        List<BusiOutsourcingDetails> list = busiOutsourcingDetailsService.selectBusiOutsourcingDetailsList(busiOutsourcingDetails);
        ExcelUtil<BusiOutsourcingDetails> util = new ExcelUtil<BusiOutsourcingDetails>(BusiOutsourcingDetails.class);
        return util.exportExcel(list, "details");
    }

    /**
     * 新增外购报价明细
     */
    @GetMapping("/add")
    public String add(String quotationId,ModelMap modelMap)
    {
        modelMap.put("quotationId",quotationId);
        return prefix + "/add";
    }

    /**
     * 新增保存外购报价明细
     */
    @RequiresPermissions("busi:details:add")
    @Log(title = "外购报价明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiOutsourcingDetails busiOutsourcingDetails)
    {
        Double motorPrice = 0d ;
        BusiOutsourcing busiOutsourcing = busiOutsourcingService.selectBusiOutsourcingById(busiOutsourcingDetails.getModelId());
        //电机成本
        if (busiOutsourcingDetails.getMotorId() != null){
            BusiMotor busiMotor = busiMotorService.selectBusiMotorById(busiOutsourcingDetails.getMotorId());
            motorPrice =  motorPrice + busiMotor.getPrice();
        }
        if (busiOutsourcingDetails.getOtherMotorPrice() != null){
            motorPrice = motorPrice + busiOutsourcingDetails.getOtherMotorPrice();
        }
        //外购报价 泵头成本（来源于供应商）*（1+外购泵配套管理费用）+电机成本*（1+外购件配套管理费比例）
        Double allPrice = ((busiOutsourcing.getOutsourcingPrice()) * (1 + Constant.PROPORTION_OF_MANAGEMENT_FEE_PURCHASED)) + (motorPrice * (1 + Constant.PROPORTION_MANAGEMENT));
        busiOutsourcingDetails.setDetailsPrice(StringUtils.doubleFormat(allPrice));
        busiOutsourcingDetails.setQuotationType(1L);
        //泵头成本
        busiOutsourcingDetails.setPumpHeadCost(busiOutsourcing.getOutsourcingPrice());
        busiOutsourcingDetails.setMotorCost(motorPrice);
        busiOutsourcingDetails.setAllCost(StringUtils.doubleFormat(busiOutsourcing.getOutsourcingPrice()+motorPrice));
        //先进行保存 保存完毕重新统计
        int i = busiOutsourcingDetailsService.insertBusiOutsourcingDetails(busiOutsourcingDetails);
        if (i > 0){
            reStatistics(busiOutsourcingDetails);
        }
        return toAjax(1);
    }

    /**
     * 修改外购报价明细
     */
    @GetMapping("/edit/{detailsId}")
    public String edit(@PathVariable("detailsId") Long detailsId, ModelMap mmap)
    {
        BusiOutsourcingDetails busiOutsourcingDetails = busiOutsourcingDetailsService.selectBusiOutsourcingDetailsById(detailsId);
        mmap.put("busiOutsourcingDetails", busiOutsourcingDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存外购报价明细
     */
    @RequiresPermissions("busi:details:edit")
    @Log(title = "外购报价明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiOutsourcingDetails busiOutsourcingDetails)
    {
        Double motorPrice = 0d ;
        BusiOutsourcing busiOutsourcing = busiOutsourcingService.selectBusiOutsourcingById(busiOutsourcingDetails.getModelId());
        //电机成本
        if (busiOutsourcingDetails.getMotorId() != null){
            BusiMotor busiMotor = busiMotorService.selectBusiMotorById(busiOutsourcingDetails.getMotorId());
            motorPrice =  busiMotor.getPrice();
        }else if (busiOutsourcingDetails.getOtherMotorPrice() != null){
            motorPrice =  busiOutsourcingDetails.getOtherMotorPrice();
        }
        //外购报价 泵头成本（来源于供应商）*（1+外购泵配套管理费用）+电机成本*（1+外购件配套管理费比例）
        Double allPrice = ((busiOutsourcing.getOutsourcingPrice()) * (1 + Constant.PROPORTION_OF_MANAGEMENT_FEE_PURCHASED)) + (motorPrice * (1 + Constant.PROPORTION_MANAGEMENT));
        busiOutsourcingDetails.setDetailsPrice(StringUtils.doubleFormat(allPrice));
        busiOutsourcingDetails.setQuotationType(1L);
        //泵头成本
        busiOutsourcingDetails.setPumpHeadCost(busiOutsourcing.getOutsourcingPrice());
        busiOutsourcingDetails.setMotorCost(motorPrice);
        busiOutsourcingDetails.setAllCost(StringUtils.doubleFormat(busiOutsourcing.getOutsourcingPrice()+motorPrice));
        //先进行保存 保存完毕重新统计
        int i = busiOutsourcingDetailsService.updateBusiOutsourcingDetails(busiOutsourcingDetails);
        if (i > 0){
            reStatistics(busiOutsourcingDetails);
        }
        return toAjax(1);
    }

    /**
     * 删除外购报价明细
     */
    @RequiresPermissions("busi:details:remove")
    @Log(title = "外购报价明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        BusiOutsourcingDetails busiOutsourcingDetails = busiOutsourcingDetailsService.selectBusiOutsourcingDetailsById(Long.parseLong(ids));
        int i = busiOutsourcingDetailsService.deleteBusiOutsourcingDetailsByIds(ids);
        if (i > 0){
            reStatistics(busiOutsourcingDetails);
        }
        return toAjax(1);
    }


    private void reStatistics(BusiOutsourcingDetails busiOutsourcingDetails){
        //保存完后重新统计
        Map<String,Double> map = busiPriceDetailsMapper.selectoutsourcingPriceDetailsByQuotationNo(busiOutsourcingDetails.getQuotationId());
        //查询之前有没有对应价格
        BusiOutsourcingCost busiOutsourcingCost = busiOutsourcingCostService.selectBusiOutsourcingCostById(busiOutsourcingDetails.getQuotationId());
        if (map != null){
            if (busiOutsourcingCost == null){
                busiOutsourcingCost = new BusiOutsourcingCost();
            }
            //电机成本
            busiOutsourcingCost.setQuotationId(busiOutsourcingDetails.getQuotationId());

            double motorPrice = 0d;
            if ( map.containsKey("motorPrice")){
                motorPrice = map.get("motorPrice");
            }
            double otherMotorPrice = 0d;
            if ( map.containsKey("otherMotorPrice")){
                motorPrice = map.get("otherMotorPrice");
            }
            Double allCost = map.get("allCost");

            busiOutsourcingCost.setMotorPrice(StringUtils.doubleFormat( motorPrice+otherMotorPrice ));
            busiOutsourcingCost.setProductPrice(map.get("outsourcingPrice"));
            busiOutsourcingCost.setQuotationAmount(map.get("quotationAmount"));

            //报价金额 - (电机成本 + 泵头成本)
            Double sumPrice = StringUtils.doubleFormat(allCost);
            Double profit = busiOutsourcingCost.getQuotationAmount() - sumPrice;
            busiOutsourcingCost.setProfit(profit);
            busiOutsourcingCost.setSumPrice(sumPrice);

            if (busiOutsourcingCost.getCostId() != null){
                busiOutsourcingCostService.updateBusiOutsourcingCost(busiOutsourcingCost);
            }else{
                busiOutsourcingCostService.insertBusiOutsourcingCost(busiOutsourcingCost);
            }
        }else{
            //为空的话就删除
            busiOutsourcingCostService.deleteBusiOutsourcingCostById(busiOutsourcingDetails.getQuotationId());
        }


    }
}
