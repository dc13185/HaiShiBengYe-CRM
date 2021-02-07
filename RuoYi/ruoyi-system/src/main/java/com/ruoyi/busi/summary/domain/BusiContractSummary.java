package com.ruoyi.busi.summary.domain;

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

    @Excel(name = "报价成本总计")
    private Double allSumCost;

    @Excel(name = "实际成本总计")
    private Double actualllSumCost;

    @Excel(name = "报价毛利率")
    private Double allSumMargin;

    @Excel(name = "实际毛利率")
    private Double actualAllSumMargin;

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
