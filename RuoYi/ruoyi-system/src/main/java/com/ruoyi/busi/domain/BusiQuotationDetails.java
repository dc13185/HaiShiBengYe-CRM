package com.ruoyi.busi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报价明细对象 busi_quotation_details
 *
 * @author ruoyi
 * @date 2021-01-14
 */
public class BusiQuotationDetails extends BaseEntity
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

    /** 产品系列 */
    private Long productLineId;

    /** 产品规格型号 */
    private Long modelId;



    /** 材料 */
    private Long materialId;


    private String materialSupplierId;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    /** 冲洗方案 */
    @Excel(name = "冲洗方案")
    private String rinseSolutionId;

    /** 其他费用 */
    @Excel(name = "其他费用")
    private Double otherExpenses;

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

    /** 电机型号 */
    private Long motorId;

    /** 其他电机 */
    @Excel(name = "其他电机")
    private String otherMotor;

    /** 其他电机价格 */
    @Excel(name = "其他电机价格")
    private Double otherMotorPrice;

    /** 机封品牌 */
    private String machineSupplierId;

    /** 机封型号 */
    private Long machineId;

    /** 其他机封 */
    @Excel(name = "其他机封")
    private String otherMachine;

    /** 其他机封价格 */
    @Excel(name = "其他机封价格")
    private Double otherMachinePrice;

    /** 轴承品牌 */
    private String bearingSupplierId;

    /** 轴承Id */
    private Long bearingId;

    @Excel(name = "其他轴承")
    private String otherBearingSupplier;

    @Excel(name = "其他轴承价格")
    private Double otherBearingPrice;

    /** 联轴器品牌 */
    private String couplingSupplierId;

    /** 联轴器型号 */
    private Long couplingId;

    /** 其他联轴器 */
    @Excel(name = "其他联轴器")
    private String otherCoupling;

    /** 其他联轴器价格 */
    @Excel(name = "其他联轴器价格")
    private Double otherCouplingPrice;

    /** 报价类型 */
    @Excel(name = "报价类型")
    private Long quotationType;

    @Excel(name = "产品系列")
    private String productLineName;

    /** 机封品牌 */
    private String machineSupplierName;

    @Excel(name = "产品规格型号")
    private String modelName;

    @Excel(name = "电机品牌")
    private String motorSupplierName;

    @Excel(name = "电机型号")
    private String motorName;


    @Excel(name = "过流材质品牌")
    private String materialSupplierName;

    @Excel(name = "过流材质")
    private String materialName;

    @Excel(name = "机封型号")
    private String machineModel;

    @Excel(name = "联轴器品牌")
    private String couplingSupplierName;

    @Excel(name = "联轴器型号")
    private String couplingName;

    @Excel(name = "轴承品牌")
    private String bearingSupplierName;

    @Excel(name = "轴承型号")
    private String bearingName;

    /** 调整系数 */
    private Double coefficient;

    @Excel(name = "基准单价")
    private Double detailsPrice;


    @Excel(name = "泵头成本")
    private Double pumpHeadCost;

    @Excel(name = "电机成本")
    private Double motorCost;

    @Excel(name = "机封以及系统成本")
    private Double sealCost;

    @Excel(name = "成本")
    private Double allCost;


    public Double getAllCost() {
        return allCost;
    }

    public void setAllCost(Double allCost) {
        this.allCost = allCost;
    }



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

    public Double getSealCost() {
        return sealCost;
    }

    public void setSealCost(Double sealCost) {
        this.sealCost = sealCost;
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
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
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

    public Double getOtherExpenses() {
        return otherExpenses;
    }

    public void setOtherExpenses(Double otherExpenses) {
        this.otherExpenses = otherExpenses;
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
    public void setMachineId(Long machineId)
    {
        this.machineId = machineId;
    }

    public Long getMachineId()
    {
        return machineId;
    }
    public void setOtherMachine(String otherMachine)
    {
        this.otherMachine = otherMachine;
    }

    public String getOtherMachine()
    {
        return otherMachine;
    }
    public void setCouplingId(Long couplingId)
    {
        this.couplingId = couplingId;
    }

    public Long getCouplingId()
    {
        return couplingId;
    }
    public void setOtherCoupling(String otherCoupling)
    {
        this.otherCoupling = otherCoupling;
    }

    public String getMaterialSupplierName() {
        return materialSupplierName;
    }

    public void setMaterialSupplierName(String materialSupplierName) {
        this.materialSupplierName = materialSupplierName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getOtherCoupling()
    {
        return otherCoupling;
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

    public Double getDetailsPrice() {
        return detailsPrice;
    }

    public void setDetailsPrice(Double detailsPrice) {
        this.detailsPrice = detailsPrice;
    }

    public String getMaterialSupplierId() {
        return materialSupplierId;
    }

    public void setMaterialSupplierId(String materialSupplierId) {
        this.materialSupplierId = materialSupplierId;
    }


    public Double getOtherMotorPrice() {
        return otherMotorPrice;
    }

    public void setOtherMotorPrice(Double otherMotorPrice) {
        this.otherMotorPrice = otherMotorPrice;
    }

    public Double getOtherMachinePrice() {
        return otherMachinePrice;
    }

    public void setOtherMachinePrice(Double otherMachinePrice) {
        this.otherMachinePrice = otherMachinePrice;
    }

    public Double getOtherCouplingPrice() {
        return otherCouplingPrice;
    }

    public void setOtherCouplingPrice(Double otherCouplingPrice) {
        this.otherCouplingPrice = otherCouplingPrice;
    }

    public String getMachineSupplierId() {
        return machineSupplierId;
    }

    public void setMachineSupplierId(String machineSupplierId) {
        this.machineSupplierId = machineSupplierId;
    }

    public String getCouplingSupplierId() {
        return couplingSupplierId;
    }

    public void setCouplingSupplierId(String couplingSupplierId) {
        this.couplingSupplierId = couplingSupplierId;
    }

    public String getMotorSupplierId() {
        return motorSupplierId;
    }

    public void setMotorSupplierId(String motorSupplierId) {
        this.motorSupplierId = motorSupplierId;
    }

    public String getBearingSupplierId() {
        return bearingSupplierId;
    }

    public void setBearingSupplierId(String bearingSupplierId) {
        this.bearingSupplierId = bearingSupplierId;
    }

    public Long getBearingId() {
        return bearingId;
    }

    public void setBearingId(Long bearingId) {
        this.bearingId = bearingId;
    }

    public String getOtherBearingSupplier() {
        return otherBearingSupplier;
    }

    public void setOtherBearingSupplier(String otherBearingSupplier) {
        this.otherBearingSupplier = otherBearingSupplier;
    }

    public Double getOtherBearingPrice() {
        return otherBearingPrice;
    }

    public void setOtherBearingPrice(Double otherBearingPrice) {
        this.otherBearingPrice = otherBearingPrice;
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

    public String getMotorSupplierName() {
        return motorSupplierName;
    }

    public void setMotorSupplierName(String motorSupplierName) {
        this.motorSupplierName = motorSupplierName;
    }

    public String getMotorName() {
        return motorName;
    }

    public void setMotorName(String motorName) {
        this.motorName = motorName;
    }

    public String getMachineSupplierName() {
        return machineSupplierName;
    }

    public void setMachineSupplierName(String machineSupplierName) {
        this.machineSupplierName = machineSupplierName;
    }

    public String getMachineModel() {
        return machineModel;
    }

    public void setMachineModel(String machineModel) {
        this.machineModel = machineModel;
    }

    public String getCouplingSupplierName() {
        return couplingSupplierName;
    }

    public void setCouplingSupplierName(String couplingSupplierName) {
        this.couplingSupplierName = couplingSupplierName;
    }

    public String getCouplingName() {
        return couplingName;
    }

    public void setCouplingName(String couplingName) {
        this.couplingName = couplingName;
    }

    public String getBearingSupplierName() {
        return bearingSupplierName;
    }

    public void setBearingSupplierName(String bearingSupplierName) {
        this.bearingSupplierName = bearingSupplierName;
    }

    public String getBearingName() {
        return bearingName;
    }

    public void setBearingName(String bearingName) {
        this.bearingName = bearingName;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("detailsId", getDetailsId())
            .append("quotationId", getQuotationId())
            .append("equipmentNum", getEquipmentNum())
            .append("productLineId", getProductLineId())
            .append("modelId", getModelId())
            .append("materialId", getMaterialId())
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
            .append("machineSupplierId", getMachineSupplierId())
            .append("machineId", getMachineId())
            .append("otherMachine", getOtherMachine())
            .append("otherMachinePrice", getOtherMachinePrice())
            .append("couplingSupplierId", getCouplingSupplierId())
            .append("couplingId", getCouplingId())
            .append("otherCoupling", getOtherCoupling())
            .append("otherCouplingPrice", getOtherCouplingPrice())
            .append("quotationType", getQuotationType())
            .toString();
    }
}
