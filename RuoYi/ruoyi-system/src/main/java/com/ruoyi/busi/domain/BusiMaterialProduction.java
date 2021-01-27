package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;


/**
 * 材料产品对象 busi_material_production
 *
 * @author ruoyi
 * @date 2021-01-01
 */
public class BusiMaterialProduction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long materialId;

    /** 材质 */
    @Excel(name = "材质")
    private String materialName;

    /** 材质等级 */
    @Excel(name = "材质等级")
    private Long materialLevel;

    /** 形式 */
    @Excel(name = "形式")
    private String form;

    /** 价格 */
    @Excel(name = "价格")
    private Float price;

    /** 材质Id */
    private Long textureId;

    private String supplierId;

    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialName()
    {
        return materialName;
    }
    public void setMaterialLevel(Long materialLevel)
    {
        this.materialLevel = materialLevel;
    }

    public Long getMaterialLevel()
    {
        return materialLevel;
    }
    public void setForm(String form)
    {
        this.form = form;
    }

    public String getForm()
    {
        return form;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Long getTextureId() {
        return textureId;
    }

    public void setTextureId(Long textureId) {
        this.textureId = textureId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("materialId", getMaterialId())
                .append("materialName", getMaterialName())
                .append("materialLevel", getMaterialLevel())
                .append("form", getForm())
                .append("price", getPrice())
                .toString();
    }
}
