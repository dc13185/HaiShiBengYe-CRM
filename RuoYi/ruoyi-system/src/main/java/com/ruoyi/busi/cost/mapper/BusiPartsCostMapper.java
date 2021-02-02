package com.ruoyi.busi.cost.mapper;

import java.util.List;
import com.ruoyi.busi.cost.domain.BusiPartsCost;

/**
 * 配件报价成本明细Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-02
 */
public interface BusiPartsCostMapper 
{
    /**
     * 查询配件报价成本明细
     * 
     * @param costId 配件报价成本明细ID
     * @return 配件报价成本明细
     */
    public BusiPartsCost selectBusiPartsCostById(Long costId);

    /**
     * 查询配件报价成本明细列表
     * 
     * @param busiPartsCost 配件报价成本明细
     * @return 配件报价成本明细集合
     */
    public List<BusiPartsCost> selectBusiPartsCostList(BusiPartsCost busiPartsCost);

    /**
     * 新增配件报价成本明细
     * 
     * @param busiPartsCost 配件报价成本明细
     * @return 结果
     */
    public int insertBusiPartsCost(BusiPartsCost busiPartsCost);

    /**
     * 修改配件报价成本明细
     * 
     * @param busiPartsCost 配件报价成本明细
     * @return 结果
     */
    public int updateBusiPartsCost(BusiPartsCost busiPartsCost);

    /**
     * 删除配件报价成本明细
     * 
     * @param costId 配件报价成本明细ID
     * @return 结果
     */
    public int deleteBusiPartsCostById(Long costId);

    /**
     * 批量删除配件报价成本明细
     * 
     * @param costIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiPartsCostByIds(String[] costIds);
}
