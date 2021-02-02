package com.ruoyi.busi.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.busi.domain.BusiPriceDetails;

/**
 * 报价单报价明细Mapper接口
 *
 * @author ruoyi
 * @date 2021-01-28
 */
public interface BusiPriceDetailsMapper
{
    /**
     * 查询报价单报价明细
     *
     * @param priceDetailsId 报价单报价明细ID
     * @return 报价单报价明细
     */
    public BusiPriceDetails selectBusiPriceDetailsById(Long priceDetailsId);

    /**
     * 查询报价单报价明细列表
     *
     * @param busiPriceDetails 报价单报价明细
     * @return 报价单报价明细集合
     */
    public List<BusiPriceDetails> selectBusiPriceDetailsList(BusiPriceDetails busiPriceDetails);

    /**
     * 新增报价单报价明细
     *
     * @param busiPriceDetails 报价单报价明细
     * @return 结果
     */
    public int insertBusiPriceDetails(BusiPriceDetails busiPriceDetails);

    /**
     * 修改报价单报价明细
     *
     * @param busiPriceDetails 报价单报价明细
     * @return 结果
     */
    public int updateBusiPriceDetails(BusiPriceDetails busiPriceDetails);

    /**
     * 删除报价单报价明细
     *
     * @param priceDetailsId 报价单报价明细ID
     * @return 结果
     */
    public int deleteBusiPriceDetailsById(Long priceDetailsId);

    /**
     * 批量删除报价单报价明细
     *
     * @param priceDetailsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiPriceDetailsByIds(String[] priceDetailsIds);

    public BusiPriceDetails selectBusiPriceDetailsByQuotationNo(String contractNo);

    public Map<String, Double> selectoutsourcingPriceDetailsByQuotationNo(Long quotationId);


}
