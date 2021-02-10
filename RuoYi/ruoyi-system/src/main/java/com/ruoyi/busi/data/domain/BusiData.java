package com.ruoyi.busi.data.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 经营数据对象 busi_data
 *
 * @author ruoyi
 * @date 2021-02-09
 */
public class BusiData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 办事处数量 */
    @Excel(name = "办事处数量")
    private Long officeAddressCount;

    /** 业务员数量 */
    @Excel(name = "业务员数量")
    private Long officeUsersCount;

    /** 报价数量 */
    @Excel(name = "报价数量")
    private Long quotationCount;

    /** 报价金额统计 */
    @Excel(name = "报价金额统计")
    private Double quotationPrice;

    /** 人均金额统计 */
    @Excel(name = "人均金额统计")
    private Double avgQuotationPrice;

    /** 合同数量 */
    @Excel(name = "合同数量")
    private Long contractCount;

    /** 合同金额统计 */
    @Excel(name = "合同金额统计")
    private Double contractPrice;

    /** 人均合同额 */
    @Excel(name = "人均合同额")
    private Double avgContractPrice;

    /** 整体折扣率 */
    @Excel(name = "整体折扣率")
    private Double overallDiscountRate;

    /** 报价折扣率 */
    @Excel(name = "报价签约率")
    private Double quotationDiscountRate;

    /** 对应回款金额 */
    @Excel(name = "对应回款金额")
    private Double refundAmount;

    /** 延期项目数量 */
    @Excel(name = "延期项目数量")
    private Long delayContractCount;

    /** 延期项目比例 */
    @Excel(name = "延期项目比例")
    private Double delayContractProportion;

    public void setOfficeAddressCount(Long officeAddressCount)
    {
        this.officeAddressCount = officeAddressCount;
    }

    public Long getOfficeAddressCount()
    {
        return officeAddressCount;
    }
    public void setOfficeUsersCount(Long officeUsersCount)
    {
        this.officeUsersCount = officeUsersCount;
    }

    public Long getOfficeUsersCount()
    {
        return officeUsersCount;
    }
    public void setQuotationCount(Long quotationCount)
    {
        this.quotationCount = quotationCount;
    }

    public Long getQuotationCount()
    {
        return quotationCount;
    }
    public void setQuotationPrice(Double quotationPrice)
    {
        this.quotationPrice = quotationPrice;
    }

    public Double getQuotationPrice()
    {
        return quotationPrice;
    }
    public void setAvgQuotationPrice(Double avgQuotationPrice)
    {
        this.avgQuotationPrice = avgQuotationPrice;
    }

    public Double getAvgQuotationPrice()
    {
        return avgQuotationPrice;
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
    public void setAvgContractPrice(Double avgContractPrice)
    {
        this.avgContractPrice = avgContractPrice;
    }

    public Double getAvgContractPrice()
    {
        return avgContractPrice;
    }
    public void setOverallDiscountRate(Double overallDiscountRate)
    {
        this.overallDiscountRate = overallDiscountRate;
    }

    public Double getOverallDiscountRate()
    {
        return overallDiscountRate;
    }
    public void setQuotationDiscountRate(Double quotationDiscountRate)
    {
        this.quotationDiscountRate = quotationDiscountRate;
    }

    public Double getQuotationDiscountRate()
    {
        return quotationDiscountRate;
    }
    public void setRefundAmount(Double refundAmount)
    {
        this.refundAmount = refundAmount;
    }

    public Double getRefundAmount()
    {
        return refundAmount;
    }
    public void setDelayContractCount(Long delayContractCount)
    {
        this.delayContractCount = delayContractCount;
    }

    public Long getDelayContractCount()
    {
        return delayContractCount;
    }
    public void setDelayContractProportion(Double delayContractProportion)
    {
        this.delayContractProportion = delayContractProportion;
    }

    public Double getDelayContractProportion()
    {
        return delayContractProportion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("officeAddressCount", getOfficeAddressCount())
            .append("officeUsersCount", getOfficeUsersCount())
            .append("quotationCount", getQuotationCount())
            .append("quotationPrice", getQuotationPrice())
            .append("avgQuotationPrice", getAvgQuotationPrice())
            .append("contractCount", getContractCount())
            .append("contractPrice", getContractPrice())
            .append("avgContractPrice", getAvgContractPrice())
            .append("overallDiscountRate", getOverallDiscountRate())
            .append("quotationDiscountRate", getQuotationDiscountRate())
            .append("refundAmount", getRefundAmount())
            .append("delayContractCount", getDelayContractCount())
            .append("delayContractProportion", getDelayContractProportion())
            .toString();
    }
}
