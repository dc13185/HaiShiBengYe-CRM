package com.ruoyi.busi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.busi.cost.domain.BusiOutsourcingCost;
import com.ruoyi.busi.cost.domain.BusiPartsCost;
import com.ruoyi.busi.cost.mapper.BusiOutsourcingCostMapper;
import com.ruoyi.busi.cost.mapper.BusiPartsCostMapper;
import com.ruoyi.busi.domain.BusiContract;
import com.ruoyi.busi.mapper.BusiPriceDetailsMapper;
import com.ruoyi.busi.mapper.BusiProductParameterMapper;
import com.ruoyi.busi.parts.domain.BusiPartsDetails;
import com.ruoyi.busi.parts.mapper.BusiPartsDetailsMapper;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.MyExcelUtil;
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

    @Autowired
    private BusiPartsDetailsMapper busiPartsDetailsMapper;

    @Autowired
    private BusiOutsourcingCostMapper busiOutsourcingCostMapper;

    @Autowired
    private BusiPartsCostMapper busiPartsCostMapper;

    @RequiresPermissions("busi:details:view")
    @GetMapping()
    public String details(String quotationNo,ModelMap modelMap )
    {
        modelMap.put("quotationNo",quotationNo);
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
        Double sumPrice = busiPriceDetails.getActualBengtouclCb()
                + busiPriceDetails.getActualBengtouRgCb()
                + busiPriceDetails.getActualBengtouFyCb()
                + busiPriceDetails.getActualMotorCb()
                + busiPriceDetails.getActualJfCb()
                + busiPriceDetails.getActualZlqCb()
                + busiPriceDetails.getActualZcCb()
                + busiPriceDetails.getActualEwCb();
        busiPriceDetails.setActualAllSumPrice(sumPrice);
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
        quotationNo = StringUtils.trim(quotationNo);
        //整机报价
        BusiPriceDetails busiPriceDetails =  busiPriceDetailsMapper.selectBusiPriceDetailsByQuotationNo(quotationNo);
        //外购报价
        BusiOutsourcingCost busiOutsourcingCost = busiOutsourcingCostMapper.selectBusiOutsourcingCostByQuotationNo(quotationNo);
        //配件报价
        BusiPartsCost busiPartsCost = busiPartsCostMapper.selectBusiPartsCostByQuotationNo(quotationNo);
        HashMap hashMap = new HashMap();
        hashMap.put("busiPriceDetails",busiPriceDetails);
        hashMap.put("outsourcingMap",busiOutsourcingCost);
        hashMap.put("busiPartsDetails",busiPartsCost);
        return  AjaxResult.success(hashMap);
    }


    @RequiresPermissions("busi:details:export")
    @Log(title = "报价单报价明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(@RequestBody  String  quotationNo)
    {
        quotationNo = StringUtils.trim(quotationNo);
        //整机报价
        BusiPriceDetails busiPriceDetails =  busiPriceDetailsMapper.selectBusiPriceDetailsByQuotationNo(quotationNo);
        busiPriceDetails.setBengtouCb(null);
        busiPriceDetails.setWghj(null);
        //外购报价
        BusiOutsourcingCost busiOutsourcingCost = busiOutsourcingCostMapper.selectBusiOutsourcingCostByQuotationNo(quotationNo);
        if (busiOutsourcingCost != null){
            busiOutsourcingCost.setAllCost(null);
            busiOutsourcingCost.setProfit(StringUtils.doubleFormat(busiOutsourcingCost.getProfit()));
        }
        //配件报价
        BusiPartsCost busiPartsCost = busiPartsCostMapper.selectBusiPartsCostByQuotationNo(quotationNo);
        if (busiPartsCost != null){
            HashMap hashMap = new HashMap();
            hashMap.put("busiPriceDetails",busiPriceDetails);
            hashMap.put("outsourcingMap",busiOutsourcingCost);
            hashMap.put("busiPartsDetails",busiPartsCost);
        }
        MyExcelUtil myExcelUtil = new MyExcelUtil(BusiPriceDetails.class);
        myExcelUtil.init();

        if (busiPriceDetails != null){
            myExcelUtil.exportExcelDetils(busiPriceDetails,BusiPriceDetails.class,"整机报价明细");
        }
        if (busiOutsourcingCost != null){
            myExcelUtil.exportExcelDetils(busiOutsourcingCost,BusiOutsourcingCost.class,"外购报价明细");
        }
        if (busiPartsCost != null){
            myExcelUtil.exportExcelDetils(busiPartsCost,BusiPartsCost.class,"配件报价明细");
        }
        return  myExcelUtil.exportAll("报价分析明细");
    }





    @GetMapping("/toAnalysis")
    public String toAnalysis(String quotationNo,ModelMap modelMap)
    {
        modelMap.put("quotationNo",quotationNo);
        return prefix + "/details_analysis";
    }



    @RequiresPermissions("busi:details:export")
    @Log(title = "报价单报价明细", businessType = BusinessType.EXPORT)
    @PostMapping("/exportAnalysis")
    @ResponseBody
    public AjaxResult exportAnalysis(@RequestBody  String  quotationNo)
    {
        quotationNo = StringUtils.trim(quotationNo);
        //整机报价
        BusiPriceDetails busiPriceDetails =  busiPriceDetailsMapper.selectBusiPriceDetailsByQuotationNo(quotationNo);
        busiPriceDetails.setBengtouCb(null);
        busiPriceDetails.setWghj(null);
        //外购报价
        BusiOutsourcingCost busiOutsourcingCost = busiOutsourcingCostMapper.selectBusiOutsourcingCostByQuotationNo(quotationNo);
        if (busiOutsourcingCost != null){
            busiOutsourcingCost.setAllCost(null);
            busiOutsourcingCost.setProfit(StringUtils.doubleFormat(busiOutsourcingCost.getProfit()));
        }
        //配件报价
        BusiPartsCost busiPartsCost = busiPartsCostMapper.selectBusiPartsCostByQuotationNo(quotationNo);
        if (busiPartsCost != null){
            HashMap hashMap = new HashMap();
            hashMap.put("busiPriceDetails",busiPriceDetails);
            hashMap.put("outsourcingMap",busiOutsourcingCost);
            hashMap.put("busiPartsDetails",busiPartsCost);
        }
        MyExcelUtil myExcelUtil = new MyExcelUtil(BusiPriceDetails.class);
        myExcelUtil.initHSSF();

        if (busiPriceDetails != null){

            myExcelUtil.exportExcelDetils(busiPriceDetails,BusiPriceDetails.class,"整机报价明细");
            myExcelUtil.getSheet().removeRow(myExcelUtil.getSheet().getRow(0));
            myExcelUtil.getSheet().getRow(1).createCell(2).setCellValue("实际泵头材料成本合计");
            myExcelUtil.getSheet().getRow(1).createCell(3).setCellValue(busiPriceDetails.getActualBengtouclCb());
            myExcelUtil.getSheet().getRow(2).createCell(2).setCellValue("实际泵头人工成本合计");
            myExcelUtil.getSheet().getRow(2).createCell(3).setCellValue(busiPriceDetails.getActualBengtouRgCb());
            myExcelUtil.getSheet().getRow(3).createCell(2).setCellValue("实际制造费用成本合计");
            myExcelUtil.getSheet().getRow(3).createCell(3).setCellValue(busiPriceDetails.getActualBengtouFyCb());
            myExcelUtil.getSheet().getRow(4).createCell(2).setCellValue("实际泵头成本合计");
            myExcelUtil.getSheet().getRow(4).createCell(3).setCellValue(busiPriceDetails.getActualBengtouCb());
            myExcelUtil.getSheet().getRow(5).createCell(2).setCellValue("实际电机成本");
            myExcelUtil.getSheet().getRow(5).createCell(3).setCellValue(busiPriceDetails.getActualMotorCb());
            myExcelUtil.getSheet().getRow(6).createCell(2).setCellValue("实际机封及系统成本");
            myExcelUtil.getSheet().getRow(6).createCell(3).setCellValue(busiPriceDetails.getActualJfCb());
            myExcelUtil.getSheet().getRow(7).createCell(2).setCellValue("实际轴承成本");
            myExcelUtil.getSheet().getRow(7).createCell(3).setCellValue(busiPriceDetails.getActualZcCb());
            myExcelUtil.getSheet().getRow(8).createCell(2).setCellValue("实际联轴器成本");
            myExcelUtil.getSheet().getRow(8).createCell(3).setCellValue(busiPriceDetails.getActualZlqCb());
            myExcelUtil.getSheet().getRow(9).createCell(2).setCellValue("实际额外配置成本");
            myExcelUtil.getSheet().getRow(9).createCell(3).setCellValue(busiPriceDetails.getActualEwCb());
            myExcelUtil.getSheet().getRow(9).createCell(2).setCellValue("实际额外配置成本");
            myExcelUtil.getSheet().getRow(9).createCell(3).setCellValue(busiPriceDetails.getActualEwCb());
            myExcelUtil.getSheet().getRow(10).createCell(2).setCellValue("实际外购合计");
            myExcelUtil.getSheet().getRow(10).createCell(3).setCellValue(busiPriceDetails.getActualWghj());
            myExcelUtil.getSheet().getRow(11).createCell(2).setCellValue("实际总计成本");
            myExcelUtil.getSheet().getRow(11).createCell(3).setCellValue(busiPriceDetails.getActualContractprice());
            myExcelUtil.getSheet().getRow(12).createCell(2).setCellValue("实际毛利");
            myExcelUtil.getSheet().getRow(12).createCell(3).setCellValue(busiPriceDetails.getActualProfit());
            myExcelUtil.getSheet().setColumnWidth(2,  (30 * 256));
            myExcelUtil.getSheet().shiftRows(1, 12, -1);
        }
        if (busiOutsourcingCost != null){
            myExcelUtil.exportExcelDetils(busiOutsourcingCost,BusiOutsourcingCost.class,"外购报价明细");
            myExcelUtil.getSheet().getRow(1).createCell(2).setCellValue("实际泵头成本合计");
            myExcelUtil.getSheet().getRow(1).createCell(3).setCellValue(busiOutsourcingCost.getActualProductPrice());
            myExcelUtil.getSheet().getRow(2).createCell(2).setCellValue("实际电机成本合计");
            myExcelUtil.getSheet().getRow(2).createCell(3).setCellValue(busiOutsourcingCost.getActualMotorPrice());
            myExcelUtil.getSheet().getRow(3).createCell(2).setCellValue("实际成本总计");
            myExcelUtil.getSheet().getRow(3).createCell(3).setCellValue(busiOutsourcingCost.getActualAllPrice());
            myExcelUtil.getSheet().getRow(4).createCell(2).setCellValue("实际毛利");
            myExcelUtil.getSheet().getRow(4).createCell(3).setCellValue(busiOutsourcingCost.getActualProfit());
            myExcelUtil.getSheet().setColumnWidth(2,  (30 * 256));
            myExcelUtil.getSheet().shiftRows(1, 4, -1);
        }
        if (busiPartsCost != null){
            myExcelUtil.exportExcelDetils(busiPartsCost,BusiPartsCost.class,"配件报价明细");
            myExcelUtil.getSheet().getRow(1).createCell(2).setCellValue("实际成本总计");
            myExcelUtil.getSheet().getRow(1).createCell(3).setCellValue(busiPartsCost.getActualPrice());
            myExcelUtil.getSheet().getRow(2).createCell(2).setCellValue("实际毛利");
            myExcelUtil.getSheet().getRow(2).createCell(3).setCellValue(busiPartsCost.getActualProfit());
            myExcelUtil.getSheet().setColumnWidth(2,  (30 * 256));
            myExcelUtil.getSheet().shiftRows(1, 2, -1);
        }
        return  myExcelUtil.exportAll("报价分析明细");
    }

}
