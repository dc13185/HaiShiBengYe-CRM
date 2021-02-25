package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.BusiBearing;

/**
 * 轴承供应商Mapper接口
 *
 * @author ruoyi
 * @date 2021-01-04
 */
public interface BusiBearingMapper
{
    /**
     * 查询轴承供应商
     *
     * @param bearingId 轴承供应商ID
     * @return 轴承供应商
     */
    public BusiBearing selectBusiBearingById(Long bearingId);

    /**
     * 查询轴承供应商列表
     *
     * @param busiBearing 轴承供应商
     * @return 轴承供应商集合
     */
    public List<BusiBearing> selectBusiBearingList(BusiBearing busiBearing);

    public List<BusiBearing> selectBusiBearingListExport(BusiBearing busiBearing);



    /**
     * 新增轴承供应商
     *
     * @param busiBearing 轴承供应商
     * @return 结果
     */
    public int insertBusiBearing(BusiBearing busiBearing);

    /**
     * 修改轴承供应商
     *
     * @param busiBearing 轴承供应商
     * @return 结果
     */
    public int updateBusiBearing(BusiBearing busiBearing);

    /**
     * 删除轴承供应商
     *
     * @param bearingId 轴承供应商ID
     * @return 结果
     */
    public int deleteBusiBearingById(Long bearingId);

    /**
     * 批量删除轴承供应商
     *
     * @param bearingIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiBearingByIds(String[] bearingIds);
}
