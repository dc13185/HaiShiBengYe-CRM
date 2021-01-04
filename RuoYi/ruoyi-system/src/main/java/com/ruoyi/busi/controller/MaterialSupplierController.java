package com.ruoyi.busi.controller;

import java.util.List;

import com.ruoyi.busi.domain.BusiAnnexFile;
import com.ruoyi.busi.domain.BusiSupplierAnnex;
import com.ruoyi.busi.domain.MaterialSupplier;
import com.ruoyi.busi.mapper.BusiAnnexFileMapper;
import com.ruoyi.busi.service.IBusiAnnexFileService;
import com.ruoyi.busi.service.IBusiSupplierAnnexService;
import com.ruoyi.busi.service.IMaterialSupplierService;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
/**
 * 材料供应商Controller
 *
 * @author ruoyi
 * @date 2020-12-25
 */
@Controller
@RequestMapping("/busi/supplier")
public class MaterialSupplierController extends BaseController
{
    private String prefix = "busi/supplier";

    @Autowired
    private IMaterialSupplierService materialSupplierService;

    @Autowired
    private IBusiSupplierAnnexService busiSupplierAnnexService;
    @Autowired
    private BusiAnnexFileMapper busiAnnexFileMapper;

    @RequiresPermissions("busi:supplier:view")
    @GetMapping()
    public String supplier(String supplierType,ModelMap modelMap)
    {
        modelMap.put("supplierType",supplierType);
        return prefix + "/supplier";
    }

    /**
     * 查询材料供应商列表
     */
    @RequiresPermissions("busi:supplier:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialSupplier materialSupplier)
    {
        startPage();
        List<MaterialSupplier> list = materialSupplierService.selectMaterialSupplierList(materialSupplier);
        return getDataTable(list);
    }

    /**
     * 导出材料供应商列表
     */
    @RequiresPermissions("busi:supplier:export")
    @Log(title = "材料供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialSupplier materialSupplier)
    {
        List<MaterialSupplier> list = materialSupplierService.selectMaterialSupplierList(materialSupplier);
        ExcelUtil<MaterialSupplier> util = new ExcelUtil<MaterialSupplier>(MaterialSupplier.class);
        return util.exportExcel(list, "supplier");
    }

    /**
     * 新增材料供应商
     */
    @GetMapping("/add")
    public String add(String supplierType,ModelMap modelMap)
    {
        modelMap.put("supplierType",supplierType);
        return prefix + "/add";
    }

    /**
     * 新增保存材料供应商
     */
    @RequiresPermissions("busi:supplier:add")
    @Log(title = "材料供应商", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaterialSupplier materialSupplier)
    {
        return toAjax(materialSupplierService.insertMaterialSupplier(materialSupplier));
    }

    /**
     * 修改材料供应商
     */
    @GetMapping("/edit/{supplierId}")
    public String edit(@PathVariable("supplierId") String supplierId, ModelMap mmap)
    {
        MaterialSupplier materialSupplier = materialSupplierService.selectMaterialSupplierById(supplierId);
        mmap.put("materialSupplier", materialSupplier);
        return prefix + "/edit";
    }

    /**
     * 修改保存材料供应商
     */
    @RequiresPermissions("busi:supplier:edit")
    @Log(title = "材料供应商", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialSupplier materialSupplier)
    {
        return toAjax(materialSupplierService.updateMaterialSupplier(materialSupplier));
    }

    /**
     * 删除材料供应商
     */
    @RequiresPermissions("busi:supplier:remove")
    @Log(title = "材料供应商", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialSupplierService.deleteMaterialSupplierByIds(ids));
    }



    @RequiresPermissions("busi:supplier:view")
    @GetMapping("/toFile")
    public String toFile(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return "busi/file/upload";
    }

    @RequiresPermissions("busi:supplier:view")
    @GetMapping("/toFileDetails")
    public String toFileDetails(String supplierId,ModelMap modelMap)
    {
        BusiSupplierAnnex busiSupplierAnnex =  new BusiSupplierAnnex();
        busiSupplierAnnex.setSupplierId(supplierId);
        List<BusiAnnexFile> busiAnnexFiles = busiAnnexFileMapper.selectBusiAnnexFileBySupplierId(supplierId);
        modelMap.put("busiAnnexFiles",busiAnnexFiles);
        modelMap.put("supplierId",supplierId);
        return "busi/file/file_manager";
    }




    @RequiresPermissions("busi:supplier:view")
    @GetMapping("/toProduct")
    public String toProduct(String supplierId,ModelMap modelMap)
    {
        MaterialSupplier supplier = materialSupplierService.selectMaterialSupplierById(supplierId);
        if (supplier.getSupplierType().equals("material")){
            return "redirect:/busi/production?supplierId="+supplierId;
        }else if(supplier.getSupplierType().equals("motor")){
            return "redirect:/busi/motor?supplierId="+supplierId;
        }


        return "busi/file/file_manager";
    }

}
