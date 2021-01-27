package com.ruoyi.busi.plan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.plan.mapper.BusiContractPlanMapper;
import com.ruoyi.busi.plan.domain.BusiContractPlan;
import com.ruoyi.busi.plan.service.IBusiContractPlanService;
import com.ruoyi.common.core.text.Convert;

/**
 * 合同进度Service业务层处理
 *
 * @author ruoyi
 * @date 2021-01-25
 */
@Service
public class BusiContractPlanServiceImpl implements IBusiContractPlanService
{
    @Autowired
    private BusiContractPlanMapper busiContractPlanMapper;

    /**
     * 查询合同进度
     *
     * @param planId 合同进度ID
     * @return 合同进度
     */
    @Override
    public BusiContractPlan selectBusiContractPlanById(Long planId)
    {
        return busiContractPlanMapper.selectBusiContractPlanById(planId);
    }

    /**
     * 查询合同进度列表
     *
     * @param busiContractPlan 合同进度
     * @return 合同进度
     */
    @Override
    public List<BusiContractPlan> selectBusiContractPlanList(BusiContractPlan busiContractPlan)
    {
        return busiContractPlanMapper.selectBusiContractPlanList(busiContractPlan);
    }

    /**
     * 新增合同进度
     *
     * @param busiContractPlan 合同进度
     * @return 结果
     */
    @Override
    public int insertBusiContractPlan(BusiContractPlan busiContractPlan)
    {
        return busiContractPlanMapper.insertBusiContractPlan(busiContractPlan);
    }

    /**
     * 修改合同进度
     *
     * @param busiContractPlan 合同进度
     * @return 结果
     */
    @Override
    public int updateBusiContractPlan(BusiContractPlan busiContractPlan)
    {
        return busiContractPlanMapper.updateBusiContractPlan(busiContractPlan);
    }

    /**
     * 删除合同进度对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiContractPlanByIds(String ids)
    {
        return busiContractPlanMapper.deleteBusiContractPlanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除合同进度信息
     *
     * @param planId 合同进度ID
     * @return 结果
     */
    @Override
    public int deleteBusiContractPlanById(Long planId)
    {
        return busiContractPlanMapper.deleteBusiContractPlanById(planId);
    }

    @Override
    public int insertBatch(List<BusiContractPlan> busiContractPlans) {
        return busiContractPlanMapper.insertBatch(busiContractPlans);
    }
}
