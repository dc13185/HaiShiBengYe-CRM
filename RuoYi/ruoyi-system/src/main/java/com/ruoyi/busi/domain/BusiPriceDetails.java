package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报价单报价明细对象 busi_price_details
 *
 * @author ruoyi
 * @date 2021-01-28
 */
public class BusiPriceDetails extends BaseEntity
{
    private static final Long serialVersionUID = 1L;

    /**  */
    private Double priceDetailsId;

    /** 泵头成本 */
    private Double bengtouCb;

    /** 泵头材料成本 */
    @Excel(name = "泵头材料成本")
    private Double bengtouclCb;

    /** 泵头人工成本 */
    @Excel(name = "泵头人工成本")
    private Double bengtouRgCb;

    /** 制造费用成本 */
    @Excel(name = "制造费用成本")
    private Double bengtouFyCb;

    /** 电机成本 */
    @Excel(name = "电机成本")
    private Double motorCb;

    /** 机封及系统成本 */
    @Excel(name = "机封及系统成本")
    private Double jfCb;

    /** 轴承成本 */
    @Excel(name = "轴承成本")
    private Double zcCb;

    /** 联轴器成本 */
    @Excel(name = "联轴器成本")
    private Double zlqCb;

    /** 额外配置成本 */
    @Excel(name = "额外配置成本")
    private Double ewCb;

    @Excel(name = "报价金额")
    private Double contractPrice;

    /**  */
    @Excel(name = "")
    private Long quotationId;

    public void setPriceDetailsId(Double priceDetailsId)
    {
        this.priceDetailsId = priceDetailsId;
    }

    public Double getPriceDetailsId()
    {
        return priceDetailsId;
    }
    public void setBengtouCb(Double bengtouCb)
    {
        this.bengtouCb = bengtouCb;
    }

    public Double getBengtouCb()
    {
        return bengtouCb;
    }
    public void setBengtouclCb(Double bengtouclCb)
    {
        this.bengtouclCb = bengtouclCb;
    }

    public Double getBengtouclCb()
    {
        return bengtouclCb;
    }
    public void setBengtouRgCb(Double bengtouRgCb)
    {
        this.bengtouRgCb = bengtouRgCb;
    }

    public Double getBengtouRgCb()
    {
        return bengtouRgCb;
    }
    public void setBengtouFyCb(Double bengtouFyCb)
    {
        this.bengtouFyCb = bengtouFyCb;
    }

    public Double getBengtouFyCb()
    {
        return bengtouFyCb;
    }
    public void setMotorCb(Double motorCb)
    {
        this.motorCb = motorCb;
    }

    public Double getMotorCb()
    {
        return motorCb;
    }
    public void setJfCb(Double jfCb)
    {
        this.jfCb = jfCb;
    }

    public Double getJfCb()
    {
        return jfCb;
    }
    public void setZcCb(Double zcCb)
    {
        this.zcCb = zcCb;
    }

    public Double getZcCb()
    {
        return zcCb;
    }
    public void setZlqCb(Double zlqCb)
    {
        this.zlqCb = zlqCb;
    }

    public Double getZlqCb()
    {
        return zlqCb;
    }
    public void setEwCb(Double ewCb)
    {
        this.ewCb = ewCb;
    }

    public Double getEwCb()
    {
        return ewCb;
    }
    public void setQuotationId(Long quotationId)
    {
        this.quotationId = quotationId;
    }

    public Long getQuotationId()
    {
        return quotationId;
    }

    public Double getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(Double contractPrice) {
        this.contractPrice = contractPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("priceDetailsId", getPriceDetailsId())
            .append("bengtouCb", getBengtouCb())
            .append("bengtouclCb", getBengtouclCb())
            .append("bengtouRgCb", getBengtouRgCb())
            .append("bengtouFyCb", getBengtouFyCb())
            .append("motorCb", getMotorCb())
            .append("jfCb", getJfCb())
            .append("zcCb", getZcCb())
            .append("zlqCb", getZlqCb())
            .append("ewCb", getEwCb())
            .append("quotationId", getQuotationId())
            .toString();
    }
}
