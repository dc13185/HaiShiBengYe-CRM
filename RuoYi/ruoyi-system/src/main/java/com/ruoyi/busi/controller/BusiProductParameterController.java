package com.ruoyi.busi.controller;

import java.util.List;

import com.ruoyi.busi.mapper.BusiProductParameterMapper;
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
import com.ruoyi.busi.domain.BusiProductParameter;
import com.ruoyi.busi.service.IBusiProductParameterService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 生产参数Controller
 *
 * @author ruoyi
 * @date 2021-01-10
 */
@Controller
@RequestMapping("/busi/parameter")
public class BusiProductParameterController extends BaseController
{
    private String prefix = "busi/parameter";

    @Autowired
    private IBusiProductParameterService busiProductParameterService;

    @Autowired
    private BusiProductParameterMapper busiProductParameterMapper;

    @RequiresPermissions("busi:parameter:view")
    @GetMapping()
    public String parameter(Long modelId,ModelMap modelMap)
    {
        modelMap.put("modelId",modelId);
        return prefix + "/parameter";
    }

    /**
     * 查询生产参数列表
     */
    @RequiresPermissions("busi:parameter:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiProductParameter busiProductParameter)
    {
        startPage();
        List<BusiProductParameter> list = busiProductParameterService.selectBusiProductParameterList(busiProductParameter);
        return getDataTable(list);
    }

    /**
     * 导出生产参数列表
     */
    @RequiresPermissions("busi:parameter:export")
    @Log(title = "生产参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiProductParameter busiProductParameter)
    {
        List<BusiProductParameter> list = busiProductParameterMapper.selectBusiProductParameterListExport(busiProductParameter);
        ExcelUtil<BusiProductParameter> util = new ExcelUtil<BusiProductParameter>(BusiProductParameter.class);
        return util.exportExcel(list, "产品参数表");
    }

    /**
     * 新增生产参数
     */
    @GetMapping("/add")
    public String add(Long modelId,ModelMap modelMap)
    {
        modelMap.put("modelId",modelId);
        return prefix + "/add";
    }

    /**
     * 修改生产参数
     */
    @GetMapping("/edit/{parameterId}")
    public String edit(@PathVariable("parameterId") Long parameterId, ModelMap mmap)
    {
        BusiProductParameter busiProductParameter = busiProductParameterService.selectBusiProductParameterById(parameterId);
        mmap.put("busiProductParameter", busiProductParameter);
        return prefix + "/edit";
    }

    /**
     * 新增保存生产参数
     */
    @RequiresPermissions("busi:parameter:add")
    @Log(title = "生产参数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiProductParameter busiProductParameter)
    {
        return toAjax(busiProductParameterService.insertBusiProductParameter(busiProductParameter));
    }

    /**
     * 修改保存生产参数
     */
    @RequiresPermissions("busi:parameter:edit")
    @Log(title = "生产参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiProductParameter busiProductParameter)
    {
        return toAjax(busiProductParameterService.updateBusiProductParameter(busiProductParameter));
    }

    /**
     * 删除生产参数
     */
    @RequiresPermissions("busi:parameter:remove")
    @Log(title = "生产参数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiProductParameterService.deleteBusiProductParameterByIds(ids));
    }
}
