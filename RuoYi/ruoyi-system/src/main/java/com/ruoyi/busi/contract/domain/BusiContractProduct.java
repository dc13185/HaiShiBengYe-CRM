package com.ruoyi.busi.contract.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 合同产品组成对象 busi_contract_product
 *
 * @author ruoyi
 * @date 2021-02-03
 */
public class BusiContractProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long product;

    /** 产品组成 */
    @Excel(name = "产品组成")
    private String productName;

    /** 产品价格 */
    @Excel(name = "产品价格")
    private Double productPrice;

    /** 产品数量 */
    @Excel(name = "产品数量")
    private Long productNumber;

    /** 合同id */
  //  @Excel(name = "合同id")
    private Long contractId;




    public void setProduct(Long product)
    {
        this.product = product;
    }

    public Long getProduct()
    {
        return product;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductName()
    {
        return productName;
    }
    public void setProductPrice(Double productPrice)
    {
        this.productPrice = productPrice;
    }

    public Double getProductPrice()
    {
        return productPrice;
    }
    public void setProductNumber(Long productNumber)
    {
        this.productNumber = productNumber;
    }

    public Long getProductNumber()
    {
        return productNumber;
    }
    public void setContractId(Long contractId)
    {
        this.contractId = contractId;
    }

    public Long getContractId()
    {
        return contractId;
    }




    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("产品名称:"+getProductName());
        stringBuffer.append(" 产品价格:"+getProductPrice());
        stringBuffer.append(" 产品数量"+getProductNumber()+"\n");
        return stringBuffer.toString();
    }
}
