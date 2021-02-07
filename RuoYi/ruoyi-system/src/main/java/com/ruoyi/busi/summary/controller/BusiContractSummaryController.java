package com.ruoyi.busi.summary.controller;

import java.util.List;
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
import com.ruoyi.busi.summary.domain.BusiContractSummary;
import com.ruoyi.busi.summary.service.IBusiContractSummaryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 历史合同汇总Controller
 *
 * @author ruoyi
 * @date 2021-02-07
 */
@Controller
@RequestMapping("/busi/summary")
public class BusiContractSummaryController extends BaseController
{
    private String prefix = "busi/summary";

    @Autowired
    private IBusiContractSummaryService busiContractSummaryService;

    @RequiresPermissions("busi:summary:view")
    @GetMapping()
    public String summary()
    {
        return prefix + "/summary";
    }

    /**
     * 查询历史合同汇总列表
     */
    @RequiresPermissions("busi:summary:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiContractSummary busiContractSummary)
    {
        startPage();
        List<BusiContractSummary> list = busiContractSummaryService.selectBusiContractSummaryList(busiContractSummary);
        return getDataTable(list);
    }

    /**
     * 导出历史合同汇总列表
     */
    @RequiresPermissions("busi:summary:export")
    @Log(title = "历史合同汇总", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiContractSummary busiContractSummary)
    {
        List<BusiContractSummary> list = busiContractSummaryService.selectBusiContractSummaryList(busiContractSummary);
        ExcelUtil<BusiContractSummary> util = new ExcelUtil<BusiContractSummary>(BusiContractSummary.class);
        return util.exportExcel(list, "summary");
    }

    /**
     * 新增历史合同汇总
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存历史合同汇总
     */
    @RequiresPermissions("busi:summary:add")
    @Log(title = "历史合同汇总", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiContractSummary busiContractSummary)
    {
        return toAjax(busiContractSummaryService.insertBusiContractSummary(busiContractSummary));
    }

    /**
     * 修改历史合同汇总
     */
    @GetMapping("/edit/{summaryId}")
    public String edit(@PathVariable("summaryId") Long summaryId, ModelMap mmap)
    {
        BusiContractSummary busiContractSummary = busiContractSummaryService.selectBusiContractSummaryById(summaryId);
        mmap.put("busiContractSummary", busiContractSummary);
        return prefix + "/edit";
    }

    /**
     * 修改保存历史合同汇总
     */
    @RequiresPermissions("busi:summary:edit")
    @Log(title = "历史合同汇总", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiContractSummary busiContractSummary)
    {
        return toAjax(busiContractSummaryService.updateBusiContractSummary(busiContractSummary));
    }

    /**
     * 删除历史合同汇总
     */
    @RequiresPermissions("busi:summary:remove")
    @Log(title = "历史合同汇总", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiContractSummaryService.deleteBusiContractSummaryByIds(ids));
    }
}
