package com.ruoyi.busi.controller;

import java.util.Date;
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
import com.ruoyi.busi.domain.OfficeStaff;
import com.ruoyi.busi.service.IOfficeStaffService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 办事处及人员Controller
 *
 * @author ruoyi
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/busi/staff")
public class OfficeStaffController extends BaseController
{
    private String prefix = "busi/staff";

    @Autowired
    private IOfficeStaffService officeStaffService;

    @RequiresPermissions("busi:staff:view")
    @GetMapping()
    public String staff()
    {
        return prefix + "/staff";
    }

    /**
     * 查询办事处及人员列表
     */
    @RequiresPermissions("busi:staff:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OfficeStaff officeStaff)
    {
        startPage();
        List<OfficeStaff> list = officeStaffService.selectOfficeStaffList(officeStaff);
        return getDataTable(list);
    }

    /**
     * 导出办事处及人员列表
     */
    @RequiresPermissions("busi:staff:export")
    @Log(title = "办事处及人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OfficeStaff officeStaff)
    {
        List<OfficeStaff> list = officeStaffService.selectOfficeStaffList(officeStaff);
        ExcelUtil<OfficeStaff> util = new ExcelUtil<OfficeStaff>(OfficeStaff.class);
        return util.exportExcel(list, "staff");
    }

    /**
     * 新增办事处及人员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存办事处及人员
     */
    @RequiresPermissions("busi:staff:add")
    @Log(title = "办事处及人员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OfficeStaff officeStaff)
    {
        officeStaff.setCreateTime(new Date());
        return toAjax(officeStaffService.insertOfficeStaff(officeStaff));
    }

    /**
     * 修改办事处及人员
     */
    @GetMapping("/edit/{officeStaffId}")
    public String edit(@PathVariable("officeStaffId") Long officeStaffId, ModelMap mmap)
    {
        OfficeStaff officeStaff = officeStaffService.selectOfficeStaffById(officeStaffId);
        mmap.put("officeStaff", officeStaff);
        return prefix + "/edit";
    }

    /**
     * 修改保存办事处及人员
     */
    @RequiresPermissions("busi:staff:edit")
    @Log(title = "办事处及人员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OfficeStaff officeStaff)
    {
        return toAjax(officeStaffService.updateOfficeStaff(officeStaff));
    }

    /**
     * 删除办事处及人员
     */
    @RequiresPermissions("busi:staff:remove")
    @Log(title = "办事处及人员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(officeStaffService.deleteOfficeStaffByIds(ids));
    }
}
