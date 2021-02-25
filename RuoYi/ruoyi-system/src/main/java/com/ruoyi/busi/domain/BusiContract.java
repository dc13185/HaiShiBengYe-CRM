package com.ruoyi.busi.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.busi.contract.domain.BusiContractProduct;
import com.ruoyi.common.utils.StringUtils;
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

    /** 产品组成 */
    //@Excel(name = "产品组成")
    private String productComposition;

    /** 组成价格 */
    //@Excel(name = "组成价格")
    private String componentPrice;

    /** 付款方式 */
    //@Excel(name = "付款方式")
    private String paymentMethod;

    /** 产品类型 */
    @Excel(name = "产品类型", readConverterExp = "0=整机,1=外购,2=配件")
    private Long quotationType;

    @Excel(name = "客户姓名")
    private String customerName;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 办事处 */
    @Excel(name = "办事处")
    private String officeAddress;


    /** 交货时间 */
    @Excel(name = "交货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryTime;

    /** 合同签订日期 */
    @Excel(name = "合同签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signingDate;


    @Excel(name = "报价金额" )
    private Double quotationPrice;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private Double contractPrice;

    @Excel(name = "回款金额" )
    private Double repaymentAmount;

    @Excel(name = "折扣率" )
    private Double discountRate;


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
    /** 项目状态 */
    @Excel(name = "项目状态" , readConverterExp = "0=执行中,1=已完成")
    private Long contractType;


    /** 更新时间 */
    @Excel(name = "更进时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Long courseId;

    private List<BusiContractProduct> busiContractProducts;

    @Excel(name = "产品组成" )
    private String busiContractProductsString;

    /** 备注 */
    @Excel(name = "备注")
    private String remake;

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getQuotationType() {
        return quotationType;
    }

    public void setQuotationType(Long quotationType) {
        this.quotationType = quotationType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getBusiContractProductsString() {
        return busiContractProductsString;
    }

    public void setBusiContractProductsString(String busiContractProductsString) {
        this.busiContractProductsString = busiContractProductsString;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = StringUtils.doubleFormat(quotationPrice/contractPrice);
    }

    public Double getQuotationPrice() {
        return quotationPrice;
    }

    public void setQuotationPrice(Double quotationPrice) {
        this.quotationPrice = busiQuotation.getSumPrice();
    }

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

    public Long getContractType() {
        return contractType;
    }

    public void setContractType(Long contractType) {
        this.contractType = contractType;
    }

    public List<BusiContractProduct> getBusiContractProducts() {
        return busiContractProducts;
    }

    public void setBusiContractProducts(List<BusiContractProduct> busiContractProducts) {
        this.busiContractProducts = busiContractProducts;
    }

    public Double getRepaymentAmount() {
        return repaymentAmount;
    }

    public void setRepaymentAmount(Double repaymentAmount) {
        this.repaymentAmount = repaymentAmount;
    }


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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
