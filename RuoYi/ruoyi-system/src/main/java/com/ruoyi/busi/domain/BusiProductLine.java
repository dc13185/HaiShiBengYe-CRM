package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品系列管理对象 busi_product_line
 *
 * @author ruoyi
 * @date 2021-01-06
 */
public class BusiProductLine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long productLineId;

    /** 泵系列 */
    @Excel(name = "泵系列")
    private String productLineName;

    /** 毛利率 */
    @Excel(name = "毛利率")
    private Float grossProfitRate;

    public void setProductLineId(Long productLineId)
    {
        this.productLineId = productLineId;
    }

    public Long getProductLineId()
    {
        return productLineId;
    }
    public void setProductLineName(String productLineName)
    {
        this.productLineName = productLineName;
    }

    public String getProductLineName()
    {
        return productLineName;
    }

    public Float getGrossProfitRate() {
        return grossProfitRate;
    }

    public void setGrossProfitRate(Float grossProfitRate) {
        this.grossProfitRate = grossProfitRate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productLineId", getProductLineId())
            .append("productLineName", getProductLineName())
            .append("grossProfitRate", getGrossProfitRate())
            .toString();
    }
}
