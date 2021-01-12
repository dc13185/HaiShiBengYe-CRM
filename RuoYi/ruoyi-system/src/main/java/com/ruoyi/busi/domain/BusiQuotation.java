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
    @Excel(name = "客户id")
    private Long customerId;

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
