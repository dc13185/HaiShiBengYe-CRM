package com.ruoyi.busi.outsourcing.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 外购产品供应商对象 busi_outsourcing
 *
 * @author ruoyi
 * @date 2021-01-30
 */
public class BusiOutsourcing extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long outsourcingId;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String outsourcingModel;

    /** 过滤流系列材质 */
    @Excel(name = "过滤流系列材质")
    private String outsourcingMaterial;

    /** 价格 */
    @Excel(name = "价格")
    private Double outsourcingPrice;

    /**  */
    private Long outsourcingLineId;

    public void setOutsourcingId(Long outsourcingId)
    {
        this.outsourcingId = outsourcingId;
    }

    public Long getOutsourcingId()
    {
        return outsourcingId;
    }
    public void setOutsourcingModel(String outsourcingModel)
    {
        this.outsourcingModel = outsourcingModel;
    }

    public String getOutsourcingModel()
    {
        return outsourcingModel;
    }
    public void setOutsourcingMaterial(String outsourcingMaterial)
    {
        this.outsourcingMaterial = outsourcingMaterial;
    }

    public String getOutsourcingMaterial()
    {
        return outsourcingMaterial;
    }

    public Double getOutsourcingPrice() {
        return outsourcingPrice;
    }

    public void setOutsourcingPrice(Double outsourcingPrice) {
        this.outsourcingPrice = outsourcingPrice;
    }

    public Long getOutsourcingLineId() {
        return outsourcingLineId;
    }

    public void setOutsourcingLineId(Long outsourcingLineId) {
        this.outsourcingLineId = outsourcingLineId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("outsourcingId", getOutsourcingId())
            .append("outsourcingModel", getOutsourcingModel())
            .append("outsourcingMaterial", getOutsourcingMaterial())
            .append("outsourcingPrice", getOutsourcingPrice())
            .toString();
    }
}
