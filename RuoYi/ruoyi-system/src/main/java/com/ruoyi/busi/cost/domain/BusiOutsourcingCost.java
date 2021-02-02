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
    @Excel(name = "")
    private Long outsourcingId;

    /**  */
    @Excel(name = "")
    private Long quotationId;

    /** 泵头成本合计 */
    @Excel(name = "泵头成本合计")
    private Long productPrice;

    /** 实际泵头成本 */
    @Excel(name = "实际泵头成本")
    private Long actualProductPrice;

    /** 电机成本合计 */
    @Excel(name = "电机成本合计")
    private Long motorPrice;

    /** 实际电机成本 */
    @Excel(name = "实际电机成本")
    private Long actualMotorPrice;

    public void setCostId(Long costId) 
    {
        this.costId = costId;
    }

    public Long getCostId() 
    {
        return costId;
    }
    public void setOutsourcingId(Long outsourcingId) 
    {
        this.outsourcingId = outsourcingId;
    }

    public Long getOutsourcingId() 
    {
        return outsourcingId;
    }
    public void setQuotationId(Long quotationId) 
    {
        this.quotationId = quotationId;
    }

    public Long getQuotationId() 
    {
        return quotationId;
    }
    public void setProductPrice(Long productPrice) 
    {
        this.productPrice = productPrice;
    }

    public Long getProductPrice() 
    {
        return productPrice;
    }
    public void setActualProductPrice(Long actualProductPrice) 
    {
        this.actualProductPrice = actualProductPrice;
    }

    public Long getActualProductPrice() 
    {
        return actualProductPrice;
    }
    public void setMotorPrice(Long motorPrice) 
    {
        this.motorPrice = motorPrice;
    }

    public Long getMotorPrice() 
    {
        return motorPrice;
    }
    public void setActualMotorPrice(Long actualMotorPrice) 
    {
        this.actualMotorPrice = actualMotorPrice;
    }

    public Long getActualMotorPrice() 
    {
        return actualMotorPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("costId", getCostId())
            .append("outsourcingId", getOutsourcingId())
            .append("quotationId", getQuotationId())
            .append("productPrice", getProductPrice())
            .append("actualProductPrice", getActualProductPrice())
            .append("motorPrice", getMotorPrice())
            .append("actualMotorPrice", getActualMotorPrice())
            .toString();
    }
}
