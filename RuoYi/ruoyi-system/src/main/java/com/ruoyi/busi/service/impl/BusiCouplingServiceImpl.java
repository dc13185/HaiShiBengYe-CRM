package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiCouplingMapper;
import com.ruoyi.busi.domain.BusiCoupling;
import com.ruoyi.busi.service.IBusiCouplingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 联轴器Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Service
public class BusiCouplingServiceImpl implements IBusiCouplingService 
{
    @Autowired
    private BusiCouplingMapper busiCouplingMapper;

    /**
     * 查询联轴器
     * 
     * @param couplingId 联轴器ID
     * @return 联轴器
     */
    @Override
    public BusiCoupling selectBusiCouplingById(Long couplingId)
    {
        return busiCouplingMapper.selectBusiCouplingById(couplingId);
    }

    /**
     * 查询联轴器列表
     * 
     * @param busiCoupling 联轴器
     * @return 联轴器
     */
    @Override
    public List<BusiCoupling> selectBusiCouplingList(BusiCoupling busiCoupling)
    {
        return busiCouplingMapper.selectBusiCouplingList(busiCoupling);
    }

    /**
     * 新增联轴器
     * 
     * @param busiCoupling 联轴器
     * @return 结果
     */
    @Override
    public int insertBusiCoupling(BusiCoupling busiCoupling)
    {
        return busiCouplingMapper.insertBusiCoupling(busiCoupling);
    }

    /**
     * 修改联轴器
     * 
     * @param busiCoupling 联轴器
     * @return 结果
     */
    @Override
    public int updateBusiCoupling(BusiCoupling busiCoupling)
    {
        return busiCouplingMapper.updateBusiCoupling(busiCoupling);
    }

    /**
     * 删除联轴器对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiCouplingByIds(String ids)
    {
        return busiCouplingMapper.deleteBusiCouplingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除联轴器信息
     * 
     * @param couplingId 联轴器ID
     * @return 结果
     */
    @Override
    public int deleteBusiCouplingById(Long couplingId)
    {
        return busiCouplingMapper.deleteBusiCouplingById(couplingId);
    }
}
