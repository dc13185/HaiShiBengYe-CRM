package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiCustomerMapper;
import com.ruoyi.busi.domain.BusiCustomer;
import com.ruoyi.busi.service.IBusiCustomerService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
@Service
public class BusiCustomerServiceImpl implements IBusiCustomerService 
{
    @Autowired
    private BusiCustomerMapper busiCustomerMapper;

    /**
     * 查询客户管理
     * 
     * @param customerId 客户管理ID
     * @return 客户管理
     */
    @Override
    public BusiCustomer selectBusiCustomerById(Long customerId)
    {
        return busiCustomerMapper.selectBusiCustomerById(customerId);
    }

    /**
     * 查询客户管理列表
     * 
     * @param busiCustomer 客户管理
     * @return 客户管理
     */
    @Override
    public List<BusiCustomer> selectBusiCustomerList(BusiCustomer busiCustomer)
    {
        return busiCustomerMapper.selectBusiCustomerList(busiCustomer);
    }

    /**
     * 新增客户管理
     * 
     * @param busiCustomer 客户管理
     * @return 结果
     */
    @Override
    public int insertBusiCustomer(BusiCustomer busiCustomer)
    {
        return busiCustomerMapper.insertBusiCustomer(busiCustomer);
    }

    /**
     * 修改客户管理
     * 
     * @param busiCustomer 客户管理
     * @return 结果
     */
    @Override
    public int updateBusiCustomer(BusiCustomer busiCustomer)
    {
        return busiCustomerMapper.updateBusiCustomer(busiCustomer);
    }

    /**
     * 删除客户管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiCustomerByIds(String ids)
    {
        return busiCustomerMapper.deleteBusiCustomerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户管理信息
     * 
     * @param customerId 客户管理ID
     * @return 结果
     */
    @Override
    public int deleteBusiCustomerById(Long customerId)
    {
        return busiCustomerMapper.deleteBusiCustomerById(customerId);
    }
}
