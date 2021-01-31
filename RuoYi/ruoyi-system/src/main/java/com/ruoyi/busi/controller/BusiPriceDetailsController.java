package com.ruoyi.busi.controller;

import java.util.List;

import com.ruoyi.busi.mapper.BusiPriceDetailsMapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.busi.domain.BusiPriceDetails;
import com.ruoyi.busi.service.IBusiPriceDetailsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报价单报价明细Controller
 *
 * @author ruoyi
 * @date 2021-01-28
 */
@Controller
@RequestMapping("/busi/price/details")
public class BusiPriceDetailsController extends BaseController
{
    private String prefix = "price/details";

    @Autowired
    private IBusiPriceDetailsService busiPriceDetailsService;

    @Autowired
    private BusiPriceDetailsMapper busiPriceDetailsMapper;

    @RequiresPermissions("busi:details:view")
    @GetMapping()
    public String details()
    {
        return prefix + "/details";
    }

    /**
     * 查询报价单报价明细列表
     */
    @RequiresPermissions("busi:details:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiPriceDetails busiPriceDetails)
    {
        startPage();
        List<BusiPriceDetails> list = busiPriceDetailsService.selectBusiPriceDetailsList(busiPriceDetails);
        return getDataTable(list);
    }

    /**
     * 导出报价单报价明细列表
     */
    @RequiresPermissions("busi:details:export")
    @Log(title = "报价单报价明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiPriceDetails busiPriceDetails)
    {
        List<BusiPriceDetails> list = busiPriceDetailsService.selectBusiPriceDetailsList(busiPriceDetails);
        ExcelUtil<BusiPriceDetails> util = new ExcelUtil<BusiPriceDetails>(BusiPriceDetails.class);
        return util.exportExcel(list, "details");
    }

    /**
     * 新增报价单报价明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报价单报价明细
     */
    @RequiresPermissions("busi:details:add")
    @Log(title = "报价单报价明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiPriceDetails busiPriceDetails)
    {
        return toAjax(busiPriceDetailsService.insertBusiPriceDetails(busiPriceDetails));
    }

    /**
     * 修改报价单报价明细
     */
    @GetMapping("/edit/{priceDetailsId}")
    public String edit(@PathVariable("priceDetailsId") Long priceDetailsId, ModelMap mmap)
    {
        BusiPriceDetails busiPriceDetails = busiPriceDetailsService.selectBusiPriceDetailsById(priceDetailsId);
        mmap.put("busiPriceDetails", busiPriceDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存报价单报价明细
     */
    @RequiresPermissions("busi:details:edit")
    @Log(title = "报价单报价明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiPriceDetails busiPriceDetails)
    {
        return toAjax(busiPriceDetailsService.updateBusiPriceDetails(busiPriceDetails));
    }

    /**
     * 删除报价单报价明细
     */
    @RequiresPermissions("busi:details:remove")
    @Log(title = "报价单报价明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiPriceDetailsService.deleteBusiPriceDetailsByIds(ids));
    }


    @RequiresPermissions("busi:details:edit")
    @Log(title = "报价单报价明细", businessType = BusinessType.UPDATE)
    @PostMapping("/searchDetails")
    @ResponseBody
    public AjaxResult searchDetails(@RequestBody  String  quotationNo){
        BusiPriceDetails busiPriceDetails =  busiPriceDetailsMapper.selectBusiPriceDetailsByQuotationNo(quotationNo);
        return  AjaxResult.success(busiPriceDetails);
    }
}