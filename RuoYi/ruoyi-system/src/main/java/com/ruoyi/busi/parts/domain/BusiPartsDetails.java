package com.ruoyi.busi.parts.domain;

import com.ruoyi.busi.cost.domain.BusiPartsCost;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 配件报价对象 busi_parts_details
 *
 * @author ruoyi
 * @date 2021-01-31
 */
public class BusiPartsDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long detailsId;

    /** 报价单ID */
    @Excel(name = "报价单ID")
    private Long quotationId;

    /** 设备位号 */
    private String equipmentNum;

    /** 产品系列 */
    private Long productLineId;

    @Excel(name = "产品系列")
    private String productLineName;

    /** 泵型号 */
    private Long modelId;

    @Excel(name = "泵型号")
    private String modelName;

    /** 配件名称 */
    private Long parameterId;

    @Excel(name = "配件名称")
    private String parameterName;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    private Double detailsPrice;

    private BusiPartsCost partsCost;

    /** 调整系数 */
    private Double coefficient;

    /** 材料ID */
    private Long materialId;
    /** 供应商ID */
    private String materialSupplierId;

    private String materialSupplierName;

    @Excel(name = "过流材质")
    private String materialName;


    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialSupplierId() {
        return materialSupplierId;
    }

    public void setMaterialSupplierId(String materialSupplierId) {
        this.materialSupplierId = materialSupplierId;
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

    public BusiPartsCost getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(BusiPartsCost partsCost) {
        this.partsCost = partsCost;
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
    public void setParameterId(Long parameterId)
    {
        this.parameterId = parameterId;
    }

    public Long getParameterId()
    {
        return parameterId;
    }
    public void setNumber(Long number)
    {
        this.number = number;
    }

    public Long getNumber()
    {
        return number;
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

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
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
            .append("productLineId", getProductLineId())
            .append("modelId", getModelId())
            .append("parameterId", getParameterId())
            .append("number", getNumber())
            .toString();
    }
}
