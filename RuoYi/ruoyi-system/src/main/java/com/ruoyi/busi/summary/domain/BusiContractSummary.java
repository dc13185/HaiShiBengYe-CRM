package com.ruoyi.busi.summary.domain;

import com.ruoyi.busi.domain.BusiQuotation;
import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 历史合同汇总对象 busi_contract_summary
 *
 * @author ruoyi
 * @date 2021-02-07
 */
public class BusiContractSummary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long summaryId;

    @Excel(name = "合同号")
    private String contractNo;

    private String quotationNo;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String customerName;

    /** 客户性质 */
    @Excel(name = "客户性质")
    private String customerNature;

    /** 所处行业 */
    @Excel(name = "所处行业")
    private String customerIndustry;

    private String customerAddress;

    private String projectAddress;

    private String projectName;

    @Excel(name = "办事处")
    private String officeAddress;

    @Excel(name = "业务员")
    private String officeStaffName;

    /** 产品类型 */
    @Excel(name = "产品类型")
    private Long quotationType;

    /** 报价金额 */
    @Excel(name = "报价金额")
    private Double sumQuotationPrice;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private Double contractPrice;

    @Excel(name = "折扣率")
    private Double discountRate;

    @Excel(name = "报价成本总计")
    private Double allSumCost;

    @Excel(name = "实际成本总计")
    private Double actualllSumCost;

    @Excel(name = "报价毛利润")
    private Double allSumMargin;

    @Excel(name = "报价毛利率")
    private Double allSumMarginGross;

    @Excel(name = "实际毛利润")
    private Double actualAllSumMargin;

    private Double actualAllSumMarginGross;

    private Double  quotationPrice;
    private Double  outsourcingPrice;
    private Double  partsPrice;

    private Double  priceSumPrice;
    private Double  outSumPrice;
    private Double  partsSumPrice;

    private Double  priceActualPrice;
    private Double  outActualPrice;
    private Double  partsActualPrice;

    private Double  priceProfit;
    private Double  outProfit;
    private Double  partsProfit;

    private Double  priceActualProfit;
    private Double  outActualProfit;
    private Double  partsActualProfit;

    private BusiQuotation busiQuotation;


    public Double getAllSumMarginGross() {
        return allSumMarginGross;
    }

    public void setAllSumMarginGross(Double allSumMarginGross) {
        this.allSumMarginGross = StringUtils.doubleFormat(allSumMargin/(allSumMargin+allSumCost));
    }

    public Double getActualAllSumMarginGross() {
        return actualAllSumMarginGross;
    }

    public void setActualAllSumMarginGross(Double actualAllSumMarginGross) {
        this.actualAllSumMarginGross = StringUtils.doubleFormat(actualAllSumMargin/(actualAllSumMargin+actualllSumCost));
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = StringUtils.doubleFormat(quotationPrice/contractPrice);
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public BusiQuotation getBusiQuotation() {
        return busiQuotation;
    }

    public void setBusiQuotation(BusiQuotation busiQuotation) {
        this.busiQuotation = busiQuotation;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Double getQuotationPrice() {
        return quotationPrice;
    }

    public void setQuotationPrice(Double quotationPrice) {
        this.quotationPrice = quotationPrice;
    }

    public Double getOutsourcingPrice() {
        return outsourcingPrice;
    }

    public void setOutsourcingPrice(Double outsourcingPrice) {
        this.outsourcingPrice = outsourcingPrice;
    }

    public Double getPartsPrice() {
        return partsPrice;
    }

    public void setPartsPrice(Double partsPrice) {
        this.partsPrice = partsPrice;
    }

    public Double getPriceSumPrice() {
        return priceSumPrice;
    }

    public void setPriceSumPrice(Double priceSumPrice) {
        this.priceSumPrice = priceSumPrice;
    }

    public Double getOutSumPrice() {
        return outSumPrice;
    }

    public void setOutSumPrice(Double outSumPrice) {
        this.outSumPrice = outSumPrice;
    }

    public Double getPartsSumPrice() {
        return partsSumPrice;
    }

    public void setPartsSumPrice(Double partsSumPrice) {
        this.partsSumPrice = partsSumPrice;
    }

    public Double getPriceActualPrice() {
        return priceActualPrice;
    }

    public void setPriceActualPrice(Double priceActualPrice) {
        this.priceActualPrice = priceActualPrice;
    }

    public Double getOutActualPrice() {
        return outActualPrice;
    }

    public void setOutActualPrice(Double outActualPrice) {
        this.outActualPrice = outActualPrice;
    }

    public Double getPartsActualPrice() {
        return partsActualPrice;
    }

    public void setPartsActualPrice(Double partsActualPrice) {
        this.partsActualPrice = partsActualPrice;
    }

    public Double getPriceProfit() {
        return priceProfit;
    }

    public void setPriceProfit(Double priceProfit) {
        this.priceProfit = priceProfit;
    }

    public Double getOutProfit() {
        return outProfit;
    }

    public void setOutProfit(Double outProfit) {
        this.outProfit = outProfit;
    }

    public Double getPartsProfit() {
        return partsProfit;
    }

    public void setPartsProfit(Double partsProfit) {
        this.partsProfit = partsProfit;
    }

    public Double getPriceActualProfit() {
        return priceActualProfit;
    }

    public void setPriceActualProfit(Double priceActualProfit) {
        this.priceActualProfit = priceActualProfit;
    }

    public Double getOutActualProfit() {
        return outActualProfit;
    }

    public void setOutActualProfit(Double outActualProfit) {
        this.outActualProfit = outActualProfit;
    }

    public Double getPartsActualProfit() {
        return partsActualProfit;
    }

    public void setPartsActualProfit(Double partsActualProfit) {
        this.partsActualProfit = partsActualProfit;
    }

    public String getQuotationNo() {
        return quotationNo;
    }

    public void setQuotationNo(String  quotationNo) {
        this.quotationNo = quotationNo;
    }

    public void setSummaryId(Long summaryId)
    {
        this.summaryId = summaryId;
    }

    public Long getSummaryId()
    {
        return summaryId;
    }
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerName()
    {
        return customerName;
    }
    public void setCustomerNature(String customerNature)
    {
        this.customerNature = customerNature;
    }

    public String getCustomerNature()
    {
        return customerNature;
    }
    public void setCustomerIndustry(String customerIndustry)
    {
        this.customerIndustry = customerIndustry;
    }

    public String getCustomerIndustry()
    {
        return customerIndustry;
    }
    public void setQuotationType(Long quotationType)
    {
        this.quotationType = quotationType;
    }

    public Long getQuotationType()
    {
        return quotationType;
    }

    public Double getSumQuotationPrice() {
        return sumQuotationPrice;
    }

    public void setSumQuotationPrice(Double sumQuotationPrice) {
        this.sumQuotationPrice = sumQuotationPrice;
    }

    public Double getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(Double contractPrice) {
        this.contractPrice = contractPrice;
    }

    public Double getAllSumCost() {
        return allSumCost;
    }

    public void setAllSumCost(Double allSumCost) {
        this.allSumCost = allSumCost;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getOfficeStaffName() {
        return officeStaffName;
    }

    public void setOfficeStaffName(String officeStaffName) {
        this.officeStaffName = officeStaffName;
    }

    public Double getActualllSumCost() {
        return actualllSumCost;
    }

    public void setActualllSumCost(Double actualllSumCost) {
        this.actualllSumCost = actualllSumCost;
    }

    public Double getAllSumMargin() {
        return allSumMargin;
    }

    public void setAllSumMargin(Double allSumMargin) {
        this.allSumMargin = allSumMargin;
    }

    public Double getActualAllSumMargin() {
        return actualAllSumMargin;
    }

    public void setActualAllSumMargin(Double actualAllSumMargin) {
        this.actualAllSumMargin = actualAllSumMargin;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("summaryId", getSummaryId())
            .append("customerName", getCustomerName())
            .append("customerNature", getCustomerNature())
            .append("customerIndustry", getCustomerIndustry())
            .append("quotationType", getQuotationType())
            .append("sumQuotationPrice", getSumQuotationPrice())
            .append("contractPrice", getContractPrice())
            .toString();
    }
}
