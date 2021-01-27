package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 变价变量对象 busi_price
 *
 * @author ruoyi
 * @date 2021-01-20
 */
public class BusiPrice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long priceId;

    /** 报价变量说明 */
    @Excel(name = "报价变量说明")
    private String priceName;

    /** 数据 */
    @Excel(name = "数据")
    private Float priceDate;

    public void setPriceId(Long priceId)
    {
        this.priceId = priceId;
    }

    public Long getPriceId()
    {
        return priceId;
    }
    public void setPriceName(String priceName)
    {
        this.priceName = priceName;
    }

    public String getPriceName()
    {
        return priceName;
    }

    public Float getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Float priceDate) {
        this.priceDate = priceDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("priceId", getPriceId())
            .append("priceName", getPriceName())
            .append("priceDate", getPriceDate())
            .toString();
    }
}
