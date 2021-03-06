package com.ruoyi.busi.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ruoyi.busi.Constant;
import com.ruoyi.busi.domain.*;
import com.ruoyi.busi.mapper.BusiQuotationDetailsMapper;
import com.ruoyi.busi.outsourcing.domain.BusiOutsourcing;
import com.ruoyi.busi.outsourcing.service.IBusiOutsourcingService;
import com.ruoyi.busi.parts.domain.BusiPartsDetails;
import com.ruoyi.busi.parts.service.IBusiPartsDetailsService;
import com.ruoyi.busi.qutsourcing.domain.BusiOutsourcingDetails;
import com.ruoyi.busi.qutsourcing.service.IBusiOutsourcingDetailsService;
import com.ruoyi.busi.service.*;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.MyExcelUtil;
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

import static com.ruoyi.busi.Constant.PACKING_AND_TRANSPORTATION_COSTS;
import static com.ruoyi.busi.Constant.TAX_AND_ADDITIONAL_RATIO;

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
    private IBusiMaterialProductionService busiMaterialProductionService;
    @Autowired
    private IBusiProductLineService busiProductLineService;
    @Autowired
    private IBusiPriceDetailsService busiPriceDetailsService;
    @Autowired
    private IBusiQuotationService quotationService;
    @Autowired
    private IBusiOutsourcingDetailsService busiOutsourcingDetailsService;
    @Autowired
    private IBusiPartsDetailsService busiPartsDetailsService;

    @RequiresPermissions("busi:details:view")
    @GetMapping()
    public String details(Long quotationId,ModelMap modelMap)
    {
        BusiQuotation quotation = quotationService.selectBusiQuotationById(quotationId);
        Map<String,Long> map =  quotationDetailsMapper.getDetilsFalg(quotationId);
        modelMap.put("quotationId",quotationId);
        modelMap.put("quotation",quotation);
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
                modelMap.put("sumOutsourcingPrice", format(sumOutsourcingPrice));
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
                modelMap.put("sumOutsourcingPrice", format(sumOutsourcingPrice));
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
        }else if(quotation.getQuotationType() == 2L){
            Double partsgSum = quotationDetailsMapper.getPartsgSumPrice(quotationId);
            if (partsgSum!=null){
                modelMap.put("partsPrice", partsgSum);
            }else{
                modelMap.put("partsFlag", 0);
            }

            if (bodCount > 0){
                Double sumOutsourcingPrice = quotationDetailsMapper.getOutsourcingSumPrice(quotationId);
                modelMap.put("sumOutsourcingPrice", format(sumOutsourcingPrice));
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

            //如果该报价单含有 外购报价单明细
            if (bodCount > 0){
                Double sumOutsourcingPrice = quotationDetailsMapper.getOutsourcingSumPrice(quotationId);
                modelMap.put("sumOutsourcingPrice", format(sumOutsourcingPrice));
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
        BusiQuotation quotation = quotationService.selectBusiQuotationById(quotationId);
        modelMap.put("quotation",quotation);
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
            modelMap.put("sumOutsourcingPrice", format(sumOutsourcingPrice));
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
        BusiQuotation quotation = quotationService.selectBusiQuotationById(quotationId);
        modelMap.put("quotation",quotation);
        Map<String,Long> map =  quotationDetailsMapper.getDetilsFalg(quotationId);
        modelMap.put("quotationId",quotationId);
        //整机报价单标识
        Long bodCount =  map.get("bod_count");
        Long bqdCount =  map.get("bqd_count");
        Long bpdCount =  map.get("bpd_count");
        Double sumOutsourcingPrice = quotationDetailsMapper.getOutsourcingSumPrice(quotationId);
        if (sumOutsourcingPrice!=null){
            modelMap.put("sumOutsourcingPrice", format(sumOutsourcingPrice));
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
            modelMap.put("quotationFlag", 1);
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
    public AjaxResult export(BusiQuotationDetails busiQuotationDetails) throws IOException {
        //报价单明细
        List<BusiQuotationDetails> busiQuotationDetailslist = busiQuotationDetailsService.selectBusiQuotationDetailsList(busiQuotationDetails);
        busiQuotationDetailslist.forEach(l -> {
            l.setAdjustUnitPrice(null);
        });
        //外购单明细
        BusiOutsourcingDetails busiOutsourcingDetails = new BusiOutsourcingDetails();
        busiOutsourcingDetails.setQuotationId(busiQuotationDetails.getQuotationId());
        List<BusiOutsourcingDetails> busiOutsourcingDetailsList = busiOutsourcingDetailsService.selectBusiOutsourcingDetailsList(busiOutsourcingDetails);
        busiOutsourcingDetailsList.forEach(l -> {
            l.setAdjustUnitPrice(null);
        });
        //配件单明细
        BusiPartsDetails busiPartsDetails = new BusiPartsDetails();
        busiPartsDetails.setQuotationId(busiQuotationDetails.getQuotationId());
        List<BusiPartsDetails> busiPartsDetailList = busiPartsDetailsService.selectBusiPartsDetailsList(busiPartsDetails);
        busiPartsDetailList.forEach(l -> {
            l.setAdjustUnitPrice(null);
        });
        //导出
        MyExcelUtil<BusiQuotationDetails> util = new MyExcelUtil<BusiQuotationDetails>(BusiQuotationDetails.class);
        util.init();
        util.exportExcel(busiQuotationDetailslist,BusiQuotationDetails.class,"整机报价明细");
        util.exportExcel(busiOutsourcingDetailsList,BusiOutsourcingDetails.class,"外购报价明细");
        util.exportExcel(busiPartsDetailList,BusiPartsDetails.class,"配件报价明细");

        return util.exportAll("报价明细");
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
        Double  motorPrice = 0d , machineProce = 0d ,couplingPrice = 0d ,bearingPrice=0d ,otherPrice=0d,rinsePrice=0d;
        List<PriceSum> priceSums = quotationDetailsMapper.selectPriceDetil(busiQuotationDetails);
        // 用过流部的材质和材质形式和供应商ID 去对应供应商查价格
        BusiMaterialProduction  baseBusiMaterialProduction = busiMaterialProductionService.selectBusiMaterialProductionById(busiQuotationDetails.getMaterialId());
        //返回材料成本费用
        Double materialCosts = format(priceSums.stream().mapToDouble(p -> {
            //如果为过流部件的话，需要将 生产参数为过流部件的材料单价替换为过流部件的单价 和质量比
            if (p.getIsCurrent() == 1){
                // 如果过流部件材质存在的话
                BusiMaterialProduction  busiMaterialProduction = busiMaterialProductionService.selectBusiMaterialProductionBySupplierId(busiQuotationDetails.getMaterialSupplierId(),p.getTextureType(),baseBusiMaterialProduction.getMaterialName());
                return  p.getNumber() * p.getWeight() * busiMaterialProduction.getPrice() * busiMaterialProduction.getMassRatio();
            }else {
                return  p.getNumber() * p.getWeight() * p.getMaterialPrice()* p.getMassRatio();
            }
        }).sum());
        //返回人工成本费用
        Double laborCost = format(priceSums.parallelStream().mapToDouble(p -> p.getNumber() * p.getTime() * Constant.LABOR_COSTCOE_FFICIENT).sum());
        //返回制造成本费用
        Double makeCost = format(priceSums.parallelStream().mapToDouble(p -> p.getNumber() * p.getTime() * Constant.MAKE_COEFFICIENT).sum());
        //低值物料成本
        Double  lowMaterialCost = busiProductModelService.selectBusiProductModelById(busiQuotationDetails.getModelId()).getLowMaterialCost();
        if (lowMaterialCost == null){
            lowMaterialCost = 0d;
        }
        materialCosts = materialCosts + lowMaterialCost;

        //电机价格
        if (busiQuotationDetails.getMotorId() != null){
            motorPrice = quotationDetailsMapper.getMotorPrice(busiQuotationDetails.getMotorId());
        }else if (busiQuotationDetails.getOtherMotorPrice() != null){
            motorPrice = busiQuotationDetails.getOtherMotorPrice();
        }

        //机封成本
        if (busiQuotationDetails.getMachineId() != null){
            machineProce = quotationDetailsMapper.getMachinePrice(busiQuotationDetails.getMachineId());
        } else if(busiQuotationDetails.getOtherMachinePrice() != null){
            machineProce = busiQuotationDetails.getOtherMachinePrice();
        }

        //系统冲洗方案成本
        if(busiQuotationDetails.getRinseId() != null){
            rinsePrice = quotationDetailsMapper.getRinsePrice(busiQuotationDetails.getRinseId());
        }else if(busiQuotationDetails.getOtherRinsePrice() != null){
            rinsePrice = busiQuotationDetails.getOtherRinsePrice();
        }

        //联轴器成本
        if (busiQuotationDetails.getCouplingId() != null){
            couplingPrice = quotationDetailsMapper.getCouplingPrice(busiQuotationDetails.getCouplingId());
        } else if (busiQuotationDetails.getOtherCouplingPrice() != null){
            couplingPrice =  busiQuotationDetails.getOtherCouplingPrice();
        }
        //轴承成本
        if (busiQuotationDetails.getBearingId() != null){
            bearingPrice =  quotationDetailsMapper.getBearingPrice(busiQuotationDetails.getBearingId());
        } else if (busiQuotationDetails.getOtherBearingPrice() != null){
            bearingPrice = busiQuotationDetails.getOtherBearingPrice();
        }
        if(busiQuotationDetails.getOtherExpenses() != null){
            otherPrice = busiQuotationDetails.getOtherExpenses();
        }

        BusiProductLine busiProductLine = busiProductLineService.selectBusiProductLineById(busiQuotationDetails.getProductLineId());
        //泵头价格=（材料成本+人工成本+制造费用）/（1-毛利率）
        Double bengTouPrice = (materialCosts + laborCost + makeCost) / (1 - busiProductLine.getGrossProfitRate()) ;
        //外购加个 （电机采购成本+机封采购成本+轴承采购成本+联轴器采购成本+特殊配置费用）×（1+外购件配套管理费比例）
        Double waiGouPrice = ( motorPrice + machineProce + couplingPrice + bearingPrice + otherPrice + rinsePrice) * (1+ Constant.PROPORTION_MANAGEMENT);
        // 整机价格（泵头价格+外购件价格）/（1 - 包装运输费比例）/（1 - 税金及附加比例）
        Double allPrice =  (bengTouPrice + waiGouPrice) / (1 - PACKING_AND_TRANSPORTATION_COSTS) / (1 - TAX_AND_ADDITIONAL_RATIO);
        busiQuotationDetails.setDetailsPrice(format(allPrice));
        busiQuotationDetails.setQuotationType(0L);
        //成本核算 （材料成本+人工成本+制造费用）
        busiQuotationDetails.setPumpHeadCost(StringUtils.doubleFormat((materialCosts + laborCost + makeCost)));
        //电机成本
        busiQuotationDetails.setMotorCost(motorPrice);
        //机封成本
        busiQuotationDetails.setSealCost(machineProce);
        busiQuotationDetails.setRinseCost(rinsePrice);
        //总成本
        Double allCost = StringUtils.doubleFormat(materialCosts + laborCost + makeCost + motorPrice + machineProce + couplingPrice + bearingPrice + otherPrice + rinsePrice);
        busiQuotationDetails.setAllCost(allCost);
        busiQuotationDetailsService.insertBusiQuotationDetails(busiQuotationDetails);
        Double sumPrice =  quotationDetailsMapper.getSumPrice(busiQuotationDetails.getQuotationId());
        reset(busiQuotationDetails.getQuotationId());
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
        //获取数量
        Double  motorPrice = 0d , machineProce = 0d ,couplingPrice = 0d ,bearingPrice=0d ,otherPrice=0d,rinsePrice=0d;;

        List<PriceSum> priceSums = quotationDetailsMapper.selectPriceDetil(busiQuotationDetails);
        BusiMaterialProduction  baseBusiMaterialProduction = busiMaterialProductionService.selectBusiMaterialProductionById(busiQuotationDetails.getMaterialId());
        //返回材料成本费用
        Double materialCosts = format(priceSums.parallelStream().mapToDouble(p -> {
            //如果为过流部件的话，需要将 生产参数为过流部件的材料单价替换为过流部件的单价 和质量比
            if (p.getIsCurrent() == 1 ){
                // 如果过流部件材质存在的话
                BusiMaterialProduction  busiMaterialProduction = busiMaterialProductionService.selectBusiMaterialProductionBySupplierId(busiQuotationDetails.getMaterialSupplierId(),p.getTextureType(),baseBusiMaterialProduction.getMaterialName());
                return  p.getNumber() * p.getWeight() * busiMaterialProduction.getPrice() * busiMaterialProduction.getMassRatio();
            }else {
                return  p.getNumber() * p.getWeight() * p.getMaterialPrice()* p.getMassRatio();
            }
        }).sum());
        //返回人工成本费用
        Double laborCost = format(priceSums.parallelStream().mapToDouble(p -> p.getNumber() * p.getTime() * Constant.LABOR_COSTCOE_FFICIENT).sum());
        //返回制造成本费用
        Double makeCost = format(priceSums.parallelStream().mapToDouble(p -> p.getNumber() * p.getTime() * Constant.MAKE_COEFFICIENT).sum());
        //低值物料成本
        Double  lowMaterialCost = busiProductModelService.selectBusiProductModelById(busiQuotationDetails.getModelId()).getLowMaterialCost();
        if (lowMaterialCost == null){
            lowMaterialCost = 0d;
        }
        materialCosts = materialCosts + lowMaterialCost;

        //电机价格
        if (busiQuotationDetails.getMotorId() != null){
            motorPrice = quotationDetailsMapper.getMotorPrice(busiQuotationDetails.getMotorId());
        }else if (busiQuotationDetails.getOtherMotorPrice() != null){
            motorPrice = busiQuotationDetails.getOtherMotorPrice();
        }

        //系统冲洗方案成本
        if(busiQuotationDetails.getRinseId() != null){
            rinsePrice = quotationDetailsMapper.getRinsePrice(busiQuotationDetails.getRinseId());
        }else if(busiQuotationDetails.getOtherRinsePrice() != null){
            rinsePrice = busiQuotationDetails.getOtherRinsePrice();
        }


        //机封成本
        if (busiQuotationDetails.getMachineId() != null){
            machineProce = quotationDetailsMapper.getMachinePrice(busiQuotationDetails.getMachineId());
        } else if(busiQuotationDetails.getOtherMachinePrice() != null){
            machineProce = busiQuotationDetails.getOtherMachinePrice();
        }
        //联轴器成本
        if (busiQuotationDetails.getCouplingId() != null){
            couplingPrice = quotationDetailsMapper.getCouplingPrice(busiQuotationDetails.getCouplingId());
        } else if (busiQuotationDetails.getOtherCouplingPrice() != null){
            couplingPrice =  busiQuotationDetails.getOtherCouplingPrice();
        }
        //轴承成本
        if (busiQuotationDetails.getBearingId() != null){
            bearingPrice =  quotationDetailsMapper.getBearingPrice(busiQuotationDetails.getBearingId());
        } else if (busiQuotationDetails.getOtherBearingPrice() != null){
            bearingPrice = busiQuotationDetails.getOtherBearingPrice();
        }
        if(busiQuotationDetails.getOtherExpenses() != null){
            otherPrice = busiQuotationDetails.getOtherExpenses();
        }

        BusiProductLine busiProductLine = busiProductLineService.selectBusiProductLineById(busiQuotationDetails.getProductLineId());
        //泵头价格=（材料成本+人工成本+制造费用）/（1-毛利率）
        Double bengTouPrice = (materialCosts + laborCost + makeCost) / (1 - busiProductLine.getGrossProfitRate()) ;
        //外购加个 （电机采购成本+机封采购成本+轴承采购成本+联轴器采购成本+特殊配置费用 + 机洗）×（1+外购件配套管理费比例）
        Double waiGouPrice = ( motorPrice + machineProce + couplingPrice + bearingPrice + otherPrice + rinsePrice) * (1+ Constant.PROPORTION_MANAGEMENT);
        // 整机价格（泵头价格+外购件价格）×（1+包装运输费比例）×（1+税金及附加比例）
        Double allPrice =  (bengTouPrice + waiGouPrice) / (1 - PACKING_AND_TRANSPORTATION_COSTS) / (1 - TAX_AND_ADDITIONAL_RATIO);
        busiQuotationDetails.setDetailsPrice(format(allPrice));
        busiQuotationDetails.setQuotationType(0L);
        //成本核算 （材料成本+人工成本+制造费用）
        busiQuotationDetails.setPumpHeadCost(StringUtils.doubleFormat((materialCosts + laborCost + makeCost)));
        //电机成本
        busiQuotationDetails.setMotorCost(motorPrice);
        //机封成本
        busiQuotationDetails.setSealCost(machineProce);
        busiQuotationDetails.setRinseCost(rinsePrice);
        //总成本
        Double allCost = StringUtils.doubleFormat(materialCosts + laborCost + makeCost + motorPrice + machineProce + couplingPrice + bearingPrice + otherPrice + rinsePrice);
        busiQuotationDetails.setAllCost(allCost);
        busiQuotationDetailsService.updateBusiQuotationDetails(busiQuotationDetails);
        Double sumPrice =  quotationDetailsMapper.getSumPrice(busiQuotationDetails.getQuotationId());
        reset(busiQuotationDetails.getQuotationId());

        //改版本号
        BusiQuotation busiQuotation = quotationService.selectBusiQuotationByIdOnlyId(busiQuotationDetails.getQuotationId());
        //版本号发生变化
        String contractNo = busiQuotation.getQuotationNo();
        String versionChar =  StringUtils.substringAfterLast(contractNo,"-");
        String prefix =  StringUtils.substringBeforeLast(contractNo,"-");
        char nextVersion = Constants.getVersion(versionChar.charAt(0));
        busiQuotation.setQuotationNo(prefix+"-"+nextVersion);
        busiQuotation.setQuotationId(busiQuotationDetails.getQuotationId());
        quotationService.updateBusiQuotation(busiQuotation);

        return success(format(sumPrice).toString());
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
        String id = ids.split(",")[0];
        BusiQuotationDetails busiQuotationDetails =  busiQuotationDetailsService.selectBusiQuotationDetailsById(Long.parseLong(id));
        busiQuotationDetailsService.deleteBusiQuotationDetailsByIds(ids);
         reset(busiQuotationDetails.getQuotationId());
        return toAjax(1);
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
        BigDecimal b = new  BigDecimal(d);
        return b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    //重新核算价格
    private void reset(Long quotationId){
        //人工成本
        BusiQuotationDetails sear = new BusiQuotationDetails();
        sear.setQuotationId(quotationId);
        //查到所有重新核算
        List<BusiQuotationDetails>  busiQuotationDetailList = busiQuotationDetailsService.selectBusiQuotationDetailsList(sear);
        if (busiQuotationDetailList == null){
            busiPriceDetailsService.deleteBusiPriceDetailsById(quotationId);
        }else{
            BusiPriceDetails busiPriceDetails = busiPriceDetailsService.selectBusiPriceDetailsById(quotationId);
            Double   motorPrice = 0d , machineProce = 0d ,couplingPrice = 0d ,bearingPrice=0d ,otherPrice=0d ,materialCosts =0d,laborCost=0d,makeCost=0d ,lowMaterialCost=0d ,rinsePrice =0d;
            for (BusiQuotationDetails quotationDetails : busiQuotationDetailList) {
                    Long number = quotationDetails.getNumber();
                    List<PriceSum> priceSums = quotationDetailsMapper.selectPriceDetil(quotationDetails);
                    BusiMaterialProduction  baseBusiMaterialProduction = busiMaterialProductionService.selectBusiMaterialProductionById(quotationDetails.getMaterialId());
                     //返回材料成本费用
                     materialCosts += format(priceSums.parallelStream().mapToDouble(p -> {
                        //如果为过流部件的话，需要将 生产参数为过流部件的材料单价替换为过流部件的单价 和质量比
                        if (p.getIsCurrent() == 1){
                            // 如果过流部件材质存在的话
                            BusiMaterialProduction  busiMaterialProduction = busiMaterialProductionService.selectBusiMaterialProductionBySupplierId(quotationDetails.getMaterialSupplierId(),p.getTextureType(),baseBusiMaterialProduction.getMaterialName());
                            return  p.getNumber() * p.getWeight()  * busiMaterialProduction.getPrice() * busiMaterialProduction.getMassRatio();
                        }else {
                            return  p.getNumber() * p.getWeight() * p.getMaterialPrice()* p.getMassRatio();
                        }
                    }).sum()) * number;
                    //返回人工成本费用
                    laborCost += format(priceSums.stream().mapToDouble(p -> p.getNumber() * p.getTime() * Constant.LABOR_COSTCOE_FFICIENT).sum()) * number;
                    //返回制造成本费用
                    makeCost += format(priceSums.parallelStream().mapToDouble(p -> p.getNumber() * p.getTime() * Constant.MAKE_COEFFICIENT).sum()) * number;
                    //低值物料成本
                    lowMaterialCost += busiProductModelService.selectBusiProductModelById(quotationDetails.getModelId()).getLowMaterialCost() * number;

                    //电机价格
                    if (quotationDetails.getMotorId() != null){
                        motorPrice += quotationDetailsMapper.getMotorPrice(quotationDetails.getMotorId()) * number;
                    }else if (quotationDetails.getOtherMotorPrice() != null){
                        motorPrice +=  format(motorPrice + quotationDetails.getOtherMotorPrice()) * number;
                    }

                    //机封成本
                    if (quotationDetails.getMachineId() != null){
                        machineProce += format(quotationDetailsMapper.getMachinePrice(quotationDetails.getMachineId()) * number);
                    }else if (quotationDetails.getOtherMachinePrice() != null){
                         machineProce += format(machineProce + quotationDetails.getOtherMachinePrice()) * number; }
                     //系统冲洗方案成本
                    if(quotationDetails.getRinseId() != null){
                        rinsePrice += format(quotationDetailsMapper.getRinsePrice(quotationDetails.getRinseId()) * number);
                    }else if(quotationDetails.getOtherRinsePrice() != null){
                        rinsePrice += format(quotationDetails.getOtherRinsePrice() * number);
                    }

                    //联轴器成本
                    if (quotationDetails.getCouplingId() != null){
                        couplingPrice += format(quotationDetailsMapper.getCouplingPrice(quotationDetails.getCouplingId()) * number);
                    } else if (quotationDetails.getOtherCouplingPrice() != null){
                        couplingPrice += format(couplingPrice + quotationDetails.getOtherCouplingPrice()) * number;
                    }
                    //轴承成本
                    if (quotationDetails.getBearingId() != null){
                        bearingPrice +=  quotationDetailsMapper.getBearingPrice(quotationDetails.getBearingId()) * number;
                    }else if (quotationDetails.getOtherBearingPrice() != null){
                        bearingPrice += format(bearingPrice + quotationDetails.getOtherBearingPrice()) * number;
                    }

                    if(quotationDetails.getOtherExpenses() != null){
                        otherPrice += quotationDetails.getOtherExpenses() * number;
                    }
                }
            if (busiPriceDetails == null){
                busiPriceDetails = new BusiPriceDetails();
            }
            //泵头材料成本  = 材料成本+ 低值物料成本
            busiPriceDetails.setBengtouclCb(format(lowMaterialCost + materialCosts));
            busiPriceDetails.setBengtouRgCb(laborCost);
            busiPriceDetails.setBengtouFyCb(makeCost);
            busiPriceDetails.setMotorCb(motorPrice);
            busiPriceDetails.setJfCb(machineProce);
            busiPriceDetails.setZlqCb(couplingPrice);
            busiPriceDetails.setZcCb(bearingPrice);
            busiPriceDetails.setEwCb(otherPrice);
            busiPriceDetails.setQuotationId(quotationId);
            busiPriceDetails.setRinseCose(rinsePrice);
            //报价金额
            Double quotationAmount =  busiQuotationDetailList.parallelStream().mapToDouble(b ->  b.getDetailsPrice()* b.getNumber() * b.getCoefficient()).sum();
            busiPriceDetails.setContractPrice(format(quotationAmount));
            Double sumPrice = busiPriceDetails.getBengtouclCb()
                    + busiPriceDetails.getBengtouRgCb()
                    + busiPriceDetails.getBengtouFyCb()
                    + busiPriceDetails.getMotorCb()
                    + busiPriceDetails.getJfCb()
                    + busiPriceDetails.getZlqCb()
                    + busiPriceDetails.getZcCb()
                    + busiPriceDetails.getEwCb()
                    + busiPriceDetails.getRinseCose();
            //获取总毛利
            Double profit = quotationAmount - sumPrice;
            busiPriceDetails.setSumPrice(sumPrice);
            busiPriceDetails.setProfit(format(profit));

            if (busiPriceDetails.getPriceDetailsId() != null){
                busiPriceDetailsService.updateBusiPriceDetails(busiPriceDetails);
            }else{
                busiPriceDetailsService.insertBusiPriceDetails(busiPriceDetails);
            }
        }


        //

    }
}
