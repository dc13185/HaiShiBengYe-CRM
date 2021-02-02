package com.ruoyi.busi.parts.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.busi.parts.domain.BusiPartsDetails;

/**
 * 配件报价Mapper接口
 *
 * @author ruoyi
 * @date 2021-01-31
 */
public interface BusiPartsDetailsMapper
{
    /**
     * 查询配件报价
     *
     * @param detailsId 配件报价ID
     * @return 配件报价
     */
    public BusiPartsDetails selectBusiPartsDetailsById(Long detailsId);


    public BusiPartsDetails selectBusiPartsDetailsByQuotationId(Long quotationId);


    /**
     * 查询配件报价列表
     *
     * @param busiPartsDetails 配件报价
     * @return 配件报价集合
     */
    public List<BusiPartsDetails> selectBusiPartsDetailsList(BusiPartsDetails busiPartsDetails);

    /**
     * 新增配件报价
     *
     * @param busiPartsDetails 配件报价
     * @return 结果
     */
    public int insertBusiPartsDetails(BusiPartsDetails busiPartsDetails);

    /**
     * 修改配件报价
     *
     * @param busiPartsDetails 配件报价
     * @return 结果
     */
    public int updateBusiPartsDetails(BusiPartsDetails busiPartsDetails);

    /**
     * 删除配件报价
     *
     * @param detailsId 配件报价ID
     * @return 结果
     */
    public int deleteBusiPartsDetailsById(Long detailsId);

    /**
     * 批量删除配件报价
     *
     * @param detailsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiPartsDetailsByIds(String[] detailsIds);


    public Map selectPartsPriceDetailsByQuotationNo(String contractNo);
}
