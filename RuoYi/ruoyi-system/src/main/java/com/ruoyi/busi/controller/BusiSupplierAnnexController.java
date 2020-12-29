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
import com.ruoyi.busi.domain.BusiSupplierAnnex;
import com.ruoyi.busi.service.IBusiSupplierAnnexService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商附件中间Controller
 * 
 * @author ruoyi
 * @date 2020-12-29
 */
@Controller
@RequestMapping("/system/annex")
public class BusiSupplierAnnexController extends BaseController
{
    private String prefix = "system/annex";

    @Autowired
    private IBusiSupplierAnnexService busiSupplierAnnexService;

    @RequiresPermissions("system:annex:view")
    @GetMapping()
    public String annex()
    {
        return prefix + "/annex";
    }

    /**
     * 查询供应商附件中间列表
     */
    @RequiresPermissions("system:annex:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiSupplierAnnex busiSupplierAnnex)
    {
        startPage();
        List<BusiSupplierAnnex> list = busiSupplierAnnexService.selectBusiSupplierAnnexList(busiSupplierAnnex);
        return getDataTable(list);
    }

    /**
     * 导出供应商附件中间列表
     */
    @RequiresPermissions("system:annex:export")
    @Log(title = "供应商附件中间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiSupplierAnnex busiSupplierAnnex)
    {
        List<BusiSupplierAnnex> list = busiSupplierAnnexService.selectBusiSupplierAnnexList(busiSupplierAnnex);
        ExcelUtil<BusiSupplierAnnex> util = new ExcelUtil<BusiSupplierAnnex>(BusiSupplierAnnex.class);
        return util.exportExcel(list, "annex");
    }

    /**
     * 新增供应商附件中间
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存供应商附件中间
     */
    @RequiresPermissions("system:annex:add")
    @Log(title = "供应商附件中间", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiSupplierAnnex busiSupplierAnnex)
    {
        return toAjax(busiSupplierAnnexService.insertBusiSupplierAnnex(busiSupplierAnnex));
    }

    /**
     * 修改供应商附件中间
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BusiSupplierAnnex busiSupplierAnnex = busiSupplierAnnexService.selectBusiSupplierAnnexById(id);
        mmap.put("busiSupplierAnnex", busiSupplierAnnex);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商附件中间
     */
    @RequiresPermissions("system:annex:edit")
    @Log(title = "供应商附件中间", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiSupplierAnnex busiSupplierAnnex)
    {
        return toAjax(busiSupplierAnnexService.updateBusiSupplierAnnex(busiSupplierAnnex));
    }

    /**
     * 删除供应商附件中间
     */
    @RequiresPermissions("system:annex:remove")
    @Log(title = "供应商附件中间", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiSupplierAnnexService.deleteBusiSupplierAnnexByIds(ids));
    }
}
