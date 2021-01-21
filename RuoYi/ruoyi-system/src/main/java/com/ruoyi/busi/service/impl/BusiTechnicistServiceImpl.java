package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiTechnicistMapper;
import com.ruoyi.busi.domain.BusiTechnicist;
import com.ruoyi.busi.service.IBusiTechnicistService;
import com.ruoyi.common.core.text.Convert;

/**
 * 选型技术人员管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-20
 */
@Service
public class BusiTechnicistServiceImpl implements IBusiTechnicistService 
{
    @Autowired
    private BusiTechnicistMapper busiTechnicistMapper;

    /**
     * 查询选型技术人员管理
     * 
     * @param technicistId 选型技术人员管理ID
     * @return 选型技术人员管理
     */
    @Override
    public BusiTechnicist selectBusiTechnicistById(Long technicistId)
    {
        return busiTechnicistMapper.selectBusiTechnicistById(technicistId);
    }

    /**
     * 查询选型技术人员管理列表
     * 
     * @param busiTechnicist 选型技术人员管理
     * @return 选型技术人员管理
     */
    @Override
    public List<BusiTechnicist> selectBusiTechnicistList(BusiTechnicist busiTechnicist)
    {
        return busiTechnicistMapper.selectBusiTechnicistList(busiTechnicist);
    }

    /**
     * 新增选型技术人员管理
     * 
     * @param busiTechnicist 选型技术人员管理
     * @return 结果
     */
    @Override
    public int insertBusiTechnicist(BusiTechnicist busiTechnicist)
    {
        return busiTechnicistMapper.insertBusiTechnicist(busiTechnicist);
    }

    /**
     * 修改选型技术人员管理
     * 
     * @param busiTechnicist 选型技术人员管理
     * @return 结果
     */
    @Override
    public int updateBusiTechnicist(BusiTechnicist busiTechnicist)
    {
        return busiTechnicistMapper.updateBusiTechnicist(busiTechnicist);
    }

    /**
     * 删除选型技术人员管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiTechnicistByIds(String ids)
    {
        return busiTechnicistMapper.deleteBusiTechnicistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除选型技术人员管理信息
     * 
     * @param technicistId 选型技术人员管理ID
     * @return 结果
     */
    @Override
    public int deleteBusiTechnicistById(Long technicistId)
    {
        return busiTechnicistMapper.deleteBusiTechnicistById(technicistId);
    }
}
