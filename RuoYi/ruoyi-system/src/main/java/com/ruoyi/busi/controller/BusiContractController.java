package com.ruoyi.busi.controller;

import java.util.List;

import com.ruoyi.busi.domain.BusiQuotation;
import com.ruoyi.busi.mapper.BusiContractMapper;
import com.ruoyi.busi.plan.domain.BusiContractPlan;
import com.ruoyi.busi.plan.service.IBusiContractPlanService;
import com.ruoyi.busi.service.IBusiQuotationService;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
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




    @RequiresPermissions("busi:contract:view")
    @GetMapping()
    public String contract()
    {
        return prefix + "/contract";
    }


    @RequiresPermissions("busi:contract:view")
    @GetMapping("/toHistory")
    public String toHistory(String contractId,ModelMap modelMap)
    {
        modelMap.put("contractId",contractId);
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
        ExcelUtil<BusiContract> util = new ExcelUtil<BusiContract>(BusiContract.class);
        return util.exportExcel(list, "contract");
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
        busiContractMapper.saveHistory(historyBusiContract);
        //版本号发生变化
        String contractNo = historyBusiContract.getContractNo();
        String versionChar =  StringUtils.substringAfterLast(contractNo,"-");
        String prefix =  StringUtils.substringBeforeLast(contractNo,"-");
        char nextVersion = Constants.getVersion(versionChar.charAt(0));
        busiContract.setContractNo(prefix+"-"+nextVersion);
        busiContractService.updateBusiContract(busiContract);

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
}
