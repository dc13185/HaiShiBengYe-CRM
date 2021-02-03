package com.ruoyi.busi.contract.controller;

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
import com.ruoyi.busi.contract.domain.BusiContractProduct;
import com.ruoyi.busi.contract.service.IBusiContractProductService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合同产品组成Controller
 *
 * @author ruoyi
 * @date 2021-02-03
 */
@Controller
@RequestMapping("/contract/product")
public class BusiContractProductController extends BaseController
{
    private String prefix = "busi/contract/product";

    @Autowired
    private IBusiContractProductService busiContractProductService;

    @GetMapping()
    public String product(String contractId,ModelMap model)
    {
        model.put("contractId",contractId);
        return prefix + "/product";
    }

    /**
     * 查询合同产品组成列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiContractProduct busiContractProduct)
    {
        List<BusiContractProduct> list = busiContractProductService.selectBusiContractProductList(busiContractProduct);
        return getDataTable(list);
    }

    /**
     * 导出合同产品组成列表
     */
    @Log(title = "合同产品组成", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiContractProduct busiContractProduct)
    {
        List<BusiContractProduct> list = busiContractProductService.selectBusiContractProductList(busiContractProduct);
        ExcelUtil<BusiContractProduct> util = new ExcelUtil<BusiContractProduct>(BusiContractProduct.class);
        return util.exportExcel(list, "product");
    }

    /**
     * 新增合同产品组成
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存合同产品组成
     */
    @Log(title = "合同产品组成", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiContractProduct busiContractProduct)
    {
        return toAjax(busiContractProductService.insertBusiContractProduct(busiContractProduct));
    }

    /**
     * 修改合同产品组成
     */
    @GetMapping("/edit/{product}")
    public String edit(@PathVariable("product") Long product, ModelMap mmap)
    {
        BusiContractProduct busiContractProduct = busiContractProductService.selectBusiContractProductById(product);
        mmap.put("busiContractProduct", busiContractProduct);
        return prefix + "/edit";
    }

    /**
     * 修改保存合同产品组成
     */
    @Log(title = "合同产品组成", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiContractProduct busiContractProduct)
    {
        return toAjax(busiContractProductService.updateBusiContractProduct(busiContractProduct));
    }

    /**
     * 删除合同产品组成
     */
    @Log(title = "合同产品组成", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiContractProductService.deleteBusiContractProductByIds(ids));
    }
}
