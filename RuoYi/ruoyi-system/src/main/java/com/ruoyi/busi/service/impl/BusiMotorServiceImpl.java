package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiMotorMapper;
import com.ruoyi.busi.domain.BusiMotor;
import com.ruoyi.busi.service.IBusiMotorService;
import com.ruoyi.common.core.text.Convert;

/**
 * 电机产品Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-01
 */
@Service
public class BusiMotorServiceImpl implements IBusiMotorService 
{
    @Autowired
    private BusiMotorMapper busiMotorMapper;

    /**
     * 查询电机产品
     * 
     * @param motorId 电机产品ID
     * @return 电机产品
     */
    @Override
    public BusiMotor selectBusiMotorById(Long motorId)
    {
        return busiMotorMapper.selectBusiMotorById(motorId);
    }

    /**
     * 查询电机产品列表
     * 
     * @param busiMotor 电机产品
     * @return 电机产品
     */
    @Override
    public List<BusiMotor> selectBusiMotorList(BusiMotor busiMotor)
    {
        return busiMotorMapper.selectBusiMotorList(busiMotor);
    }

    /**
     * 新增电机产品
     * 
     * @param busiMotor 电机产品
     * @return 结果
     */
    @Override
    public int insertBusiMotor(BusiMotor busiMotor)
    {
        return busiMotorMapper.insertBusiMotor(busiMotor);
    }

    /**
     * 修改电机产品
     * 
     * @param busiMotor 电机产品
     * @return 结果
     */
    @Override
    public int updateBusiMotor(BusiMotor busiMotor)
    {
        return busiMotorMapper.updateBusiMotor(busiMotor);
    }

    /**
     * 删除电机产品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiMotorByIds(String ids)
    {
        return busiMotorMapper.deleteBusiMotorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除电机产品信息
     * 
     * @param motorId 电机产品ID
     * @return 结果
     */
    @Override
    public int deleteBusiMotorById(Long motorId)
    {
        return busiMotorMapper.deleteBusiMotorById(motorId);
    }
}
