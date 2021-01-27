package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiContractMapper;
import com.ruoyi.busi.domain.BusiContract;
import com.ruoyi.busi.service.IBusiContractService;
import com.ruoyi.common.core.text.Convert;

/**
 * 合同管理Service业务层处理
 *
 * @author ruoyi
 * @date 2021-01-25
 */
@Service
public class BusiContractServiceImpl implements IBusiContractService
{
    @Autowired
    private BusiContractMapper busiContractMapper;

    /**
     * 查询合同管理
     *
     * @param contractId 合同管理ID
     * @return 合同管理
     */
    @Override
    public BusiContract selectBusiContractById(Long contractId)
    {
        return busiContractMapper.selectBusiContractById(contractId);
    }

    /**
     * 查询合同管理列表
     *
     * @param busiContract 合同管理
     * @return 合同管理
     */
    @Override
    public List<BusiContract> selectBusiContractList(BusiContract busiContract)
    {
        return busiContractMapper.selectBusiContractList(busiContract);
    }

    /**
     * 新增合同管理
     *
     * @param busiContract 合同管理
     * @return 结果
     */
    @Override
    public int insertBusiContract(BusiContract busiContract)
    {
        return busiContractMapper.insertBusiContract(busiContract);
    }

    /**
     * 修改合同管理
     *
     * @param busiContract 合同管理
     * @return 结果
     */
    @Override
    public int updateBusiContract(BusiContract busiContract)
    {
        return busiContractMapper.updateBusiContract(busiContract);
    }

    /**
     * 删除合同管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiContractByIds(String ids)
    {
        return busiContractMapper.deleteBusiContractByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除合同管理信息
     *
     * @param contractId 合同管理ID
     * @return 结果
     */
    @Override
    public int deleteBusiContractById(Long contractId)
    {
        return busiContractMapper.deleteBusiContractById(contractId);
    }

    @Override
    public int selectCount() {
        return busiContractMapper.selectCount();
    }
}
