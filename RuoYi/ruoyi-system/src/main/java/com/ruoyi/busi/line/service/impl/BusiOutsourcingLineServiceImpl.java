package com.ruoyi.busi.line.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.line.mapper.BusiOutsourcingLineMapper;
import com.ruoyi.busi.line.domain.BusiOutsourcingLine;
import com.ruoyi.busi.line.service.IBusiOutsourcingLineService;
import com.ruoyi.common.core.text.Convert;

/**
 * 外购泵系列Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-30
 */
@Service
public class BusiOutsourcingLineServiceImpl implements IBusiOutsourcingLineService 
{
    @Autowired
    private BusiOutsourcingLineMapper busiOutsourcingLineMapper;

    /**
     * 查询外购泵系列
     * 
     * @param outsourcingLineId 外购泵系列ID
     * @return 外购泵系列
     */
    @Override
    public BusiOutsourcingLine selectBusiOutsourcingLineById(Long outsourcingLineId)
    {
        return busiOutsourcingLineMapper.selectBusiOutsourcingLineById(outsourcingLineId);
    }

    /**
     * 查询外购泵系列列表
     * 
     * @param busiOutsourcingLine 外购泵系列
     * @return 外购泵系列
     */
    @Override
    public List<BusiOutsourcingLine> selectBusiOutsourcingLineList(BusiOutsourcingLine busiOutsourcingLine)
    {
        return busiOutsourcingLineMapper.selectBusiOutsourcingLineList(busiOutsourcingLine);
    }

    /**
     * 新增外购泵系列
     * 
     * @param busiOutsourcingLine 外购泵系列
     * @return 结果
     */
    @Override
    public int insertBusiOutsourcingLine(BusiOutsourcingLine busiOutsourcingLine)
    {
        return busiOutsourcingLineMapper.insertBusiOutsourcingLine(busiOutsourcingLine);
    }

    /**
     * 修改外购泵系列
     * 
     * @param busiOutsourcingLine 外购泵系列
     * @return 结果
     */
    @Override
    public int updateBusiOutsourcingLine(BusiOutsourcingLine busiOutsourcingLine)
    {
        return busiOutsourcingLineMapper.updateBusiOutsourcingLine(busiOutsourcingLine);
    }

    /**
     * 删除外购泵系列对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiOutsourcingLineByIds(String ids)
    {
        return busiOutsourcingLineMapper.deleteBusiOutsourcingLineByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除外购泵系列信息
     * 
     * @param outsourcingLineId 外购泵系列ID
     * @return 结果
     */
    @Override
    public int deleteBusiOutsourcingLineById(Long outsourcingLineId)
    {
        return busiOutsourcingLineMapper.deleteBusiOutsourcingLineById(outsourcingLineId);
    }
}
