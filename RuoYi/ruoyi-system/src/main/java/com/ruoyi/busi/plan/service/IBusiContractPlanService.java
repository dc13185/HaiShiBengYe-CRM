package com.ruoyi.busi.plan.service;

import java.util.List;
import com.ruoyi.busi.plan.domain.BusiContractPlan;

/**
 * 合同进度Service接口
 *
 * @author ruoyi
 * @date 2021-01-25
 */
public interface IBusiContractPlanService
{
    /**
     * 查询合同进度
     *
     * @param planId 合同进度ID
     * @return 合同进度
     */
    public BusiContractPlan selectBusiContractPlanById(Long planId);

    /**
     * 查询合同进度列表
     *
     * @param busiContractPlan 合同进度
     * @return 合同进度集合
     */
    public List<BusiContractPlan> selectBusiContractPlanList(BusiContractPlan busiContractPlan);

    public List<BusiContractPlan> selectBusiContractPlanListNotNull(BusiContractPlan busiContractPlan);

    /**
     * 新增合同进度
     *
     * @param busiContractPlan 合同进度
     * @return 结果
     */
    public int insertBusiContractPlan(BusiContractPlan busiContractPlan);

    /**
     * 修改合同进度
     *
     * @param busiContractPlan 合同进度
     * @return 结果
     */
    public int updateBusiContractPlan(BusiContractPlan busiContractPlan);

    /**
     * 批量删除合同进度
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiContractPlanByIds(String ids);

    /**
     * 删除合同进度信息
     *
     * @param planId 合同进度ID
     * @return 结果
     */
    public int deleteBusiContractPlanById(Long planId);

    public int insertBatch(List<BusiContractPlan> busiContractPlans);
}
