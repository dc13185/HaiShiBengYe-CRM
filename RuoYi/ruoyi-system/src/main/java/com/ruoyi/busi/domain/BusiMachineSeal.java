package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 机封以及系统产品对象 busi_machine_seal
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public class BusiMachineSeal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 机封Id */
    private Long machineId;

    /** 机封型号 */
    @Excel(name = "机封型号")
    private String machineSealModel;

    /** 机封价格 */
    @Excel(name = "机封价格")
    private Long machineSealPrice;

    /** 冲洗方案 */
    @Excel(name = "冲洗方案")
    private String rinseSolution;

    /** 冲洗方案价格 */
    @Excel(name = "冲洗方案价格")
    private Long rinseSolutionPrice;

    /** 系统型号 */
    @Excel(name = "系统型号")
    private String systemModel;

    /** 系统价格 */
    @Excel(name = "系统价格")
    private Long systemPrice;

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
    public void setMachineSealModel(String machineSealModel) 
    {
        this.machineSealModel = machineSealModel;
    }

    public String getMachineSealModel() 
    {
        return machineSealModel;
    }
    public void setMachineSealPrice(Long machineSealPrice) 
    {
        this.machineSealPrice = machineSealPrice;
    }

    public Long getMachineSealPrice() 
    {
        return machineSealPrice;
    }
    public void setRinseSolution(String rinseSolution) 
    {
        this.rinseSolution = rinseSolution;
    }

    public String getRinseSolution() 
    {
        return rinseSolution;
    }
    public void setRinseSolutionPrice(Long rinseSolutionPrice) 
    {
        this.rinseSolutionPrice = rinseSolutionPrice;
    }

    public Long getRinseSolutionPrice() 
    {
        return rinseSolutionPrice;
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
            .append("machineId", getMachineId())
            .append("machineSealModel", getMachineSealModel())
            .append("machineSealPrice", getMachineSealPrice())
            .append("rinseSolution", getRinseSolution())
            .append("rinseSolutionPrice", getRinseSolutionPrice())
            .append("systemModel", getSystemModel())
            .append("systemPrice", getSystemPrice())
            .append("supplierId", getSupplierId())
            .toString();
    }
}
