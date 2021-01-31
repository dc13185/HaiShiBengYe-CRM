package com.ruoyi.busi.qutsourcing.service;

import java.util.List;
import com.ruoyi.busi.qutsourcing.domain.BusiOutsourcingDetails;

/**
 * 外购报价明细Service接口
 * 
 * @author ruoyi
 * @date 2021-01-30
 */
public interface IBusiOutsourcingDetailsService 
{
    /**
     * 查询外购报价明细
     * 
     * @param detailsId 外购报价明细ID
     * @return 外购报价明细
     */
    public BusiOutsourcingDetails selectBusiOutsourcingDetailsById(Long detailsId);

    /**
     * 查询外购报价明细列表
     * 
     * @param busiOutsourcingDetails 外购报价明细
     * @return 外购报价明细集合
     */
    public List<BusiOutsourcingDetails> selectBusiOutsourcingDetailsList(BusiOutsourcingDetails busiOutsourcingDetails);

    /**
     * 新增外购报价明细
     * 
     * @param busiOutsourcingDetails 外购报价明细
     * @return 结果
     */
    public int insertBusiOutsourcingDetails(BusiOutsourcingDetails busiOutsourcingDetails);

    /**
     * 修改外购报价明细
     * 
     * @param busiOutsourcingDetails 外购报价明细
     * @return 结果
     */
    public int updateBusiOutsourcingDetails(BusiOutsourcingDetails busiOutsourcingDetails);

    /**
     * 批量删除外购报价明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiOutsourcingDetailsByIds(String ids);

    /**
     * 删除外购报价明细信息
     * 
     * @param detailsId 外购报价明细ID
     * @return 结果
     */
    public int deleteBusiOutsourcingDetailsById(Long detailsId);
}
