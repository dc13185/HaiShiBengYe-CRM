package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 材质管理对象 busi_texture
 *
 * @author ruoyi
 * @date 2021-01-21
 */
public class BusiTexture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long textureId;

    /** 材质 */
    @Excel(name = "材质")
    private String textureName;

    /** 材质形式 */
    @Excel(name = "材质形式")
    private String textureType;

    /** 与304质量比 */
    @Excel(name = "与304质量比")
    private Float massRatio;

    public void setTextureId(Long textureId)
    {
        this.textureId = textureId;
    }

    public Long getTextureId()
    {
        return textureId;
    }
    public void setTextureName(String textureName)
    {
        this.textureName = textureName;
    }

    public String getTextureName()
    {
        return textureName;
    }
    public void setTextureType(String textureType)
    {
        this.textureType = textureType;
    }

    public String getTextureType()
    {
        return textureType;
    }

    public Float getMassRatio() {
        return massRatio;
    }

    public void setMassRatio(Float massRatio) {
        this.massRatio = massRatio;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("textureId", getTextureId())
            .append("textureName", getTextureName())
            .append("textureType", getTextureType())
            .append("massRatio", getMassRatio())
            .toString();
    }
}
