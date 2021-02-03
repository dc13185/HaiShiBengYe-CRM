package com.ruoyi.busi.contract.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.contract.mapper.BusiContractProductMapper;
import com.ruoyi.busi.contract.domain.BusiContractProduct;
import com.ruoyi.busi.contract.service.IBusiContractProductService;
import com.ruoyi.common.core.text.Convert;

/**
 * 合同产品组成Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-03
 */
@Service
public class BusiContractProductServiceImpl implements IBusiContractProductService 
{
    @Autowired
    private BusiContractProductMapper busiContractProductMapper;

    /**
     * 查询合同产品组成
     * 
     * @param product 合同产品组成ID
     * @return 合同产品组成
     */
    @Override
    public BusiContractProduct selectBusiContractProductById(Long product)
    {
        return busiContractProductMapper.selectBusiContractProductById(product);
    }

    /**
     * 查询合同产品组成列表
     * 
     * @param busiContractProduct 合同产品组成
     * @return 合同产品组成
     */
    @Override
    public List<BusiContractProduct> selectBusiContractProductList(BusiContractProduct busiContractProduct)
    {
        return busiContractProductMapper.selectBusiContractProductList(busiContractProduct);
    }

    /**
     * 新增合同产品组成
     * 
     * @param busiContractProduct 合同产品组成
     * @return 结果
     */
    @Override
    public int insertBusiContractProduct(BusiContractProduct busiContractProduct)
    {
        return busiContractProductMapper.insertBusiContractProduct(busiContractProduct);
    }

    /**
     * 修改合同产品组成
     * 
     * @param busiContractProduct 合同产品组成
     * @return 结果
     */
    @Override
    public int updateBusiContractProduct(BusiContractProduct busiContractProduct)
    {
        return busiContractProductMapper.updateBusiContractProduct(busiContractProduct);
    }

    /**
     * 删除合同产品组成对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiContractProductByIds(String ids)
    {
        return busiContractProductMapper.deleteBusiContractProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除合同产品组成信息
     * 
     * @param product 合同产品组成ID
     * @return 结果
     */
    @Override
    public int deleteBusiContractProductById(Long product)
    {
        return busiContractProductMapper.deleteBusiContractProductById(product);
    }
}
