package com.ruoyi.busi.contract.mapper;

import java.util.List;
import com.ruoyi.busi.contract.domain.BusiContractProduct;

/**
 * 合同产品组成Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-03
 */
public interface BusiContractProductMapper 
{
    /**
     * 查询合同产品组成
     * 
     * @param product 合同产品组成ID
     * @return 合同产品组成
     */
    public BusiContractProduct selectBusiContractProductById(Long product);

    /**
     * 查询合同产品组成列表
     * 
     * @param busiContractProduct 合同产品组成
     * @return 合同产品组成集合
     */
    public List<BusiContractProduct> selectBusiContractProductList(BusiContractProduct busiContractProduct);

    /**
     * 新增合同产品组成
     * 
     * @param busiContractProduct 合同产品组成
     * @return 结果
     */
    public int insertBusiContractProduct(BusiContractProduct busiContractProduct);

    /**
     * 修改合同产品组成
     * 
     * @param busiContractProduct 合同产品组成
     * @return 结果
     */
    public int updateBusiContractProduct(BusiContractProduct busiContractProduct);

    /**
     * 删除合同产品组成
     * 
     * @param product 合同产品组成ID
     * @return 结果
     */
    public int deleteBusiContractProductById(Long product);

    /**
     * 批量删除合同产品组成
     * 
     * @param products 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiContractProductByIds(String[] products);
}
