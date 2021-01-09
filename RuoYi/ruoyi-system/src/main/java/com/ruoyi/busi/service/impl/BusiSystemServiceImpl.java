package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiSystemMapper;
import com.ruoyi.busi.domain.BusiSystem;
import com.ruoyi.busi.service.IBusiSystemService;
import com.ruoyi.common.core.text.Convert;

/**
 * 机封系统管理Service业务层处理
 *
 * @author ruoyi
 * @date 2021-01-09
 */
@Service
public class BusiSystemServiceImpl implements IBusiSystemService
{
    @Autowired
    private BusiSystemMapper busiSystemMapper;

    /**
     * 查询机封系统管理
     *
     * @param systemId 机封系统管理ID
     * @return 机封系统管理
     */
    @Override
    public BusiSystem selectBusiSystemById(Long systemId)
    {
        return busiSystemMapper.selectBusiSystemById(systemId);
    }

    /**
     * 查询机封系统管理列表
     *
     * @param busiSystem 机封系统管理
     * @return 机封系统管理
     */
    @Override
    public List<BusiSystem> selectBusiSystemList(BusiSystem busiSystem)
    {
        return busiSystemMapper.selectBusiSystemList(busiSystem);
    }

    /**
     * 新增机封系统管理
     *
     * @param busiSystem 机封系统管理
     * @return 结果
     */
    @Override
    public int insertBusiSystem(BusiSystem busiSystem)
    {
        return busiSystemMapper.insertBusiSystem(busiSystem);
    }

    /**
     * 修改机封系统管理
     *
     * @param busiSystem 机封系统管理
     * @return 结果
     */
    @Override
    public int updateBusiSystem(BusiSystem busiSystem)
    {
        return busiSystemMapper.updateBusiSystem(busiSystem);
    }

    /**
     * 删除机封系统管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiSystemByIds(String ids)
    {
        return busiSystemMapper.deleteBusiSystemByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除机封系统管理信息
     *
     * @param systemId 机封系统管理ID
     * @return 结果
     */
    @Override
    public int deleteBusiSystemById(Long systemId)
    {
        return busiSystemMapper.deleteBusiSystemById(systemId);
    }
}
