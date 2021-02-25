package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 生产参数对象 busi_product_parameter
 *
 * @author ruoyi
 * @date 2021-01-10
 */
public class BusiProductParameter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long parameterId;

    /** 物料编号 */
    @Excel(name = "物料编号")
    private String itemNumber;

    /** 材质 */
    @Excel(name = "材质")
    private String material;

    /** 材质形式 */
    @Excel(name = "材质形式")
    private String materialForm;

    /** 重量/kg */
    @Excel(name = "重量/kg")
    private Float weight;

    /** 机加工工时/h */
    @Excel(name = "机加工工时/h")
    private Float time;

    /** 是否为过流部件 */
    @Excel(name = "是否为过流部件" ,readConverterExp = "0=否,1=是")
    private Long isCurrent;


    @Excel(name = "型号名称" )
    private String modelName;

    /** 模型ID */
    private Long modelId;


    private Long  textureId;

/*    */


    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setParameterId(Long parameterId)
    {
        this.parameterId = parameterId;
    }

    public Long getParameterId()
    {
        return parameterId;
    }
    public void setItemNumber(String itemNumber)
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber()
    {
        return itemNumber;
    }
    public void setMaterial(String material)
    {
        this.material = material;
    }

    public String getMaterial()
    {
        return material;
    }
    public void setMaterialForm(String materialForm)
    {
        this.materialForm = materialForm;
    }

    public String getMaterialForm()
    {
        return materialForm;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public void setIsCurrent(Long isCurrent)
    {
        this.isCurrent = isCurrent;
    }

    public Long getIsCurrent()
    {
        return isCurrent;
    }
    public void setModelId(Long modelId)
    {
        this.modelId = modelId;
    }

    public Long getModelId()
    {
        return modelId;
    }

    public Long getTextureId() {
        return textureId;
    }

    public void setTextureId(Long textureId) {
        this.textureId = textureId;
    }

   /* public Double getLowMaterialCost() {
        return lowMaterialCost;
    }

    public void setLowMaterialCost(Double lowMaterialCost) {
        this.lowMaterialCost = lowMaterialCost;
    }*/

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("parameterId", getParameterId())
            .append("itemNumber", getItemNumber())
            .append("material", getMaterial())
            .append("materialForm", getMaterialForm())
            .append("weight", getWeight())
            .append("time", getTime())
            .append("isCurrent", getIsCurrent())
            .append("modelId", getModelId())
            .toString();
    }
}
