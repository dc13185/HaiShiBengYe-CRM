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
import com.ruoyi.busi.domain.BusiMachineSeal;
import com.ruoyi.busi.service.IBusiMachineSealService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 机封以及系统产品Controller
 *
 * @author ruoyi
 * @date 2021-01-04
 */
@Controller
@RequestMapping("/busi/seal")
public class BusiMachineSealController extends BaseController
{
    private String prefix = "busi/seal";

    @Autowired
    private IBusiMachineSealService busiMachineSealService;

    @RequiresPermissions("busi:seal:view")
    @GetMapping()
    public String seal(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/seal";
    }

    /**
     * 查询机封以及系统产品列表
     */
    @RequiresPermissions("busi:seal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiMachineSeal busiMachineSeal)
    {
        startPage();
        List<BusiMachineSeal> list = busiMachineSealService.selectBusiMachineSealList(busiMachineSeal);
        return getDataTable(list);
    }

    /**
     * 导出机封以及系统产品列表
     */
    @RequiresPermissions("busi:seal:export")
    @Log(title = "机封以及系统产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiMachineSeal busiMachineSeal)
    {
        List<BusiMachineSeal> list = busiMachineSealService.selectBusiMachineSealList(busiMachineSeal);
        ExcelUtil<BusiMachineSeal> util = new ExcelUtil<BusiMachineSeal>(BusiMachineSeal.class);
        return util.exportExcel(list, "seal");
    }

    /**
     * 新增机封以及系统产品
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存机封以及系统产品
     */
    @RequiresPermissions("busi:seal:add")
    @Log(title = "机封以及系统产品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiMachineSeal busiMachineSeal)
    {
        return toAjax(busiMachineSealService.insertBusiMachineSeal(busiMachineSeal));
    }

    /**
     * 修改机封以及系统产品
     */
    @GetMapping("/edit/{machineId}")
    public String edit(@PathVariable("machineId") Long machineId, ModelMap mmap)
    {
        BusiMachineSeal busiMachineSeal = busiMachineSealService.selectBusiMachineSealById(machineId);
        mmap.put("busiMachineSeal", busiMachineSeal);
        return prefix + "/edit";
    }

    /**
     * 修改保存机封以及系统产品
     */
    @RequiresPermissions("busi:seal:edit")
    @Log(title = "机封以及系统产品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiMachineSeal busiMachineSeal)
    {
        return toAjax(busiMachineSealService.updateBusiMachineSeal(busiMachineSeal));
    }

    /**
     * 删除机封以及系统产品
     */
    @RequiresPermissions("busi:seal:remove")
    @Log(title = "机封以及系统产品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiMachineSealService.deleteBusiMachineSealByIds(ids));
    }
}
