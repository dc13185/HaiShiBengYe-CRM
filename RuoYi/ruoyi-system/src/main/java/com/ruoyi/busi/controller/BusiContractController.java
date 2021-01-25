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
import com.ruoyi.busi.domain.BusiContract;
import com.ruoyi.busi.service.IBusiContractService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合同管理Controller
 *
 * @author ruoyi
 * @date 2021-01-25
 */
@Controller
@RequestMapping("/busi/contract")
public class BusiContractController extends BaseController
{
    private String prefix = "busi/contract";

    @Autowired
    private IBusiContractService busiContractService;

    @RequiresPermissions("busi:contract:view")
    @GetMapping()
    public String contract()
    {
        return prefix + "/contract";
    }

    /**
     * 查询合同管理列表
     */
    @RequiresPermissions("busi:contract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiContract busiContract)
    {
        startPage();
        List<BusiContract> list = busiContractService.selectBusiContractList(busiContract);
        return getDataTable(list);
    }

    /**
     * 导出合同管理列表
     */
    @RequiresPermissions("busi:contract:export")
    @Log(title = "合同管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiContract busiContract)
    {
        List<BusiContract> list = busiContractService.selectBusiContractList(busiContract);
        ExcelUtil<BusiContract> util = new ExcelUtil<BusiContract>(BusiContract.class);
        return util.exportExcel(list, "contract");
    }

    /**
     * 新增合同管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存合同管理
     */
    @RequiresPermissions("busi:contract:add")
    @Log(title = "合同管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiContract busiContract)
    {
        return toAjax(busiContractService.insertBusiContract(busiContract));
    }

    /**
     * 修改合同管理
     */
    @GetMapping("/edit/{contractId}")
    public String edit(@PathVariable("contractId") Long contractId, ModelMap mmap)
    {
        BusiContract busiContract = busiContractService.selectBusiContractById(contractId);
        mmap.put("busiContract", busiContract);
        return prefix + "/edit";
    }

    /**
     * 修改保存合同管理
     */
    @RequiresPermissions("busi:contract:edit")
    @Log(title = "合同管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiContract busiContract)
    {
        return toAjax(busiContractService.updateBusiContract(busiContract));
    }

    /**
     * 删除合同管理
     */
    @RequiresPermissions("busi:contract:remove")
    @Log(title = "合同管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiContractService.deleteBusiContractByIds(ids));
    }
}
