package com.ruoyi.busi.service;

import java.util.List;
import com.ruoyi.busi.domain.BusiMotor;

/**
 * 电机产品Service接口
 * 
 * @author ruoyi
 * @date 2021-01-01
 */
public interface IBusiMotorService 
{
    /**
     * 查询电机产品
     * 
     * @param motorId 电机产品ID
     * @return 电机产品
     */
    public BusiMotor selectBusiMotorById(Long motorId);

    /**
     * 查询电机产品列表
     * 
     * @param busiMotor 电机产品
     * @return 电机产品集合
     */
    public List<BusiMotor> selectBusiMotorList(BusiMotor busiMotor);

    /**
     * 新增电机产品
     * 
     * @param busiMotor 电机产品
     * @return 结果
     */
    public int insertBusiMotor(BusiMotor busiMotor);

    /**
     * 修改电机产品
     * 
     * @param busiMotor 电机产品
     * @return 结果
     */
    public int updateBusiMotor(BusiMotor busiMotor);

    /**
     * 批量删除电机产品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiMotorByIds(String ids);

    /**
     * 删除电机产品信息
     * 
     * @param motorId 电机产品ID
     * @return 结果
     */
    public int deleteBusiMotorById(Long motorId);
}
