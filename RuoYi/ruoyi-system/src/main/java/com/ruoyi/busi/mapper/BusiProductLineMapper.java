package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.BusiProductLine;

/**
 * 产品系列管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
public interface BusiProductLineMapper 
{
    /**
     * 查询产品系列管理
     * 
     * @param productLineId 产品系列管理ID
     * @return 产品系列管理
     */
    public BusiProductLine selectBusiProductLineById(Long productLineId);

    /**
     * 查询产品系列管理列表
     * 
     * @param busiProductLine 产品系列管理
     * @return 产品系列管理集合
     */
    public List<BusiProductLine> selectBusiProductLineList(BusiProductLine busiProductLine);

    /**
     * 新增产品系列管理
     * 
     * @param busiProductLine 产品系列管理
     * @return 结果
     */
    public int insertBusiProductLine(BusiProductLine busiProductLine);

    /**
     * 修改产品系列管理
     * 
     * @param busiProductLine 产品系列管理
     * @return 结果
     */
    public int updateBusiProductLine(BusiProductLine busiProductLine);

    /**
     * 删除产品系列管理
     * 
     * @param productLineId 产品系列管理ID
     * @return 结果
     */
    public int deleteBusiProductLineById(Long productLineId);

    /**
     * 批量删除产品系列管理
     * 
     * @param productLineIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiProductLineByIds(String[] productLineIds);
}
