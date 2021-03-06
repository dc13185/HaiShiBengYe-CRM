package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.BusiCustomer;

/**
 * 客户管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
public interface BusiCustomerMapper 
{
    /**
     * 查询客户管理
     * 
     * @param customerId 客户管理ID
     * @return 客户管理
     */
    public BusiCustomer selectBusiCustomerById(Long customerId);

    /**
     * 查询客户管理列表
     * 
     * @param busiCustomer 客户管理
     * @return 客户管理集合
     */
    public List<BusiCustomer> selectBusiCustomerList(BusiCustomer busiCustomer);

    /**
     * 新增客户管理
     * 
     * @param busiCustomer 客户管理
     * @return 结果
     */
    public int insertBusiCustomer(BusiCustomer busiCustomer);

    /**
     * 修改客户管理
     * 
     * @param busiCustomer 客户管理
     * @return 结果
     */
    public int updateBusiCustomer(BusiCustomer busiCustomer);

    /**
     * 删除客户管理
     * 
     * @param customerId 客户管理ID
     * @return 结果
     */
    public int deleteBusiCustomerById(Long customerId);

    /**
     * 批量删除客户管理
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiCustomerByIds(String[] customerIds);
}
