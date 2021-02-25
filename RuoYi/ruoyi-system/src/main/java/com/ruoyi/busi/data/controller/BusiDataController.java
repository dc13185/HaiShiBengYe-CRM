package com.ruoyi.busi.data.controller;

import java.util.Date;
import java.util.List;

import com.ruoyi.busi.data.mapper.BusiDataMapper;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.MyExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.busi.data.domain.BusiData;
import com.ruoyi.busi.data.service.BusiDataService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 经营数据Controller
 *
 * @author ruoyi
 * @date 2021-02-09
 */
@Controller
@RequestMapping("/busi/data")
public class BusiDataController extends BaseController
{
    private String prefix = "busi/data";

    @Autowired
    private BusiDataService busiDataService;

    @Autowired
    private BusiDataMapper busiDataMapper;

    @RequiresPermissions("busi:data:view")
    @GetMapping()
    public String data()
    {
        return prefix + "/data";
    }

    /**
     * 查询经营数据列表
     */
    @RequiresPermissions("busi:data:list")
    @PostMapping("/list")
    @ResponseBody
    public AjaxResult list(BusiData busiData)
    {
        BusiData resDate = new BusiData();
        busiData.setCreateTime(new Date());
        //业务员数量
        Long officeUserStaffLong = busiDataMapper.queryOfficeUserStaff(busiData);
        resDate.setOfficeUsersCount(officeUserStaffLong);
        //办事处数量
        Long officeAddressLong  = busiDataMapper.queryOfficeAddress(busiData);
        resDate.setOfficeAddressCount(officeAddressLong);
        //报价单
        Long quotationCount =  busiDataMapper.queryQuotationCount(busiData);
        resDate.setQuotationCount(quotationCount);
        //报价单总价
        Double quotationAllPrice = busiDataMapper.queryQuotationAllPrice(busiData);
        resDate.setQuotationPrice(quotationAllPrice);
        //人均报价额
        resDate.setAvgQuotationPrice(StringUtils.doubleFormat(quotationAllPrice/officeUserStaffLong));
        //合同
        Long contractCount = busiDataMapper.queryContractCount(busiData);
        resDate.setContractCount(contractCount);
        //合同额
        Double contractPrice = busiDataMapper.queryContractAllPrice(busiData);
        resDate.setContractPrice(contractPrice);
        //人均合同
        resDate.setAvgContractPrice(StringUtils.doubleFormat(contractPrice/officeUserStaffLong));
        //整体折扣率
        resDate.setOverallDiscountRate(StringUtils.doubleFormat(StringUtils.doubleFormat(contractPrice/quotationAllPrice)));
        //签约金额
        Double signContractPrice = busiDataMapper.querySignContractPrice(busiData);
        //报价签约率
        resDate.setQuotationDiscountRate(StringUtils.doubleFormat(signContractPrice/quotationAllPrice));
        //回款金额
        Double repaymentAmount = busiDataMapper.queryRepaymentAmount(busiData);
        resDate.setRefundAmount(repaymentAmount);
        //延迟数
        Long delayContractCount  = busiDataMapper.queryDeilverCount(busiData);
        resDate.setDelayContractCount(delayContractCount);
        //完成数
        Long overCount = busiDataMapper.queryOverCount(busiData);
        //完成比率
        if (overCount != 0L){
            resDate.setDelayContractProportion(StringUtils.doubleFormat(delayContractCount.doubleValue()/overCount.doubleValue()));
        }else{
            resDate.setDelayContractProportion(0d);
        }

        return AjaxResult.success(resDate);
    }

    /**
     * 导出经营数据列表
     */
    @RequiresPermissions("busi:data:export")
    @Log(title = "经营数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusiData busiData)
    {

        BusiData resDate = new BusiData();
        busiData.setCreateTime(new Date());
        //业务员数量
        Long officeUserStaffLong = busiDataMapper.queryOfficeUserStaff(busiData);
        resDate.setOfficeUsersCount(officeUserStaffLong);
        //办事处数量
        Long officeAddressLong  = busiDataMapper.queryOfficeAddress(busiData);
        resDate.setOfficeAddressCount(officeAddressLong);
        //报价单
        Long quotationCount =  busiDataMapper.queryQuotationCount(busiData);
        resDate.setQuotationCount(quotationCount);
        //报价单总价
        Double quotationAllPrice = busiDataMapper.queryQuotationAllPrice(busiData);
        resDate.setQuotationPrice(quotationAllPrice);
        //人均报价额
        resDate.setAvgQuotationPrice(StringUtils.doubleFormat(quotationAllPrice/officeUserStaffLong));
        //合同
        Long contractCount = busiDataMapper.queryContractCount(busiData);
        resDate.setContractCount(contractCount);
        //合同额
        Double contractPrice = busiDataMapper.queryContractAllPrice(busiData);
        resDate.setContractPrice(contractPrice);
        //人均合同
        resDate.setAvgContractPrice(StringUtils.doubleFormat(contractPrice/officeUserStaffLong));
        //整体折扣率
        resDate.setOverallDiscountRate(StringUtils.doubleFormat(StringUtils.doubleFormat(contractPrice/quotationAllPrice)));
        //签约金额
        Double signContractPrice = busiDataMapper.querySignContractPrice(busiData);
        //报价签约率
        resDate.setQuotationDiscountRate(StringUtils.doubleFormat(signContractPrice/quotationAllPrice));
        //回款金额
        Double repaymentAmount = busiDataMapper.queryRepaymentAmount(busiData);
        resDate.setRefundAmount(repaymentAmount);
        //延迟数
        Long delayContractCount  = busiDataMapper.queryDeilverCount(busiData);
        resDate.setDelayContractCount(delayContractCount);
        //完成数
        Long overCount = busiDataMapper.queryOverCount(busiData);
        //完成比率
        if (overCount != 0L){
            resDate.setDelayContractProportion(StringUtils.doubleFormat(delayContractCount.doubleValue()/overCount.doubleValue()));
        }else{
            resDate.setDelayContractProportion(0d);
        }

        MyExcelUtil myExcelUtil = new MyExcelUtil(BusiData.class);
        myExcelUtil.init();
        myExcelUtil.exportExcelDetils(resDate,BusiData.class,"经费数据");

        return myExcelUtil.exportAll("经费数据明细");
    }

    /**
     * 新增经营数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存经营数据
     */
    @RequiresPermissions("busi:data:add")
    @Log(title = "经营数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusiData busiData)
    {
        return toAjax(busiDataService.insertBusiData(busiData));
    }

    /**
     * 修改经营数据
     */
    @GetMapping("/edit/{officeAddressCount}")
    public String edit(@PathVariable("officeAddressCount") Long officeAddressCount, ModelMap mmap)
    {
        BusiData busiData = busiDataService.selectBusiDataById(officeAddressCount);
        mmap.put("busiData", busiData);
        return prefix + "/edit";
    }

    /**
     * 修改保存经营数据
     */
    @RequiresPermissions("busi:data:edit")
    @Log(title = "经营数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusiData busiData)
    {
        return toAjax(busiDataService.updateBusiData(busiData));
    }

    /**
     * 删除经营数据
     */
    @RequiresPermissions("busi:data:remove")
    @Log(title = "经营数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busiDataService.deleteBusiDataByIds(ids));
    }
}
