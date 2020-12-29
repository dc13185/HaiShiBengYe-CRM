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
import com.ruoyi.busi.domain.BusiAnnexFile;
import com.ruoyi.busi.service.IBusiAnnexFileService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 附件Controller
 * 
 * @author ruoyi
 * @date 2020-12-29
 */
@Controller
@RequestMapping("/system/file")
public class BusiAnnexFileController extends BaseController
{
    private String prefix = "system/file";

    @Autowired
    private IBusiAnnexFileService busiAnnexFileService;

    @RequiresPermissions("system:file:view")
    @GetMapping()
    public String file()
    {
        return prefix + "/file";
    }

    /**
     * 查询附件列表
     */
    @RequiresPermissions("system:file:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiAnnexFile busiAnnexFile)
    {
        startPage();
        List<BusiAnnexFile> list = busiAnnexFileService.selectBusiAnnexFileList(busiAnnexFile);
        return getDataTable(list);
    }

    /**
     * 导出附件列表
     */
    @RequiresPermissions("system:file:export")
    @Log(title = "附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiAnnexFile busiAnnexFile)
    {
        List<BusiAnnexFile> list = busiAnnexFileService.selectBusiAnnexFileList(busiAnnexFile);
        ExcelUtil<BusiAnnexFile> util = new ExcelUtil<BusiAnnexFile>(BusiAnnexFile.class);
        return util.exportExcel(list, "file");
    }

    /**
     * 新增附件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存附件
     */
    @RequiresPermissions("system:file:add")
    @Log(title = "附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiAnnexFile busiAnnexFile)
    {
        return toAjax(busiAnnexFileService.insertBusiAnnexFile(busiAnnexFile));
    }

    /**
     * 修改附件
     */
    @GetMapping("/edit/{annexId}")
    public String edit(@PathVariable("annexId") Long annexId, ModelMap mmap)
    {
        BusiAnnexFile busiAnnexFile = busiAnnexFileService.selectBusiAnnexFileById(annexId);
        mmap.put("busiAnnexFile", busiAnnexFile);
        return prefix + "/edit";
    }

    /**
     * 修改保存附件
     */
    @RequiresPermissions("system:file:edit")
    @Log(title = "附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiAnnexFile busiAnnexFile)
    {
        return toAjax(busiAnnexFileService.updateBusiAnnexFile(busiAnnexFile));
    }

    /**
     * 删除附件
     */
    @RequiresPermissions("system:file:remove")
    @Log(title = "附件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiAnnexFileService.deleteBusiAnnexFileByIds(ids));
    }
}
