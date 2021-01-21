package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiPriceMapper;
import com.ruoyi.busi.domain.BusiPrice;
import com.ruoyi.busi.service.IBusiPriceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 变价变量Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-20
 */
@Service
public class BusiPriceServiceImpl implements IBusiPriceService 
{
    @Autowired
    private BusiPriceMapper busiPriceMapper;

    /**
     * 查询变价变量
     * 
     * @param priceId 变价变量ID
     * @return 变价变量
     */
    @Override
    public BusiPrice selectBusiPriceById(Long priceId)
    {
        return busiPriceMapper.selectBusiPriceById(priceId);
    }

    /**
     * 查询变价变量列表
     * 
     * @param busiPrice 变价变量
     * @return 变价变量
     */
    @Override
    public List<BusiPrice> selectBusiPriceList(BusiPrice busiPrice)
    {
        return busiPriceMapper.selectBusiPriceList(busiPrice);
    }

    /**
     * 新增变价变量
     * 
     * @param busiPrice 变价变量
     * @return 结果
     */
    @Override
    public int insertBusiPrice(BusiPrice busiPrice)
    {
        return busiPriceMapper.insertBusiPrice(busiPrice);
    }

    /**
     * 修改变价变量
     * 
     * @param busiPrice 变价变量
     * @return 结果
     */
    @Override
    public int updateBusiPrice(BusiPrice busiPrice)
    {
        return busiPriceMapper.updateBusiPrice(busiPrice);
    }

    /**
     * 删除变价变量对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiPriceByIds(String ids)
    {
        return busiPriceMapper.deleteBusiPriceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除变价变量信息
     * 
     * @param priceId 变价变量ID
     * @return 结果
     */
    @Override
    public int deleteBusiPriceById(Long priceId)
    {
        return busiPriceMapper.deleteBusiPriceById(priceId);
    }
}
