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
import com.ruoyi.busi.domain.BusiCustomer;
import com.ruoyi.busi.service.IBusiCustomerService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户管理Controller
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
@Controller
@RequestMapping("/busi/customer")
public class BusiCustomerController extends BaseController
{
    private String prefix = "busi/customer";

    @Autowired
    private IBusiCustomerService busiCustomerService;

    @RequiresPermissions("busi:customer:view")
    @GetMapping()
    public String customer()
    {
        return prefix + "/customer";
    }

    /**
     * 查询客户管理列表
     */
    @RequiresPermissions("busi:customer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiCustomer busiCustomer)
    {
        startPage();
        List<BusiCustomer> list = busiCustomerService.selectBusiCustomerList(busiCustomer);
        return getDataTable(list);
    }

    /**
     * 导出客户管理列表
     */
    @RequiresPermissions("busi:customer:export")
    @Log(title = "客户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiCustomer busiCustomer)
    {
        List<BusiCustomer> list = busiCustomerService.selectBusiCustomerList(busiCustomer);
        ExcelUtil<BusiCustomer> util = new ExcelUtil<BusiCustomer>(BusiCustomer.class);
        return util.exportExcel(list, "customer");
    }

    /**
     * 新增客户管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户管理
     */
    @RequiresPermissions("busi:customer:add")
    @Log(title = "客户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiCustomer busiCustomer)
    {
        return toAjax(busiCustomerService.insertBusiCustomer(busiCustomer));
    }

    /**
     * 修改客户管理
     */
    @GetMapping("/edit/{customerId}")
    public String edit(@PathVariable("customerId") Long customerId, ModelMap mmap)
    {
        BusiCustomer busiCustomer = busiCustomerService.selectBusiCustomerById(customerId);
        mmap.put("busiCustomer", busiCustomer);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户管理
     */
    @RequiresPermissions("busi:customer:edit")
    @Log(title = "客户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiCustomer busiCustomer)
    {
        return toAjax(busiCustomerService.updateBusiCustomer(busiCustomer));
    }

    /**
     * 删除客户管理
     */
    @RequiresPermissions("busi:customer:remove")
    @Log(title = "客户管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiCustomerService.deleteBusiCustomerByIds(ids));
    }
}
