package com.ruoyi.busi.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.ruoyi.busi.domain.*;
import com.ruoyi.busi.mapper.BusiQuotationDetailsMapper;
import com.ruoyi.busi.service.*;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报价明细Controller
 *
 * @author ruoyi
 * @date 2021-01-14
 */
@Controller
@RequestMapping("/busi/details")
public class BusiQuotationDetailsController extends BaseController
{
    private String prefix = "busi/details";

    @Autowired
    private IBusiQuotationDetailsService busiQuotationDetailsService;
    @Autowired
    private BusiQuotationDetailsMapper quotationDetailsMapper;
    @Autowired
    private IBusiProductModelService busiProductModelService;
    @Autowired
    private IBusiPriceDetailsService busiPriceDetailsService;
    @Autowired
    private IBusiPriceService busiPriceService;
    @Autowired
    private IBusiQuotationService quotationService;

    @RequiresPermissions("busi:details:view")
    @GetMapping()
    public String details(Long quotationId,ModelMap modelMap)
    {
        BusiQuotation quotation = quotationService.selectBusiQuotationById(quotationId);
        Map<String,Long> map =  quotationDetailsMapper.getDetilsFalg(quotationId);
        modelMap.put("quotationId",quotationId);
        //整机报价单标识
        Long bodCount =  map.get("bod_count");
        Long bqdCount =  map.get("bqd_count");
        Long bpdCount =  map.get("bpd_count");
        //整机报价单
        if (quotation.getQuotationType() == 0L){
            Double sumPrice =  quotationDetailsMapper.getSumPrice(quotationId);
            if (sumPrice != null){
                modelMap.put("sumPrice", format(sumPrice));
            }else{
                modelMap.put("sumPrice", 0);
            }
            //如果该报价单含有 外购报价单明细
            if (bodCount > 0){
                Double sumOutsourcingPrice = quotationDetailsMapper.getOutsourcingSumPrice(quotationId);
                modelMap.put("sumOutsourcingPrice", sumOutsourcingPrice);
                modelMap.put("quotationFlag", 1);
            }
            //如果有配件单
            if (bpdCount > 0){
                Double partsgSum = quotationDetailsMapper.getPartsgSumPrice(quotationId);
                modelMap.put("partsPrice", partsgSum);
                modelMap.put("partsFlag", 1);
            }
        }else if(quotation.getQuotationType() == 1L){
            Double sumOutsourcingPrice = quotationDetailsMapper.getOutsourcingSumPrice(quotationId);
            if (sumOutsourcingPrice!=null){
                modelMap.put("sumOutsourcingPrice", sumOutsourcingPrice);
            }else{
                modelMap.put("sumOutsourcingPrice", 0);
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
            //如果有配件单
            if (bpdCount > 0){
                Double partsgSum = quotationDetailsMapper.getPartsgSumPrice(quotationId);
                modelMap.put("partsPrice", partsgSum);
                modelMap.put("partsFlag", 1);
            }

            return "busi/outsourcing/details/details";
        }else if(quotation.getQuotationType() == 3L){
            Double partsgSum = quotationDetailsMapper.getPartsgSumPrice(quotationId);
            if (partsgSum!=null){
                modelMap.put("sumOutsourcingPrice", partsgSum);
            }else{
                modelMap.put("sumOutsourcingPrice", 0);
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

            //如果该报价单含有 外购报价单明细
            if (bodCount > 0){
                Double sumOutsourcingPrice = quotationDetailsMapper.getOutsourcingSumPrice(quotationId);
                modelMap.put("sumOutsourcingPrice", sumOutsourcingPrice);
                modelMap.put("quotationFlag", 1);
            }

            return "busi/parts/parts";
        }

        return prefix + "/details";
    }


    @RequiresPermissions("busi:details:view")
    @GetMapping("toZhengJiDetils")
    public String toZhengJiDetils(Long quotationId,ModelMap modelMap)
    {
        Map<String,Long> map =  quotationDetailsMapper.getDetilsFalg(quotationId);
        modelMap.put("quotationId",quotationId);
        //整机报价单标识
        Long bodCount =  map.get("bod_count");
        Long bqdCount =  map.get("bqd_count");
        Long bpdCount =  map.get("bpd_count");
        Double sumPrice =  quotationDetailsMapper.getSumPrice(quotationId);
        if (sumPrice != null){
            modelMap.put("sumPrice", format(sumPrice));
        }else{
            modelMap.put("sumPrice", 0);
        }
        //如果该报价单含有 外购报价单明细
        if (bodCount > 0){
            Double sumOutsourcingPrice = quotationDetailsMapper.getOutsourcingSumPrice(quotationId);
            modelMap.put("sumOutsourcingPrice", sumOutsourcingPrice);
            modelMap.put("quotationFlag", 1);
        }
        if (bpdCount > 0){
            Double partsgSum = quotationDetailsMapper.getPartsgSumPrice(quotationId);
            modelMap.put("partsPrice", partsgSum);
            modelMap.put("partsFlag", 1);
        }
        return prefix + "/details";
    }





    @RequiresPermissions("busi:details:view")
    @GetMapping("toOutsourcingDetils")
    public String toOutsourcingDetils(Long quotationId,ModelMap modelMap)
    {
        Map<String,Long> map =  quotationDetailsMapper.getDetilsFalg(quotationId);
        modelMap.put("quotationId",quotationId);
        //整机报价单标识
        Long bodCount =  map.get("bod_count");
        Long bqdCount =  map.get("bqd_count");
        Long bpdCount =  map.get("bpd_count");
        Double sumOutsourcingPrice = quotationDetailsMapper.getOutsourcingSumPrice(quotationId);
        if (sumOutsourcingPrice!=null){
            modelMap.put("sumOutsourcingPrice", sumOutsourcingPrice);
        }else{
            modelMap.put("sumOutsourcingPrice", 0);
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
        if (bpdCount > 0){
            Double partsgSum = quotationDetailsMapper.getPartsgSumPrice(quotationId);
            modelMap.put("partsPrice", partsgSum);
            modelMap.put("partsFlag", 1);
        }
        return "busi/outsourcing/details/details";
    }

    /**
     * 查询报价明细列表
     */
    @RequiresPermissions("busi:details:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiQuotationDetails busiQuotationDetails)
    {
        startPage();
        List<BusiQuotationDetails> list = busiQuotationDetailsService.selectBusiQuotationDetailsList(busiQuotationDetails);
        return getDataTable(list);
    }




    /**
     * 导出报价明细列表
     */
    @RequiresPermissions("busi:details:export")
    @Log(title = "报价明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiQuotationDetails busiQuotationDetails)
    {
        List<BusiQuotationDetails> list = busiQuotationDetailsService.selectBusiQuotationDetailsList(busiQuotationDetails);
        ExcelUtil<BusiQuotationDetails> util = new ExcelUtil<BusiQuotationDetails>(BusiQuotationDetails.class);
        return util.exportExcel(list, "details");
    }

    /**
     * 新增报价明细
     */
    @GetMapping("/add")
    public String add(String quotationId,ModelMap modelMap)
    {
        modelMap.put("quotationId",quotationId);
        return prefix + "/choose";
    }


    /**
     * 新增报价明细
     */
    @GetMapping("/addDetails")
    public String addDetails(String quotationId,ModelMap modelMap)
    {
        modelMap.put("quotationId",quotationId);
        return prefix + "/add";
    }

    /**
     * 新增保存报价明细
     */
    @RequiresPermissions("busi:details:add")
    @Log(title = "报价明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiQuotationDetails busiQuotationDetails)
    {
        //获取数量
        Long number = busiQuotationDetails.getNumber();
        Double  motorPrice = 0d , machineProce = 0d ,couplingPrice = 0d ,bearingPrice=0d;

        List<BusiPrice> busiPrices = busiPriceService.selectBusiPriceList(new BusiPrice());
        Double laborCostCoefficient = busiPrices.get(0).getPriceDate();
        Double makeCoefficient = busiPrices.get(1).getPriceDate();
        List<PriceSum> priceSums = quotationDetailsMapper.selectPriceDetil(busiQuotationDetails);
        //返回材料成本费用
        Double materialCosts = format(priceSums.parallelStream().mapToDouble(p -> p.getWeight() * p.getMaterialPrice()* p.getMassRatio()).sum());
        //返回人工成本费用
        Double laborCost = format(priceSums.parallelStream().mapToDouble(p -> p.getTime() * laborCostCoefficient).sum());
        //返回制造成本费用
        Double makeCost = format(priceSums.parallelStream().mapToDouble(p -> p.getTime() * makeCoefficient).sum());
        //低值物料成本
        Double  lowMaterialCost = busiProductModelService.selectBusiProductModelById(busiQuotationDetails.getModelId()).getLowMaterialCost();
        if (lowMaterialCost == null){
            lowMaterialCost = 0d;
        }
        //电机价格
        if (busiQuotationDetails.getMotorId() != null){
            motorPrice = quotationDetailsMapper.getMotorPrice(busiQuotationDetails.getMotorId());
        }
        if (busiQuotationDetails.getOtherMotorPrice() != null){
            motorPrice =  format(motorPrice + busiQuotationDetails.getOtherMotorPrice());
        }
        //机封成本
        if (busiQuotationDetails.getMachineId() != null){
            machineProce = quotationDetailsMapper.getMachinePrice(busiQuotationDetails.getMachineId());
        }
        if (busiQuotationDetails.getOtherMachinePrice() != null){
            machineProce = format(machineProce + busiQuotationDetails.getOtherMachinePrice());
        }
        //联轴器成本
        if (busiQuotationDetails.getCouplingId() != null){
            couplingPrice = quotationDetailsMapper.getCouplingPrice(busiQuotationDetails.getCouplingId());
        }
        if (busiQuotationDetails.getOtherMachinePrice() != null){
            couplingPrice = format(couplingPrice + busiQuotationDetails.getOtherCouplingPrice());
        }
        //轴承成本
        if (busiQuotationDetails.getBearingId() != null){
            bearingPrice =  quotationDetailsMapper.getBearingPrice(busiQuotationDetails.getBearingId());
        }
        if (busiQuotationDetails.getOtherBearingPrice() != null){
            bearingPrice = format(bearingPrice + busiQuotationDetails.getOtherBearingPrice());
        }
        //保存报价单明细
        BusiPriceDetails  busiPriceDetails = busiPriceDetailsService.selectBusiPriceDetailsById(busiQuotationDetails.getQuotationId());
        if (busiPriceDetails == null){
            busiPriceDetails = new BusiPriceDetails();
            busiPriceDetails.setBengtouCb(lowMaterialCost*number);
            busiPriceDetails.setBengtouclCb(materialCosts*number);
            busiPriceDetails.setBengtouRgCb(laborCost*number);
            busiPriceDetails.setBengtouFyCb(makeCost*number);
            busiPriceDetails.setMotorCb(motorPrice*number);
            busiPriceDetails.setJfCb(machineProce*number);
            busiPriceDetails.setZlqCb(couplingPrice*number);
            busiPriceDetails.setZcCb(bearingPrice*number);
            if(busiQuotationDetails.getOtherExpenses() != null){
                busiPriceDetails.setEwCb(busiQuotationDetails.getOtherExpenses()*number);
            }
            busiPriceDetails.setQuotationId(busiQuotationDetails.getQuotationId());
            busiPriceDetailsService.insertBusiPriceDetails(busiPriceDetails);
        }else {
            busiPriceDetails.setQuotationId(busiQuotationDetails.getQuotationId());
            busiPriceDetails.setBengtouCb(busiPriceDetails.getBengtouCb()+(lowMaterialCost*number));
            busiPriceDetails.setBengtouclCb((materialCosts*number) + busiPriceDetails.getBengtouCb());
            busiPriceDetails.setBengtouRgCb((laborCost*number) + busiPriceDetails.getBengtouCb());
            busiPriceDetails.setBengtouFyCb((makeCost*number) + busiPriceDetails.getBengtouFyCb());
            busiPriceDetails.setMotorCb((motorPrice*number) + busiPriceDetails.getMotorCb());
            busiPriceDetails.setJfCb((machineProce*number) + busiPriceDetails.getJfCb());
            busiPriceDetails.setZlqCb((couplingPrice*number) + busiPriceDetails.getZlqCb());
            busiPriceDetails.setZcCb((bearingPrice*number) + busiPriceDetails.getZcCb());
            if(busiQuotationDetails.getOtherExpenses() != null) {
                busiPriceDetails.setEwCb((busiQuotationDetails.getOtherExpenses() * number) + busiPriceDetails.getEwCb());
            }
            busiPriceDetailsService.updateBusiPriceDetails(busiPriceDetails);
        }

        //基准单价
        Double quotationDetailsPrice =  format(materialCosts + laborCost + makeCost + lowMaterialCost + motorPrice + machineProce + couplingPrice + bearingPrice);
        if (busiQuotationDetails.getOtherExpenses() != null){
            quotationDetailsPrice = format(quotationDetailsPrice + busiQuotationDetails.getOtherExpenses());
        }
        busiQuotationDetails.setDetailsPrice(quotationDetailsPrice);

        busiQuotationDetails.setQuotationType(0L);
        busiQuotationDetailsService.insertBusiQuotationDetails(busiQuotationDetails);
        Double sumPrice =  quotationDetailsMapper.getSumPrice(busiQuotationDetails.getQuotationId());
        return success(format(sumPrice).toString());
    }

    /**
     * 修改报价明细
     */
    @GetMapping("/edit/{detailsId}")
    public String edit(@PathVariable("detailsId") Long detailsId, ModelMap mmap)
    {
        BusiQuotationDetails busiQuotationDetails = busiQuotationDetailsService.selectBusiQuotationDetailsById(detailsId);
        mmap.put("busiQuotationDetails", busiQuotationDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存报价明细
     */
    @RequiresPermissions("busi:details:edit")
    @Log(title = "报价明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiQuotationDetails busiQuotationDetails)
    {
        return toAjax(busiQuotationDetailsService.updateBusiQuotationDetails(busiQuotationDetails));
    }

    /**
     * 删除报价明细
     */
    @RequiresPermissions("busi:details:remove")
    @Log(title = "报价明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiQuotationDetailsService.deleteBusiQuotationDetailsByIds(ids));
    }

    private Function<Double,Double> format = (d -> {
        NumberFormat nf = NumberFormat.getNumberInstance();
        // 保留两位小数
        nf.setMaximumFractionDigits(2);
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);
        return  Double.valueOf(nf.format(d));
    });

    public Double format(Double d){
        BigDecimal b   =   new  BigDecimal(d);
        return b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
