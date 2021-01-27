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
import com.ruoyi.busi.domain.BusiMotor;
import com.ruoyi.busi.service.IBusiMotorService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 电机产品Controller
 *
 * @author ruoyi
 * @date 2021-01-01
 */
@Controller
@RequestMapping("/busi/motor")
public class BusiMotorController extends BaseController
{
    private String prefix = "busi/motor";

    @Autowired
    private IBusiMotorService busiMotorService;

    @RequiresPermissions("busi:motor:view")
    @GetMapping()
    public String motor(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/motor";
    }

    /**
     * 查询电机产品列表
     */
    @RequiresPermissions("busi:motor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiMotor busiMotor)
    {
        startPage();
        List<BusiMotor> list = busiMotorService.selectBusiMotorList(busiMotor);
        return getDataTable(list);
    }

    /**
     * 导出电机产品列表
     */
    @RequiresPermissions("busi:motor:export")
    @Log(title = "电机产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiMotor busiMotor)
    {
        List<BusiMotor> list = busiMotorService.selectBusiMotorList(busiMotor);
        ExcelUtil<BusiMotor> util = new ExcelUtil<BusiMotor>(BusiMotor.class);
        return util.exportExcel(list, "motor");
    }

    /**
     * 新增电机产品
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存电机产品
     */
    @RequiresPermissions("busi:motor:add")
    @Log(title = "电机产品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiMotor busiMotor)
    {
        return toAjax(busiMotorService.insertBusiMotor(busiMotor));
    }

    /**
     * 修改电机产品
     */
    @GetMapping("/edit/{motorId}")
    public String edit(@PathVariable("motorId") Long motorId, ModelMap mmap)
    {
        BusiMotor busiMotor = busiMotorService.selectBusiMotorById(motorId);
        mmap.put("busiMotor", busiMotor);
        return prefix + "/edit";
    }

    /**
     * 修改保存电机产品
     */
    @RequiresPermissions("busi:motor:edit")
    @Log(title = "电机产品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiMotor busiMotor)
    {
        return toAjax(busiMotorService.updateBusiMotor(busiMotor));
    }

    /**
     * 删除电机产品
     */
    @RequiresPermissions("busi:motor:remove")
    @Log(title = "电机产品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiMotorService.deleteBusiMotorByIds(ids));
    }
}
