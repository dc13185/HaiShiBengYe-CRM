package com.ruoyi.busi.qutsourcing.controller;

import java.util.List;

import com.ruoyi.busi.domain.BusiMotor;
import com.ruoyi.busi.outsourcing.domain.BusiOutsourcing;
import com.ruoyi.busi.outsourcing.service.IBusiOutsourcingService;
import com.ruoyi.busi.service.IBusiMotorService;
import com.ruoyi.busi.service.IBusiQuotationService;
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
        Double busiPrice = 0d , otherPrice = 0d;
        BusiOutsourcing busiOutsourcing = busiOutsourcingService.selectBusiOutsourcingById(busiOutsourcingDetails.getModelId());
        //电机成本
        if (busiOutsourcingDetails.getMotorId() != null){
            BusiMotor busiMotor = busiMotorService.selectBusiMotorById(busiOutsourcingDetails.getMotorId());
            busiPrice =  busiPrice + busiMotor.getPrice();
        }
        if (busiOutsourcingDetails.getOtherMotorPrice() != null){
            busiPrice = busiPrice + busiOutsourcingDetails.getOtherMotorPrice();
        }
        //其他费用
        if (busiOutsourcingDetails.getOtherMotorPrice() != null){
            otherPrice = otherPrice + busiOutsourcingDetails.getOtherMotorPrice();
        }
        //总计费用 泵头成本 + 电机成本 + 其他费用
        Double allPrice = busiOutsourcing.getOutsourcingPrice() + busiPrice + otherPrice ;
        busiOutsourcingDetails.setDetailsPrice(allPrice);
        busiOutsourcingDetails.setQuotationType(1L);
        return toAjax(busiOutsourcingDetailsService.insertBusiOutsourcingDetails(busiOutsourcingDetails));
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


        return toAjax(busiOutsourcingDetailsService.updateBusiOutsourcingDetails(busiOutsourcingDetails));
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
        return toAjax(busiOutsourcingDetailsService.deleteBusiOutsourcingDetailsByIds(ids));
    }
}
