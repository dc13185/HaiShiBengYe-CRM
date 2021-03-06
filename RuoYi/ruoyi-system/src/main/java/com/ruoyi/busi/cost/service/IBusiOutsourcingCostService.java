package com.ruoyi.busi.cost.service;

import java.util.List;
import com.ruoyi.busi.cost.domain.BusiOutsourcingCost;

/**
 * 外购电机成本明细Service接口
 *
 * @author ruoyi
 * @date 2021-02-02
 */
public interface IBusiOutsourcingCostService
{
    /**
     * 查询外购电机成本明细
     *
     * @param costId 外购电机成本明细ID
     * @return 外购电机成本明细
     */
    public BusiOutsourcingCost selectBusiOutsourcingCostById(Long costId);

    /**
     * 查询外购电机成本明细列表
     *
     * @param busiOutsourcingCost 外购电机成本明细
     * @return 外购电机成本明细集合
     */
    public List<BusiOutsourcingCost> selectBusiOutsourcingCostList(BusiOutsourcingCost busiOutsourcingCost);



    /**
     * 新增外购电机成本明细
     *
     * @param busiOutsourcingCost 外购电机成本明细
     * @return 结果
     */
    public int insertBusiOutsourcingCost(BusiOutsourcingCost busiOutsourcingCost);

    /**
     * 修改外购电机成本明细
     *
     * @param busiOutsourcingCost 外购电机成本明细
     * @return 结果
     */
    public int updateBusiOutsourcingCost(BusiOutsourcingCost busiOutsourcingCost);

    /**
     * 批量删除外购电机成本明细
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiOutsourcingCostByIds(String ids);

    /**
     * 删除外购电机成本明细信息
     *
     * @param costId 外购电机成本明细ID
     * @return 结果
     */
    public int deleteBusiOutsourcingCostById(Long costId);
}
