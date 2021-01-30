package com.ruoyi.busi.outsourcing.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.outsourcing.mapper.BusiOutsourcingMapper;
import com.ruoyi.busi.outsourcing.domain.BusiOutsourcing;
import com.ruoyi.busi.outsourcing.service.IBusiOutsourcingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 外购产品供应商Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-30
 */
@Service
public class BusiOutsourcingServiceImpl implements IBusiOutsourcingService 
{
    @Autowired
    private BusiOutsourcingMapper busiOutsourcingMapper;

    /**
     * 查询外购产品供应商
     * 
     * @param outsourcingId 外购产品供应商ID
     * @return 外购产品供应商
     */
    @Override
    public BusiOutsourcing selectBusiOutsourcingById(Long outsourcingId)
    {
        return busiOutsourcingMapper.selectBusiOutsourcingById(outsourcingId);
    }

    /**
     * 查询外购产品供应商列表
     * 
     * @param busiOutsourcing 外购产品供应商
     * @return 外购产品供应商
     */
    @Override
    public List<BusiOutsourcing> selectBusiOutsourcingList(BusiOutsourcing busiOutsourcing)
    {
        return busiOutsourcingMapper.selectBusiOutsourcingList(busiOutsourcing);
    }

    /**
     * 新增外购产品供应商
     * 
     * @param busiOutsourcing 外购产品供应商
     * @return 结果
     */
    @Override
    public int insertBusiOutsourcing(BusiOutsourcing busiOutsourcing)
    {
        return busiOutsourcingMapper.insertBusiOutsourcing(busiOutsourcing);
    }

    /**
     * 修改外购产品供应商
     * 
     * @param busiOutsourcing 外购产品供应商
     * @return 结果
     */
    @Override
    public int updateBusiOutsourcing(BusiOutsourcing busiOutsourcing)
    {
        return busiOutsourcingMapper.updateBusiOutsourcing(busiOutsourcing);
    }

    /**
     * 删除外购产品供应商对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiOutsourcingByIds(String ids)
    {
        return busiOutsourcingMapper.deleteBusiOutsourcingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除外购产品供应商信息
     * 
     * @param outsourcingId 外购产品供应商ID
     * @return 结果
     */
    @Override
    public int deleteBusiOutsourcingById(Long outsourcingId)
    {
        return busiOutsourcingMapper.deleteBusiOutsourcingById(outsourcingId);
    }
}
