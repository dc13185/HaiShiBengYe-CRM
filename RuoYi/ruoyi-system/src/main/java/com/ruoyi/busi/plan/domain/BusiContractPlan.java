package com.ruoyi.busi.plan.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合同进度对象 busi_contract_plan
 *
 * @author ruoyi
 * @date 2021-01-25
 */
public class BusiContractPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long planId;

    /** 合同ID */
    @Excel(name = "合同ID")
    private Long contractId;

    /** 步骤名 */
    @Excel(name = "步骤名")
    private String planName;

    /** 计划完成时间 */
    @Excel(name = "计划完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date plannedTime;

    /** 实际完成时间 */
    @Excel(name = "实际完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date actualTime;

    public void setPlanId(Long planId)
    {
        this.planId = planId;
    }

    public Long getPlanId()
    {
        return planId;
    }
    public void setContractId(Long contractId)
    {
        this.contractId = contractId;
    }

    public Long getContractId()
    {
        return contractId;
    }
    public void setPlanName(String planName)
    {
        this.planName = planName;
    }

    public String getPlanName()
    {
        return planName;
    }
    public void setPlannedTime(Date plannedTime)
    {
        this.plannedTime = plannedTime;
    }

    public Date getPlannedTime()
    {
        return plannedTime;
    }
    public void setActualTime(Date actualTime)
    {
        this.actualTime = actualTime;
    }

    public Date getActualTime()
    {
        return actualTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planId", getPlanId())
            .append("contractId", getContractId())
            .append("planName", getPlanName())
            .append("plannedTime", getPlannedTime())
            .append("actualTime", getActualTime())
            .toString();
    }
}
