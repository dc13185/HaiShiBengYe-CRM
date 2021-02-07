package com.ruoyi.busi.summary.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.summary.mapper.BusiContractSummaryMapper;
import com.ruoyi.busi.summary.domain.BusiContractSummary;
import com.ruoyi.busi.summary.service.IBusiContractSummaryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 历史合同汇总Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-07
 */
@Service
public class BusiContractSummaryServiceImpl implements IBusiContractSummaryService 
{
    @Autowired
    private BusiContractSummaryMapper busiContractSummaryMapper;

    /**
     * 查询历史合同汇总
     * 
     * @param summaryId 历史合同汇总ID
     * @return 历史合同汇总
     */
    @Override
    public BusiContractSummary selectBusiContractSummaryById(Long summaryId)
    {
        return busiContractSummaryMapper.selectBusiContractSummaryById(summaryId);
    }

    /**
     * 查询历史合同汇总列表
     * 
     * @param busiContractSummary 历史合同汇总
     * @return 历史合同汇总
     */
    @Override
    public List<BusiContractSummary> selectBusiContractSummaryList(BusiContractSummary busiContractSummary)
    {
        return busiContractSummaryMapper.selectBusiContractSummaryList(busiContractSummary);
    }

    /**
     * 新增历史合同汇总
     * 
     * @param busiContractSummary 历史合同汇总
     * @return 结果
     */
    @Override
    public int insertBusiContractSummary(BusiContractSummary busiContractSummary)
    {
        return busiContractSummaryMapper.insertBusiContractSummary(busiContractSummary);
    }

    /**
     * 修改历史合同汇总
     * 
     * @param busiContractSummary 历史合同汇总
     * @return 结果
     */
    @Override
    public int updateBusiContractSummary(BusiContractSummary busiContractSummary)
    {
        return busiContractSummaryMapper.updateBusiContractSummary(busiContractSummary);
    }

    /**
     * 删除历史合同汇总对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiContractSummaryByIds(String ids)
    {
        return busiContractSummaryMapper.deleteBusiContractSummaryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除历史合同汇总信息
     * 
     * @param summaryId 历史合同汇总ID
     * @return 结果
     */
    @Override
    public int deleteBusiContractSummaryById(Long summaryId)
    {
        return busiContractSummaryMapper.deleteBusiContractSummaryById(summaryId);
    }
}
