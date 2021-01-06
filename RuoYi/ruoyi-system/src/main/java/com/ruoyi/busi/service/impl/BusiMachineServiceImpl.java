package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiMachineMapper;
import com.ruoyi.busi.domain.BusiMachine;
import com.ruoyi.busi.service.IBusiMachineService;
import com.ruoyi.common.core.text.Convert;

/**
 * 机封管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
@Service
public class BusiMachineServiceImpl implements IBusiMachineService 
{
    @Autowired
    private BusiMachineMapper busiMachineMapper;

    /**
     * 查询机封管理
     * 
     * @param machineId 机封管理ID
     * @return 机封管理
     */
    @Override
    public BusiMachine selectBusiMachineById(Long machineId)
    {
        return busiMachineMapper.selectBusiMachineById(machineId);
    }

    /**
     * 查询机封管理列表
     * 
     * @param busiMachine 机封管理
     * @return 机封管理
     */
    @Override
    public List<BusiMachine> selectBusiMachineList(BusiMachine busiMachine)
    {
        return busiMachineMapper.selectBusiMachineList(busiMachine);
    }

    /**
     * 新增机封管理
     * 
     * @param busiMachine 机封管理
     * @return 结果
     */
    @Override
    public int insertBusiMachine(BusiMachine busiMachine)
    {
        return busiMachineMapper.insertBusiMachine(busiMachine);
    }

    /**
     * 修改机封管理
     * 
     * @param busiMachine 机封管理
     * @return 结果
     */
    @Override
    public int updateBusiMachine(BusiMachine busiMachine)
    {
        return busiMachineMapper.updateBusiMachine(busiMachine);
    }

    /**
     * 删除机封管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiMachineByIds(String ids)
    {
        return busiMachineMapper.deleteBusiMachineByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除机封管理信息
     * 
     * @param machineId 机封管理ID
     * @return 结果
     */
    @Override
    public int deleteBusiMachineById(Long machineId)
    {
        return busiMachineMapper.deleteBusiMachineById(machineId);
    }
}
