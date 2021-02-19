package com.ruoyi.busi.settlement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.settlement.mapper.BusiSettlementHistoryMapper;
import com.ruoyi.busi.settlement.domain.BusiSettlementHistory;
import com.ruoyi.busi.settlement.service.IBusiSettlementHistoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 业务费用结算历史Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-19
 */
@Service
public class BusiSettlementHistoryServiceImpl implements IBusiSettlementHistoryService 
{
    @Autowired
    private BusiSettlementHistoryMapper busiSettlementHistoryMapper;

    /**
     * 查询业务费用结算历史
     * 
     * @param basedCommission 业务费用结算历史ID
     * @return 业务费用结算历史
     */
    @Override
    public BusiSettlementHistory selectBusiSettlementHistoryById(Double basedCommission)
    {
        return busiSettlementHistoryMapper.selectBusiSettlementHistoryById(basedCommission);
    }

    /**
     * 查询业务费用结算历史列表
     * 
     * @param busiSettlementHistory 业务费用结算历史
     * @return 业务费用结算历史
     */
    @Override
    public List<BusiSettlementHistory> selectBusiSettlementHistoryList(BusiSettlementHistory busiSettlementHistory)
    {
        return busiSettlementHistoryMapper.selectBusiSettlementHistoryList(busiSettlementHistory);
    }

    /**
     * 新增业务费用结算历史
     * 
     * @param busiSettlementHistory 业务费用结算历史
     * @return 结果
     */
    @Override
    public int insertBusiSettlementHistory(BusiSettlementHistory busiSettlementHistory)
    {
        return busiSettlementHistoryMapper.insertBusiSettlementHistory(busiSettlementHistory);
    }

    /**
     * 修改业务费用结算历史
     * 
     * @param busiSettlementHistory 业务费用结算历史
     * @return 结果
     */
    @Override
    public int updateBusiSettlementHistory(BusiSettlementHistory busiSettlementHistory)
    {
        return busiSettlementHistoryMapper.updateBusiSettlementHistory(busiSettlementHistory);
    }

    /**
     * 删除业务费用结算历史对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiSettlementHistoryByIds(String ids)
    {
        return busiSettlementHistoryMapper.deleteBusiSettlementHistoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除业务费用结算历史信息
     * 
     * @param basedCommission 业务费用结算历史ID
     * @return 结果
     */
    @Override
    public int deleteBusiSettlementHistoryById(Double basedCommission)
    {
        return busiSettlementHistoryMapper.deleteBusiSettlementHistoryById(basedCommission);
    }
}
