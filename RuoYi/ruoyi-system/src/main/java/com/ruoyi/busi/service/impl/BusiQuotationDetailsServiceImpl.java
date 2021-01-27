package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiQuotationDetailsMapper;
import com.ruoyi.busi.domain.BusiQuotationDetails;
import com.ruoyi.busi.service.IBusiQuotationDetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报价明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-14
 */
@Service
public class BusiQuotationDetailsServiceImpl implements IBusiQuotationDetailsService 
{
    @Autowired
    private BusiQuotationDetailsMapper busiQuotationDetailsMapper;

    /**
     * 查询报价明细
     * 
     * @param detailsId 报价明细ID
     * @return 报价明细
     */
    @Override
    public BusiQuotationDetails selectBusiQuotationDetailsById(Long detailsId)
    {
        return busiQuotationDetailsMapper.selectBusiQuotationDetailsById(detailsId);
    }

    /**
     * 查询报价明细列表
     * 
     * @param busiQuotationDetails 报价明细
     * @return 报价明细
     */
    @Override
    public List<BusiQuotationDetails> selectBusiQuotationDetailsList(BusiQuotationDetails busiQuotationDetails)
    {
        return busiQuotationDetailsMapper.selectBusiQuotationDetailsList(busiQuotationDetails);
    }

    /**
     * 新增报价明细
     * 
     * @param busiQuotationDetails 报价明细
     * @return 结果
     */
    @Override
    public int insertBusiQuotationDetails(BusiQuotationDetails busiQuotationDetails)
    {
        return busiQuotationDetailsMapper.insertBusiQuotationDetails(busiQuotationDetails);
    }

    /**
     * 修改报价明细
     * 
     * @param busiQuotationDetails 报价明细
     * @return 结果
     */
    @Override
    public int updateBusiQuotationDetails(BusiQuotationDetails busiQuotationDetails)
    {
        return busiQuotationDetailsMapper.updateBusiQuotationDetails(busiQuotationDetails);
    }

    /**
     * 删除报价明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiQuotationDetailsByIds(String ids)
    {
        return busiQuotationDetailsMapper.deleteBusiQuotationDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报价明细信息
     * 
     * @param detailsId 报价明细ID
     * @return 结果
     */
    @Override
    public int deleteBusiQuotationDetailsById(Long detailsId)
    {
        return busiQuotationDetailsMapper.deleteBusiQuotationDetailsById(detailsId);
    }
}
