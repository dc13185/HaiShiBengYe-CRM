package com.ruoyi.busi.service;

import java.util.List;
import com.ruoyi.busi.domain.BusiQuotation;

/**
 * 报价单管理Service接口
 *
 * @author ruoyi
 * @date 2021-01-12
 */
public interface IBusiQuotationService
{
    /**
     * 查询报价单管理
     *
     * @param quotationId 报价单管理ID
     * @return 报价单管理
     */
    public BusiQuotation selectBusiQuotationById(Long quotationId);

    /**
     * 查询报价单管理列表
     *
     * @param busiQuotation 报价单管理
     * @return 报价单管理集合
     */
    public List<BusiQuotation> selectBusiQuotationList(BusiQuotation busiQuotation);

    /**
     * 新增报价单管理
     *
     * @param busiQuotation 报价单管理
     * @return 结果
     */
    public int insertBusiQuotation(BusiQuotation busiQuotation);

    /**
     * 修改报价单管理
     *
     * @param busiQuotation 报价单管理
     * @return 结果
     */
    public int updateBusiQuotation(BusiQuotation busiQuotation);

    /**
     * 批量删除报价单管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiQuotationByIds(String ids);

    /**
     * 删除报价单管理信息
     *
     * @param quotationId 报价单管理ID
     * @return 结果
     */
    public int deleteBusiQuotationById(Long quotationId);

    public Integer selectEndCount(String province);

    BusiQuotation selectBusiQuotationByIdOnlyId(Long quotationId);
}
