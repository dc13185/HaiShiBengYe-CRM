package com.ruoyi.busi.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 选型技术人员管理对象 busi_technicist
 *
 * @author ruoyi
 * @date 2021-01-20
 */
public class BusiTechnicist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long technicistId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String technicistName;

    /** 职位 */
    @Excel(name = "职位")
    private String position;

    @Excel(name = "联系方式")
    private String contactDetails;

    /** 出生年月 */
    @Excel(name = "出生年月", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthDate;

    /** 学历 */
    @Excel(name = "学历" ,dictType="education_status")
    private Long education;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private String university;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 居住地 */
    @Excel(name = "居住地")
    private String residence;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;


    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setTechnicistId(Long technicistId)
    {
        this.technicistId = technicistId;
    }

    public Long getTechnicistId()
    {
        return technicistId;
    }
    public void setTechnicistName(String technicistName)
    {
        this.technicistName = technicistName;
    }

    public String getTechnicistName()
    {
        return technicistName;
    }
    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getPosition()
    {
        return position;
    }
    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }
    public void setEducation(Long education)
    {
        this.education = education;
    }

    public Long getEducation()
    {
        return education;
    }
    public void setUniversity(String university)
    {
        this.university = university;
    }

    public String getUniversity()
    {
        return university;
    }
    public void setMajor(String major)
    {
        this.major = major;
    }

    public String getMajor()
    {
        return major;
    }
    public void setResidence(String residence)
    {
        this.residence = residence;
    }

    public String getResidence()
    {
        return residence;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("technicistId", getTechnicistId())
            .append("technicistName", getTechnicistName())
            .append("position", getPosition())
            .append("birthDate", getBirthDate())
            .append("education", getEducation())
            .append("university", getUniversity())
            .append("major", getMajor())
            .append("residence", getResidence())
            .append("email", getEmail())
            .toString();
    }
}
