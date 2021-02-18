package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiQuotationMapper;
import com.ruoyi.busi.domain.BusiQuotation;
import com.ruoyi.busi.service.IBusiQuotationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报价单管理Service业务层处理
 *
 * @author ruoyi
 * @date 2021-01-12
 */
@Service
public class BusiQuotationServiceImpl implements IBusiQuotationService
{
    @Autowired
    private BusiQuotationMapper busiQuotationMapper;

    /**
     * 查询报价单管理
     *
     * @param quotationId 报价单管理ID
     * @return 报价单管理
     */
    @Override
    public BusiQuotation selectBusiQuotationById(Long quotationId)
    {
        return busiQuotationMapper.selectBusiQuotationById(quotationId);
    }

    /**
     * 查询报价单管理列表
     *
     * @param busiQuotation 报价单管理
     * @return 报价单管理
     */
    @Override
    public List<BusiQuotation> selectBusiQuotationList(BusiQuotation busiQuotation)
    {
        return busiQuotationMapper.selectBusiQuotationList(busiQuotation);
    }

    /**
     * 新增报价单管理
     *
     * @param busiQuotation 报价单管理
     * @return 结果
     */
    @Override
    public int insertBusiQuotation(BusiQuotation busiQuotation)
    {
        return busiQuotationMapper.insertBusiQuotation(busiQuotation);
    }

    /**
     * 修改报价单管理
     *
     * @param busiQuotation 报价单管理
     * @return 结果
     */
    @Override
    public int updateBusiQuotation(BusiQuotation busiQuotation)
    {
        return busiQuotationMapper.updateBusiQuotation(busiQuotation);
    }

    /**
     * 删除报价单管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiQuotationByIds(String ids)
    {
        return busiQuotationMapper.deleteBusiQuotationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报价单管理信息
     *
     * @param quotationId 报价单管理ID
     * @return 结果
     */
    @Override
    public int deleteBusiQuotationById(Long quotationId)
    {
        return busiQuotationMapper.deleteBusiQuotationById(quotationId);
    }

    @Override
    public Integer selectEndCount(String province){
        return busiQuotationMapper.selectEndCount(province);
    }
}
