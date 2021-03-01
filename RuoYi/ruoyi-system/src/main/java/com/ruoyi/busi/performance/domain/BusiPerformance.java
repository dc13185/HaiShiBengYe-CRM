package com.ruoyi.busi.performance.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 业绩管理对象 busi_performance
 *
 * @author ruoyi
 * @date 2021-02-07
 */
public class BusiPerformance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long performanceId;

    /** 办事处 */
    @Excel(name = "办事处")
    private String officeAddress;

    private Long peopleCount;

    /** 业务员 */
    @Excel(name = "业务员")
    private String officeStaffName;

    /** 报价数量 */
    @Excel(name = "报价数量")
    private Long quotationCount;


    /** 报价金额 */
    @Excel(name = "报价金额")
    private Double quotationPrice;


    /** 合同数量 */
    @Excel(name = "合同数量")
    private Long contractCount;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private Double contractPrice;

    /** 回款金额 */
    @Excel(name = "回款金额")
    private Double repaymentAmount;

    /** 签约金额 */
    private Double singQuotationPrice;

    @Excel(name = "报价签约率")
    private Double singQuotationRatio;

    @Excel(name = "回款率")
    private Double repaymentRatio;


    public Double getSingQuotationRatio() {
        return singQuotationRatio;
    }

    public void setSingQuotationRatio(Double singQuotationRatio) {
        this.singQuotationRatio = singQuotationRatio;
    }

    public Double getRepaymentRatio() {
        return repaymentRatio;
    }

    public void setRepaymentRatio(Double repaymentRatio) {
        this.repaymentRatio = repaymentRatio;
    }

    public void setPerformanceId(Long performanceId)
    {
        this.performanceId = performanceId;
    }

    public Long getPerformanceId()
    {
        return performanceId;
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
        if (quotationPrice == null){
            return 0d;
        }else{
            return quotationPrice;
        }
    }
    public void setOfficeStaffName(String officeStaffName)
    {
        this.officeStaffName = officeStaffName;
    }

    public String getOfficeStaffName()
    {
        return officeStaffName;
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
        if (contractCount == null) {
            return 0L;
        }
        return contractCount;
    }
    public void setContractPrice(Double contractPrice)
    {
        if (contractCount == null){
            this.contractPrice = 0d;
        }
        this.contractPrice = contractPrice;
    }

    public Double getContractPrice()
    {
        if (contractPrice == null){
            return 0d;
        }else{
            return contractPrice;
        }
    }
    public void setRepaymentAmount(Double repaymentAmount)
    {
        this.repaymentAmount = repaymentAmount;
    }

    public Double getRepaymentAmount()
    {
        if (repaymentAmount == null){
            return 0d;
        }else{
            return repaymentAmount;
        }

    }
    public void setSingQuotationPrice(Double singQuotationPrice)
    {
        this.singQuotationPrice = singQuotationPrice;
    }

    public Double getSingQuotationPrice()
    {
        return singQuotationPrice;
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
            .append("performanceId", getPerformanceId())
            .append("officeAddress", getOfficeAddress())
            .append("quotationPrice", getQuotationPrice())
            .append("officeStaffName", getOfficeStaffName())
            .append("quotationCount", getQuotationCount())
            .append("contractCount", getContractCount())
            .append("contractPrice", getContractPrice())
            .append("repaymentAmount", getRepaymentAmount())
            .append("singQuotationPrice", getSingQuotationPrice())
            .toString();
    }
}
