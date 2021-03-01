package com.ruoyi.busi.settlement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 业务费用结算历史对象 busi_settlement_history
 *
 * @author ruoyi
 * @date 2021-02-19
 */
public class BusiSettlementHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    @Excel(name = "更新时间")
    private Date updateTime;


    /** 基础性提成计提比例/% */
    @Excel(name = "基础性提成计提比例/%")
    private Double basedCommission;

    /** 溢价部分计提比例/% */
    @Excel(name = "溢价部分计提比例/%")
    private Double premiumCommission;

    /** 应付业务费合计/元 */
    @Excel(name = "应付业务费合计/元")
    private Double businessCommission;

    /** 应付业务费用类型选择 */
    private Long businessCommissionType;

    /** 质保金比例/% */
    @Excel(name = "质保金比例/%")
    private Double warrantyCommission;

    @Excel(name = "质保金暂扣比例/%")
    private Double deductionCommission;

    /** 已回款金额/元 */
    @Excel(name = "已回款金额/元")
    private Double receivedCommission;

    /** 已结算业务费 */
    @Excel(name = "已结算业务费")
    private Double alreadySettlementBusinessFee;

    /** 结算业务费 */
    @Excel(name = "结算业务费")
    private Double settlementBusinessFee;

    /** 暂扣代缴个人所得税 */
    @Excel(name = "暂扣代缴个人所得税")
    private Double individualIncomeTax;

    /** 支付业务费金额 */
    @Excel(name = "支付业务费金额")
    private Double amountOfBusiness;


    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 业务结算费用Id */
    private Long settlementId;


    public Double getDeductionCommission() {
        return deductionCommission;
    }

    public void setDeductionCommission(Double deductionCommission) {
        this.deductionCommission = deductionCommission;
    }

    public void setBasedCommission(Double basedCommission)
    {
        this.basedCommission = basedCommission;
    }

    public Double getBasedCommission()
    {
        return basedCommission;
    }
    public void setPremiumCommission(Double premiumCommission)
    {
        this.premiumCommission = premiumCommission;
    }

    public Double getPremiumCommission()
    {
        return premiumCommission;
    }
    public void setBusinessCommission(Double businessCommission)
    {
        this.businessCommission = businessCommission;
    }

    public Double getBusinessCommission()
    {
        return businessCommission;
    }
    public void setBusinessCommissionType(Long businessCommissionType)
    {
        this.businessCommissionType = businessCommissionType;
    }

    public Long getBusinessCommissionType()
    {
        return businessCommissionType;
    }
    public void setWarrantyCommission(Double warrantyCommission)
    {
        this.warrantyCommission = warrantyCommission;
    }

    public Double getWarrantyCommission()
    {
        return warrantyCommission;
    }
    public void setReceivedCommission(Double receivedCommission)
    {
        this.receivedCommission = receivedCommission;
    }

    public Double getReceivedCommission()
    {
        return receivedCommission;
    }
    public void setAlreadySettlementBusinessFee(Double alreadySettlementBusinessFee)
    {
        this.alreadySettlementBusinessFee = alreadySettlementBusinessFee;
    }

    public Double getAlreadySettlementBusinessFee()
    {
        return alreadySettlementBusinessFee;
    }
    public void setSettlementBusinessFee(Double settlementBusinessFee)
    {
        this.settlementBusinessFee = settlementBusinessFee;
    }

    public Double getSettlementBusinessFee()
    {
        return settlementBusinessFee;
    }
    public void setIndividualIncomeTax(Double individualIncomeTax)
    {
        this.individualIncomeTax = individualIncomeTax;
    }

    public Double getIndividualIncomeTax()
    {
        return individualIncomeTax;
    }
    public void setAmountOfBusiness(Double amountOfBusiness)
    {
        this.amountOfBusiness = amountOfBusiness;
    }

    public Double getAmountOfBusiness()
    {
        return amountOfBusiness;
    }
    public void setSettlementId(Long settlementId)
    {
        this.settlementId = settlementId;
    }

    public Long getSettlementId()
    {
        return settlementId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("basedCommission", getBasedCommission())
            .append("premiumCommission", getPremiumCommission())
            .append("businessCommission", getBusinessCommission())
            .append("businessCommissionType", getBusinessCommissionType())
            .append("warrantyCommission", getWarrantyCommission())
            .append("receivedCommission", getReceivedCommission())
            .append("alreadySettlementBusinessFee", getAlreadySettlementBusinessFee())
            .append("settlementBusinessFee", getSettlementBusinessFee())
            .append("individualIncomeTax", getIndividualIncomeTax())
            .append("amountOfBusiness", getAmountOfBusiness())
            .append("settlementId", getSettlementId())
            .toString();
    }
}
