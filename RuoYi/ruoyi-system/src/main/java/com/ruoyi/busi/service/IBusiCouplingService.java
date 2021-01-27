package com.ruoyi.busi.service;

import java.util.List;
import com.ruoyi.busi.domain.BusiCoupling;

/**
 * 联轴器Service接口
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public interface IBusiCouplingService 
{
    /**
     * 查询联轴器
     * 
     * @param couplingId 联轴器ID
     * @return 联轴器
     */
    public BusiCoupling selectBusiCouplingById(Long couplingId);

    /**
     * 查询联轴器列表
     * 
     * @param busiCoupling 联轴器
     * @return 联轴器集合
     */
    public List<BusiCoupling> selectBusiCouplingList(BusiCoupling busiCoupling);

    /**
     * 新增联轴器
     * 
     * @param busiCoupling 联轴器
     * @return 结果
     */
    public int insertBusiCoupling(BusiCoupling busiCoupling);

    /**
     * 修改联轴器
     * 
     * @param busiCoupling 联轴器
     * @return 结果
     */
    public int updateBusiCoupling(BusiCoupling busiCoupling);

    /**
     * 批量删除联轴器
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiCouplingByIds(String ids);

    /**
     * 删除联轴器信息
     * 
     * @param couplingId 联轴器ID
     * @return 结果
     */
    public int deleteBusiCouplingById(Long couplingId);
}
