package com.ruoyi.busi.controller;

import java.util.List;

import com.ruoyi.busi.domain.BusiMotor;
import com.ruoyi.busi.mapper.BusiCouplingMapper;
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
import com.ruoyi.busi.domain.BusiCoupling;
import com.ruoyi.busi.service.IBusiCouplingService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;

/**
 * 联轴器Controller
 *
 * @author ruoyi
 * @date 2021-01-04
 */
@Controller
@RequestMapping("/busi/coupling")
public class BusiCouplingController extends BaseController
{
    private String prefix = "busi/coupling";

    @Autowired
    private IBusiCouplingService busiCouplingService;

    @Autowired
    private BusiCouplingMapper busiCouplingMapper;

    @RequiresPermissions("busi:coupling:view")
    @GetMapping()
    public String coupling(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/coupling";
    }

    /**
     * 查询联轴器列表
     */
    @RequiresPermissions("busi:coupling:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusiCoupling busiCoupling)
    {
        startPage();
        List<BusiCoupling> list = busiCouplingService.selectBusiCouplingList(busiCoupling);
        return getDataTable(list);
    }

    /**
     * 导出联轴器列表
     */
    @RequiresPermissions("busi:coupling:export")
    @Log(title = "联轴器", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiCoupling busiCoupling)
    {
        List<BusiCoupling> list = busiCouplingMapper.selectBusiCouplingListExport(busiCoupling);
        ExcelUtil<BusiCoupling> util = new ExcelUtil<BusiCoupling>(BusiCoupling.class);
        return util.exportExcel(list, "轴联器产品表");
    }


    @RequiresPermissions("busi:coupling:export")
    @Log(title = "电机产品", businessType = BusinessType.EXPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, String supplierId) throws Exception {
        ExcelUtil<BusiCoupling> util = new ExcelUtil<>(BusiCoupling.class);
        List<BusiCoupling> userList = util.importExcel(file.getInputStream());
        for (BusiCoupling busiMotor : userList) {
            busiMotor.setSupplierId(supplierId);
            busiCouplingMapper.insertBusiCoupling(busiMotor);
        }
        return AjaxResult.success();
    }

    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BusiCoupling> util = new ExcelUtil<BusiCoupling>(BusiCoupling.class);
        return util.importTemplateExcel("轴联器产品");
    }


    /**
     * 新增联轴器
     */
    @GetMapping("/add")
    public String add(String supplierId,ModelMap modelMap)
    {
        modelMap.put("supplierId",supplierId);
        return prefix + "/add";
    }

    /**
     * 新增保存联轴器
     */
    @RequiresPermissions("busi:coupling:add")
    @Log(title = "联轴器", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiCoupling busiCoupling)
    {
        return toAjax(busiCouplingService.insertBusiCoupling(busiCoupling));
    }

    /**
     * 修改联轴器
     */
    @GetMapping("/edit/{couplingId}")
    public String edit(@PathVariable("couplingId") Long couplingId, ModelMap mmap)
    {
        BusiCoupling busiCoupling = busiCouplingService.selectBusiCouplingById(couplingId);
        mmap.put("busiCoupling", busiCoupling);
        return prefix + "/edit";
    }

    /**
     * 修改保存联轴器
     */
    @RequiresPermissions("busi:coupling:edit")
    @Log(title = "联轴器", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiCoupling busiCoupling)
    {
        return toAjax(busiCouplingService.updateBusiCoupling(busiCoupling));
    }

    /**
     * 删除联轴器
     */
    @RequiresPermissions("busi:coupling:remove")
    @Log(title = "联轴器", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiCouplingService.deleteBusiCouplingByIds(ids));
    }
}
