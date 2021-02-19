package com.ruoyi.busi.settlement.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.busi.domain.BusiContract;
import com.ruoyi.busi.domain.BusiQuotation;
import com.ruoyi.busi.mapper.BusiContractMapper;
import com.ruoyi.busi.service.IBusiContractService;
import com.ruoyi.busi.settlement.domain.BusiSettlementHistory;
import com.ruoyi.busi.settlement.service.IBusiSettlementHistoryService;
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
import com.ruoyi.busi.settlement.domain.BusiSettlement;
import com.ruoyi.busi.settlement.service.IBusiSettlementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 业务费用结算Controller
 *
 * @author ruoyi
 * @date 2021-02-19
 */
@Controller
@RequestMapping("/busi/settlement")
public class BusiSettlementController extends BaseController
{
    private String prefix = "busi/settlement";

    @Autowired
    private IBusiSettlementService busiSettlementService;

    @Autowired
    private IBusiSettlementHistoryService busiSettlementHistoryService;

    @Autowired
    private BusiContractMapper busiContractMapper;

    @RequiresPermissions("busi:settlement:view")
    @GetMapping()
    public String settlement()
    {
        return prefix + "/settlement";
    }

    /**
     * 查询业务费用结算列表
     */
    @RequiresPermissions("busi:settlement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiSettlement busiSettlement)
    {
        startPage();
        List<BusiSettlement> list = busiSettlementService.selectBusiSettlementList(busiSettlement);
        return getDataTable(list);
    }

    /**
     * 导出业务费用结算列表
     */
    @RequiresPermissions("busi:settlement:export")
    @Log(title = "业务费用结算", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiSettlement busiSettlement)
    {
        List<BusiSettlement> list = busiSettlementService.selectBusiSettlementList(busiSettlement);
        ExcelUtil<BusiSettlement> util = new ExcelUtil<BusiSettlement>(BusiSettlement.class);
        return util.exportExcel(list, "settlement");
    }

    /**
     * 新增业务费用结算
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存业务费用结算
     */
    @RequiresPermissions("busi:settlement:add")
    @Log(title = "业务费用结算", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiSettlement busiSettlement)
    {
        int i = busiSettlementService.insertBusiSettlement(busiSettlement);
        if (i > 0){
            BusiSettlementHistory busiSettlementHistory = new BusiSettlementHistory();
            //保存历史
            busiSettlementHistory.setBasedCommission(busiSettlement.getBasedCommission());
            busiSettlementHistory.setPremiumCommission(busiSettlement.getPremiumCommission());
            busiSettlementHistory.setBusinessCommission(busiSettlement.getBasedCommission());
            busiSettlementHistory.setWarrantyCommission(busiSettlement.getWarrantyCommission());
            busiSettlementHistory.setReceivedCommission(busiSettlement.getReceivedCommission());
            busiSettlementHistory.setAlreadySettlementBusinessFee(busiSettlement.getSettlementBusinessFee());
            busiSettlementHistory.setIndividualIncomeTax(busiSettlement.getIndividualIncomeTax());
            busiSettlementHistory.setAmountOfBusiness(busiSettlement.getAmountOfBusiness());
            busiSettlementHistory.setSettlementId(busiSettlement.getSettlementId());
            busiSettlementHistory.setSettlementBusinessFee(busiSettlement.getSettlementBusinessFee());
            busiSettlementHistory.setUpdateTime(new Date());
            busiSettlementHistoryService.insertBusiSettlementHistory(busiSettlementHistory);
        }

        return toAjax(i);
    }

    /**
     * 修改业务费用结算
     */
    @GetMapping("/edit/{settlementId}")
    public String edit(@PathVariable("settlementId") Long settlementId, ModelMap mmap)
    {
        BusiSettlement busiSettlement = busiSettlementService.selectBusiSettlementById(settlementId);
        //求出来基本信息
        BusiContract busiContract = busiContractMapper.selectBusiContractByNo(busiSettlement.getContractNo());
        BusiQuotation busiQuotation = busiContract.getBusiQuotation();
        busiQuotation.setSumPrice(StringUtils.doubleFormat(busiQuotation.getOutsourcingPrice()  + busiQuotation.getPartsPrice() + busiQuotation.getQuotationPrice()));
        busiContract.setBusiQuotation(busiQuotation);

        Map<String,Double> map = busiContractMapper.queryCostByQuotationId(busiContract.getQutationId().toString());
        Double motorCost = map.get("motorCost");
        Double otherCost = map.get("otherCost");
        //保存基本信息
        busiSettlement.setContractPrice(busiContract.getContractPrice());
        busiSettlement.setQuotationPrice(busiQuotation.getSumPrice());
        busiSettlement.setMotorCost(motorCost);
        busiSettlement.setOtherCost(otherCost);

        mmap.put("busiSettlement", busiSettlement);
        return prefix + "/edit";
    }

    /**
     * 修改保存业务费用结算
     */
    @RequiresPermissions("busi:settlement:edit")
    @Log(title = "业务费用结算", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiSettlement busiSettlement)
    {
        BusiSettlementHistory busiSettlementHistory = new BusiSettlementHistory();
        //保存本次结算业务费用
        busiSettlementHistory.setSettlementBusinessFee(busiSettlement.getSettlementBusinessFee());
        //查找上一次的 业务结算费用
        BusiSettlement nowBusiSettlement = busiSettlementService.selectBusiSettlementById(busiSettlement.getSettlementId());
        //此时就是已结算的业务费用
        busiSettlement.setSettlementBusinessFee(busiSettlement.getSettlementBusinessFee() + nowBusiSettlement.getSettlementBusinessFee());

        //保存历史
        busiSettlementHistory.setBasedCommission(busiSettlement.getBasedCommission());
        busiSettlementHistory.setPremiumCommission(busiSettlement.getPremiumCommission());
        busiSettlementHistory.setBusinessCommission(busiSettlement.getBasedCommission());
        busiSettlementHistory.setWarrantyCommission(busiSettlement.getWarrantyCommission());
        busiSettlementHistory.setReceivedCommission(busiSettlement.getReceivedCommission());
        busiSettlementHistory.setAlreadySettlementBusinessFee(busiSettlement.getSettlementBusinessFee());
        busiSettlementHistory.setIndividualIncomeTax(busiSettlement.getIndividualIncomeTax());
        busiSettlementHistory.setAmountOfBusiness(busiSettlement.getAmountOfBusiness());
        busiSettlementHistory.setSettlementId(busiSettlement.getSettlementId());
        busiSettlementHistory.setUpdateTime(new Date());
        busiSettlementHistoryService.insertBusiSettlementHistory(busiSettlementHistory);
        return toAjax(busiSettlementService.updateBusiSettlement(busiSettlement));
    }

    /**
     * 删除业务费用结算
     */
    @RequiresPermissions("busi:settlement:remove")
    @Log(title = "业务费用结算", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiSettlementService.deleteBusiSettlementByIds(ids));
    }
}
