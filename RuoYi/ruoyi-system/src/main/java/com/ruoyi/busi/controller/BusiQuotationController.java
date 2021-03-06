package com.ruoyi.busi.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ruoyi.busi.Constant;
import com.ruoyi.busi.domain.BusiCustomer;
import com.ruoyi.busi.mapper.BusiPriceDetailsMapper;
import com.ruoyi.busi.parts.mapper.BusiPartsDetailsMapper;
import com.ruoyi.busi.service.IBusiCustomerService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
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
import com.ruoyi.busi.domain.BusiQuotation;
import com.ruoyi.busi.service.IBusiQuotationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报价单管理Controller
 *
 * @author ruoyi
 * @date 2021-01-12
 */
@Controller
@RequestMapping("/busi/quotation")
public class BusiQuotationController extends BaseController
{
    private String prefix = "busi/quotation";

    @Autowired
    private IBusiQuotationService busiQuotationService;

    @Autowired
    private IBusiCustomerService customerService;

    @Autowired
    private BusiPriceDetailsMapper busiPriceDetailsMapper;

    @RequiresPermissions("busi:quotation:view")
    @GetMapping()
    public String quotation(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/quotation";
    }

    /**
     * 查询报价单管理列表
     */
    @RequiresPermissions("busi:quotation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiQuotation busiQuotation)
    {
        startPage();
        List<BusiQuotation> list = busiQuotationService.selectBusiQuotationList(busiQuotation);
        return getDataTable(list);
    }

    /**
     * 导出报价单管理列表
     */
    @RequiresPermissions("busi:quotation:export")
    @Log(title = "报价单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiQuotation busiQuotation)
    {
        List<BusiQuotation> list = busiQuotationService.selectBusiQuotationList(busiQuotation);
        list.forEach(l -> {
            l.setAllCount(null);
            l.setSumPrice(null);
        });
        ExcelUtil<BusiQuotation> util = new ExcelUtil<BusiQuotation>(BusiQuotation.class);
        return util.exportExcel(list, "quotation");
    }

    /**
     * 新增报价单管理
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存报价单管理
     */
    @RequiresPermissions("busi:quotation:add")
    @Log(title = "报价单管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiQuotation busiQuotation)
    {
        Long customerId = busiQuotation.getCustomerId();
        BusiCustomer customer = customerService.selectBusiCustomerById(customerId);
        String pinYin = Constant.getSfPinyin(busiQuotation.getProvince());
        Integer endCount = busiQuotationService.selectEndCount(pinYin);
        String endCountStr = endCount != null ? (endCount+1)+"":"1";
        if (endCountStr.length() < 3){
            String qz = "";
            for (int i = 0; i < 3 - endCountStr.length(); i++) {
                qz += "0";
            }
            endCountStr =    qz + endCountStr;
        }
        busiQuotation.setProjectAddress(busiQuotation.getProvince()+busiQuotation.getCity()+busiQuotation.getArea());
        String quotationNo = DateUtils.dateTimeNow("YYYY-MM")+"-"+pinYin+"-"+endCountStr+"-A";
        busiQuotation.setProvince(pinYin);
        busiQuotation.setQuotationNo(quotationNo);
        busiQuotation.setCreateTime(new Date());
        busiQuotationService.insertBusiQuotation(busiQuotation);
        return success(busiQuotation.getQuotationId().toString());
    }

    /**
     * 修改报价单管理
     */
    @GetMapping("/edit/{quotationId}")
    public String edit(@PathVariable("quotationId") Long quotationId, ModelMap mmap)
    {

        BusiQuotation busiQuotation = busiQuotationService.selectBusiQuotationById(quotationId);
        mmap.put("busiQuotation", busiQuotation);
        return prefix + "/edit";
    }

    /**
     * 修改保存报价单管理
     */
    @RequiresPermissions("busi:quotation:edit")
    @Log(title = "报价单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiQuotation busiQuotation)
    {
        return toAjax(busiQuotationService.updateBusiQuotation(busiQuotation));
    }

    /**
     * 删除报价单管理
     */
    @RequiresPermissions("busi:quotation:remove")
    @Log(title = "报价单管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiQuotationService.deleteBusiQuotationByIds(ids));
    }
}
