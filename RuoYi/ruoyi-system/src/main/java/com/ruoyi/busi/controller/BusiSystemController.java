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
import com.ruoyi.busi.domain.BusiSystem;
import com.ruoyi.busi.service.IBusiSystemService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 机封系统管理Controller
 *
 * @author ruoyi
 * @date 2021-01-09
 */
@Controller
@RequestMapping("/busi/busiSystem")
public class BusiSystemController extends BaseController
{
    private String prefix = "busi/busiSystem";

    @Autowired
    private IBusiSystemService busiSystemService;

    @RequiresPermissions("busi:busiSystem:view")
    @GetMapping()
    public String busiSystem(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/busiSystem";
    }

    /**
     * 查询机封系统管理列表
     */
    @RequiresPermissions("busi:busiSystem:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiSystem busiSystem)
    {
        startPage();
        List<BusiSystem> list = busiSystemService.selectBusiSystemList(busiSystem);
        return getDataTable(list);
    }

    /**
     * 导出机封系统管理列表
     */
    @RequiresPermissions("busi:busiSystem:export")
    @Log(title = "机封系统管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiSystem busiSystem)
    {
        List<BusiSystem> list = busiSystemService.selectBusiSystemList(busiSystem);
        ExcelUtil<BusiSystem> util = new ExcelUtil<BusiSystem>(BusiSystem.class);
        return util.exportExcel(list, "busiSystem");
    }

    /**
     * 新增机封系统管理
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存机封系统管理
     */
    @RequiresPermissions("busi:busiSystem:add")
    @Log(title = "机封系统管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiSystem busiSystem)
    {
        return toAjax(busiSystemService.insertBusiSystem(busiSystem));
    }

    /**
     * 修改机封系统管理
     */
    @GetMapping("/edit/{systemId}")
    public String edit(@PathVariable("systemId") Long systemId, ModelMap mmap)
    {
        BusiSystem busiSystem = busiSystemService.selectBusiSystemById(systemId);
        mmap.put("busiSystem", busiSystem);
        return prefix + "/edit";
    }

    /**
     * 修改保存机封系统管理
     */
    @RequiresPermissions("busi:busiSystem:edit")
    @Log(title = "机封系统管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiSystem busiSystem)
    {
        return toAjax(busiSystemService.updateBusiSystem(busiSystem));
    }

    /**
     * 删除机封系统管理
     */
    @RequiresPermissions("busi:busiSystem:remove")
    @Log(title = "机封系统管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiSystemService.deleteBusiSystemByIds(ids));
    }
}
