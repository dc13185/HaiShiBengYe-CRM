package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报价单管理对象 busi_quotation
 *
 * @author ruoyi
 * @date 2021-01-12
 */
public class BusiQuotation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目编号 */
    private Long quotationId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目所在地 */
    @Excel(name = "项目所在地")
    private String projectAddress;

    /** 报价单号 */
    @Excel(name = "报价单号")
    private String quotationNo;

    /** 客户id */
    private Long customerId;

    @Excel(name = "客户姓名")
    private String customerName;

    @Excel(name = "所在行业")
    private String customerIndustry;

    @Excel(name = "客户所在地")
    private String customerAddress;


    /** 办事处 */
    @Excel(name = "办事处")
    private String officeAddress;

    /** 业务员 */
    @Excel(name = "业务员")
    private String officeStaffName;

    /** 选型技术人员 */
    @Excel(name = "选型技术人员")
    private Long technicalStaffId;

    /** 产品类型 */
    @Excel(name = "产品类型")
    private Long quotationType;

    @Excel(name = "合计数量")
    private Double allCount;

    @Excel(name = "自制报价单价格")
    private Double quotationPrice;

    @Excel(name = "外购单价格")
    private Double outsourcingPrice;

    @Excel(name = "配件价格")
    private Double partsPrice;

    @Excel(name = "合计价格")
    private Double sumPrice;



    public void setQuotationId(Long quotationId)
    {
        this.quotationId = quotationId;
    }

    public Long getQuotationId()
    {
        return quotationId;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }
    public void setProjectAddress(String projectAddress)
    {
        this.projectAddress = projectAddress;
    }

    public String getProjectAddress()
    {
        return projectAddress;
    }
    public void setQuotationNo(String quotationNo)
    {
        this.quotationNo = quotationNo;
    }

    public String getQuotationNo()
    {
        return quotationNo;
    }
    public void setCustomerId(Long customerId)
    {
        this.customerId = customerId;
    }

    public Long getCustomerId()
    {
        return customerId;
    }
    public void setOfficeAddress(String officeAddress)
    {
        this.officeAddress = officeAddress;
    }

    public String getOfficeAddress()
    {
        return officeAddress;
    }
    public void setOfficeStaffName(String officeStaffName)
    {
        this.officeStaffName = officeStaffName;
    }

    public String getOfficeStaffName()
    {
        return officeStaffName;
    }
    public void setTechnicalStaffId(Long technicalStaffId)
    {
        this.technicalStaffId = technicalStaffId;
    }

    public Long getTechnicalStaffId()
    {
        return technicalStaffId;
    }
    public void setQuotationType(Long quotationType)
    {
        this.quotationType = quotationType;
    }

    public Long getQuotationType()
    {
        return quotationType;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIndustry() {
        return customerIndustry;
    }

    public void setCustomerIndustry(String customerIndustry) {
        this.customerIndustry = customerIndustry;
    }

    public Double getAllCount() {
        return allCount;
    }

    public void setAllCount(Double allCount) {
        this.allCount = allCount;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


    public Double getQuotationPrice() {
        return quotationPrice;
    }

    public void setQuotationPrice(Double quotationPrice) {
        this.quotationPrice = quotationPrice;
    }

    public Double getOutsourcingPrice() {
        return outsourcingPrice;
    }

    public void setOutsourcingPrice(Double outsourcingPrice) {
        this.outsourcingPrice = outsourcingPrice;
    }


    public Double getPartsPrice() {
        return partsPrice;
    }

    public void setPartsPrice(Double partsPrice) {
        this.partsPrice = partsPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("quotationId", getQuotationId())
            .append("projectName", getProjectName())
            .append("projectAddress", getProjectAddress())
            .append("quotationNo", getQuotationNo())
            .append("customerId", getCustomerId())
            .append("officeAddress", getOfficeAddress())
            .append("officeStaffName", getOfficeStaffName())
            .append("technicalStaffId", getTechnicalStaffId())
            .append("quotationType", getQuotationType())
            .toString();
    }
}
