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
import com.ruoyi.busi.domain.BusiQuotationDetails;
import com.ruoyi.busi.service.IBusiQuotationDetailsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报价明细Controller
 *
 * @author ruoyi
 * @date 2021-01-14
 */
@Controller
@RequestMapping("/busi/details")
public class BusiQuotationDetailsController extends BaseController
{
    private String prefix = "busi/details";

    @Autowired
    private IBusiQuotationDetailsService busiQuotationDetailsService;

    @RequiresPermissions("busi:details:view")
    @GetMapping()
    public String details(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/details";
    }

    /**
     * 查询报价明细列表
     */
    @RequiresPermissions("busi:details:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiQuotationDetails busiQuotationDetails)
    {
        startPage();
        List<BusiQuotationDetails> list = busiQuotationDetailsService.selectBusiQuotationDetailsList(busiQuotationDetails);
        return getDataTable(list);
    }

    /**
     * 导出报价明细列表
     */
    @RequiresPermissions("busi:details:export")
    @Log(title = "报价明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiQuotationDetails busiQuotationDetails)
    {
        List<BusiQuotationDetails> list = busiQuotationDetailsService.selectBusiQuotationDetailsList(busiQuotationDetails);
        ExcelUtil<BusiQuotationDetails> util = new ExcelUtil<BusiQuotationDetails>(BusiQuotationDetails.class);
        return util.exportExcel(list, "details");
    }

    /**
     * 新增报价明细
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存报价明细
     */
    @RequiresPermissions("busi:details:add")
    @Log(title = "报价明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiQuotationDetails busiQuotationDetails)
    {

        //获取数量
        Long number = busiQuotationDetails.getNumber();


        //如果为整机
        if (busiQuotationDetails.getQuotationType() == 0){

        }


        return toAjax(busiQuotationDetailsService.insertBusiQuotationDetails(busiQuotationDetails));
    }

    /**
     * 修改报价明细
     */
    @GetMapping("/edit/{detailsId}")
    public String edit(@PathVariable("detailsId") Long detailsId, ModelMap mmap)
    {
        BusiQuotationDetails busiQuotationDetails = busiQuotationDetailsService.selectBusiQuotationDetailsById(detailsId);
        mmap.put("busiQuotationDetails", busiQuotationDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存报价明细
     */
    @RequiresPermissions("busi:details:edit")
    @Log(title = "报价明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiQuotationDetails busiQuotationDetails)
    {
        return toAjax(busiQuotationDetailsService.updateBusiQuotationDetails(busiQuotationDetails));
    }

    /**
     * 删除报价明细
     */
    @RequiresPermissions("busi:details:remove")
    @Log(title = "报价明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiQuotationDetailsService.deleteBusiQuotationDetailsByIds(ids));
    }
}
