package com.ruoyi.busi.outsourcing.controller;

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
import com.ruoyi.busi.outsourcing.domain.BusiOutsourcing;
import com.ruoyi.busi.outsourcing.service.IBusiOutsourcingService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 外购产品供应商Controller
 *
 * @author ruoyi
 * @date 2021-01-30
 */
@Controller
@RequestMapping("/system/outsourcing")
public class BusiOutsourcingController extends BaseController
{
    private String prefix = "system/outsourcing";

    @Autowired
    private IBusiOutsourcingService busiOutsourcingService;

    @RequiresPermissions("system:outsourcing:view")
    @GetMapping()
    public String outsourcing(String outsourcingLineId,ModelMap modelMap)
    {
        modelMap.put("outsourcingLineId",outsourcingLineId);
        return prefix + "/outsourcing";
    }

    /**
     * 查询外购产品供应商列表
     */
    @RequiresPermissions("system:outsourcing:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiOutsourcing busiOutsourcing)
    {
        startPage();
        List<BusiOutsourcing> list = busiOutsourcingService.selectBusiOutsourcingList(busiOutsourcing);
        return getDataTable(list);
    }

    /**
     * 导出外购产品供应商列表
     */
    @RequiresPermissions("system:outsourcing:export")
    @Log(title = "外购产品供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiOutsourcing busiOutsourcing)
    {
        List<BusiOutsourcing> list = busiOutsourcingService.selectBusiOutsourcingList(busiOutsourcing);
        ExcelUtil<BusiOutsourcing> util = new ExcelUtil<BusiOutsourcing>(BusiOutsourcing.class);
        return util.exportExcel(list, "outsourcing");
    }

    /**
     * 新增外购产品供应商
     */
    @GetMapping("/add")
    public String add(String outsourcingLineId,ModelMap modelMap)
    {
        modelMap.put("outsourcingLineId",outsourcingLineId);
        return prefix + "/add";
    }

    /**
     * 新增保存外购产品供应商
     */
    @RequiresPermissions("system:outsourcing:add")
    @Log(title = "外购产品供应商", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiOutsourcing busiOutsourcing)
    {
        return toAjax(busiOutsourcingService.insertBusiOutsourcing(busiOutsourcing));
    }

    /**
     * 修改外购产品供应商
     */
    @GetMapping("/edit/{outsourcingId}")
    public String edit(@PathVariable("outsourcingId") Long outsourcingId, ModelMap mmap)
    {
        BusiOutsourcing busiOutsourcing = busiOutsourcingService.selectBusiOutsourcingById(outsourcingId);
        mmap.put("busiOutsourcing", busiOutsourcing);
        return prefix + "/edit";
    }

    /**
     * 修改保存外购产品供应商
     */
    @RequiresPermissions("system:outsourcing:edit")
    @Log(title = "外购产品供应商", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiOutsourcing busiOutsourcing)
    {
        return toAjax(busiOutsourcingService.updateBusiOutsourcing(busiOutsourcing));
    }

    /**
     * 删除外购产品供应商
     */
    @RequiresPermissions("system:outsourcing:remove")
    @Log(title = "外购产品供应商", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiOutsourcingService.deleteBusiOutsourcingByIds(ids));
    }
}
