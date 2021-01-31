package com.ruoyi.busi.qutsourcing.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.qutsourcing.mapper.BusiOutsourcingDetailsMapper;
import com.ruoyi.busi.qutsourcing.domain.BusiOutsourcingDetails;
import com.ruoyi.busi.qutsourcing.service.IBusiOutsourcingDetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 外购报价明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-30
 */
@Service
public class BusiOutsourcingDetailsServiceImpl implements IBusiOutsourcingDetailsService 
{
    @Autowired
    private BusiOutsourcingDetailsMapper busiOutsourcingDetailsMapper;

    /**
     * 查询外购报价明细
     * 
     * @param detailsId 外购报价明细ID
     * @return 外购报价明细
     */
    @Override
    public BusiOutsourcingDetails selectBusiOutsourcingDetailsById(Long detailsId)
    {
        return busiOutsourcingDetailsMapper.selectBusiOutsourcingDetailsById(detailsId);
    }

    /**
     * 查询外购报价明细列表
     * 
     * @param busiOutsourcingDetails 外购报价明细
     * @return 外购报价明细
     */
    @Override
    public List<BusiOutsourcingDetails> selectBusiOutsourcingDetailsList(BusiOutsourcingDetails busiOutsourcingDetails)
    {
        return busiOutsourcingDetailsMapper.selectBusiOutsourcingDetailsList(busiOutsourcingDetails);
    }

    /**
     * 新增外购报价明细
     * 
     * @param busiOutsourcingDetails 外购报价明细
     * @return 结果
     */
    @Override
    public int insertBusiOutsourcingDetails(BusiOutsourcingDetails busiOutsourcingDetails)
    {
        return busiOutsourcingDetailsMapper.insertBusiOutsourcingDetails(busiOutsourcingDetails);
    }

    /**
     * 修改外购报价明细
     * 
     * @param busiOutsourcingDetails 外购报价明细
     * @return 结果
     */
    @Override
    public int updateBusiOutsourcingDetails(BusiOutsourcingDetails busiOutsourcingDetails)
    {
        return busiOutsourcingDetailsMapper.updateBusiOutsourcingDetails(busiOutsourcingDetails);
    }

    /**
     * 删除外购报价明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiOutsourcingDetailsByIds(String ids)
    {
        return busiOutsourcingDetailsMapper.deleteBusiOutsourcingDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除外购报价明细信息
     * 
     * @param detailsId 外购报价明细ID
     * @return 结果
     */
    @Override
    public int deleteBusiOutsourcingDetailsById(Long detailsId)
    {
        return busiOutsourcingDetailsMapper.deleteBusiOutsourcingDetailsById(detailsId);
    }
}
