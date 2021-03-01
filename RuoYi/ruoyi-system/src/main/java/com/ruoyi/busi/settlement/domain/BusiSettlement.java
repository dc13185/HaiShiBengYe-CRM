package com.ruoyi.busi.settlement.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 业务费用结算对象 busi_settlement
 *
 * @author ruoyi
 * @date 2021-02-19
 */
public class BusiSettlement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long settlementId;

    /** 合同号 */
    @Excel(name = "合同号")
    private String contractNo;

    /** 报价单号 */
    @Excel(name = "报价单号")
    private String quotationNo;

    /** 办事处ID */
    private Long staffId;

    @Excel(name = "办事处")
    private String officeAddress;

    @Excel(name = "业务员")
    private String officeStaffName;

    /** 合同金额/元 */
    @Excel(name = "合同金额/元")
    private Double contractPrice;

    /** 报价金额/元 */
    private Double quotationPrice;

    /** 成本金额 */
    @Excel(name = "报价成本")
    private Double quotationCost;

    /** 电机成本/元 */
    @Excel(name = "电机成本/元")
    private Double motorCost;

    /** 特殊配置费用/元 */
    @Excel(name = "特殊配置费用/元")
    private Double otherCost;

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
    @Excel(name = "应付业务费用类型选择" ,readConverterExp="0=常规,1=一事一议")
    private Long businessCommissionType;

    /** 质保金比例/% */
    @Excel(name = "质保金比例/%")
    private Double warrantyCommission;


    @Excel(name = "质保金暂扣比例/%")
    private Double deductionCommission;

    /** 已回款金额/元 */
    @Excel(name = "已回款金额/元")
    private Double receivedCommission;

    /** 结算业务费 */
    @Excel(name = "结算业务费")
    private Double settlementBusinessFee;


    /** 暂扣代缴个人所得税 */
    @Excel(name = "暂扣代缴个人所得税")
    private Double individualIncomeTax;

    /** 支付业务费金额 */
    @Excel(name = "支付业务费金额")
    private Double amountOfBusiness;


    public Double getQuotationCost() {
        return quotationCost;
    }

    public void setQuotationCost(Double quotationCost) {
        this.quotationCost = quotationCost;
    }

    public Double getDeductionCommission() {
        return deductionCommission;
    }

    public void setDeductionCommission(Double deductionCommission) {
        this.deductionCommission = deductionCommission;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getOfficeStaffName() {
        return officeStaffName;
    }

    public void setOfficeStaffName(String officeStaffName) {
        this.officeStaffName = officeStaffName;
    }

    public void setSettlementId(Long settlementId)
    {
        this.settlementId = settlementId;
    }

    public Long getSettlementId()
    {
        return settlementId;
    }
    public void setContractNo(String contractNo)
    {
        this.contractNo = contractNo;
    }

    public String getContractNo()
    {
        return contractNo;
    }


    public String getQuotationNo() {
        return quotationNo;
    }

    public void setQuotationNo(String quotationNo) {
        this.quotationNo = quotationNo;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getStaffId()
    {
        return staffId;
    }
    public void setContractPrice(Double contractPrice)
    {
        this.contractPrice = contractPrice;
    }

    public Double getContractPrice()
    {
        return contractPrice;
    }
    public void setQuotationPrice(Double quotationPrice)
    {
        this.quotationPrice = quotationPrice;
    }

    public Double getQuotationPrice()
    {
        return quotationPrice;
    }
    public void setMotorCost(Double motorCost)
    {
        this.motorCost = motorCost;
    }

    public Double getMotorCost()
    {
        return motorCost;
    }
    public void setOtherCost(Double otherCost)
    {
        this.otherCost = otherCost;
    }

    public Double getOtherCost()
    {
        return otherCost;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("settlementId", getSettlementId())
            .append("contractNo", getContractNo())
            .append("staffId", getStaffId())
            .append("contractPrice", getContractPrice())
            .append("quotationPrice", getQuotationPrice())
            .append("motorCost", getMotorCost())
            .append("otherCost", getOtherCost())
            .append("basedCommission", getBasedCommission())
            .append("premiumCommission", getPremiumCommission())
            .append("businessCommission", getBusinessCommission())
            .append("businessCommissionType", getBusinessCommissionType())
            .append("warrantyCommission", getWarrantyCommission())
            .append("receivedCommission", getReceivedCommission())
            .append("settlementBusinessFee", getSettlementBusinessFee())
            .append("individualIncomeTax", getIndividualIncomeTax())
            .append("amountOfBusiness", getAmountOfBusiness())
            .toString();
    }
}
