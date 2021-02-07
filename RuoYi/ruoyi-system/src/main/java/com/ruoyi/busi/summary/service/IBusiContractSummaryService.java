package com.ruoyi.busi.summary.service;

import java.util.List;
import com.ruoyi.busi.summary.domain.BusiContractSummary;

/**
 * 历史合同汇总Service接口
 * 
 * @author ruoyi
 * @date 2021-02-07
 */
public interface IBusiContractSummaryService 
{
    /**
     * 查询历史合同汇总
     * 
     * @param summaryId 历史合同汇总ID
     * @return 历史合同汇总
     */
    public BusiContractSummary selectBusiContractSummaryById(Long summaryId);

    /**
     * 查询历史合同汇总列表
     * 
     * @param busiContractSummary 历史合同汇总
     * @return 历史合同汇总集合
     */
    public List<BusiContractSummary> selectBusiContractSummaryList(BusiContractSummary busiContractSummary);

    /**
     * 新增历史合同汇总
     * 
     * @param busiContractSummary 历史合同汇总
     * @return 结果
     */
    public int insertBusiContractSummary(BusiContractSummary busiContractSummary);

    /**
     * 修改历史合同汇总
     * 
     * @param busiContractSummary 历史合同汇总
     * @return 结果
     */
    public int updateBusiContractSummary(BusiContractSummary busiContractSummary);

    /**
     * 批量删除历史合同汇总
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiContractSummaryByIds(String ids);

    /**
     * 删除历史合同汇总信息
     * 
     * @param summaryId 历史合同汇总ID
     * @return 结果
     */
    public int deleteBusiContractSummaryById(Long summaryId);
}
