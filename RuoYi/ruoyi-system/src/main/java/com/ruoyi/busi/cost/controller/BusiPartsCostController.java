package com.ruoyi.busi.cost.controller;

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
import com.ruoyi.busi.cost.domain.BusiPartsCost;
import com.ruoyi.busi.cost.service.IBusiPartsCostService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 配件报价成本明细Controller
 *
 * @author ruoyi
 * @date 2021-02-02
 */
@Controller
@RequestMapping("/busi/partsCost")
public class BusiPartsCostController extends BaseController
{
    private String prefix = "busi/partsCost";

    @Autowired
    private IBusiPartsCostService busiPartsCostService;

    @GetMapping()
    public String partsCost()
    {
        return prefix + "/partsCost";
    }

    /**
     * 查询配件报价成本明细列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiPartsCost busiPartsCost)
    {
        startPage();
        List<BusiPartsCost> list = busiPartsCostService.selectBusiPartsCostList(busiPartsCost);
        return getDataTable(list);
    }

    /**
     * 导出配件报价成本明细列表
     */
    @Log(title = "配件报价成本明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiPartsCost busiPartsCost)
    {
        List<BusiPartsCost> list = busiPartsCostService.selectBusiPartsCostList(busiPartsCost);
        ExcelUtil<BusiPartsCost> util = new ExcelUtil<BusiPartsCost>(BusiPartsCost.class);
        return util.exportExcel(list, "partsCost");
    }

    /**
     * 新增配件报价成本明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存配件报价成本明细
     */
    @Log(title = "配件报价成本明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiPartsCost busiPartsCost)
    {
        return toAjax(busiPartsCostService.insertBusiPartsCost(busiPartsCost));
    }

    /**
     * 修改配件报价成本明细
     */
    @GetMapping("/edit/{costId}")
    public String edit(@PathVariable("costId") Long costId, ModelMap mmap)
    {
        BusiPartsCost busiPartsCost = busiPartsCostService.selectBusiPartsCostById(costId);
        mmap.put("busiPartsCost", busiPartsCost);
        return prefix + "/edit";
    }

    /**
     * 修改保存配件报价成本明细
     */
    @Log(title = "配件报价成本明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiPartsCost busiPartsCost)
    {
        return toAjax(busiPartsCostService.updateBusiPartsCost(busiPartsCost));
    }

    /**
     * 删除配件报价成本明细
     */
    @Log(title = "配件报价成本明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiPartsCostService.deleteBusiPartsCostByIds(ids));
    }
}
