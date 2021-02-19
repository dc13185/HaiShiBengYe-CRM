package com.ruoyi.busi.qutsourcing.domain;

import com.ruoyi.busi.cost.domain.BusiOutsourcingCost;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 外购报价明细对象 busi_outsourcing_details
 *
 * @author ruoyi
 * @date 2021-01-30
 */
public class BusiOutsourcingDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long detailsId;

    /** 报价单ID */
    @Excel(name = "报价单ID")
    private Long quotationId;

    /** 设备位号 */
    @Excel(name = "设备位号")
    private String equipmentNum;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 产品系列 */
    private Long productLineId;

    @Excel(name = "产品系列")
    private String productLineName;

    /** 产品规格型号 */
    private Long modelId;

    @Excel(name = "产品规格型号")
    private String modelName;

    /** 过流器品牌 */
    private String productSupplierId;

    @Excel(name = "产品供应商")
    private String productSupplierName;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    /** 冲洗方案 */
    @Excel(name = "冲洗方案")
    private String rinseSolutionId;

    /** 其他费用 */
    @Excel(name = "其他费用")
    private Long otherExpenses;

    /** 其他费用说明 */
    @Excel(name = "其他费用说明")
    private String otherExpensesDescription;

    /** 额定流量(m3/h) */
    @Excel(name = "额定流量(m3/h)")
    private Long ratedFlow;

    /** 扬程(m) */
    @Excel(name = "扬程(m)")
    private Long lift;

    /** 工况温度(℃) */
    @Excel(name = "工况温度(℃)")
    private Long operatingTemperature;

    /** 流体密度(Kg/m³) */
    @Excel(name = "流体密度(Kg/m³)")
    private Long fluidDensity;

    /** 入口压力(Mpa) */
    @Excel(name = "入口压力(Mpa)")
    private Long inletPressure;

    /** 汽蚀余量(m) */
    @Excel(name = "汽蚀余量(m)")
    private Long npsh;

    /** 电机品牌 */
    private String motorSupplierId;

    @Excel(name = "电机品牌")
    private String motorSupplierName;

    /** 电机型号 */
    private Long motorId;

    @Excel(name = "电机型号")
    private Long motorName;

    /** 其他电机 */
    @Excel(name = "其他电机")
    private String otherMotor;

    /** 其他电机价格 */
    @Excel(name = "其他电机价格")
    private Double otherMotorPrice;

    /** 报价类型 */
    @Excel(name = "报价类型")
    private Long quotationType;

    /** 单价系数 */
    @Excel(name = "单价系数")
    private Double coefficient;

    /** 单条报价单明细总价 */
    @Excel(name = "单条报价单明细总价")
    private Double detailsPrice;

    @Excel(name = "泵头成本")
    private Double pumpHeadCost;

    @Excel(name = "电机成本")
    private Double motorCost;

    @Excel(name = "成本")
    private Double allCost;



    public Double getPumpHeadCost() {
        return pumpHeadCost;
    }

    public void setPumpHeadCost(Double pumpHeadCost) {
        this.pumpHeadCost = pumpHeadCost;
    }

    public Double getMotorCost() {
        return motorCost;
    }

    public void setMotorCost(Double motorCost) {
        this.motorCost = motorCost;
    }

    public Double getAllCost() {
        return allCost;
    }

    public void setAllCost(Double allCost) {
        this.allCost = allCost;
    }


    public void setDetailsId(Long detailsId)
    {
        this.detailsId = detailsId;
    }

    public Long getDetailsId()
    {
        return detailsId;
    }
    public void setQuotationId(Long quotationId)
    {
        this.quotationId = quotationId;
    }

    public Long getQuotationId()
    {
        return quotationId;
    }
    public void setEquipmentNum(String equipmentNum)
    {
        this.equipmentNum = equipmentNum;
    }

    public String getEquipmentNum()
    {
        return equipmentNum;
    }
    public void setEquipmentName(String equipmentName)
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName()
    {
        return equipmentName;
    }
    public void setProductLineId(Long productLineId)
    {
        this.productLineId = productLineId;
    }

    public Long getProductLineId()
    {
        return productLineId;
    }
    public void setModelId(Long modelId)
    {
        this.modelId = modelId;
    }

    public Long getModelId()
    {
        return modelId;
    }
    public void setProductSupplierId(String productSupplierId)
    {
        this.productSupplierId = productSupplierId;
    }

    public String getProductSupplierId()
    {
        return productSupplierId;
    }
    public void setNumber(Long number)
    {
        this.number = number;
    }

    public Long getNumber()
    {
        return number;
    }
    public void setRinseSolutionId(String rinseSolutionId)
    {
        this.rinseSolutionId = rinseSolutionId;
    }

    public String getRinseSolutionId()
    {
        return rinseSolutionId;
    }
    public void setOtherExpenses(Long otherExpenses)
    {
        this.otherExpenses = otherExpenses;
    }

    public Long getOtherExpenses()
    {
        return otherExpenses;
    }
    public void setOtherExpensesDescription(String otherExpensesDescription)
    {
        this.otherExpensesDescription = otherExpensesDescription;
    }

    public String getOtherExpensesDescription()
    {
        return otherExpensesDescription;
    }
    public void setRatedFlow(Long ratedFlow)
    {
        this.ratedFlow = ratedFlow;
    }

    public Long getRatedFlow()
    {
        return ratedFlow;
    }
    public void setLift(Long lift)
    {
        this.lift = lift;
    }

    public Long getLift()
    {
        return lift;
    }
    public void setOperatingTemperature(Long operatingTemperature)
    {
        this.operatingTemperature = operatingTemperature;
    }

    public Long getOperatingTemperature()
    {
        return operatingTemperature;
    }
    public void setFluidDensity(Long fluidDensity)
    {
        this.fluidDensity = fluidDensity;
    }

    public Long getFluidDensity()
    {
        return fluidDensity;
    }
    public void setInletPressure(Long inletPressure)
    {
        this.inletPressure = inletPressure;
    }

    public Long getInletPressure()
    {
        return inletPressure;
    }
    public void setNpsh(Long npsh)
    {
        this.npsh = npsh;
    }

    public Long getNpsh()
    {
        return npsh;
    }
    public void setMotorSupplierId(String motorSupplierId)
    {
        this.motorSupplierId = motorSupplierId;
    }

    public String getMotorSupplierId()
    {
        return motorSupplierId;
    }
    public void setMotorId(Long motorId)
    {
        this.motorId = motorId;
    }

    public Long getMotorId()
    {
        return motorId;
    }
    public void setOtherMotor(String otherMotor)
    {
        this.otherMotor = otherMotor;
    }

    public String getOtherMotor()
    {
        return otherMotor;
    }

    public Double getOtherMotorPrice() {
        return otherMotorPrice;
    }

    public void setOtherMotorPrice(Double otherMotorPrice) {
        this.otherMotorPrice = otherMotorPrice;
    }

    public void setQuotationType(Long quotationType)
    {
        this.quotationType = quotationType;
    }

    public Long getQuotationType()
    {
        return quotationType;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public String getProductLineName() {
        return productLineName;
    }

    public void setProductLineName(String productLineName) {
        this.productLineName = productLineName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getProductSupplierName() {
        return productSupplierName;
    }

    public void setProductSupplierName(String productSupplierName) {
        this.productSupplierName = productSupplierName;
    }

    public String getMotorSupplierName() {
        return motorSupplierName;
    }

    public void setMotorSupplierName(String motorSupplierName) {
        this.motorSupplierName = motorSupplierName;
    }

    public Long getMotorName() {
        return motorName;
    }

    public void setMotorName(Long motorName) {
        this.motorName = motorName;
    }

    public Double getDetailsPrice() {
        return detailsPrice;
    }

    public void setDetailsPrice(Double detailsPrice) {
        this.detailsPrice = detailsPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("detailsId", getDetailsId())
            .append("quotationId", getQuotationId())
            .append("equipmentNum", getEquipmentNum())
            .append("equipmentName", getEquipmentName())
            .append("productLineId", getProductLineId())
            .append("modelId", getModelId())
            .append("productSupplierId", getProductSupplierId())
            .append("number", getNumber())
            .append("rinseSolutionId", getRinseSolutionId())
            .append("otherExpenses", getOtherExpenses())
            .append("otherExpensesDescription", getOtherExpensesDescription())
            .append("ratedFlow", getRatedFlow())
            .append("lift", getLift())
            .append("operatingTemperature", getOperatingTemperature())
            .append("fluidDensity", getFluidDensity())
            .append("inletPressure", getInletPressure())
            .append("npsh", getNpsh())
            .append("motorSupplierId", getMotorSupplierId())
            .append("motorId", getMotorId())
            .append("otherMotor", getOtherMotor())
            .append("otherMotorPrice", getOtherMotorPrice())
            .append("quotationType", getQuotationType())
            .append("coefficient", getCoefficient())
            .append("detailsPrice", getDetailsPrice())
            .toString();
    }
}
