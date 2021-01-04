package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiMachineSealMapper;
import com.ruoyi.busi.domain.BusiMachineSeal;
import com.ruoyi.busi.service.IBusiMachineSealService;
import com.ruoyi.common.core.text.Convert;

/**
 * 机封以及系统产品Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Service
public class BusiMachineSealServiceImpl implements IBusiMachineSealService 
{
    @Autowired
    private BusiMachineSealMapper busiMachineSealMapper;

    /**
     * 查询机封以及系统产品
     * 
     * @param machineId 机封以及系统产品ID
     * @return 机封以及系统产品
     */
    @Override
    public BusiMachineSeal selectBusiMachineSealById(Long machineId)
    {
        return busiMachineSealMapper.selectBusiMachineSealById(machineId);
    }

    /**
     * 查询机封以及系统产品列表
     * 
     * @param busiMachineSeal 机封以及系统产品
     * @return 机封以及系统产品
     */
    @Override
    public List<BusiMachineSeal> selectBusiMachineSealList(BusiMachineSeal busiMachineSeal)
    {
        return busiMachineSealMapper.selectBusiMachineSealList(busiMachineSeal);
    }

    /**
     * 新增机封以及系统产品
     * 
     * @param busiMachineSeal 机封以及系统产品
     * @return 结果
     */
    @Override
    public int insertBusiMachineSeal(BusiMachineSeal busiMachineSeal)
    {
        return busiMachineSealMapper.insertBusiMachineSeal(busiMachineSeal);
    }

    /**
     * 修改机封以及系统产品
     * 
     * @param busiMachineSeal 机封以及系统产品
     * @return 结果
     */
    @Override
    public int updateBusiMachineSeal(BusiMachineSeal busiMachineSeal)
    {
        return busiMachineSealMapper.updateBusiMachineSeal(busiMachineSeal);
    }

    /**
     * 删除机封以及系统产品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiMachineSealByIds(String ids)
    {
        return busiMachineSealMapper.deleteBusiMachineSealByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除机封以及系统产品信息
     * 
     * @param machineId 机封以及系统产品ID
     * @return 结果
     */
    @Override
    public int deleteBusiMachineSealById(Long machineId)
    {
        return busiMachineSealMapper.deleteBusiMachineSealById(machineId);
    }
}
