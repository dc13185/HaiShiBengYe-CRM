package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.BusiSystem;

/**
 * 机封系统管理Mapper接口
 *
 * @author ruoyi
 * @date 2021-01-09
 */
public interface BusiSystemMapper
{
    /**
     * 查询机封系统管理
     *
     * @param systemId 机封系统管理ID
     * @return 机封系统管理
     */
    public BusiSystem selectBusiSystemById(Long systemId);

    /**
     * 查询机封系统管理列表
     *
     * @param busiSystem 机封系统管理
     * @return 机封系统管理集合
     */
    public List<BusiSystem> selectBusiSystemList(BusiSystem busiSystem);

    /**
     * 新增机封系统管理
     *
     * @param busiSystem 机封系统管理
     * @return 结果
     */
    public int insertBusiSystem(BusiSystem busiSystem);

    /**
     * 修改机封系统管理
     *
     * @param busiSystem 机封系统管理
     * @return 结果
     */
    public int updateBusiSystem(BusiSystem busiSystem);

    /**
     * 删除机封系统管理
     *
     * @param systemId 机封系统管理ID
     * @return 结果
     */
    public int deleteBusiSystemById(Long systemId);

    /**
     * 批量删除机封系统管理
     *
     * @param systemIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiSystemByIds(String[] systemIds);
}
