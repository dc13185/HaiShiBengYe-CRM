package com.ruoyi.busi.service;

import java.util.List;
import com.ruoyi.busi.domain.BusiTechnicist;

/**
 * 选型技术人员管理Service接口
 * 
 * @author ruoyi
 * @date 2021-01-20
 */
public interface IBusiTechnicistService 
{
    /**
     * 查询选型技术人员管理
     * 
     * @param technicistId 选型技术人员管理ID
     * @return 选型技术人员管理
     */
    public BusiTechnicist selectBusiTechnicistById(Long technicistId);

    /**
     * 查询选型技术人员管理列表
     * 
     * @param busiTechnicist 选型技术人员管理
     * @return 选型技术人员管理集合
     */
    public List<BusiTechnicist> selectBusiTechnicistList(BusiTechnicist busiTechnicist);

    /**
     * 新增选型技术人员管理
     * 
     * @param busiTechnicist 选型技术人员管理
     * @return 结果
     */
    public int insertBusiTechnicist(BusiTechnicist busiTechnicist);

    /**
     * 修改选型技术人员管理
     * 
     * @param busiTechnicist 选型技术人员管理
     * @return 结果
     */
    public int updateBusiTechnicist(BusiTechnicist busiTechnicist);

    /**
     * 批量删除选型技术人员管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiTechnicistByIds(String ids);

    /**
     * 删除选型技术人员管理信息
     * 
     * @param technicistId 选型技术人员管理ID
     * @return 结果
     */
    public int deleteBusiTechnicistById(Long technicistId);
}
