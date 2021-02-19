package com.ruoyi.busi.settlement.controller;

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
import com.ruoyi.busi.settlement.domain.BusiSettlementHistory;
import com.ruoyi.busi.settlement.service.IBusiSettlementHistoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 业务费用结算历史Controller
 *
 * @author ruoyi
 * @date 2021-02-19
 */
@Controller
@RequestMapping("/busi/history")
public class BusiSettlementHistoryController extends BaseController
{
    private String prefix = "busi/history";

    @Autowired
    private IBusiSettlementHistoryService busiSettlementHistoryService;

    @RequiresPermissions("busi:history:view")
    @GetMapping()
    public String history(String settlementId,ModelMap modelMap)
    {
        modelMap.put("settlementId",settlementId);
        return prefix + "/history";
    }

    /**
     * 查询业务费用结算历史列表
     */
    @RequiresPermissions("busi:history:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiSettlementHistory busiSettlementHistory)
    {
        List<BusiSettlementHistory> list = busiSettlementHistoryService.selectBusiSettlementHistoryList(busiSettlementHistory);
        return getDataTable(list);
    }

    /**
     * 导出业务费用结算历史列表
     */
    @RequiresPermissions("busi:history:export")
    @Log(title = "业务费用结算历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiSettlementHistory busiSettlementHistory)
    {
        List<BusiSettlementHistory> list = busiSettlementHistoryService.selectBusiSettlementHistoryList(busiSettlementHistory);
        ExcelUtil<BusiSettlementHistory> util = new ExcelUtil<BusiSettlementHistory>(BusiSettlementHistory.class);
        return util.exportExcel(list, "history");
    }

    /**
     * 新增业务费用结算历史
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存业务费用结算历史
     */
    @RequiresPermissions("busi:history:add")
    @Log(title = "业务费用结算历史", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiSettlementHistory busiSettlementHistory)
    {
        return toAjax(busiSettlementHistoryService.insertBusiSettlementHistory(busiSettlementHistory));
    }

    /**
     * 修改业务费用结算历史
     */
    @GetMapping("/edit/{basedCommission}")
    public String edit(@PathVariable("basedCommission") Double basedCommission, ModelMap mmap)
    {
        BusiSettlementHistory busiSettlementHistory = busiSettlementHistoryService.selectBusiSettlementHistoryById(basedCommission);
        mmap.put("busiSettlementHistory", busiSettlementHistory);
        return prefix + "/edit";
    }

    /**
     * 修改保存业务费用结算历史
     */
    @RequiresPermissions("busi:history:edit")
    @Log(title = "业务费用结算历史", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiSettlementHistory busiSettlementHistory)
    {
        return toAjax(busiSettlementHistoryService.updateBusiSettlementHistory(busiSettlementHistory));
    }

    /**
     * 删除业务费用结算历史
     */
    @RequiresPermissions("busi:history:remove")
    @Log(title = "业务费用结算历史", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiSettlementHistoryService.deleteBusiSettlementHistoryByIds(ids));
    }
}
