package com.ruoyi.busi.service;

import java.util.List;
import com.ruoyi.busi.domain.BusiSeal;

/**
 * 冲洗方案管理Service接口
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
public interface IBusiSealService 
{
    /**
     * 查询冲洗方案管理
     * 
     * @param sealId 冲洗方案管理ID
     * @return 冲洗方案管理
     */
    public BusiSeal selectBusiSealById(Long sealId);

    /**
     * 查询冲洗方案管理列表
     * 
     * @param busiSeal 冲洗方案管理
     * @return 冲洗方案管理集合
     */
    public List<BusiSeal> selectBusiSealList(BusiSeal busiSeal);

    /**
     * 新增冲洗方案管理
     * 
     * @param busiSeal 冲洗方案管理
     * @return 结果
     */
    public int insertBusiSeal(BusiSeal busiSeal);

    /**
     * 修改冲洗方案管理
     * 
     * @param busiSeal 冲洗方案管理
     * @return 结果
     */
    public int updateBusiSeal(BusiSeal busiSeal);

    /**
     * 批量删除冲洗方案管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiSealByIds(String ids);

    /**
     * 删除冲洗方案管理信息
     * 
     * @param sealId 冲洗方案管理ID
     * @return 结果
     */
    public int deleteBusiSealById(Long sealId);
}
