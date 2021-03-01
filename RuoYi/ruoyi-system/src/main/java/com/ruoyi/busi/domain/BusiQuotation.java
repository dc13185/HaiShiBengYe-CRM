package com.ruoyi.busi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

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

    /** 报价单号 */
    @Excel(name = "报价单号")
    private String quotationNo;


    /** 产品类型 */
    @Excel(name = "产品类型", readConverterExp = "0=整机,1=外购,2=配件")
    private Long quotationType;


    @Excel(name = "客户名称")
    private String customerName;

    @Excel(name = "所在行业")
    private String customerIndustry;

    @Excel(name = "客户所在地")
    private String customerAddress;


    /** 项目所在地 */
    @Excel(name = "项目所在地")
    private String projectAddress;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;


    /** 办事处 */
    @Excel(name = "办事处")
    private String officeAddress;

    /** 客户id */
    private Long customerId;

    /** 业务员ID */
    private Long staffId;

    /** 业务员 */
    @Excel(name = "业务员")
    private String officeStaffName;

    /** 选型技术人员 */
    private Long technicalStaffId;

    @Excel(name = "选型技术人员")
    private String technicalStaffName;


    @Excel(name = "合计数量")
    private Long allCount;

    //@Excel(name = "自制报价单价格")
    private double quotationPrice;

    //@Excel(name = "外购单价格")
    private double outsourcingPrice;

    //@Excel(name = "配件价格")
    private double partsPrice;

    @Excel(name = "合计价格")
    private Double sumPrice;

    @Excel(name = "报价日期")
    private Date createTime;

    /** 是否签约 */
    @Excel(name = "是否签约", readConverterExp = "0=否,1=是")
    private Long isSing;

    /** 省市区 */
    private String province;

    private String city;

    private String area;

    /** 整机数量 */
    private long wholeCount;

    /** 外购数量 */
    private long outsourcingCount;

    /** 外购数量 */
    private long partsCount;

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setQuotationPrice(double quotationPrice) {
        this.quotationPrice = quotationPrice;
    }

    public void setOutsourcingPrice(double outsourcingPrice) {
        this.outsourcingPrice = outsourcingPrice;
    }

    public void setPartsPrice(double partsPrice) {
        this.partsPrice = partsPrice;
    }

    public long getWholeCount() {
        return wholeCount;
    }

    public void setWholeCount(long wholeCount) {
        this.wholeCount = wholeCount;
    }

    public long getOutsourcingCount() {
        return outsourcingCount;
    }

    public void setOutsourcingCount(long outsourcingCount) {
        this.outsourcingCount = outsourcingCount;
    }

    public long getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(long partsCount) {
        this.partsCount = partsCount;
    }

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

    public Long getAllCount() {
        return this.allCount = wholeCount+outsourcingCount+partsCount;
    }

    public void setAllCount(Long allCount) {
        this.allCount = wholeCount+outsourcingCount+partsCount;
    }

    public Double getSumPrice() {
        return  this.sumPrice = StringUtils.doubleFormat(quotationPrice+outsourcingPrice+partsPrice);
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = StringUtils.doubleFormat(quotationPrice+outsourcingPrice+partsPrice);
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

    public String getTechnicalStaffName() {
        return technicalStaffName;
    }

    public void setTechnicalStaffName(String technicalStaffName) {
        this.technicalStaffName = technicalStaffName;
    }


    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getIsSing() {
        return isSing;
    }

    public void setIsSing(Long isSing) {
        this.isSing = isSing;
    }

    public String getProvince() {
        if (province != null){
            return province;
        }else{
            return "";
        }
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        if (city != null){
            return city;
        }else{
            return "";
        }
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        if (area != null){
            return area;
        }else{
            return "";
        }
    }

    public void setArea(String area) {
        this.area = area;
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
