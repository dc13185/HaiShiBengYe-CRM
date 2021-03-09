package com.ruoyi.busi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ruoyi.busi.contract.domain.BusiContractProduct;
import com.ruoyi.busi.contract.service.IBusiContractProductService;
import com.ruoyi.busi.domain.BusiQuotation;
import com.ruoyi.busi.mapper.BusiContractMapper;
import com.ruoyi.busi.plan.domain.BusiContractPlan;
import com.ruoyi.busi.plan.service.IBusiContractPlanService;
import com.ruoyi.busi.service.IBusiProductLineService;
import com.ruoyi.busi.service.IBusiProductModelService;
import com.ruoyi.busi.service.IBusiQuotationService;
import com.ruoyi.busi.settlement.domain.BusiSettlement;
import com.ruoyi.busi.settlement.service.IBusiSettlementService;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.busi.domain.BusiContract;
import com.ruoyi.busi.service.IBusiContractService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合同管理Controller
 *
 * @author ruoyi
 * @date 2021-01-25
 */
@Controller
@RequestMapping("/busi/contract")
public class BusiContractController extends BaseController
{
    private String prefix = "busi/contract";

    @Autowired
    private IBusiContractService busiContractService;

    @Autowired
    private IBusiQuotationService quotationService;

    @Autowired
    private IBusiContractPlanService busiContractPlanService;

    @Autowired
    private BusiContractMapper busiContractMapper;

    @Autowired
    private IBusiContractProductService busiContractProductService;

    @Autowired
    private IBusiSettlementService busiSettlementService;




    @RequiresPermissions("busi:contract:view")
    @GetMapping()
    public String contract(String courseId,ModelMap modelMap)
    {
        if(StringUtils.isNotEmpty(courseId)){
            modelMap.put("courseId",courseId);
        }
        return prefix + "/contract";
    }


    @RequiresPermissions("busi:contract:view")
    @GetMapping("/toHistory")
    public String toHistory(String contractId,String courseId,ModelMap modelMap)
    {
        modelMap.put("contractId",contractId);
        BusiContract busiContract = new BusiContract();
        busiContract.setContractId(Long.parseLong(contractId));
        busiContract.setUpdateTime(new Date());
        busiContractService.updateBusiContract(busiContract);
        return prefix + "/contract_history";
    }

