package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 机封管理对象 busi_machine
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
public class BusiMachine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long machineId;

    /** 机封型号 */
    @Excel(name = "机封型号")
    private String machineModel;

    /** 机封价格 */
    @Excel(name = "机封价格")
    private String machinePrice;

    /**  */
    private String supplierId;

    public void setMachineId(Long machineId) 
    {
        this.machineId = machineId;
    }

    public Long getMachineId() 
    {
        return machineId;
    }
    public void setMachineModel(String machineModel) 
    {
        this.machineModel = machineModel;
    }

    public String getMachineModel() 
    {
        return machineModel;
    }
    public void setMachinePrice(String machinePrice) 
    {
        this.machinePrice = machinePrice;
    }

    public String getMachinePrice() 
    {
        return machinePrice;
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
            .append("machineId", getMachineId())
            .append("machineModel", getMachineModel())
            .append("machinePrice", getMachinePrice())
            .append("supplierId", getSupplierId())
            .toString();
    }
}
