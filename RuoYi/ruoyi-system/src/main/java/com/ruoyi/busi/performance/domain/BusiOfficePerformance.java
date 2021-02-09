package com.ruoyi.busi.performance.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
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

    /** 报价金额 */
    @Excel(name = "平均报价金额")
    private Double quotationPrice;


    /** 报价数量 */
    @Excel(name = "总报价数量")
    private Long quotationCount;

    /** 合同数量 */
    @Excel(name = "总合同数量")
    private Long contractCount;

    /** 合同金额 */
    @Excel(name = "平均合同金额")
    private Double contractPrice;

    /** 回款金额 */
    @Excel(name = "平均回款金额")
    private Double repaymentAmount;

    /** 签约金额 */
    @Excel(name = "平均签约金额")
    private Double singQuotationPrice;

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
            .append("officeAddress", getOfficeAddress())
            .append("quotationPrice", getQuotationPrice())
            .append("quotationCount", getQuotationCount())
            .append("contractCount", getContractCount())
            .append("contractPrice", getContractPrice())
            .append("repaymentAmount", getRepaymentAmount())
            .append("singQuotationPrice", getSingQuotationPrice())
            .toString();
    }
}
