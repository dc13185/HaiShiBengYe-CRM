package com.ruoyi.busi.controller;

import java.util.List;

import com.ruoyi.busi.mapper.BusiProductModelMapper;
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
import com.ruoyi.busi.domain.BusiProductModel;
import com.ruoyi.busi.service.IBusiProductModelService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品模型管理Controller
 *
 * @author ruoyi
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/busi/model")
public class BusiProductModelController extends BaseController
{
    private String prefix = "busi/model";

    @Autowired
    private IBusiProductModelService busiProductModelService;

    @Autowired
    private BusiProductModelMapper busiProductModelMapper;

    @RequiresPermissions("busi:model:view")
    @GetMapping()
    public String model(String productLineId,ModelMap modelMap)
    {
        modelMap.put("productLineId",productLineId);
        return prefix + "/model";
    }

    /**
     * 查询产品模型管理列表
     */
    @RequiresPermissions("busi:model:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiProductModel busiProductModel)
    {
        startPage();
        List<BusiProductModel> list = busiProductModelService.selectBusiProductModelList(busiProductModel);
        return getDataTable(list);
    }

    /**
     * 导出产品模型管理列表
     */
    @RequiresPermissions("busi:model:export")
    @Log(title = "产品模型管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiProductModel busiProductModel)
    {
        List<BusiProductModel> list = busiProductModelMapper.selectBusiProductModelListExport(busiProductModel);
        ExcelUtil<BusiProductModel> util = new ExcelUtil<BusiProductModel>(BusiProductModel.class);
        return util.exportExcel(list, "泵头型号表");
    }

    /**
     * 新增产品模型管理
     */
    @GetMapping("/add")
    public String add(String productLineId,ModelMap modelMap)
    {
        modelMap.put("productLineId",productLineId);
        return prefix + "/add";
    }

    /**
     * 新增保存产品模型管理
     */
    @RequiresPermissions("busi:model:add")
    @Log(title = "产品模型管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiProductModel busiProductModel)
    {
        return toAjax(busiProductModelService.insertBusiProductModel(busiProductModel));
    }

    /**
     * 修改产品模型管理
     */
    @GetMapping("/edit/{modelId}")
    public String edit(@PathVariable("modelId") Long modelId, ModelMap mmap)
    {
        BusiProductModel busiProductModel = busiProductModelService.selectBusiProductModelById(modelId);
        mmap.put("busiProductModel", busiProductModel);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品模型管理
     */
    @RequiresPermissions("busi:model:edit")
    @Log(title = "产品模型管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiProductModel busiProductModel)
    {
        return toAjax(busiProductModelService.updateBusiProductModel(busiProductModel));
    }

    /**
     * 删除产品模型管理
     */
    @RequiresPermissions("busi:model:remove")
    @Log(title = "产品模型管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiProductModelService.deleteBusiProductModelByIds(ids));
    }
}
