package com.ruoyi.busi.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合同管理对象 busi_contract
 *
 * @author ruoyi
 * @date 2021-01-25
 */
public class BusiContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long contractId;

    /** 报价单 */
    private Long qutationId;

    /** 合同号 */
    @Excel(name = "合同号")
    private String contractNo;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private Double contractPrice;

    /** 产品组成 */
    @Excel(name = "产品组成")
    private String productComposition;

    /** 组成价格 */
    @Excel(name = "组成价格")
    private String componentPrice;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String paymentMethod;

    /** 交货时间 */
    @Excel(name = "交货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryTime;

    /** 合同签订日期 */
    @Excel(name = "合同签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signingDate;

    /** 备注 */
    @Excel(name = "备注")
    private String remake;



    /** 整体进度说明 */
    @Excel(name = "整体进度说明")
    private String progressStatement;

    /** 负责人 */
    @Excel(name = "负责人")
    private String principal;

    /** 延期警告 */
    @Excel(name = "延期警告")
    private Long delayWarning;

    /** 延期说明 */
    @Excel(name = "延期说明")
    private String delayInstructions;

    private BusiQuotation busiQuotation;

    public void setContractId(Long contractId)
    {
        this.contractId = contractId;
    }

    public Long getContractId()
    {
        return contractId;
    }
    public void setQutationId(Long qutationId)
    {
        this.qutationId = qutationId;
    }

    public Long getQutationId()
    {
        return qutationId;
    }
    public void setContractPrice(Double contractPrice)
    {
        this.contractPrice = contractPrice;
    }

    public Double getContractPrice()
    {
        return contractPrice;
    }
    public void setProductComposition(String productComposition)
    {
        this.productComposition = productComposition;
    }

    public String getProductComposition()
    {
        return productComposition;
    }
    public void setComponentPrice(String componentPrice)
    {
        this.componentPrice = componentPrice;
    }

    public String getComponentPrice()
    {
        return componentPrice;
    }
    public void setPaymentMethod(String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod()
    {
        return paymentMethod;
    }
    public void setDeliveryTime(Date deliveryTime)
    {
        this.deliveryTime = deliveryTime;
    }

    public Date getDeliveryTime()
    {
        return deliveryTime;
    }
    public void setSigningDate(Date signingDate)
    {
        this.signingDate = signingDate;
    }

    public Date getSigningDate()
    {
        return signingDate;
    }
    public void setRemake(String remake)
    {
        this.remake = remake;
    }

    public String getRemake()
    {
        return remake;
    }

    public BusiQuotation getBusiQuotation() {
        return busiQuotation;
    }

    public void setBusiQuotation(BusiQuotation busiQuotation) {
        this.busiQuotation = busiQuotation;
    }

    public String getProgressStatement() {
        return progressStatement;
    }

    public void setProgressStatement(String progressStatement) {
        this.progressStatement = progressStatement;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Long getDelayWarning() {
        return delayWarning;
    }

    public void setDelayWarning(Long delayWarning) {
        this.delayWarning = delayWarning;
    }

    public String getDelayInstructions() {
        return delayInstructions;
    }

    public void setDelayInstructions(String delayInstructions) {
        this.delayInstructions = delayInstructions;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("contractId", getContractId())
                .append("qutationId", getQutationId())
                .append("contractPrice", getContractPrice())
                .append("productComposition", getProductComposition())
                .append("componentPrice", getComponentPrice())
                .append("paymentMethod", getPaymentMethod())
                .append("deliveryTime", getDeliveryTime())
                .append("signingDate", getSigningDate())
                .append("remake", getRemake())
                .toString();
    }
}
