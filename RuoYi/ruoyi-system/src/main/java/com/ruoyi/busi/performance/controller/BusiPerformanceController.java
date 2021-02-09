package com.ruoyi.busi.performance.controller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ruoyi.busi.performance.domain.BusiOfficePerformance;
import org.apache.commons.compress.utils.Lists;
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
import com.ruoyi.busi.performance.domain.BusiPerformance;
import com.ruoyi.busi.performance.service.IBusiPerformanceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 业绩管理Controller
 *
 * @author ruoyi
 * @date 2021-02-07
 */
@Controller
@RequestMapping("/busi/performance")
public class BusiPerformanceController extends BaseController
{
    private String prefix = "busi/performance";

    @Autowired
    private IBusiPerformanceService busiPerformanceService;

    @RequiresPermissions("busi:performance:view")
    @GetMapping()
    public String performance()
    {
        return prefix + "/performance";
    }

    /**
     * 查询业绩管理列表
     */
    @RequiresPermissions("busi:performance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiPerformance busiPerformance)
    {
        startPage();
        List<BusiPerformance> list = busiPerformanceService.selectBusiPerformanceList(busiPerformance);
        return getDataTable(list);
    }


    @RequiresPermissions("busi:performance:list")
    @PostMapping("/officeList")
    @ResponseBody
    public TableDataInfo officeList(BusiPerformance busiPerformance)
    {
        List<BusiPerformance> list = busiPerformanceService.selectBusiPerformanceList(busiPerformance);
        list = list.parallelStream().peek(l -> {
            if (l.getContractPrice() == null) {
                l.setContractPrice(0d);
            }
            if (l.getRepaymentAmount() == null) {
                l.setRepaymentAmount(0d);
            }
        }).collect(Collectors.toList());
        List statisticsList = Lists.newArrayList();
        Map<String, Set<BusiPerformance>> sets =  list.stream().collect(Collectors.groupingBy(BusiPerformance::getOfficeAddress, Collectors.toSet()));
        sets.entrySet().forEach(m -> {
            BusiOfficePerformance busiPerformance1 = new BusiOfficePerformance();
            busiPerformance1.setOfficeAddress(m.getKey());
            busiPerformance1.setQuotationPrice(m.getValue().stream().mapToDouble(BusiPerformance::getQuotationPrice).average().getAsDouble());
            busiPerformance1.setPeopleCount(m.getValue().stream().count());
            busiPerformance1.setQuotationCount(m.getValue().stream().mapToLong(BusiPerformance::getQuotationCount).sum());
            busiPerformance1.setContractCount(m.getValue().stream().mapToLong(BusiPerformance::getContractCount).sum());
            busiPerformance1.setContractPrice(m.getValue().stream().mapToDouble(BusiPerformance::getContractPrice).average().getAsDouble());
            busiPerformance1.setRepaymentAmount(m.getValue().stream().mapToDouble(BusiPerformance::getRepaymentAmount).average().getAsDouble());
            busiPerformance1.setSingQuotationPrice(m.getValue().stream().mapToDouble(BusiPerformance::getSingQuotationPrice).average().getAsDouble());
            statisticsList.add(busiPerformance1);
        });

        return getDataTable(statisticsList);
    }

    /**
     * 导出业绩管理列表
     */
    @RequiresPermissions("busi:performance:export")
    @Log(title = "业绩管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiPerformance busiPerformance)
    {
        List<BusiPerformance> list = busiPerformanceService.selectBusiPerformanceList(busiPerformance);
        ExcelUtil<BusiPerformance> util = new ExcelUtil<BusiPerformance>(BusiPerformance.class);
        return util.exportExcel(list, "performance");
    }

    /**
     * 新增业绩管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存业绩管理
     */
    @RequiresPermissions("busi:performance:add")
    @Log(title = "业绩管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiPerformance busiPerformance)
    {
        return toAjax(busiPerformanceService.insertBusiPerformance(busiPerformance));
    }

    /**
     * 修改业绩管理
     */
    @GetMapping("/edit/{performanceId}")
    public String edit(@PathVariable("performanceId") Long performanceId, ModelMap mmap)
    {
        BusiPerformance busiPerformance = busiPerformanceService.selectBusiPerformanceById(performanceId);
        mmap.put("busiPerformance", busiPerformance);
        return prefix + "/edit";
    }

    /**
     * 修改保存业绩管理
     */
    @RequiresPermissions("busi:performance:edit")
    @Log(title = "业绩管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiPerformance busiPerformance)
    {
        return toAjax(busiPerformanceService.updateBusiPerformance(busiPerformance));
    }

    /**
     * 删除业绩管理
     */
    @RequiresPermissions("busi:performance:remove")
    @Log(title = "业绩管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiPerformanceService.deleteBusiPerformanceByIds(ids));
    }
}
