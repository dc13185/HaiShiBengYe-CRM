package com.ruoyi.busi.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 办事处及人员对象 office_staff
 *
 * @author ruoyi
 * @date 2021-01-06
 */
public class OfficeStaff extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private Long officeStaffId;

    /** 办事处 */
    @Excel(name = "办事处")
    private String officeAddress;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private String officeStaffName;

    /** 职位 */
    @Excel(name = "职位")
    private String position;

    /** 出生年月 */
    @Excel(name = "出生年月", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birth;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private String school;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 居住地 */
    @Excel(name = "居住地")
    private String residence;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String information;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String mail;

    @Excel(name = "学历")
    private Long education;


    public void setOfficeStaffId(Long officeStaffId)
    {
        this.officeStaffId = officeStaffId;
    }

    public Long getOfficeStaffId()
    {
        return officeStaffId;
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
    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getPosition()
    {
        return position;
    }
    public void setBirth(Date birth)
    {
        this.birth = birth;
    }

    public Date getBirth()
    {
        return birth;
    }
    public void setSchool(String school)
    {
        this.school = school;
    }

    public String getSchool()
    {
        return school;
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
    public void setInformation(String information)
    {
        this.information = information;
    }

    public String getInformation()
    {
        return information;
    }
    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getMail()
    {
        return mail;
    }


    public Long getEducation() {
        return education;
    }

    public void setEducation(Long education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("officeStaffId", getOfficeStaffId())
            .append("officeAddress", getOfficeAddress())
            .append("officeStaffName", getOfficeStaffName())
            .append("position", getPosition())
            .append("birth", getBirth())
            .append("school", getSchool())
            .append("major", getMajor())
            .append("residence", getResidence())
            .append("information", getInformation())
            .append("mail", getMail())
            .toString();
    }
}
