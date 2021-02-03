package com.ruoyi.busi.cost.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 外购电机成本明细对象 busi_outsourcing_cost
 *
 * @author ruoyi
 * @date 2021-02-02
 */
public class BusiOutsourcingCost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long costId;

    /**  */

    /**  */
    @Excel(name = "")
    private Long quotationId;

    /** 泵头成本合计 */
    @Excel(name = "泵头成本合计")
    private Double productPrice;

    /** 实际泵头成本 */
    @Excel(name = "实际泵头成本")
    private Double actualProductPrice;

    /** 电机成本合计 */
    @Excel(name = "电机成本合计")
    private Double motorPrice;

    /** 实际电机成本 */
    @Excel(name = "实际电机成本")
    private Double actualMotorPrice;

    private Double quotationAmount;
    /** 毛利 */
    @Excel(name = "毛利")
    private Double profit;
    /** 实际毛利 */
    @Excel(name = "实际毛利")
    private Double actualProfit;

    @Excel(name = "实际成本总计")
    private Double actualAllPrice;

    public void setCostId(Long costId)
    {
        this.costId = costId;
    }

    public Long getCostId()
    {
        return costId;
    }
    public void setQuotationId(Long quotationId)
    {
        this.quotationId = quotationId;
    }

    public Long getQuotationId()
    {
        return quotationId;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getActualProductPrice() {
        return actualProductPrice;
    }

    public void setActualProductPrice(Double actualProductPrice) {
        this.actualProductPrice = actualProductPrice;
    }

    public Double getMotorPrice() {
        return motorPrice;
    }

    public void setMotorPrice(Double motorPrice) {
        this.motorPrice = motorPrice;
    }

    public Double getActualMotorPrice() {
        return actualMotorPrice;
    }

    public void setActualMotorPrice(Double actualMotorPrice) {
        this.actualMotorPrice = actualMotorPrice;
    }

    public Double getQuotationAmount() {
        return quotationAmount;
    }

    public void setQuotationAmount(Double quotationAmount) {
        this.quotationAmount = quotationAmount;
    }

    public Double getProfit() {
        return profit;
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


    public Double getActualAllPrice() {
        return actualAllPrice;
    }

    public void setActualAllPrice(Double actualAllPrice) {
        this.actualAllPrice = actualAllPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("costId", getCostId())
            .append("quotationId", getQuotationId())
            .append("productPrice", getProductPrice())
            .append("actualProductPrice", getActualProductPrice())
            .append("motorPrice", getMotorPrice())
            .append("actualMotorPrice", getActualMotorPrice())
            .toString();
    }
}
