package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiProductParameterMapper;
import com.ruoyi.busi.domain.BusiProductParameter;
import com.ruoyi.busi.service.IBusiProductParameterService;
import com.ruoyi.common.core.text.Convert;

/**
 * 生产参数Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-10
 */
@Service
public class BusiProductParameterServiceImpl implements IBusiProductParameterService 
{
    @Autowired
    private BusiProductParameterMapper busiProductParameterMapper;

    /**
     * 查询生产参数
     * 
     * @param parameterId 生产参数ID
     * @return 生产参数
     */
    @Override
    public BusiProductParameter selectBusiProductParameterById(Long parameterId)
    {
        return busiProductParameterMapper.selectBusiProductParameterById(parameterId);
    }

    /**
     * 查询生产参数列表
     * 
     * @param busiProductParameter 生产参数
     * @return 生产参数
     */
    @Override
    public List<BusiProductParameter> selectBusiProductParameterList(BusiProductParameter busiProductParameter)
    {
        return busiProductParameterMapper.selectBusiProductParameterList(busiProductParameter);
    }

    /**
     * 新增生产参数
     * 
     * @param busiProductParameter 生产参数
     * @return 结果
     */
    @Override
    public int insertBusiProductParameter(BusiProductParameter busiProductParameter)
    {
        return busiProductParameterMapper.insertBusiProductParameter(busiProductParameter);
    }

    /**
     * 修改生产参数
     * 
     * @param busiProductParameter 生产参数
     * @return 结果
     */
    @Override
    public int updateBusiProductParameter(BusiProductParameter busiProductParameter)
    {
        return busiProductParameterMapper.updateBusiProductParameter(busiProductParameter);
    }

    /**
     * 删除生产参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiProductParameterByIds(String ids)
    {
        return busiProductParameterMapper.deleteBusiProductParameterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除生产参数信息
     * 
     * @param parameterId 生产参数ID
     * @return 结果
     */
    @Override
    public int deleteBusiProductParameterById(Long parameterId)
    {
        return busiProductParameterMapper.deleteBusiProductParameterById(parameterId);
    }
}
