package com.ruoyi.busi.settlement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.settlement.mapper.BusiSettlementMapper;
import com.ruoyi.busi.settlement.domain.BusiSettlement;
import com.ruoyi.busi.settlement.service.IBusiSettlementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 业务费用结算Service业务层处理
 *
 * @author ruoyi
 * @date 2021-02-19
 */
@Service
public class BusiSettlementServiceImpl implements IBusiSettlementService
{
    @Autowired
    private BusiSettlementMapper busiSettlementMapper;

    /**
     * 查询业务费用结算
     *
     * @param settlementId 业务费用结算ID
     * @return 业务费用结算
     */
    @Override
    public BusiSettlement selectBusiSettlementById(Long settlementId)
    {
        return busiSettlementMapper.selectBusiSettlementById(settlementId);
    }

    /**
     * 查询业务费用结算列表
     *
     * @param busiSettlement 业务费用结算
     * @return 业务费用结算
     */
    @Override
    public List<BusiSettlement> selectBusiSettlementList(BusiSettlement busiSettlement)
    {
        return busiSettlementMapper.selectBusiSettlementList(busiSettlement);
    }

    /**
     * 新增业务费用结算
     *
     * @param busiSettlement 业务费用结算
     * @return 结果
     */
    @Override
    public int insertBusiSettlement(BusiSettlement busiSettlement)
    {
        return busiSettlementMapper.insertBusiSettlement(busiSettlement);
    }

    /**
     * 修改业务费用结算
     *
     * @param busiSettlement 业务费用结算
     * @return 结果
     */
    @Override
    public int updateBusiSettlement(BusiSettlement busiSettlement)
    {
        return busiSettlementMapper.updateBusiSettlement(busiSettlement);
    }

    /**
     * 删除业务费用结算对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiSettlementByIds(String ids)
    {
        return busiSettlementMapper.deleteBusiSettlementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除业务费用结算信息
     *
     * @param settlementId 业务费用结算ID
     * @return 结果
     */
    @Override
    public int deleteBusiSettlementById(Long settlementId)
    {
        return busiSettlementMapper.deleteBusiSettlementById(settlementId);
    }

    @Override
    public BusiSettlement selectBusiSettlementByNo(String no) {
        return busiSettlementMapper.selectBusiSettlementByContractNo(no);
    }
}
