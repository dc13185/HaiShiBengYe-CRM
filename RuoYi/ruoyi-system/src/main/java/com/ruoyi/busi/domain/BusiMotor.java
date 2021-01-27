package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电机产品对象 busi_motor
 *
 * @author ruoyi
 * @date 2021-01-01
 */
public class BusiMotor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long motorId;

    /** 电机型号 */
    @Excel(name = "电机型号")
    private String motorModel;

    /** 功率/KW */
    @Excel(name = "功率/KW")
    private Long motorPower;

    /** 电机种类 */
    @Excel(name = "电机种类")
    private String motorType;

    /** 价格 */
    @Excel(name = "价格")
    private Float price;


    private String supplierId;

    public void setMotorId(Long motorId)
    {
        this.motorId = motorId;
    }

    public Long getMotorId()
    {
        return motorId;
    }
    public void setMotorModel(String motorModel)
    {
        this.motorModel = motorModel;
    }

    public String getMotorModel()
    {
        return motorModel;
    }
    public void setMotorPower(Long motorPower)
    {
        this.motorPower = motorPower;
    }

    public Long getMotorPower()
    {
        return motorPower;
    }
    public void setMotorType(String motorType)
    {
        this.motorType = motorType;
    }

    public String getMotorType()
    {
        return motorType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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
            .append("motorId", getMotorId())
            .append("motorModel", getMotorModel())
            .append("motorPower", getMotorPower())
            .append("motorType", getMotorType())
            .append("price", getPrice())
            .toString();
    }
}
