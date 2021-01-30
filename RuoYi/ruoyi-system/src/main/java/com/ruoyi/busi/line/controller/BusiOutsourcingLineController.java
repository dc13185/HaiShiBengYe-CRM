package com.ruoyi.busi.line.controller;

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
import com.ruoyi.busi.line.domain.BusiOutsourcingLine;
import com.ruoyi.busi.line.service.IBusiOutsourcingLineService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 外购泵系列Controller
 *
 * @author ruoyi
 * @date 2021-01-30
 */
@Controller
@RequestMapping("/busi/outsourcing/line")
public class BusiOutsourcingLineController extends BaseController
{
    private String prefix = "busi/outsourcing/line";

    @Autowired
    private IBusiOutsourcingLineService busiOutsourcingLineService;

    @RequiresPermissions("busi:line:view")
    @GetMapping()
    public String line(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/line";
    }

    /**
     * 查询外购泵系列列表
     */
    @RequiresPermissions("busi:line:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiOutsourcingLine busiOutsourcingLine)
    {
        startPage();
        List<BusiOutsourcingLine> list = busiOutsourcingLineService.selectBusiOutsourcingLineList(busiOutsourcingLine);
        return getDataTable(list);
    }

    /**
     * 导出外购泵系列列表
     */
    @RequiresPermissions("busi:line:export")
    @Log(title = "外购泵系列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiOutsourcingLine busiOutsourcingLine)
    {
        List<BusiOutsourcingLine> list = busiOutsourcingLineService.selectBusiOutsourcingLineList(busiOutsourcingLine);
        ExcelUtil<BusiOutsourcingLine> util = new ExcelUtil<BusiOutsourcingLine>(BusiOutsourcingLine.class);
        return util.exportExcel(list, "line");
    }

    /**
     * 新增外购泵系列
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存外购泵系列
     */
    @RequiresPermissions("busi:line:add")
    @Log(title = "外购泵系列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiOutsourcingLine busiOutsourcingLine)
    {
        return toAjax(busiOutsourcingLineService.insertBusiOutsourcingLine(busiOutsourcingLine));
    }

    /**
     * 修改外购泵系列
     */
    @GetMapping("/edit/{outsourcingLineId}")
    public String edit(@PathVariable("outsourcingLineId") Long outsourcingLineId, ModelMap mmap)
    {
        BusiOutsourcingLine busiOutsourcingLine = busiOutsourcingLineService.selectBusiOutsourcingLineById(outsourcingLineId);
        mmap.put("busiOutsourcingLine", busiOutsourcingLine);
        return prefix + "/edit";
    }

    /**
     * 修改保存外购泵系列
     */
    @RequiresPermissions("busi:line:edit")
    @Log(title = "外购泵系列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiOutsourcingLine busiOutsourcingLine)
    {
        return toAjax(busiOutsourcingLineService.updateBusiOutsourcingLine(busiOutsourcingLine));
    }

    /**
     * 删除外购泵系列
     */
    @RequiresPermissions("busi:line:remove")
    @Log(title = "外购泵系列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiOutsourcingLineService.deleteBusiOutsourcingLineByIds(ids));
    }
}
