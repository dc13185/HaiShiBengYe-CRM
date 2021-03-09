package com.ruoyi.busi.controller;

import java.util.List;

import com.ruoyi.busi.domain.BusiMotor;
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
import com.ruoyi.busi.domain.BusiMachine;
import com.ruoyi.busi.service.IBusiMachineService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 机封管理Controller
 *
 * @author ruoyi
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/busi/machine")
public class BusiMachineController extends BaseController
{
    private String prefix = "busi/machine";

    @Autowired
    private IBusiMachineService busiMachineService;

    @RequiresPermissions("busi:machine:view")
    @GetMapping()
    public String machine(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/machine";
    }

    /**
     * 查询机封管理列表
     */
    @RequiresPermissions("busi:machine:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiMachine busiMachine)
    {
        startPage();
        List<BusiMachine> list = busiMachineService.selectBusiMachineList(busiMachine);
        return getDataTable(list);
    }

    /**
     * 导出机封管理列表
     */
    @RequiresPermissions("busi:machine:export")
    @Log(title = "机封管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiMachine busiMachine)
    {
        List<BusiMachine> list = busiMachineService.selectBusiMachineList(busiMachine);
        ExcelUtil<BusiMachine> util = new ExcelUtil<BusiMachine>(BusiMachine.class);
        return util.exportExcel(list, "machine");
    }

    /**
     * 新增机封管理
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存机封管理
     */
    @RequiresPermissions("busi:machine:add")
    @Log(title = "机封管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiMachine busiMachine)
    {
        return toAjax(busiMachineService.insertBusiMachine(busiMachine));
    }

    /**
     * 修改机封管理
     */
    @GetMapping("/edit/{machineId}")
    public String edit(@PathVariable("machineId") Long machineId, ModelMap mmap)
    {
        BusiMachine busiMachine = busiMachineService.selectBusiMachineById(machineId);
        mmap.put("busiMachine", busiMachine);
        return prefix + "/edit";
    }

    /**
     * 修改保存机封管理
     */
    @RequiresPermissions("busi:machine:edit")
    @Log(title = "机封管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiMachine busiMachine)
    {
        return toAjax(busiMachineService.updateBusiMachine(busiMachine));
    }


    @RequiresPermissions("busi:machine:edit")
    @Log(title = "机封型号", businessType = BusinessType.EXPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, String supplierId) throws Exception {
        ExcelUtil<BusiMachine> util = new ExcelUtil<>(BusiMachine.class);
        List<BusiMachine> userList = util.importExcel(file.getInputStream());
        for (BusiMachine busiMotor : userList) {
            busiMotor.setSupplierId(supplierId);
            busiMachineService.insertBusiMachine(busiMotor);
        }
        return AjaxResult.success();
    }

    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BusiMachine> util = new ExcelUtil<BusiMachine>(BusiMachine.class);
        return util.importTemplateExcel("机封型号");
    }

    /**
     * 删除机封管理
     */
    @RequiresPermissions("busi:machine:remove")
    @Log(title = "机封管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiMachineService.deleteBusiMachineByIds(ids));
    }
}
