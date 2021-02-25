package com.ruoyi.busi.cost.domain;

import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 配件报价成本明细对象 busi_parts_cost
 *
 * @author ruoyi
 * @date 2021-02-02
 */
public class BusiPartsCost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long costId;

    /** 报价金额 */
    @Excel(name = "报价金额")
    private Double quotationAmount;

    /** 成本总计 */
    @Excel(name = "成本总计")
    private Double costPrice;

    /** 实际成本总计 */
    //@Excel(name = "实际成本总计")
    private Double actualPrice;

    /** 毛利 */
    @Excel(name = "毛利")
    private Double profit;

    /** 实际毛利 */
   // @Excel(name = "实际毛利")
    private Double actualProfit;

    /** 1111 */
    private Long quotationId;

    public Long getCostId() {
        return costId;
    }

    public void setCostId(Long costId) {
        this.costId = costId;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Double getQuotationAmount() {
        return quotationAmount;
    }

    public void setQuotationAmount(Double quotationAmount) {
        this.quotationAmount = quotationAmount;
    }

    public Double getProfit() {
        return StringUtils.doubleFormat(profit);
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getActualProfit() {
        return actualProfit;
    }

    public void setActualProfit(Double actualProfit) {
        this.actualProfit = actualProfit;
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("costId", getCostId())
            .append("costPrice", getCostPrice())
            .append("actualPrice", getActualPrice())
            .append("quotationAmount", getQuotationAmount())
            .append("profit", getProfit())
            .append("actualProfit", getActualProfit())
            .append("quotationId", getQuotationId())
            .toString();
    }
}
