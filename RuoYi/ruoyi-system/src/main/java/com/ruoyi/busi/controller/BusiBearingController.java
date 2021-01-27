package com.ruoyi.busi.controller;

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
import com.ruoyi.busi.domain.BusiBearing;
import com.ruoyi.busi.service.IBusiBearingService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 轴承供应商Controller
 *
 * @author ruoyi
 * @date 2021-01-04
 */
@Controller
@RequestMapping("/busi/bearing")
public class BusiBearingController extends BaseController
{
    private String prefix = "busi/bearing";

    @Autowired
    private IBusiBearingService busiBearingService;

    @RequiresPermissions("busi:bearing:view")
    @GetMapping()
    public String bearing(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/bearing";
    }

    /**
     * 查询轴承供应商列表
     */
    @RequiresPermissions("busi:bearing:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiBearing busiBearing)
    {
        startPage();
        List<BusiBearing> list = busiBearingService.selectBusiBearingList(busiBearing);
        return getDataTable(list);
    }

    /**
     * 导出轴承供应商列表
     */
    @RequiresPermissions("busi:bearing:export")
    @Log(title = "轴承供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiBearing busiBearing)
    {
        List<BusiBearing> list = busiBearingService.selectBusiBearingList(busiBearing);
        ExcelUtil<BusiBearing> util = new ExcelUtil<BusiBearing>(BusiBearing.class);
        return util.exportExcel(list, "bearing");
    }

    /**
     * 新增轴承供应商
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存轴承供应商
     */
    @RequiresPermissions("busi:bearing:add")
    @Log(title = "轴承供应商", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiBearing busiBearing)
    {
        return toAjax(busiBearingService.insertBusiBearing(busiBearing));
    }

    /**
     * 修改轴承供应商
     */
    @GetMapping("/edit/{bearingId}")
    public String edit(@PathVariable("bearingId") Long bearingId, ModelMap mmap)
    {
        BusiBearing busiBearing = busiBearingService.selectBusiBearingById(bearingId);
        mmap.put("busiBearing", busiBearing);
        return prefix + "/edit";
    }

    /**
     * 修改保存轴承供应商
     */
    @RequiresPermissions("busi:bearing:edit")
    @Log(title = "轴承供应商", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiBearing busiBearing)
    {
        return toAjax(busiBearingService.updateBusiBearing(busiBearing));
    }

    /**
     * 删除轴承供应商
     */
    @RequiresPermissions("busi:bearing:remove")
    @Log(title = "轴承供应商", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiBearingService.deleteBusiBearingByIds(ids));
    }
}
