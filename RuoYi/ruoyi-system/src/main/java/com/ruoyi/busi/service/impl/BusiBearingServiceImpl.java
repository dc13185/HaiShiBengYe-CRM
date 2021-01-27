package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiBearingMapper;
import com.ruoyi.busi.domain.BusiBearing;
import com.ruoyi.busi.service.IBusiBearingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 轴承供应商Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Service
public class BusiBearingServiceImpl implements IBusiBearingService 
{
    @Autowired
    private BusiBearingMapper busiBearingMapper;

    /**
     * 查询轴承供应商
     * 
     * @param bearingId 轴承供应商ID
     * @return 轴承供应商
     */
    @Override
    public BusiBearing selectBusiBearingById(Long bearingId)
    {
        return busiBearingMapper.selectBusiBearingById(bearingId);
    }

    /**
     * 查询轴承供应商列表
     * 
     * @param busiBearing 轴承供应商
     * @return 轴承供应商
     */
    @Override
    public List<BusiBearing> selectBusiBearingList(BusiBearing busiBearing)
    {
        return busiBearingMapper.selectBusiBearingList(busiBearing);
    }

    /**
     * 新增轴承供应商
     * 
     * @param busiBearing 轴承供应商
     * @return 结果
     */
    @Override
    public int insertBusiBearing(BusiBearing busiBearing)
    {
        return busiBearingMapper.insertBusiBearing(busiBearing);
    }

    /**
     * 修改轴承供应商
     * 
     * @param busiBearing 轴承供应商
     * @return 结果
     */
    @Override
    public int updateBusiBearing(BusiBearing busiBearing)
    {
        return busiBearingMapper.updateBusiBearing(busiBearing);
    }

    /**
     * 删除轴承供应商对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiBearingByIds(String ids)
    {
        return busiBearingMapper.deleteBusiBearingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除轴承供应商信息
     * 
     * @param bearingId 轴承供应商ID
     * @return 结果
     */
    @Override
    public int deleteBusiBearingById(Long bearingId)
    {
        return busiBearingMapper.deleteBusiBearingById(bearingId);
    }
}
