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
import com.ruoyi.busi.domain.BusiPrice;
import com.ruoyi.busi.service.IBusiPriceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 变价变量Controller
 *
 * @author ruoyi
 * @date 2021-01-20
 */
@Controller
@RequestMapping("/busi/price")
public class BusiPriceController extends BaseController
{
    private String prefix = "busi/price";

    @Autowired
    private IBusiPriceService busiPriceService;

    @RequiresPermissions("busi:price:view")
    @GetMapping()
    public String price(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/price";
    }

    /**
     * 查询变价变量列表
     */
    @RequiresPermissions("busi:price:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiPrice busiPrice)
    {
        startPage();
        List<BusiPrice> list = busiPriceService.selectBusiPriceList(busiPrice);
        return getDataTable(list);
    }

    /**
     * 导出变价变量列表
     */
    @RequiresPermissions("busi:price:export")
    @Log(title = "变价变量", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiPrice busiPrice)
    {
        List<BusiPrice> list = busiPriceService.selectBusiPriceList(busiPrice);
        ExcelUtil<BusiPrice> util = new ExcelUtil<BusiPrice>(BusiPrice.class);
        return util.exportExcel(list, "price");
    }

    /**
     * 新增变价变量
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存变价变量
     */
    @RequiresPermissions("busi:price:add")
    @Log(title = "变价变量", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiPrice busiPrice)
    {
        return toAjax(busiPriceService.insertBusiPrice(busiPrice));
    }

    /**
     * 修改变价变量
     */
    @GetMapping("/edit/{priceId}")
    public String edit(@PathVariable("priceId") Long priceId, ModelMap mmap)
    {
        BusiPrice busiPrice = busiPriceService.selectBusiPriceById(priceId);
        mmap.put("busiPrice", busiPrice);
        return prefix + "/edit";
    }

    /**
     * 修改保存变价变量
     */
    @RequiresPermissions("busi:price:edit")
    @Log(title = "变价变量", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiPrice busiPrice)
    {
        return toAjax(busiPriceService.updateBusiPrice(busiPrice));
    }

    /**
     * 删除变价变量
     */
    @RequiresPermissions("busi:price:remove")
    @Log(title = "变价变量", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiPriceService.deleteBusiPriceByIds(ids));
    }
}
