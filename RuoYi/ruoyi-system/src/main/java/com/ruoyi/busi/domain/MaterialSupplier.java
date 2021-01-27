package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 材料供应商对象 material_supplier
 *
 * @author ruoyi
 * @date 2020-12-25
 */
public class MaterialSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商编号 */
    private String supplierId;

    /** 材料供应商名称 */
    @Excel(name = "材料供应商名称")
    private String materialName;

    /** 所在地区 */
    @Excel(name = "所在地区")
    private String materialAddress;

    /** 采购类别 */
    @Excel(name = "采购类别")
    private String purchaseCategory;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系人职务 */
    @Excel(name = "联系人职务")
    private String contactTitle;

    /** 联系人方式 */
    @Excel(name = "联系人方式")
    private String contactInformation;

    /** 联系人地址 */
    @Excel(name = "联系人地址")
    private String contactAddress;

    /** 供应商资质情况 */
    private String qualification;

    /** 供应商评级 */
    @Excel(name = "供应商评级")
    private Long supplierLevel;

    private String supplierType;

    /** 供应商简介 */
    private String profile;

    /** 相关材料 */
    private Long material;

    public void setSupplierId(String supplierId)
    {
        this.supplierId = supplierId;
    }

    public String getSupplierId()
    {
        return supplierId;
    }
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialName()
    {
        return materialName;
    }
    public void setMaterialAddress(String materialAddress)
    {
        this.materialAddress = materialAddress;
    }

    public String getMaterialAddress()
    {
        return materialAddress;
    }
    public void setPurchaseCategory(String purchaseCategory)
    {
        this.purchaseCategory = purchaseCategory;
    }

    public String getPurchaseCategory()
    {
        return purchaseCategory;
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
    public void setContactInformation(String contactInformation)
    {
        this.contactInformation = contactInformation;
    }

    public String getContactInformation()
    {
        return contactInformation;
    }
    public void setContactAddress(String contactAddress)
    {
        this.contactAddress = contactAddress;
    }

    public String getContactAddress()
    {
        return contactAddress;
    }
    public void setQualification(String qualification)
    {
        this.qualification = qualification;
    }

    public String getQualification()
    {
        return qualification;
    }
    public void setSupplierLevel(Long supplierLevel)
    {
        this.supplierLevel = supplierLevel;
    }

    public Long getSupplierLevel()
    {
        return supplierLevel;
    }
    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    public String getProfile()
    {
        return profile;
    }
    public void setMaterial(Long material)
    {
        this.material = material;
    }

    public Long getMaterial()
    {
        return material;
    }

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("supplierId", getSupplierId())
            .append("materialName", getMaterialName())
            .append("materialAddress", getMaterialAddress())
            .append("purchaseCategory", getPurchaseCategory())
            .append("contacts", getContacts())
            .append("contactTitle", getContactTitle())
            .append("contactInformation", getContactInformation())
            .append("contactAddress", getContactAddress())
            .append("qualification", getQualification())
            .append("supplierLevel", getSupplierLevel())
            .append("profile", getProfile())
            .append("material", getMaterial())
            .toString();
    }
}
