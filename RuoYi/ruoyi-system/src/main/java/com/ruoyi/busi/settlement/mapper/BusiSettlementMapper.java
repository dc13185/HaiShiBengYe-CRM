package com.ruoyi.busi.settlement.mapper;

import java.util.List;
import com.ruoyi.busi.settlement.domain.BusiSettlement;

/**
 * 业务费用结算Mapper接口
 *
 * @author ruoyi
 * @date 2021-02-19
 */
public interface BusiSettlementMapper
{
    /**
     * 查询业务费用结算列表
     *
     * @param busiSettlement 业务费用结算
     * @return 业务费用结算集合
     */
    public List<BusiSettlement> selectBusiSettlementList(BusiSettlement busiSettlement);

    /**
     * 查询业务费用结算
     *
     * @param settlementId 业务费用结算ID
     * @return 业务费用结算
     */
    public BusiSettlement selectBusiSettlementById(Long settlementId);

    /**
     * 新增业务费用结算
     *
     * @param busiSettlement 业务费用结算
     * @return 结果
     */
    public int insertBusiSettlement(BusiSettlement busiSettlement);

    /**
     * 修改业务费用结算
     *
     * @param busiSettlement 业务费用结算
     * @return 结果
     */
    public int updateBusiSettlement(BusiSettlement busiSettlement);

    /**
     * 删除业务费用结算
     *
     * @param settlementId 业务费用结算ID
     * @return 结果
     */
    public int deleteBusiSettlementById(Long settlementId);

    /**
     * 批量删除业务费用结算
     *
     * @param settlementIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiSettlementByIds(String[] settlementIds);
}
