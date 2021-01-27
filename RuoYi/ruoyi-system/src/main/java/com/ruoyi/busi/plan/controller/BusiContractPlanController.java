package com.ruoyi.busi.plan.controller;

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
import com.ruoyi.busi.plan.domain.BusiContractPlan;
import com.ruoyi.busi.plan.service.IBusiContractPlanService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合同进度Controller
 *
 * @author ruoyi
 * @date 2021-01-25
 */
@Controller
@RequestMapping("/busi.plan/plan")
public class BusiContractPlanController extends BaseController
{
    private String prefix = "busi/plan";

    @Autowired
    private IBusiContractPlanService busiContractPlanService;

    @RequiresPermissions("busi.plan:plan:view")
    @GetMapping()
    public String plan()
    {
        return prefix + "/plan";
    }

    /**
     * 查询合同进度列表
     */
    @RequiresPermissions("busi.plan:plan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiContractPlan busiContractPlan)
    {
        startPage();
        List<BusiContractPlan> list = busiContractPlanService.selectBusiContractPlanList(busiContractPlan);
        return getDataTable(list);
    }

    /**
     * 导出合同进度列表
     */
    @RequiresPermissions("busi.plan:plan:export")
    @Log(title = "合同进度", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiContractPlan busiContractPlan)
    {
        List<BusiContractPlan> list = busiContractPlanService.selectBusiContractPlanList(busiContractPlan);
        ExcelUtil<BusiContractPlan> util = new ExcelUtil<BusiContractPlan>(BusiContractPlan.class);
        return util.exportExcel(list, "plan");
    }

    /**
     * 新增合同进度
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存合同进度
     */
    @RequiresPermissions("busi.plan:plan:add")
    @Log(title = "合同进度", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiContractPlan busiContractPlan)
    {
        return toAjax(busiContractPlanService.insertBusiContractPlan(busiContractPlan));
    }

    /**
     * 修改合同进度
     */
    @GetMapping("/edit/{planId}")
    public String edit(@PathVariable("planId") Long planId, ModelMap mmap)
    {
        BusiContractPlan busiContractPlan = busiContractPlanService.selectBusiContractPlanById(planId);
        mmap.put("busiContractPlan", busiContractPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存合同进度
     */
    @RequiresPermissions("busi.plan:plan:edit")
    @Log(title = "合同进度", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiContractPlan busiContractPlan)
    {
        return toAjax(busiContractPlanService.updateBusiContractPlan(busiContractPlan));
    }

    /**
     * 删除合同进度
     */
    @RequiresPermissions("busi.plan:plan:remove")
    @Log(title = "合同进度", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiContractPlanService.deleteBusiContractPlanByIds(ids));
    }
}
