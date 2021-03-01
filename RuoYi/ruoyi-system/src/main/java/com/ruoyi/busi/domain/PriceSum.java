package com.ruoyi.busi.domain;

/**
 * @author Dong.Chao
 * @Classname PriceSum
 * @Description 报价明细中 价格计算
 * @Date 2021/1/21 17:48
 * @Version V1.0
 */
public class PriceSum {

    /** 重量 */
    private Float weight;

    private Long  number;

    /** 质量比参数 */
    private Float massRatio;

    /** 材料单价 */
    private Float materialPrice;

    /** 工时 */
    private Float time;

    /** 低值物料成本 */
    private Double lowMaterialCost;


    /** 是否为过流材质 */
    private Long isCurrent;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getMassRatio() {
        return massRatio;
    }

    public void setMassRatio(Float massRatio) {
        this.massRatio = massRatio;
    }

    public Float getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(Float materialPrice) {
        this.materialPrice = materialPrice;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public Double getLowMaterialCost() {
        return lowMaterialCost;
    }

    public void setLowMaterialCost(Double lowMaterialCost) {
        this.lowMaterialCost = lowMaterialCost;
    }


    public Long getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Long isCurrent) {
        this.isCurrent = isCurrent;
    }
}
