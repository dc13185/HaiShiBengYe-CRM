package com.ruoyi.busi.service;

import java.util.List;
import com.ruoyi.busi.domain.BusiMachineSeal;

/**
 * 机封以及系统产品Service接口
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public interface IBusiMachineSealService 
{
    /**
     * 查询机封以及系统产品
     * 
     * @param machineId 机封以及系统产品ID
     * @return 机封以及系统产品
     */
    public BusiMachineSeal selectBusiMachineSealById(Long machineId);

    /**
     * 查询机封以及系统产品列表
     * 
     * @param busiMachineSeal 机封以及系统产品
     * @return 机封以及系统产品集合
     */
    public List<BusiMachineSeal> selectBusiMachineSealList(BusiMachineSeal busiMachineSeal);

    /**
     * 新增机封以及系统产品
     * 
     * @param busiMachineSeal 机封以及系统产品
     * @return 结果
     */
    public int insertBusiMachineSeal(BusiMachineSeal busiMachineSeal);

    /**
     * 修改机封以及系统产品
     * 
     * @param busiMachineSeal 机封以及系统产品
     * @return 结果
     */
    public int updateBusiMachineSeal(BusiMachineSeal busiMachineSeal);

    /**
     * 批量删除机封以及系统产品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiMachineSealByIds(String ids);

    /**
     * 删除机封以及系统产品信息
     * 
     * @param machineId 机封以及系统产品ID
     * @return 结果
     */
    public int deleteBusiMachineSealById(Long machineId);
}
