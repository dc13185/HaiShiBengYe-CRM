package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 机封系统管理对象 busi_system
 *
 * @author ruoyi
 * @date 2021-01-09
 */
public class BusiSystem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long systemId;

    /** 系统型号 */
    @Excel(name = "系统型号")
    private String systemModel;

    /** 系统价格 */
    @Excel(name = "系统价格")
    private Long systemPrice;

    /**  */
    private String supplierId;

    public void setSystemId(Long systemId)
    {
        this.systemId = systemId;
    }

    public Long getSystemId()
    {
        return systemId;
    }
    public void setSystemModel(String systemModel)
    {
        this.systemModel = systemModel;
    }

    public String getSystemModel()
    {
        return systemModel;
    }
    public void setSystemPrice(Long systemPrice)
    {
        this.systemPrice = systemPrice;
    }

    public Long getSystemPrice()
    {
        return systemPrice;
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
            .append("systemId", getSystemId())
            .append("systemModel", getSystemModel())
            .append("systemPrice", getSystemPrice())
            .append("supplierId", getSupplierId())
            .toString();
    }
}
