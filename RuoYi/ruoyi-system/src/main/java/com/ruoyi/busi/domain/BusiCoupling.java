package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 联轴器对象 busi_coupling
 *
 * @author ruoyi
 * @date 2021-01-04
 */
public class BusiCoupling extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long couplingId;

    /** 联轴器型号 */
    @Excel(name = "联轴器型号")
    private String couplingModel;

    /** 联轴器价格 */
    @Excel(name = "联轴器价格")
    private Long couplingPrice;

    @Excel(name = "供应商")
    private String supplierName;
    /**  */
    private String supplierId;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setCouplingId(Long couplingId)
    {
        this.couplingId = couplingId;
    }

    public Long getCouplingId()
    {
        return couplingId;
    }
    public void setCouplingModel(String couplingModel)
    {
        this.couplingModel = couplingModel;
    }

    public String getCouplingModel()
    {
        return couplingModel;
    }
    public void setCouplingPrice(Long couplingPrice)
    {
        this.couplingPrice = couplingPrice;
    }

    public Long getCouplingPrice()
    {
        return couplingPrice;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("couplingId", getCouplingId())
            .append("couplingModel", getCouplingModel())
            .append("couplingPrice", getCouplingPrice())
            .append("supplierId", getSupplierId())
            .toString();
    }
}
