package com.ruoyi.busi.controller;

import java.util.List;

import com.ruoyi.busi.domain.BusiMachine;
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
import com.ruoyi.busi.domain.BusiSeal;
import com.ruoyi.busi.service.IBusiSealService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 冲洗方案管理Controller
 *
 * @author ruoyi
 * @date 2021-01-09
 */
@Controller
@RequestMapping("/busi/rinse")
public class BusiSealController extends BaseController
{
    private String prefix = "busi/rinse";

    @Autowired
    private IBusiSealService busiSealService;

    @RequiresPermissions("busi:rinse:view")
    @GetMapping()
    public String rinse(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/rinse";
    }

    /**
     * 查询冲洗方案管理列表
     */
    @RequiresPermissions("busi:rinse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiSeal busiSeal)
    {
        startPage();
        List<BusiSeal> list = busiSealService.selectBusiSealList(busiSeal);
        return getDataTable(list);
    }

    /**
     * 导出冲洗方案管理列表
     */
    @RequiresPermissions("busi:rinse:export")
    @Log(title = "冲洗方案管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiSeal busiSeal)
    {
        List<BusiSeal> list = busiSealService.selectBusiSealList(busiSeal);
        ExcelUtil<BusiSeal> util = new ExcelUtil<BusiSeal>(BusiSeal.class);
        return util.exportExcel(list, "rinse");
    }

    @RequiresPermissions("busi:machine:edit")
    @Log(title = "机封型号", businessType = BusinessType.EXPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, String supplierId) throws Exception {
        ExcelUtil<BusiSeal> util = new ExcelUtil<>(BusiSeal.class);
        List<BusiSeal> userList = util.importExcel(file.getInputStream());
        for (BusiSeal busiMotor : userList) {
            busiMotor.setSupplierId(supplierId);
            busiSealService.insertBusiSeal(busiMotor);
        }
        return AjaxResult.success();
    }

    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BusiSeal> util = new ExcelUtil<BusiSeal>(BusiSeal.class);
        return util.importTemplateExcel("冲洗系统");
    }


    /**
     * 新增冲洗方案管理
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存冲洗方案管理
     */
    @RequiresPermissions("busi:rinse:add")
    @Log(title = "冲洗方案管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiSeal busiSeal)
    {
        return toAjax(busiSealService.insertBusiSeal(busiSeal));
    }

    /**
     * 修改冲洗方案管理
     */
    @GetMapping("/edit/{sealId}")
    public String edit(@PathVariable("sealId") Long sealId, ModelMap mmap)
    {
        BusiSeal busiSeal = busiSealService.selectBusiSealById(sealId);
        mmap.put("busiSeal", busiSeal);
        return prefix + "/edit";
    }

    /**
     * 修改保存冲洗方案管理
     */
    @RequiresPermissions("busi:rinse:edit")
    @Log(title = "冲洗方案管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiSeal busiSeal)
    {
        return toAjax(busiSealService.updateBusiSeal(busiSeal));
    }

    /**
     * 删除冲洗方案管理
     */
    @RequiresPermissions("busi:rinse:remove")
    @Log(title = "冲洗方案管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiSealService.deleteBusiSealByIds(ids));
    }
}
