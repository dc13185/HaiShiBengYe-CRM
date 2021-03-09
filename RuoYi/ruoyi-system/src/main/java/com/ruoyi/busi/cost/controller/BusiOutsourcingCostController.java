package com.ruoyi.busi.cost.controller;

import java.util.List;

import com.ruoyi.busi.domain.BusiBearing;
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
import com.ruoyi.busi.cost.domain.BusiOutsourcingCost;
import com.ruoyi.busi.cost.service.IBusiOutsourcingCostService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 外购电机成本明细Controller
 *
 * @author ruoyi
 * @date 2021-02-02
 */
@Controller
@RequestMapping("/busi/cost")
public class BusiOutsourcingCostController extends BaseController
{
    private String prefix = "busi/cost";

    @Autowired
    private IBusiOutsourcingCostService busiOutsourcingCostService;

    @RequiresPermissions("busi:cost:view")
    @GetMapping()
    public String cost()
    {
        return prefix + "/cost";
    }

    /**
     * 查询外购电机成本明细列表
     */
    @ResponseBody
    public TableDataInfo list(BusiOutsourcingCost busiOutsourcingCost)
    {
        startPage();
        List<BusiOutsourcingCost> list = busiOutsourcingCostService.selectBusiOutsourcingCostList(busiOutsourcingCost);
        return getDataTable(list);
    }

    /**
     * 导出外购电机成本明细列表
     */
    @Log(title = "外购电机成本明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiOutsourcingCost busiOutsourcingCost)
    {
        List<BusiOutsourcingCost> list = busiOutsourcingCostService.selectBusiOutsourcingCostList(busiOutsourcingCost);
        ExcelUtil<BusiOutsourcingCost> util = new ExcelUtil<BusiOutsourcingCost>(BusiOutsourcingCost.class);
        return util.exportExcel(list, "cost");
    }

    /**
     * 新增外购电机成本明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存外购电机成本明细
     */
    @Log(title = "外购电机成本明细", businessType = BusinessType.INSERT)
    @PostMapping("/addSave")
    @ResponseBody
    public AjaxResult addSave(BusiOutsourcingCost busiOutsourcingCost)
    {
        return toAjax(busiOutsourcingCostService.insertBusiOutsourcingCost(busiOutsourcingCost));
    }




    /**
     * 修改外购电机成本明细
     */
    @GetMapping("/edit/{costId}")
    public String edit(@PathVariable("costId") Long costId, ModelMap mmap)
    {
        BusiOutsourcingCost busiOutsourcingCost = busiOutsourcingCostService.selectBusiOutsourcingCostById(costId);
        mmap.put("busiOutsourcingCost", busiOutsourcingCost);
        return prefix + "/edit";
    }

    /**
     * 修改保存外购电机成本明细
     */
    @Log(title = "外购电机成本明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiOutsourcingCost busiOutsourcingCost)
    {
        return toAjax(busiOutsourcingCostService.updateBusiOutsourcingCost(busiOutsourcingCost));
    }

    /**
     * 删除外购电机成本明细
     */
    @Log(title = "外购电机成本明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiOutsourcingCostService.deleteBusiOutsourcingCostByIds(ids));
    }
}
