package com.ruoyi.busi.outsourcing.service;

import java.util.List;
import com.ruoyi.busi.outsourcing.domain.BusiOutsourcing;

/**
 * 外购产品供应商Service接口
 * 
 * @author ruoyi
 * @date 2021-01-30
 */
public interface IBusiOutsourcingService 
{
    /**
     * 查询外购产品供应商
     * 
     * @param outsourcingId 外购产品供应商ID
     * @return 外购产品供应商
     */
    public BusiOutsourcing selectBusiOutsourcingById(Long outsourcingId);

    /**
     * 查询外购产品供应商列表
     * 
     * @param busiOutsourcing 外购产品供应商
     * @return 外购产品供应商集合
     */
    public List<BusiOutsourcing> selectBusiOutsourcingList(BusiOutsourcing busiOutsourcing);

    /**
     * 新增外购产品供应商
     * 
     * @param busiOutsourcing 外购产品供应商
     * @return 结果
     */
    public int insertBusiOutsourcing(BusiOutsourcing busiOutsourcing);

    /**
     * 修改外购产品供应商
     * 
     * @param busiOutsourcing 外购产品供应商
     * @return 结果
     */
    public int updateBusiOutsourcing(BusiOutsourcing busiOutsourcing);

    /**
     * 批量删除外购产品供应商
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiOutsourcingByIds(String ids);

    /**
     * 删除外购产品供应商信息
     * 
     * @param outsourcingId 外购产品供应商ID
     * @return 结果
     */
    public int deleteBusiOutsourcingById(Long outsourcingId);
}
