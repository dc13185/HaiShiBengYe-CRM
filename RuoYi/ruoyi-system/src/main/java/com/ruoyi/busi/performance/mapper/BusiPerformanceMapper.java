package com.ruoyi.busi.performance.mapper;

import java.util.List;
import com.ruoyi.busi.performance.domain.BusiPerformance;

/**
 * 业绩管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-07
 */
public interface BusiPerformanceMapper 
{
    /**
     * 查询业绩管理
     * 
     * @param performanceId 业绩管理ID
     * @return 业绩管理
     */
    public BusiPerformance selectBusiPerformanceById(Long performanceId);

    /**
     * 查询业绩管理列表
     * 
     * @param busiPerformance 业绩管理
     * @return 业绩管理集合
     */
    public List<BusiPerformance> selectBusiPerformanceList(BusiPerformance busiPerformance);

    /**
     * 新增业绩管理
     * 
     * @param busiPerformance 业绩管理
     * @return 结果
     */
    public int insertBusiPerformance(BusiPerformance busiPerformance);

    /**
     * 修改业绩管理
     * 
     * @param busiPerformance 业绩管理
     * @return 结果
     */
    public int updateBusiPerformance(BusiPerformance busiPerformance);

    /**
     * 删除业绩管理
     * 
     * @param performanceId 业绩管理ID
     * @return 结果
     */
    public int deleteBusiPerformanceById(Long performanceId);

    /**
     * 批量删除业绩管理
     * 
     * @param performanceIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiPerformanceByIds(String[] performanceIds);
}
