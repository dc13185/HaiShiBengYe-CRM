package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商附件中间对象 busi_supplier_annex
 * 
 * @author ruoyi
 * @date 2020-12-29
 */
public class BusiSupplierAnnex extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private String supplierId;

    /** 附件ID */
    @Excel(name = "附件ID")
    private Long annexId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSupplierId(String supplierId) 
    {
        this.supplierId = supplierId;
    }

    public String getSupplierId() 
    {
        return supplierId;
    }
    public void setAnnexId(Long annexId) 
    {
        this.annexId = annexId;
    }

    public Long getAnnexId() 
    {
        return annexId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supplierId", getSupplierId())
            .append("annexId", getAnnexId())
            .toString();
    }
}
