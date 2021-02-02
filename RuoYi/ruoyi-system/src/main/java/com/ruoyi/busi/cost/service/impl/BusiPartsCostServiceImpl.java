package com.ruoyi.busi.cost.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.cost.mapper.BusiPartsCostMapper;
import com.ruoyi.busi.cost.domain.BusiPartsCost;
import com.ruoyi.busi.cost.service.IBusiPartsCostService;
import com.ruoyi.common.core.text.Convert;

/**
 * 配件报价成本明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-02
 */
@Service
public class BusiPartsCostServiceImpl implements IBusiPartsCostService 
{
    @Autowired
    private BusiPartsCostMapper busiPartsCostMapper;

    /**
     * 查询配件报价成本明细
     * 
     * @param costId 配件报价成本明细ID
     * @return 配件报价成本明细
     */
    @Override
    public BusiPartsCost selectBusiPartsCostById(Long costId)
    {
        return busiPartsCostMapper.selectBusiPartsCostById(costId);
    }

    /**
     * 查询配件报价成本明细列表
     * 
     * @param busiPartsCost 配件报价成本明细
     * @return 配件报价成本明细
     */
    @Override
    public List<BusiPartsCost> selectBusiPartsCostList(BusiPartsCost busiPartsCost)
    {
        return busiPartsCostMapper.selectBusiPartsCostList(busiPartsCost);
    }

    /**
     * 新增配件报价成本明细
     * 
     * @param busiPartsCost 配件报价成本明细
     * @return 结果
     */
    @Override
    public int insertBusiPartsCost(BusiPartsCost busiPartsCost)
    {
        return busiPartsCostMapper.insertBusiPartsCost(busiPartsCost);
    }

    /**
     * 修改配件报价成本明细
     * 
     * @param busiPartsCost 配件报价成本明细
     * @return 结果
     */
    @Override
    public int updateBusiPartsCost(BusiPartsCost busiPartsCost)
    {
        return busiPartsCostMapper.updateBusiPartsCost(busiPartsCost);
    }

    /**
     * 删除配件报价成本明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiPartsCostByIds(String ids)
    {
        return busiPartsCostMapper.deleteBusiPartsCostByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除配件报价成本明细信息
     * 
     * @param costId 配件报价成本明细ID
     * @return 结果
     */
    @Override
    public int deleteBusiPartsCostById(Long costId)
    {
        return busiPartsCostMapper.deleteBusiPartsCostById(costId);
    }
}
