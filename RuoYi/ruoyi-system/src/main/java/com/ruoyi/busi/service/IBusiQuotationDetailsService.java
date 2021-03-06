package com.ruoyi.busi.service;

import java.util.List;
import com.ruoyi.busi.domain.BusiQuotationDetails;

/**
 * 报价明细Service接口
 * 
 * @author ruoyi
 * @date 2021-01-14
 */
public interface IBusiQuotationDetailsService 
{
    /**
     * 查询报价明细
     * 
     * @param detailsId 报价明细ID
     * @return 报价明细
     */
    public BusiQuotationDetails selectBusiQuotationDetailsById(Long detailsId);

    /**
     * 查询报价明细列表
     * 
     * @param busiQuotationDetails 报价明细
     * @return 报价明细集合
     */
    public List<BusiQuotationDetails> selectBusiQuotationDetailsList(BusiQuotationDetails busiQuotationDetails);

    /**
     * 新增报价明细
     * 
     * @param busiQuotationDetails 报价明细
     * @return 结果
     */
    public int insertBusiQuotationDetails(BusiQuotationDetails busiQuotationDetails);

    /**
     * 修改报价明细
     * 
     * @param busiQuotationDetails 报价明细
     * @return 结果
     */
    public int updateBusiQuotationDetails(BusiQuotationDetails busiQuotationDetails);

    /**
     * 批量删除报价明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiQuotationDetailsByIds(String ids);

    /**
     * 删除报价明细信息
     * 
     * @param detailsId 报价明细ID
     * @return 结果
     */
    public int deleteBusiQuotationDetailsById(Long detailsId);
}
