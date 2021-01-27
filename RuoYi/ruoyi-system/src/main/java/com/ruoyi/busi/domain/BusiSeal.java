package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 冲洗方案管理对象 busi_seal
 *
 * @author ruoyi
 * @date 2021-01-09
 */
public class BusiSeal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long sealId;

    /** 冲洗方案 */
    @Excel(name = "冲洗方案")
    private String sealModel;

    /** 冲洗价格 */
    @Excel(name = "冲洗价格")
    private Float sealPrice;

    /**  */
    private String supplierId;

    public void setSealId(Long sealId)
    {
        this.sealId = sealId;
    }

    public Long getSealId()
    {
        return sealId;
    }
    public void setSealModel(String sealModel)
    {
        this.sealModel = sealModel;
    }

    public String getSealModel()
    {
        return sealModel;
    }

    public Float getSealPrice() {
        return sealPrice;
    }

    public void setSealPrice(Float sealPrice) {
        this.sealPrice = sealPrice;
    }

    public void setSupplierId(String supplierId)
    {
        this.supplierId = supplierId;
    }

    public String getSupplierId()
    {
        return supplierId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sealId", getSealId())
            .append("sealModel", getSealModel())
            .append("sealPrice", getSealPrice())
            .append("supplierId", getSupplierId())
            .toString();
    }
}
