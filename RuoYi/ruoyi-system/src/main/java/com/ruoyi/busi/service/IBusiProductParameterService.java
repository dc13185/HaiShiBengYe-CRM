package com.ruoyi.busi.service;

import java.util.List;
import com.ruoyi.busi.domain.BusiProductParameter;

/**
 * 生产参数Service接口
 * 
 * @author ruoyi
 * @date 2021-01-10
 */
public interface IBusiProductParameterService 
{
    /**
     * 查询生产参数
     * 
     * @param parameterId 生产参数ID
     * @return 生产参数
     */
    public BusiProductParameter selectBusiProductParameterById(Long parameterId);

    /**
     * 查询生产参数列表
     * 
     * @param busiProductParameter 生产参数
     * @return 生产参数集合
     */
    public List<BusiProductParameter> selectBusiProductParameterList(BusiProductParameter busiProductParameter);

    /**
     * 新增生产参数
     * 
     * @param busiProductParameter 生产参数
     * @return 结果
     */
    public int insertBusiProductParameter(BusiProductParameter busiProductParameter);

    /**
     * 修改生产参数
     * 
     * @param busiProductParameter 生产参数
     * @return 结果
     */
    public int updateBusiProductParameter(BusiProductParameter busiProductParameter);

    /**
     * 批量删除生产参数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiProductParameterByIds(String ids);

    /**
     * 删除生产参数信息
     * 
     * @param parameterId 生产参数ID
     * @return 结果
     */
    public int deleteBusiProductParameterById(Long parameterId);
}
