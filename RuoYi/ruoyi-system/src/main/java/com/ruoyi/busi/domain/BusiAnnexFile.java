package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 附件对象 busi_annex_file
 * 
 * @author ruoyi
 * @date 2020-12-29
 */
public class BusiAnnexFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 附件Id */
    private Long annexId;

    /** 后缀名 */
    @Excel(name = "后缀名")
    private String annexFileSuffix;

    /** 文件名 */
    @Excel(name = "文件名")
    private String annexFileName;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long annexFileSize;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String annexFilePath;

    public void setAnnexId(Long annexId) 
    {
        this.annexId = annexId;
    }

    public Long getAnnexId() 
    {
        return annexId;
    }
    public void setAnnexFileSuffix(String annexFileSuffix) 
    {
        this.annexFileSuffix = annexFileSuffix;
    }

    public String getAnnexFileSuffix() 
    {
        return annexFileSuffix;
    }
    public void setAnnexFileName(String annexFileName) 
    {
        this.annexFileName = annexFileName;
    }

    public String getAnnexFileName() 
    {
        return annexFileName;
    }
    public void setAnnexFileSize(Long annexFileSize) 
    {
        this.annexFileSize = annexFileSize;
    }

    public Long getAnnexFileSize() 
    {
        return annexFileSize;
    }
    public void setAnnexFilePath(String annexFilePath) 
    {
        this.annexFilePath = annexFilePath;
    }

    public String getAnnexFilePath() 
    {
        return annexFilePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("annexId", getAnnexId())
            .append("annexFileSuffix", getAnnexFileSuffix())
            .append("annexFileName", getAnnexFileName())
            .append("annexFileSize", getAnnexFileSize())
            .append("annexFilePath", getAnnexFilePath())
            .append("createTime", getCreateTime())
            .toString();
    }
}
