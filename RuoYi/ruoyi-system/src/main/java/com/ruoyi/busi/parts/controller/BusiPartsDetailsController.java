package com.ruoyi.busi.parts.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.ruoyi.busi.Constant;
import com.ruoyi.busi.cost.domain.BusiPartsCost;
import com.ruoyi.busi.cost.mapper.BusiPartsCostMapper;
import com.ruoyi.busi.domain.*;
import com.ruoyi.busi.mapper.BusiProductParameterMapper;
import com.ruoyi.busi.mapper.BusiQuotationDetailsMapper;
import com.ruoyi.busi.parts.mapper.BusiPartsDetailsMapper;
import com.ruoyi.busi.service.*;
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
import com.ruoyi.busi.parts.domain.BusiPartsDetails;
import com.ruoyi.busi.parts.service.IBusiPartsDetailsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 配件报价Controller
 *
 * @author ruoyi
 * @date 2021-01-31
 */
@Controller
@RequestMapping("/parts/parts")
public class BusiPartsDetailsController extends BaseController
{
    private String prefix = "busi/parts";

    @Autowired
    private IBusiPartsDetailsService busiPartsDetailsService;

    @Autowired
    private IBusiProductLineService busiProductLineService;

    @Autowired
    private BusiProductParameterMapper busiProductParameterMapper;

    @Autowired
    private BusiQuotationDetailsMapper quotationDetailsMapper;

    @Autowired
    private BusiPartsDetailsMapper busiPartsDetailsMapper;

    @Autowired
    private BusiPartsCostMapper partsCostMapper;

    @Autowired
    private IBusiQuotationService quotationService;

    @Autowired
    private IBusiMaterialProductionService busiMaterialProductionService;


    @RequiresPermissions("parts:parts:view")
    @GetMapping()
    public String parts(Long quotationId,ModelMap modelMap)
    {
        BusiQuotation quotation = quotationService.selectBusiQuotationById(quotationId);
        modelMap.put("quotation",quotation);
        Map<String,Long> map =  quotationDetailsMapper.getDetilsFalg(quotationId);
        modelMap.put("quotationId",quotationId);
        //整机报价单标识
        Long bodCount =  map.get("bod_count");
        Long bqdCount =  map.get("bqd_count");

        Double partsgSum = quotationDetailsMapper.getPartsgSumPrice(quotationId);
        if (partsgSum!=null){
            modelMap.put("partsPrice", partsgSum);
        }else{
            modelMap.put("partsFlag", 0);
        }

        //如果该报价单含有 外购报价单明细
        if (bodCount > 0){
            Double sumOutsourcingPrice = quotationDetailsMapper.getOutsourcingSumPrice(quotationId);
            modelMap.put("sumOutsourcingPrice", sumOutsourcingPrice);
            modelMap.put("quotationFlag", 1);
        }
        if (bqdCount > 0){
            Double sumPrice =  quotationDetailsMapper.getSumPrice(quotationId);
            if (sumPrice != null){
                modelMap.put("sumPrice", format(sumPrice));
            }else{
                modelMap.put("sumPrice", 0);
            }
            modelMap.put("zhengjiFlag", 1);
        }
        modelMap.put("quotationId",quotationId);
        return prefix + "/parts";
    }

