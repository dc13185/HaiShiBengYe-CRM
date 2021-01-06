package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiProductLineMapper;
import com.ruoyi.busi.domain.BusiProductLine;
import com.ruoyi.busi.service.IBusiProductLineService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产品系列管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
@Service
public class BusiProductLineServiceImpl implements IBusiProductLineService 
{
    @Autowired
    private BusiProductLineMapper busiProductLineMapper;

    /**
     * 查询产品系列管理
     * 
     * @param productLineId 产品系列管理ID
     * @return 产品系列管理
     */
    @Override
    public BusiProductLine selectBusiProductLineById(Long productLineId)
    {
        return busiProductLineMapper.selectBusiProductLineById(productLineId);
    }

    /**
     * 查询产品系列管理列表
     * 
     * @param busiProductLine 产品系列管理
     * @return 产品系列管理
     */
    @Override
    public List<BusiProductLine> selectBusiProductLineList(BusiProductLine busiProductLine)
    {
        return busiProductLineMapper.selectBusiProductLineList(busiProductLine);
    }

    /**
     * 新增产品系列管理
     * 
     * @param busiProductLine 产品系列管理
     * @return 结果
     */
    @Override
    public int insertBusiProductLine(BusiProductLine busiProductLine)
    {
        return busiProductLineMapper.insertBusiProductLine(busiProductLine);
    }

    /**
     * 修改产品系列管理
     * 
     * @param busiProductLine 产品系列管理
     * @return 结果
     */
    @Override
    public int updateBusiProductLine(BusiProductLine busiProductLine)
    {
        return busiProductLineMapper.updateBusiProductLine(busiProductLine);
    }

    /**
     * 删除产品系列管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiProductLineByIds(String ids)
    {
        return busiProductLineMapper.deleteBusiProductLineByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品系列管理信息
     * 
     * @param productLineId 产品系列管理ID
     * @return 结果
     */
    @Override
    public int deleteBusiProductLineById(Long productLineId)
    {
        return busiProductLineMapper.deleteBusiProductLineById(productLineId);
    }
}
