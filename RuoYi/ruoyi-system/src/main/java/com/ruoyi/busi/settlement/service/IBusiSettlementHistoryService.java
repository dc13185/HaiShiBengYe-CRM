package com.ruoyi.busi.settlement.service;

import java.util.List;
import com.ruoyi.busi.settlement.domain.BusiSettlementHistory;

/**
 * 业务费用结算历史Service接口
 * 
 * @author ruoyi
 * @date 2021-02-19
 */
public interface IBusiSettlementHistoryService 
{
    /**
     * 查询业务费用结算历史
     * 
     * @param basedCommission 业务费用结算历史ID
     * @return 业务费用结算历史
     */
    public BusiSettlementHistory selectBusiSettlementHistoryById(Double basedCommission);

    /**
     * 查询业务费用结算历史列表
     * 
     * @param busiSettlementHistory 业务费用结算历史
     * @return 业务费用结算历史集合
     */
    public List<BusiSettlementHistory> selectBusiSettlementHistoryList(BusiSettlementHistory busiSettlementHistory);

    /**
     * 新增业务费用结算历史
     * 
     * @param busiSettlementHistory 业务费用结算历史
     * @return 结果
     */
    public int insertBusiSettlementHistory(BusiSettlementHistory busiSettlementHistory);

    /**
     * 修改业务费用结算历史
     * 
     * @param busiSettlementHistory 业务费用结算历史
     * @return 结果
     */
    public int updateBusiSettlementHistory(BusiSettlementHistory busiSettlementHistory);

    /**
     * 批量删除业务费用结算历史
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiSettlementHistoryByIds(String ids);

    /**
     * 删除业务费用结算历史信息
     * 
     * @param basedCommission 业务费用结算历史ID
     * @return 结果
     */
    public int deleteBusiSettlementHistoryById(Double basedCommission);
}
