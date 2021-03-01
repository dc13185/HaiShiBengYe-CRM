package com.ruoyi.busi.domain;

import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报价单报价明细对象 busi_price_details
 *
 * @author ruoyi
 * @date 2021-02-02
 */
public class BusiPriceDetails extends BaseEntity
{
    private static final Long serialVersionUID = 1L;

    /**  */
    private Long priceDetailsId;

    //@Excel(name = "实际泵头合计成本")
    private Double actualBengtouCb;

    /** 报价金额 */
    @Excel(name = "报价金额")
    private Double contractPrice;

    /** 泵头材料成本 */
    @Excel(name = "泵头材料成本合计")
    private Double bengtouclCb;

    /** 泵头人工成本 */
    @Excel(name = "泵头人工成本合计")
    private Double bengtouRgCb;

    /** 制造费用成本 */
    @Excel(name = "制造费用成本合计")
    private Double bengtouFyCb;

    @Excel(name = "泵头成本合计")
    private Double bengtouCb;

    /** 电机成本 */
    @Excel(name = "电机成本")
    private Double motorCb;

    /** 机封及系统成本 */
    @Excel(name = "机封及系统成本")
    private Double jfCb;

    /** 轴承成本 */
    @Excel(name = "轴承成本")
    private Double zcCb;

    /** 联轴器成本 */
    @Excel(name = "联轴器成本")
    private Double zlqCb;

    /** 额外配置成本 */
    @Excel(name = "额外配置成本")
    private Double ewCb;

    @Excel(name = "外购成本合计")
    private Double wghj;


    @Excel(name = "总计成本")
    private Double sumPrice;

    /** 毛利 */
    @Excel(name = "毛利")
    private Double profit;

    /** 实际泵头成本 */
   // @Excel(name = "实际泵头成本")
    private Double actualBengtouclCb;

    /** 实际人工成本 */
    //@Excel(name = "实际人工成本")
    private Double actualBengtouRgCb;

    /** 实际制造费用成本 */
    //@Excel(name = "实际制造费用成本")
    private Double actualBengtouFyCb;


    /** 实际电机成本 */
   // @Excel(name = "实际电机成本")
    private Double actualMotorCb;

    /**  */
    private Long quotationId;

    /** 实际机封成本 */
   // @Excel(name = "实际机封成本")
    private Double actualJfCb;

    /** 实际轴承成本 */
   // @Excel(name = "实际轴承成本")
    private Double actualZcCb;

    /** 实际联轴器成本 */
   // @Excel(name = "实际联轴器成本")
    private Double actualZlqCb;

    /** 实际额外成本 */
   // @Excel(name = "实际额外成本")
    private Double actualEwCb;

    /** 实际报价金额 */
   // @Excel(name = "实际报价金额")
    private Double actualContractprice;

    /** 实际毛利 */
    //@Excel(name = "实际毛利")
    private Double actualProfit;

    //@Excel(name = "实际外购合计")
    private Double actualWghj;


    //@Excel(name = "实际成本")
    private Double actualAllSumPrice;

    public Double getWghj() {
        return wghj;
    }

    public void setWghj(Double wghj) {
        this.wghj = StringUtils.doubleFormat(motorCb + jfCb + zlqCb + ewCb);
    }

    public Double getBengtouCb() {
        return bengtouCb;
    }

    public void setBengtouCb(Double bengtouCb) {
        this.bengtouCb = bengtouclCb+bengtouRgCb+bengtouFyCb;
    }

    public void setBengtouclCb(Double bengtouclCb)
    {
        this.bengtouclCb = bengtouclCb;
    }

    public Double getBengtouclCb()
    {
        return bengtouclCb;
    }
    public void setActualBengtouclCb(Double actualBengtouclCb)
    {
        this.actualBengtouclCb = actualBengtouclCb;
    }

    public Double getActualBengtouclCb()
    {
        if (actualBengtouclCb == null){
            return 0d;
        }
        return actualBengtouclCb;
    }
    public void setBengtouRgCb(Double bengtouRgCb)
    {
        this.bengtouRgCb = bengtouRgCb;
    }

    public Double getBengtouRgCb()
    {
        return bengtouRgCb;
    }
    public void setBengtouFyCb(Double bengtouFyCb)
    {
        this.bengtouFyCb = bengtouFyCb;
    }

    public Double getBengtouFyCb()
    {
        return bengtouFyCb;
    }
    public void setActualBengtouRgCb(Double actualBengtouRgCb)
    {
        this.actualBengtouRgCb = actualBengtouRgCb;
    }

    public Double getActualBengtouRgCb()
    {
        if (actualBengtouRgCb == null){
            return 0d;
        }
        return actualBengtouRgCb;
    }
    public void setMotorCb(Double motorCb)
    {
        this.motorCb = motorCb;
    }

    public Double getMotorCb()
    {
        return motorCb;
    }
    public void setActualBengtouFyCb(Double actualBengtouFyCb)
    {
        this.actualBengtouFyCb = actualBengtouFyCb;
    }

