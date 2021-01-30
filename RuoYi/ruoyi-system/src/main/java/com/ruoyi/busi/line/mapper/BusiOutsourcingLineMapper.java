package com.ruoyi.busi.line.mapper;

import java.util.List;
import com.ruoyi.busi.line.domain.BusiOutsourcingLine;

/**
 * 外购泵系列Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-30
 */
public interface BusiOutsourcingLineMapper 
{
    /**
     * 查询外购泵系列
     * 
     * @param outsourcingLineId 外购泵系列ID
     * @return 外购泵系列
     */
    public BusiOutsourcingLine selectBusiOutsourcingLineById(Long outsourcingLineId);

    /**
     * 查询外购泵系列列表
     * 
     * @param busiOutsourcingLine 外购泵系列
     * @return 外购泵系列集合
     */
    public List<BusiOutsourcingLine> selectBusiOutsourcingLineList(BusiOutsourcingLine busiOutsourcingLine);

    /**
     * 新增外购泵系列
     * 
     * @param busiOutsourcingLine 外购泵系列
     * @return 结果
     */
    public int insertBusiOutsourcingLine(BusiOutsourcingLine busiOutsourcingLine);

    /**
     * 修改外购泵系列
     * 
     * @param busiOutsourcingLine 外购泵系列
     * @return 结果
     */
    public int updateBusiOutsourcingLine(BusiOutsourcingLine busiOutsourcingLine);

    /**
     * 删除外购泵系列
     * 
     * @param outsourcingLineId 外购泵系列ID
     * @return 结果
     */
    public int deleteBusiOutsourcingLineById(Long outsourcingLineId);

    /**
     * 批量删除外购泵系列
     * 
     * @param outsourcingLineIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiOutsourcingLineByIds(String[] outsourcingLineIds);
}
