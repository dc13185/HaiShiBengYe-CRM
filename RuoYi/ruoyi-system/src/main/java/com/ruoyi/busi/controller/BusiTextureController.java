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
import com.ruoyi.busi.domain.BusiTexture;
import com.ruoyi.busi.service.IBusiTextureService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 材质管理Controller
 *
 * @author ruoyi
 * @date 2021-01-21
 */
@Controller
@RequestMapping("/busi/texture")
public class BusiTextureController extends BaseController
{
    private String prefix = "busi/texture";

    @Autowired
    private IBusiTextureService busiTextureService;

    @RequiresPermissions("busi:texture:view")
    @GetMapping()
    public String texture()
    {
        return prefix + "/texture";
    }

    /**
     * 查询材质管理列表
     */
    @RequiresPermissions("busi:texture:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiTexture busiTexture)
    {
        startPage();
        List<BusiTexture> list = busiTextureService.selectBusiTextureList(busiTexture);
        return getDataTable(list);
    }

    /**
     * 导出材质管理列表
     */
    @RequiresPermissions("busi:texture:export")
    @Log(title = "材质管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiTexture busiTexture)
    {
        List<BusiTexture> list = busiTextureService.selectBusiTextureList(busiTexture);
        ExcelUtil<BusiTexture> util = new ExcelUtil<BusiTexture>(BusiTexture.class);
        return util.exportExcel(list, "texture");
    }

    /**
     * 新增材质管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存材质管理
     */
    @RequiresPermissions("busi:texture:add")
    @Log(title = "材质管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiTexture busiTexture)
    {
        return toAjax(busiTextureService.insertBusiTexture(busiTexture));
    }

    /**
     * 修改材质管理
     */
    @GetMapping("/edit/{textureId}")
    public String edit(@PathVariable("textureId") Long textureId, ModelMap mmap)
    {
        BusiTexture busiTexture = busiTextureService.selectBusiTextureById(textureId);
        mmap.put("busiTexture", busiTexture);
        return prefix + "/edit";
    }

    /**
     * 修改保存材质管理
     */
    @RequiresPermissions("busi:texture:edit")
    @Log(title = "材质管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiTexture busiTexture)
    {
        return toAjax(busiTextureService.updateBusiTexture(busiTexture));
    }

    /**
     * 删除材质管理
     */
    @RequiresPermissions("busi:texture:remove")
    @Log(title = "材质管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiTextureService.deleteBusiTextureByIds(ids));
    }
}
