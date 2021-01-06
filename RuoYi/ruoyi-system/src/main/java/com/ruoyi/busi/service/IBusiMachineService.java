package com.ruoyi.busi.service;

import java.util.List;
import com.ruoyi.busi.domain.BusiMachine;

/**
 * 机封管理Service接口
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
public interface IBusiMachineService 
{
    /**
     * 查询机封管理
     * 
     * @param machineId 机封管理ID
     * @return 机封管理
     */
    public BusiMachine selectBusiMachineById(Long machineId);

    /**
     * 查询机封管理列表
     * 
     * @param busiMachine 机封管理
     * @return 机封管理集合
     */
    public List<BusiMachine> selectBusiMachineList(BusiMachine busiMachine);

    /**
     * 新增机封管理
     * 
     * @param busiMachine 机封管理
     * @return 结果
     */
    public int insertBusiMachine(BusiMachine busiMachine);

    /**
     * 修改机封管理
     * 
     * @param busiMachine 机封管理
     * @return 结果
     */
    public int updateBusiMachine(BusiMachine busiMachine);

    /**
     * 批量删除机封管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiMachineByIds(String ids);

    /**
     * 删除机封管理信息
     * 
     * @param machineId 机封管理ID
     * @return 结果
     */
    public int deleteBusiMachineById(Long machineId);
}
