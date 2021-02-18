package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户管理对象 busi_customer
 *
 * @author ruoyi
 * @date 2021-01-06
 */
public class BusiCustomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long customerId;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String customerName;

    /** 客户性质 */
    @Excel(name = "客户性质")
    private String customerNature;

    /** 所在行业 */
    @Excel(name = "所在行业")
    private String customerIndustry;

    @Excel(name = "所在行业")
    private String customerAddress;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系人职位 */
    @Excel(name = "联系人职位")
    private String contactTitle;

    /** 联系人地址 */
    @Excel(name = "联系人地址")
    private String contactAddress;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contactPhone;

    @Excel(name = "合同金额")
    private Double allContractPrice;

    public void setCustomerId(Long customerId)
    {
        this.customerId = customerId;
    }

    public Long getCustomerId()
    {
        return customerId;
    }
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerName()
    {
        return customerName;
    }
    public void setCustomerNature(String customerNature)
    {
        this.customerNature = customerNature;
    }

    public String getCustomerNature()
    {
        return customerNature;
    }
    public void setCustomerIndustry(String customerIndustry)
    {
        this.customerIndustry = customerIndustry;
    }

    public String getCustomerIndustry()
    {
        return customerIndustry;
    }
    public void setContacts(String contacts)
    {
        this.contacts = contacts;
    }

    public String getContacts()
    {
        return contacts;
    }
    public void setContactTitle(String contactTitle)
    {
        this.contactTitle = contactTitle;
    }

    public String getContactTitle()
    {
        return contactTitle;
    }
    public void setContactAddress(String contactAddress)
    {
        this.contactAddress = contactAddress;
    }

    public String getContactAddress()
    {
        return contactAddress;
    }
    public void setContactPhone(String contactPhone)
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone()
    {
        return contactPhone;
    }


    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Double getAllContractPrice() {
        return allContractPrice;
    }

    public void setAllContractPrice(Double allContractPrice) {
        this.allContractPrice = allContractPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("customerId", getCustomerId())
            .append("customerName", getCustomerName())
            .append("customerNature", getCustomerNature())
            .append("customerIndustry", getCustomerIndustry())
            .append("contacts", getContacts())
            .append("contactTitle", getContactTitle())
            .append("contactAddress", getContactAddress())
            .append("contactPhone", getContactPhone())
            .toString();
    }
}
