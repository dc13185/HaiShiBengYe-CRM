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
    @Excel(name = "流量")
    private Float flow;

    /** 扬程 */
    @Excel(name = "扬程")
    private Float lift;

    /** 温度 */
    @Excel(name = "温度")
    private Float temperature;

    /** 入口压力 */
    @Excel(name = "入口压力")
    private Float pressure;

    /** 汽蚀余量 */
    @Excel(name = "汽蚀余量")
    private Float npsh;

    /** 产品系列Id */
    private Long productLineId;

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

    public Float getFlow() {
        return flow;
    }

    public void setFlow(Float flow) {
        this.flow = flow;
    }

    public Float getLift() {
        return lift;
    }

    public void setLift(Float lift) {
        this.lift = lift;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public Float getNpsh() {
        return npsh;
    }

    public void setNpsh(Float npsh) {
        this.npsh = npsh;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }

    public Long getProductLineId()
    {
        return productLineId;
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
