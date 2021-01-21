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
import com.ruoyi.busi.domain.BusiTechnicist;
import com.ruoyi.busi.service.IBusiTechnicistService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 选型技术人员管理Controller
 *
 * @author ruoyi
 * @date 2021-01-20
 */
@Controller
@RequestMapping("/busi/technicist")
public class BusiTechnicistController extends BaseController
{
    private String prefix = "busi/technicist";

    @Autowired
    private IBusiTechnicistService busiTechnicistService;

    @RequiresPermissions("busi:technicist:view")
    @GetMapping()
    public String technicist(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/technicist";
    }

    /**
     * 查询选型技术人员管理列表
     */
    @RequiresPermissions("busi:technicist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiTechnicist busiTechnicist)
    {
        startPage();
        List<BusiTechnicist> list = busiTechnicistService.selectBusiTechnicistList(busiTechnicist);
        return getDataTable(list);
    }

    /**
     * 导出选型技术人员管理列表
     */
    @RequiresPermissions("busi:technicist:export")
    @Log(title = "选型技术人员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiTechnicist busiTechnicist)
    {
        List<BusiTechnicist> list = busiTechnicistService.selectBusiTechnicistList(busiTechnicist);
        ExcelUtil<BusiTechnicist> util = new ExcelUtil<BusiTechnicist>(BusiTechnicist.class);
        return util.exportExcel(list, "technicist");
    }

    /**
     * 新增选型技术人员管理
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存选型技术人员管理
     */
    @RequiresPermissions("busi:technicist:add")
    @Log(title = "选型技术人员管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiTechnicist busiTechnicist)
    {
        return toAjax(busiTechnicistService.insertBusiTechnicist(busiTechnicist));
    }

    /**
     * 修改选型技术人员管理
     */
    @GetMapping("/edit/{technicistId}")
    public String edit(@PathVariable("technicistId") Long technicistId, ModelMap mmap)
    {
        BusiTechnicist busiTechnicist = busiTechnicistService.selectBusiTechnicistById(technicistId);
        mmap.put("busiTechnicist", busiTechnicist);
        return prefix + "/edit";
    }

    /**
     * 修改保存选型技术人员管理
     */
    @RequiresPermissions("busi:technicist:edit")
    @Log(title = "选型技术人员管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiTechnicist busiTechnicist)
    {
        return toAjax(busiTechnicistService.updateBusiTechnicist(busiTechnicist));
    }

    /**
     * 删除选型技术人员管理
     */
    @RequiresPermissions("busi:technicist:remove")
    @Log(title = "选型技术人员管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiTechnicistService.deleteBusiTechnicistByIds(ids));
    }
}
