package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiPriceDetailsMapper;
import com.ruoyi.busi.domain.BusiPriceDetails;
import com.ruoyi.busi.service.IBusiPriceDetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报价单报价明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-28
 */
@Service
public class BusiPriceDetailsServiceImpl implements IBusiPriceDetailsService 
{
    @Autowired
    private BusiPriceDetailsMapper busiPriceDetailsMapper;

    /**
     * 查询报价单报价明细
     * 
     * @param priceDetailsId 报价单报价明细ID
     * @return 报价单报价明细
     */
    @Override
    public BusiPriceDetails selectBusiPriceDetailsById(Long priceDetailsId)
    {
        return busiPriceDetailsMapper.selectBusiPriceDetailsById(priceDetailsId);
    }

    /**
     * 查询报价单报价明细列表
     * 
     * @param busiPriceDetails 报价单报价明细
     * @return 报价单报价明细
     */
    @Override
    public List<BusiPriceDetails> selectBusiPriceDetailsList(BusiPriceDetails busiPriceDetails)
    {
        return busiPriceDetailsMapper.selectBusiPriceDetailsList(busiPriceDetails);
    }

    /**
     * 新增报价单报价明细
     * 
     * @param busiPriceDetails 报价单报价明细
     * @return 结果
     */
    @Override
    public int insertBusiPriceDetails(BusiPriceDetails busiPriceDetails)
    {
        return busiPriceDetailsMapper.insertBusiPriceDetails(busiPriceDetails);
    }

    /**
     * 修改报价单报价明细
     * 
     * @param busiPriceDetails 报价单报价明细
     * @return 结果
     */
    @Override
    public int updateBusiPriceDetails(BusiPriceDetails busiPriceDetails)
    {
        return busiPriceDetailsMapper.updateBusiPriceDetails(busiPriceDetails);
    }

    /**
     * 删除报价单报价明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiPriceDetailsByIds(String ids)
    {
        return busiPriceDetailsMapper.deleteBusiPriceDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报价单报价明细信息
     * 
     * @param priceDetailsId 报价单报价明细ID
     * @return 结果
     */
    @Override
    public int deleteBusiPriceDetailsById(Long priceDetailsId)
    {
        return busiPriceDetailsMapper.deleteBusiPriceDetailsById(priceDetailsId);
    }
}