    public Double getActualBengtouFyCb()
    {
        if (actualBengtouFyCb == null){
            return 0d;
        }
        return actualBengtouFyCb;
    }
    public void setJfCb(Double jfCb)
    {
        this.jfCb = jfCb;
    }

    public Double getJfCb()
    {
        return jfCb;
    }
    public void setZcCb(Double zcCb)
    {
        this.zcCb = zcCb;
    }

    public Double getZcCb()
    {
        return zcCb;
    }
    public void setZlqCb(Double zlqCb)
    {
        this.zlqCb = zlqCb;
    }

    public Double getZlqCb()
    {
        return zlqCb;
    }
    public void setActualMotorCb(Double actualMotorCb)
    {
        this.actualMotorCb = actualMotorCb;
    }

    public Double getActualMotorCb()
    {
        if (actualMotorCb == null){return 0d;}else {
            return actualMotorCb;
        }

    }
    public void setEwCb(Double ewCb)
    {
        this.ewCb = ewCb;
    }

    public Double getEwCb()
    {
        return ewCb;
    }
    public void setActualJfCb(Double actualJfCb)
    {
        this.actualJfCb = actualJfCb;
    }

    public Double getActualJfCb()
    { if (actualJfCb == null){return 0d;}else {
        return actualJfCb;
      }
    }
    public void setActualZcCb(Double actualZcCb)
    {
        this.actualZcCb = actualZcCb;
    }

    public Double getActualZcCb()
    {
        if (actualZcCb == null){return 0d;}else {
            return actualZcCb;
        }
    }
    public void setActualZlqCb(Double actualZlqCb)
    {
        this.actualZlqCb = actualZlqCb;
    }

    public Double getActualZlqCb()
    {
        if (actualZlqCb == null){return 0d;}else {
            return actualZlqCb;
        }
    }
    public void setActualEwCb(Double actualEwCb)
    {
        this.actualEwCb = actualEwCb;
    }

    public Double getActualEwCb()
    {
        if (actualEwCb == null){return 0d;}else {
            return actualEwCb;
        }
    }
    public void setContractPrice(Double contractPrice)
    {
        this.contractPrice = contractPrice;
    }

    public Double getContractPrice()
    {
        return contractPrice;
    }
    public void setActualContractprice(Double actualContractprice)
    {
        this.actualContractprice = actualContractprice;
    }

    public Double getActualContractprice()
    {
        if (actualContractprice == null){
            return 0d;
        }
        return actualContractprice;
    }
    public void setProfit(Double profit)
    {
        this.profit = profit;
    }

    public Double getProfit()
    {
        return profit;
    }
    public void setActualProfit(Double actualProfit)
    {
        this.actualProfit = actualProfit;
    }

    public Double getActualProfit()
    {
        if (actualProfit == null){return 0d;}else {
            return actualProfit;
        }
    }


    public Long getPriceDetailsId() {
        return priceDetailsId;
    }

    public void setPriceDetailsId(Long priceDetailsId) {
        this.priceDetailsId = priceDetailsId;
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
    }

    public void setActualBengtouCb(Double actualBengtouCb) {
        this.actualBengtouCb = actualBengtouCb;
    }

    public Double getActualBengtouCb() {
        return getActualBengtouclCb() + getActualBengtouRgCb() + getActualBengtouFyCb();
    }

    public Double getActualWghj() {
        if (actualWghj == null){return 0d;}else {
            return actualWghj;
        }
    }

    public void setActualWghj(Double actualWghj) {
        this.actualWghj = actualWghj;
    }

    public Double getActualAllSumPrice() {

        if (actualAllSumPrice == null){return 0d;}else {
            return actualAllSumPrice;
        }
    }

    public void setActualAllSumPrice(Double actualAllSumPrice) {
        this.actualAllSumPrice = actualAllSumPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("priceDetailsId", getPriceDetailsId())
            .append("bengtouclCb", getBengtouclCb())
            .append("actualBengtouclCb", getActualBengtouclCb())
            .append("bengtouRgCb", getBengtouRgCb())
            .append("bengtouFyCb", getBengtouFyCb())
            .append("actualBengtouRgCb", getActualBengtouRgCb())
            .append("motorCb", getMotorCb())
            .append("actualBengtouFyCb", getActualBengtouFyCb())
            .append("jfCb", getJfCb())
            .append("zcCb", getZcCb())
            .append("zlqCb", getZlqCb())
            .append("actualMotorCb", getActualMotorCb())
            .append("ewCb", getEwCb())
            .append("quotationId", getQuotationId())
            .append("actualJfCb", getActualJfCb())
            .append("actualZcCb", getActualZcCb())
            .append("actualZlqCb", getActualZlqCb())
            .append("actualEwCb", getActualEwCb())
            .append("contractPrice", getContractPrice())
            .append("actualContractprice", getActualContractprice())
            .append("profit", getProfit())
            .append("actualProfit", getActualProfit())
            .toString();
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }
}
