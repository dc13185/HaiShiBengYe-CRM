package com.ruoyi.busi.controller;

import java.util.List;

import com.ruoyi.busi.mapper.BusiMaterialProductionMapper;
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
import com.ruoyi.busi.domain.BusiMaterialProduction;
import com.ruoyi.busi.service.IBusiMaterialProductionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 材料产品Controller
 *
 * @author ruoyi
 * @date 2021-01-01
 */
@Controller
@RequestMapping("/busi/production")
public class BusiMaterialProductionController extends BaseController
{
    private String prefix = "busi/production";

    @Autowired
    private IBusiMaterialProductionService busiMaterialProductionService;

    @Autowired
    private BusiMaterialProductionMapper busiMaterialProductionMapper;

    @RequiresPermissions("system:production:view")
    @GetMapping()
    public String production(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/production";
    }

    /**
     * 查询材料产品列表
     */
    @RequiresPermissions("system:production:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiMaterialProduction busiMaterialProduction)
    {
        startPage();
        List<BusiMaterialProduction> list = busiMaterialProductionService.selectBusiMaterialProductionList(busiMaterialProduction);
        return getDataTable(list);
    }

    /**
     * 导出材料产品列表
     */
    @RequiresPermissions("system:production:export")
    @Log(title = "材料产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiMaterialProduction busiMaterialProduction)
    {
        List<BusiMaterialProduction> list = busiMaterialProductionMapper.selectBusiMaterialProductionListExport(busiMaterialProduction);
        ExcelUtil<BusiMaterialProduction> util = new ExcelUtil<BusiMaterialProduction>(BusiMaterialProduction.class);
        return util.exportExcel(list, "材料产品表");
    }

    /**
     * 新增材料产品
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存材料产品
     */
    @RequiresPermissions("system:production:add")
    @Log(title = "材料产品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiMaterialProduction busiMaterialProduction)
    {
        return toAjax(busiMaterialProductionService.insertBusiMaterialProduction(busiMaterialProduction));
    }

    /**
     * 修改材料产品
     */
    @GetMapping("/edit/{materialId}")
    public String edit(@PathVariable("materialId") Long materialId, ModelMap mmap)
    {
        BusiMaterialProduction busiMaterialProduction = busiMaterialProductionService.selectBusiMaterialProductionById(materialId);
        mmap.put("busiMaterialProduction", busiMaterialProduction);
        return prefix + "/edit";
    }

    /**
     * 修改保存材料产品
     */
    @RequiresPermissions("system:production:edit")
    @Log(title = "材料产品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiMaterialProduction busiMaterialProduction)
    {
        return toAjax(busiMaterialProductionService.updateBusiMaterialProduction(busiMaterialProduction));
    }

    /**
     * 删除材料产品
     */
    @RequiresPermissions("system:production:remove")
    @Log(title = "材料产品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiMaterialProductionService.deleteBusiMaterialProductionByIds(ids));
    }
}
