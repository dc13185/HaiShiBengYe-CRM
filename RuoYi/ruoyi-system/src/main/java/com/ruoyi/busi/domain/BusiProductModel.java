package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品模型管理对象 busi_product_model
 *
 * @author ruoyi
 * @date 2021-01-06
 */
public class BusiProductModel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long modelId;

    /** 型号 */
    @Excel(name = "型号")
    private String modelName;

    /** 流量 */
    @Excel(name = "流量(m³/h)'")
    private String flow;

    /** 扬程 */
    @Excel(name = "扬程(m)")
    private String lift;

    /** 温度 */
    @Excel(name = "温度(℃)")
    private String temperature;

    /** 入口压力 */
    @Excel(name = "设计压力(Mpa)")
    private String pressure;

    /** 汽蚀余量 */
    @Excel(name = "汽蚀余量(m)")
    private String npsh;

    /** 产品系列Id */
    private Long productLineId;

    /** 是否为过流部件 */
    @Excel(name = "低值物料成本")
    private Double lowMaterialCost;

    @Excel(name = "产品系列名称")
    private String product_line_name;

    public String getProduct_line_name() {
        return product_line_name;
    }

    public void setProduct_line_name(String product_line_name) {
        this.product_line_name = product_line_name;
    }

    public void setModelId(Long modelId)
    {
        this.modelId = modelId;
    }

    public Long getModelId()
    {
        return modelId;
    }
    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public String getFlow() {
        return flow;
    }

    public BusiProductModel setFlow(String flow) {
        this.flow = flow;
        return this;
    }

    public String getLift() {
        return lift;
    }

    public BusiProductModel setLift(String lift) {
        this.lift = lift;
        return this;
    }

    public String getTemperature() {
        return temperature;
    }

    public BusiProductModel setTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }

    public String getPressure() {
        return pressure;
    }

    public BusiProductModel setPressure(String pressure) {
        this.pressure = pressure;
        return this;
    }

    public String getNpsh() {
        return npsh;
    }

    public BusiProductModel setNpsh(String npsh) {
        this.npsh = npsh;
        return this;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }

    public Long getProductLineId()
    {
        return productLineId;
    }

    public Double getLowMaterialCost() {
        return lowMaterialCost;
    }

    public void setLowMaterialCost(Double lowMaterialCost) {
        this.lowMaterialCost = lowMaterialCost;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("modelId", getModelId())
            .append("modelName", getModelName())
            .append("flow", getFlow())
            .append("lift", getLift())
            .append("temperature", getTemperature())
            .append("pressure", getPressure())
            .append("npsh", getNpsh())
            .append("productLineId", getProductLineId())
            .toString();
    }
}
