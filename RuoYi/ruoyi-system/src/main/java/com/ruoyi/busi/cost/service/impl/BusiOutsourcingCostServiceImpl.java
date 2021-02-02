package com.ruoyi.busi.cost.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.cost.mapper.BusiOutsourcingCostMapper;
import com.ruoyi.busi.cost.domain.BusiOutsourcingCost;
import com.ruoyi.busi.cost.service.IBusiOutsourcingCostService;
import com.ruoyi.common.core.text.Convert;

/**
 * 外购电机成本明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-02
 */
@Service
public class BusiOutsourcingCostServiceImpl implements IBusiOutsourcingCostService 
{
    @Autowired
    private BusiOutsourcingCostMapper busiOutsourcingCostMapper;

    /**
     * 查询外购电机成本明细
     * 
     * @param costId 外购电机成本明细ID
     * @return 外购电机成本明细
     */
    @Override
    public BusiOutsourcingCost selectBusiOutsourcingCostById(Long costId)
    {
        return busiOutsourcingCostMapper.selectBusiOutsourcingCostById(costId);
    }

    /**
     * 查询外购电机成本明细列表
     * 
     * @param busiOutsourcingCost 外购电机成本明细
     * @return 外购电机成本明细
     */
    @Override
    public List<BusiOutsourcingCost> selectBusiOutsourcingCostList(BusiOutsourcingCost busiOutsourcingCost)
    {
        return busiOutsourcingCostMapper.selectBusiOutsourcingCostList(busiOutsourcingCost);
    }

    /**
     * 新增外购电机成本明细
     * 
     * @param busiOutsourcingCost 外购电机成本明细
     * @return 结果
     */
    @Override
    public int insertBusiOutsourcingCost(BusiOutsourcingCost busiOutsourcingCost)
    {
        return busiOutsourcingCostMapper.insertBusiOutsourcingCost(busiOutsourcingCost);
    }

    /**
     * 修改外购电机成本明细
     * 
     * @param busiOutsourcingCost 外购电机成本明细
     * @return 结果
     */
    @Override
    public int updateBusiOutsourcingCost(BusiOutsourcingCost busiOutsourcingCost)
    {
        return busiOutsourcingCostMapper.updateBusiOutsourcingCost(busiOutsourcingCost);
    }

    /**
     * 删除外购电机成本明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiOutsourcingCostByIds(String ids)
    {
        return busiOutsourcingCostMapper.deleteBusiOutsourcingCostByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除外购电机成本明细信息
     * 
     * @param costId 外购电机成本明细ID
     * @return 结果
     */
    @Override
    public int deleteBusiOutsourcingCostById(Long costId)
    {
        return busiOutsourcingCostMapper.deleteBusiOutsourcingCostById(costId);
    }
}
