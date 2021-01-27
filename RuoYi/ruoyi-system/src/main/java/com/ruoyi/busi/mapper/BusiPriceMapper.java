package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.BusiPrice;

/**
 * 变价变量Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-20
 */
public interface BusiPriceMapper 
{
    /**
     * 查询变价变量
     * 
     * @param priceId 变价变量ID
     * @return 变价变量
     */
    public BusiPrice selectBusiPriceById(Long priceId);

    /**
     * 查询变价变量列表
     * 
     * @param busiPrice 变价变量
     * @return 变价变量集合
     */
    public List<BusiPrice> selectBusiPriceList(BusiPrice busiPrice);

    /**
     * 新增变价变量
     * 
     * @param busiPrice 变价变量
     * @return 结果
     */
    public int insertBusiPrice(BusiPrice busiPrice);

    /**
     * 修改变价变量
     * 
     * @param busiPrice 变价变量
     * @return 结果
     */
    public int updateBusiPrice(BusiPrice busiPrice);

    /**
     * 删除变价变量
     * 
     * @param priceId 变价变量ID
     * @return 结果
     */
    public int deleteBusiPriceById(Long priceId);

    /**
     * 批量删除变价变量
     * 
     * @param priceIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiPriceByIds(String[] priceIds);
}