    /**
     * 查询配件报价列表
     */
    @RequiresPermissions("parts:parts:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiPartsDetails busiPartsDetails)
    {
        startPage();
        List<BusiPartsDetails> list = busiPartsDetailsService.selectBusiPartsDetailsList(busiPartsDetails);
        return getDataTable(list);
    }

    /**
     * 导出配件报价列表
     */
    @RequiresPermissions("parts:parts:export")
    @Log(title = "配件报价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiPartsDetails busiPartsDetails)
    {
        List<BusiPartsDetails> list = busiPartsDetailsService.selectBusiPartsDetailsList(busiPartsDetails);
        ExcelUtil<BusiPartsDetails> util = new ExcelUtil<BusiPartsDetails>(BusiPartsDetails.class);
        return util.exportExcel(list, "parts");
    }

    /**
     * 新增配件报价
     */
    @GetMapping("/add")
    public String add(String quotationId,ModelMap modelMap)
    {
        modelMap.put("quotationId",quotationId);
        return prefix + "/add";
    }

    /**
     * 新增保存配件报价
     */
    @RequiresPermissions("parts:parts:add")
    @Log(title = "配件报价", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiPartsDetails busiPartsDetails)
    {
        BusiProductLine busiProductLine = busiProductLineService.selectBusiProductLineById(busiPartsDetails.getProductLineId());
        PriceSum priceSum = busiProductParameterMapper.selectPriceDetil(busiPartsDetails.getParameterId());

        BusiMaterialProduction  busiMaterialProduction = busiMaterialProductionService.selectBusiMaterialProductionById(busiPartsDetails.getMaterialId());

        //返回材料成本费用
        Double materialCosts = 0d;
        if (busiMaterialProduction == null){
            Double.valueOf(priceSum.getWeight() * priceSum.getMaterialPrice()* priceSum.getMassRatio());
        }else{
            //如果材质存在 ,则就是重量*系数* 材质单价
            Double.valueOf(priceSum.getWeight() * busiMaterialProduction.getPrice()* priceSum.getMassRatio());
        }

        //返回人工成本费用
        Double laborCost = priceSum.getTime()* Constant.LABOR_COSTCOE_FFICIENT;
        //返回制造成本费用
        Double makeCost = priceSum.getTime()*Constant.MAKE_COEFFICIENT;
        //（配件重量×材料单价+配件工时×机加工工时单价）/（1-配件毛利率）
        Double allSum = (materialCosts+laborCost+makeCost) / (1 - Constant.ACCESSORIES_GROSS_MARGIN);
        busiPartsDetails.setDetailsPrice(format(allSum));
        int i = busiPartsDetailsService.insertBusiPartsDetails(busiPartsDetails);
        if (i > 0){
            restart(busiPartsDetails.getQuotationId());
        }
        return toAjax(i);
    }

    /**
     * 修改配件报价
     */
    @GetMapping("/edit/{detailsId}")
    public String edit(@PathVariable("detailsId") Long detailsId, ModelMap mmap)
    {
        BusiPartsDetails busiPartsDetails = busiPartsDetailsService.selectBusiPartsDetailsById(detailsId);
        mmap.put("busiPartsDetails", busiPartsDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存配件报价
     */
    @RequiresPermissions("parts:parts:edit")
    @Log(title = "配件报价", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiPartsDetails busiPartsDetails)
    {
        return toAjax(busiPartsDetailsService.updateBusiPartsDetails(busiPartsDetails));
    }

    /**
     * 删除配件报价
     */
    @RequiresPermissions("parts:parts:remove")
    @Log(title = "配件报价", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        BusiPartsDetails busiPartsDetails = busiPartsDetailsMapper.selectBusiPartsDetailsById(Long.parseLong(ids.split(",")[0]));
        int i = busiPartsDetailsService.deleteBusiPartsDetailsByIds(ids);
        if (i > 0){
            restart(busiPartsDetails.getQuotationId());
        }
        return toAjax(i);
    }


    //核酸成本
    public void restart(Long quotationId){
        BusiPartsDetails busiPartsDetail = new BusiPartsDetails();
        busiPartsDetail.setQuotationId(quotationId);
        List<BusiPartsDetails> busiPartsDetails = busiPartsDetailsMapper.selectBusiPartsDetailsList(busiPartsDetail);
        if (busiPartsDetails != null){
            Double allSum = 0d;
            for (BusiPartsDetails partsDetail : busiPartsDetails) {
                BusiProductLine busiProductLine = busiProductLineService.selectBusiProductLineById(partsDetail.getProductLineId());
                PriceSum priceSum = busiProductParameterMapper.selectPriceDetil(partsDetail.getParameterId());
                //返回材料成本费用
                Double materialCosts =  (Double.valueOf(priceSum.getWeight() * priceSum.getMaterialPrice()* priceSum.getMassRatio())) * partsDetail.getNumber();
                //返回人工成本费用
                Double laborCost = priceSum.getTime()* Constant.LABOR_COSTCOE_FFICIENT * partsDetail.getNumber();
                //返回制造成本费用
                Double makeCost = priceSum.getTime()*Constant.MAKE_COEFFICIENT * partsDetail.getNumber();
                //（配件重量×材料单价+配件工时×机加工工时单价）
                allSum +=  format(materialCosts+laborCost+makeCost);
            }
            BusiPartsCost busiPartsCost =  partsCostMapper.selectBusiPartsCostById(quotationId);
            if (busiPartsCost == null){
                busiPartsCost = new BusiPartsCost();
            }

            Double quotationAmount = busiPartsDetails.parallelStream().mapToDouble(b -> b.getDetailsPrice() * b.getNumber()).sum();
            busiPartsCost.setQuotationAmount(format(quotationAmount));
            busiPartsCost.setQuotationId(quotationId);
            busiPartsCost.setCostPrice(format(allSum));
            //毛利
            busiPartsCost.setProfit(format(busiPartsCost.getQuotationAmount() - busiPartsCost.getCostPrice()));
            if (busiPartsCost.getCostId() != null){
                partsCostMapper.updateBusiPartsCost(busiPartsCost);
            }else{
                partsCostMapper.insertBusiPartsCost(busiPartsCost);
            }

        }else{
            partsCostMapper.deleteBusiPartsCostById(quotationId);
        }



    }


    public Double format(Double d){
        BigDecimal b  = new  BigDecimal(d);
        return b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