    /**
     * 查询合同管理列表
     */
    @RequiresPermissions("busi:contract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiContract busiContract)
    {
        startPage();
        List<BusiContract> list = busiContractService.selectBusiContractList(busiContract);
        list = list.parallelStream().filter(b -> b.getContractId() != null).peek(b -> {
            BusiQuotation busiQuotation = b.getBusiQuotation();
            busiQuotation.setSumPrice(StringUtils.doubleFormat(busiQuotation.getOutsourcingPrice()  + busiQuotation.getPartsPrice() + busiQuotation.getQuotationPrice()));
            b.setBusiQuotation(busiQuotation);
        }).collect(Collectors.toList());
        return getDataTable(list);
    }


    @RequiresPermissions("busi:contract:list")
    @PostMapping("/historyList")
    @ResponseBody
    public TableDataInfo historyList(BusiContract busiContract)
    {
        List<BusiContract> list = busiContractMapper.selectHistoryBusiContractList(busiContract.getContractId());
        return getDataTable(list);
    }

    /**
     * 导出合同管理列表
     */
    @RequiresPermissions("busi:contract:export")
    @Log(title = "合同管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiContract busiContract)
    {
        List<BusiContract> list = busiContractService.selectBusiContractList(busiContract);
        list.forEach(l -> {
            l.setQuotationPrice(null);
            l.setDiscountRate(null);
            BusiContractProduct busiContractProduct = new BusiContractProduct();
            busiContractProduct.setContractId(l.getContractId());
            List<BusiContractProduct>  busiContractProducts =  busiContractProductService.selectBusiContractProductList(busiContractProduct);
            StringBuffer sb = new StringBuffer();
            for (BusiContractProduct contractProduct : busiContractProducts) {
                sb.append(contractProduct.toString());
            }
            l.setBusiContractProductsString(sb.toString());
        });
        ExcelUtil<BusiContract> util = new ExcelUtil<BusiContract>(BusiContract.class);
        return util.exportExcel(list, "合同列表");
    }

    /**
     * 新增合同管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存合同管理
     */
    @RequiresPermissions("busi:contract:add")
    @Log(title = "合同管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiContract busiContract)
    {
        BusiQuotation busiQuotation =  quotationService.selectBusiQuotationById(busiContract.getQutationId());
        Long quotationType = busiQuotation.getQuotationType();
        String quotationTypeStr;
        if (quotationType == 0L){
            quotationTypeStr = "Z";
        } else if(quotationType == 1L){
            quotationTypeStr = "W";
        }else {
            quotationTypeStr = "P";
        }
        int count = busiContractService.selectCount();
        String dateStr = DateUtils.parseDateToStr(DateUtils.YYYY_MM, busiContract.getSigningDate());
        String contractNo = quotationTypeStr + "-" + dateStr + "-" + (count+1) + "-A";
        busiContract.setContractNo(contractNo);
        busiContractService.insertBusiContract(busiContract);
        //插入进度模板
        List<BusiContractPlan> busiContractPlans =  busiContractPlanService.selectBusiContractPlanList(null);
        busiContractPlans.forEach(p -> p.setContractId(busiContract.getContractId()));
        busiContractPlanService.insertBatch(busiContractPlans);
        //插入产品组成
        if (busiContract.getBusiContractProducts() != null){
            busiContract.getBusiContractProducts().forEach( busiContractProduct -> {
                busiContractProduct.setContractId(busiContract.getContractId());
                busiContractProductService.insertBusiContractProduct(busiContractProduct);
            });
        }
        return toAjax(1);
    }

    /**
     * 修改合同管理
     */
    @GetMapping("/edit/{contractId}")
    public String edit(@PathVariable("contractId") Long contractId, ModelMap mmap)
    {
        BusiContract busiContract = busiContractService.selectBusiContractById(contractId);
        mmap.put("busiContract", busiContract);
        return prefix + "/edit";
    }

    /**
     * 修改保存合同管理
     */
    @RequiresPermissions("busi:contract:edit")
    @Log(title = "合同管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiContract busiContract)
    {
        BusiContract historyBusiContract = busiContractService.selectBusiContractById(busiContract.getContractId());
        boolean flag = ObjectUtils.notEqual(historyBusiContract.getContractPrice(),busiContract.getContractPrice()) ||
                ObjectUtils.notEqual(historyBusiContract.getDeliveryTime(),busiContract.getDeliveryTime()) ||
                ObjectUtils.notEqual(historyBusiContract.getPaymentMethod(),busiContract.getPaymentMethod());
        if (flag){
            busiContractMapper.saveHistory(historyBusiContract);
            //版本号发生变化
            String contractNo = historyBusiContract.getContractNo();
            String versionChar =  StringUtils.substringAfterLast(contractNo,"-");
            String prefix =  StringUtils.substringBeforeLast(contractNo,"-");
            char nextVersion = Constants.getVersion(versionChar.charAt(0));
            busiContract.setContractNo(prefix+"-"+nextVersion);
        }
        busiContractService.updateBusiContract(busiContract);
        //同时更新其他地方
        BusiSettlement busiSettlement = busiSettlementService.selectBusiSettlementByNo(busiContract.getContractNo());
        busiSettlement.setContractNo(busiContract.getContractNo());
        busiSettlementService.updateBusiSettlement(busiSettlement);

        return toAjax(1);
    }


    /**
     * 修改保存合同管理
     */
    @RequiresPermissions("busi:contract:edit")
    @Log(title = "合同管理", businessType = BusinessType.UPDATE)
    @PostMapping("/editForType")
    @ResponseBody
    public AjaxResult editForType(@RequestBody BusiContract busiContract)
    {
        return toAjax(busiContractService.updateBusiContract(busiContract));
    }
    /**
     * 删除合同管理
     */
    @RequiresPermissions("busi:contract:remove")
    @Log(title = "合同管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiContractService.deleteBusiContractByIds(ids));
    }

    @GetMapping( "/queryCostByQuotationId")
    @ResponseBody
    public Map queryCostByQuotationId(String quotationId){
        Map<String,Double> map =  busiContractMapper.queryCostByQuotationId(quotationId);
        Double quotationMotorCost = map.get("quotationMotorCost");
        Double outsourcingMotorCost=   map.get("outsourcingMotorCost");
        Double quotationOtherCost =  map.get("quotationOtherCost");
        Double outsourcingOtherCost  =  map.get("outsourcingOtherCost");
        Double quotationAllCost=  map.get("quotationAllCost");
        Double outsourcingAllCost =  map.get("outsourcingAllCost");
        Double partsAllCost =   map.get("partsAllCost");

        if (quotationMotorCost == null){
            quotationMotorCost = 0d;
        }
        if (outsourcingMotorCost == null){
            outsourcingMotorCost = 0d;
        }
        if (quotationOtherCost == null){
            quotationOtherCost = 0d;
        }
        if (quotationAllCost == null){
            quotationAllCost = 0d;
        }
        if (outsourcingAllCost == null){
            outsourcingAllCost = 0d;
        }
        if (partsAllCost == null){
            partsAllCost = 0d;
        }
        if (outsourcingOtherCost == null){
            outsourcingOtherCost = 0d;
        }

        Double motorCost = StringUtils.doubleFormat(quotationMotorCost + outsourcingMotorCost);
        Double otherCost = StringUtils.doubleFormat(quotationOtherCost + outsourcingOtherCost);
        Double allCost = StringUtils.doubleFormat(quotationAllCost + outsourcingAllCost + partsAllCost);
        HashMap map1 = new HashMap();
        map1.put("motorCost",motorCost);
        map1.put("otherCost",otherCost);
        map1.put("rinseCost",map.get("rinseCost"));
        map1.put("allCost",allCost);
        return  map1;
    }
}
