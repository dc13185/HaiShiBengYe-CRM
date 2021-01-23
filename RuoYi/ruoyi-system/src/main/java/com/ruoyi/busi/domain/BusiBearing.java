package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 轴承供应商对象 busi_bearing
 *
 * @author ruoyi
 * @date 2021-01-04
 */
public class BusiBearing extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long bearingId;

    /** 轴承型号 */
    @Excel(name = "轴承型号")
    private String bearingModel;

    /** 轴承价格 */
    @Excel(name = "轴承价格")
    private Double bearingPrice;

    /**  */
    private String supplierId;

    public void setBearingId(Long bearingId)
    {
        this.bearingId = bearingId;
    }

    public Long getBearingId()
    {
        return bearingId;
    }
    public void setBearingModel(String bearingModel)
    {
        this.bearingModel = bearingModel;
    }

    public String getBearingModel()
    {
        return bearingModel;
    }
    public void setSupplierId(String supplierId)
    {
        this.supplierId = supplierId;
    }

    public String getSupplierId()
    {
        return supplierId;
    }


    public Double getBearingPrice() {
        return bearingPrice;
    }

    public void setBearingPrice(Double bearingPrice) {
        this.bearingPrice = bearingPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bearingId", getBearingId())
            .append("bearingModel", getBearingModel())
            .append("bearingPrice", getBearingPrice())
            .append("supplierId", getSupplierId())
            .toString();
    }
}
