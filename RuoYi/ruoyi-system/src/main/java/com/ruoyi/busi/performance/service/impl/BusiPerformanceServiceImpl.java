package com.ruoyi.busi.performance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.performance.mapper.BusiPerformanceMapper;
import com.ruoyi.busi.performance.domain.BusiPerformance;
import com.ruoyi.busi.performance.service.IBusiPerformanceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 业绩管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-07
 */
@Service
public class BusiPerformanceServiceImpl implements IBusiPerformanceService 
{
    @Autowired
    private BusiPerformanceMapper busiPerformanceMapper;

    /**
     * 查询业绩管理
     * 
     * @param performanceId 业绩管理ID
     * @return 业绩管理
     */
    @Override
    public BusiPerformance selectBusiPerformanceById(Long performanceId)
    {
        return busiPerformanceMapper.selectBusiPerformanceById(performanceId);
    }

    /**
     * 查询业绩管理列表
     * 
     * @param busiPerformance 业绩管理
     * @return 业绩管理
     */
    @Override
    public List<BusiPerformance> selectBusiPerformanceList(BusiPerformance busiPerformance)
    {
        return busiPerformanceMapper.selectBusiPerformanceList(busiPerformance);
    }

    /**
     * 新增业绩管理
     * 
     * @param busiPerformance 业绩管理
     * @return 结果
     */
    @Override
    public int insertBusiPerformance(BusiPerformance busiPerformance)
    {
        return busiPerformanceMapper.insertBusiPerformance(busiPerformance);
    }

    /**
     * 修改业绩管理
     * 
     * @param busiPerformance 业绩管理
     * @return 结果
     */
    @Override
    public int updateBusiPerformance(BusiPerformance busiPerformance)
    {
        return busiPerformanceMapper.updateBusiPerformance(busiPerformance);
    }

    /**
     * 删除业绩管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiPerformanceByIds(String ids)
    {
        return busiPerformanceMapper.deleteBusiPerformanceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除业绩管理信息
     * 
     * @param performanceId 业绩管理ID
     * @return 结果
     */
    @Override
    public int deleteBusiPerformanceById(Long performanceId)
    {
        return busiPerformanceMapper.deleteBusiPerformanceById(performanceId);
    }
}
