package com.ruoyi.busi.parts.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.parts.mapper.BusiPartsDetailsMapper;
import com.ruoyi.busi.parts.domain.BusiPartsDetails;
import com.ruoyi.busi.parts.service.IBusiPartsDetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 配件报价Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-31
 */
@Service
public class BusiPartsDetailsServiceImpl implements IBusiPartsDetailsService 
{
    @Autowired
    private BusiPartsDetailsMapper busiPartsDetailsMapper;

    /**
     * 查询配件报价
     * 
     * @param detailsId 配件报价ID
     * @return 配件报价
     */
    @Override
    public BusiPartsDetails selectBusiPartsDetailsById(Long detailsId)
    {
        return busiPartsDetailsMapper.selectBusiPartsDetailsById(detailsId);
    }

    /**
     * 查询配件报价列表
     * 
     * @param busiPartsDetails 配件报价
     * @return 配件报价
     */
    @Override
    public List<BusiPartsDetails> selectBusiPartsDetailsList(BusiPartsDetails busiPartsDetails)
    {
        return busiPartsDetailsMapper.selectBusiPartsDetailsList(busiPartsDetails);
    }

    /**
     * 新增配件报价
     * 
     * @param busiPartsDetails 配件报价
     * @return 结果
     */
    @Override
    public int insertBusiPartsDetails(BusiPartsDetails busiPartsDetails)
    {
        return busiPartsDetailsMapper.insertBusiPartsDetails(busiPartsDetails);
    }

    /**
     * 修改配件报价
     * 
     * @param busiPartsDetails 配件报价
     * @return 结果
     */
    @Override
    public int updateBusiPartsDetails(BusiPartsDetails busiPartsDetails)
    {
        return busiPartsDetailsMapper.updateBusiPartsDetails(busiPartsDetails);
    }

    /**
     * 删除配件报价对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiPartsDetailsByIds(String ids)
    {
        return busiPartsDetailsMapper.deleteBusiPartsDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除配件报价信息
     * 
     * @param detailsId 配件报价ID
     * @return 结果
     */
    @Override
    public int deleteBusiPartsDetailsById(Long detailsId)
    {
        return busiPartsDetailsMapper.deleteBusiPartsDetailsById(detailsId);
    }
}
