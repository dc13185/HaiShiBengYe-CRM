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
import com.ruoyi.busi.domain.BusiProductLine;
import com.ruoyi.busi.service.IBusiProductLineService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品系列管理Controller
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/busi/line")
public class BusiProductLineController extends BaseController
{
    private String prefix = "busi/line";

    @Autowired
    private IBusiProductLineService busiProductLineService;

    @RequiresPermissions("busi:line:view")
    @GetMapping()
    public String line()
    {
        return prefix + "/line";
    }

    /**
     * 查询产品系列管理列表
     */
    @RequiresPermissions("busi:line:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiProductLine busiProductLine)
    {
        startPage();
        List<BusiProductLine> list = busiProductLineService.selectBusiProductLineList(busiProductLine);
        return getDataTable(list);
    }

    /**
     * 导出产品系列管理列表
     */
    @RequiresPermissions("busi:line:export")
    @Log(title = "产品系列管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiProductLine busiProductLine)
    {
        List<BusiProductLine> list = busiProductLineService.selectBusiProductLineList(busiProductLine);
        ExcelUtil<BusiProductLine> util = new ExcelUtil<BusiProductLine>(BusiProductLine.class);
        return util.exportExcel(list, "line");
    }

    /**
     * 新增产品系列管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品系列管理
     */
    @RequiresPermissions("busi:line:add")
    @Log(title = "产品系列管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiProductLine busiProductLine)
    {
        return toAjax(busiProductLineService.insertBusiProductLine(busiProductLine));
    }

    /**
     * 修改产品系列管理
     */
    @GetMapping("/edit/{productLineId}")
    public String edit(@PathVariable("productLineId") Long productLineId, ModelMap mmap)
    {
        BusiProductLine busiProductLine = busiProductLineService.selectBusiProductLineById(productLineId);
        mmap.put("busiProductLine", busiProductLine);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品系列管理
     */
    @RequiresPermissions("busi:line:edit")
    @Log(title = "产品系列管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiProductLine busiProductLine)
    {
        return toAjax(busiProductLineService.updateBusiProductLine(busiProductLine));
    }

    /**
     * 删除产品系列管理
     */
    @RequiresPermissions("busi:line:remove")
    @Log(title = "产品系列管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiProductLineService.deleteBusiProductLineByIds(ids));
    }
}
