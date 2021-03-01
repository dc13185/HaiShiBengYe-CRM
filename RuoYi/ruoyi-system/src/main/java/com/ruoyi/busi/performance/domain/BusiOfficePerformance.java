package com.ruoyi.busi.performance.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 业绩管理对象 busi_performance
 *
 * @author ruoyi
 * @date 2021-02-07
 */
public class BusiOfficePerformance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 办事处 */
    @Excel(name = "办事处")
    private String officeAddress;

    @Excel(name = "总人数")
    private Long peopleCount;


    private Double allQuotationPrice;

    /** 报价金额 */
    @Excel(name = "平均报价金额")
    private Double quotationPrice;

    /** 报价数量 */
    @Excel(name = "总报价数量")
    private Long quotationCount;

    /** 合同数量 */
    @Excel(name = "总合同数量")
    private Long contractCount;

    @Excel(name = "总合同金额")
    private Double allContractPrice;

    /** 合同金额 */
    @Excel(name = "平均合同金额")
    private Double contractPrice;

    @Excel(name = "总回款金额")
    private Double allRepaymentAmount;

    /** 回款金额 */
    @Excel(name = "平均回款金额")
    private Double repaymentAmount;


    @Excel(name = "回款率")
    private Double avgRepaymentRatio;

    @Excel(name = "总回款率")
    private Double repaymentRatio;

/*
    */
/** 签约金额 *//*

    @Excel(name = "总签约金额")
    private Double allSingQuotationPrice;
    */
/** 签约金额 *//*

    @Excel(name = "平均签约金额")
    private Double singQuotationPrice;
*/

    @Excel(name = "签约率")
    private Double avgSingQuotationRatio;

    @Excel(name = "总签约率")
    private Double singQuotationRatio;


    public Double getAvgRepaymentRatio() {
        return avgRepaymentRatio;
    }

    public void setAvgRepaymentRatio(Double avgRepaymentRatio) {
        this.avgRepaymentRatio = StringUtils.doubleFormat(avgRepaymentRatio);
    }

    public Double getRepaymentRatio() {
        return repaymentRatio;
    }

    public void setRepaymentRatio(Double repaymentRatio) {
        this.repaymentRatio = StringUtils.doubleFormat(repaymentRatio);
    }

    public Double getAllQuotationPrice() {
        return allQuotationPrice;
    }

    public void setAllQuotationPrice(Double allQuotationPrice) {
        this.allQuotationPrice = StringUtils.doubleFormat(allQuotationPrice);
    }


    public Double getAllContractPrice() {
        return allContractPrice;
    }

    public void setAllContractPrice(Double allContractPrice) {
        this.allContractPrice = StringUtils.doubleFormat(allContractPrice);
    }

    public Double getAllRepaymentAmount() {
        return allRepaymentAmount;
    }

    public void setAllRepaymentAmount(Double allRepaymentAmount) {
        this.allRepaymentAmount = StringUtils.doubleFormat(allRepaymentAmount);
    }

    public Double getAvgSingQuotationRatio() {
        return avgSingQuotationRatio;
    }

    public void setAvgSingQuotationRatio(Double avgSingQuotationRatio) {
        this.avgSingQuotationRatio = StringUtils.doubleFormat(avgSingQuotationRatio);
    }

    public Double getSingQuotationRatio() {
        return singQuotationRatio;
    }

    public void setSingQuotationRatio(Double singQuotationRatio) {
        this.singQuotationRatio = StringUtils.doubleFormat(singQuotationRatio);
    }

    public void setOfficeAddress(String officeAddress)
    {
        this.officeAddress = officeAddress;
    }

    public String getOfficeAddress()
    {
        return officeAddress;
    }
    public void setQuotationPrice(Double quotationPrice)
    {
        this.quotationPrice = quotationPrice;
    }

    public Double getQuotationPrice()
    {
        return quotationPrice;
    }

    public void setQuotationCount(Long quotationCount)
    {
        this.quotationCount = quotationCount;
    }

    public Long getQuotationCount()
    {
        return quotationCount;
    }
    public void setContractCount(Long contractCount)
    {
        this.contractCount = contractCount;
    }

    public Long getContractCount()
    {
        return contractCount;
    }
    public void setContractPrice(Double contractPrice)
    {
        this.contractPrice = contractPrice;
    }

    public Double getContractPrice()
    {
        return contractPrice;
    }
    public void setRepaymentAmount(Double repaymentAmount)
    {
        this.repaymentAmount = repaymentAmount;
    }

    public Double getRepaymentAmount()
    {
        return repaymentAmount;
    }

    public Long getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Long peopleCount) {
        this.peopleCount = peopleCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("officeAddress", getOfficeAddress())
            .append("quotationPrice", getQuotationPrice())
            .append("quotationCount", getQuotationCount())
            .append("contractCount", getContractCount())
            .append("contractPrice", getContractPrice())
            .append("repaymentAmount", getRepaymentAmount())
            .toString();
    }
}
