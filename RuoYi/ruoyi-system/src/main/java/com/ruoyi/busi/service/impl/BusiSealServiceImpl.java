package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiSealMapper;
import com.ruoyi.busi.domain.BusiSeal;
import com.ruoyi.busi.service.IBusiSealService;
import com.ruoyi.common.core.text.Convert;

/**
 * 冲洗方案管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
@Service
public class BusiSealServiceImpl implements IBusiSealService 
{
    @Autowired
    private BusiSealMapper busiSealMapper;

    /**
     * 查询冲洗方案管理
     * 
     * @param sealId 冲洗方案管理ID
     * @return 冲洗方案管理
     */
    @Override
    public BusiSeal selectBusiSealById(Long sealId)
    {
        return busiSealMapper.selectBusiSealById(sealId);
    }

    /**
     * 查询冲洗方案管理列表
     * 
     * @param busiSeal 冲洗方案管理
     * @return 冲洗方案管理
     */
    @Override
    public List<BusiSeal> selectBusiSealList(BusiSeal busiSeal)
    {
        return busiSealMapper.selectBusiSealList(busiSeal);
    }

    /**
     * 新增冲洗方案管理
     * 
     * @param busiSeal 冲洗方案管理
     * @return 结果
     */
    @Override
    public int insertBusiSeal(BusiSeal busiSeal)
    {
        return busiSealMapper.insertBusiSeal(busiSeal);
    }

    /**
     * 修改冲洗方案管理
     * 
     * @param busiSeal 冲洗方案管理
     * @return 结果
     */
    @Override
    public int updateBusiSeal(BusiSeal busiSeal)
    {
        return busiSealMapper.updateBusiSeal(busiSeal);
    }

    /**
     * 删除冲洗方案管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiSealByIds(String ids)
    {
        return busiSealMapper.deleteBusiSealByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除冲洗方案管理信息
     * 
     * @param sealId 冲洗方案管理ID
     * @return 结果
     */
    @Override
    public int deleteBusiSealById(Long sealId)
    {
        return busiSealMapper.deleteBusiSealById(sealId);
    }
}
