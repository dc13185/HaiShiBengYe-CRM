package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.BusiMotor;

/**
 * 电机产品Mapper接口
 *
 * @author ruoyi
 * @date 2021-01-01
 */
public interface BusiMotorMapper
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

    public List<BusiMotor> selectBusiMotorListExport(BusiMotor busiMotor);


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
     * 删除电机产品
     *
     * @param motorId 电机产品ID
     * @return 结果
     */
    public int deleteBusiMotorById(Long motorId);

    /**
     * 批量删除电机产品
     *
     * @param motorIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiMotorByIds(String[] motorIds);
}
