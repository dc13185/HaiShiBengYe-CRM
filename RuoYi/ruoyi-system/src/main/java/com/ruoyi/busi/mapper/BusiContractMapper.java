package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.BusiContract;

/**
 * 合同管理Mapper接口
 *
 * @author ruoyi
 * @date 2021-01-25
 */
public interface BusiContractMapper
{
    /**
     * 查询合同管理
     *
     * @param contractId 合同管理ID
     * @return 合同管理
     */
    public BusiContract selectBusiContractById(Long contractId);

    /**
     * 查询合同管理列表
     *
     * @param busiContract 合同管理
     * @return 合同管理集合
     */
    public List<BusiContract> selectBusiContractList(BusiContract busiContract);

    /**
     * 新增合同管理
     *
     * @param busiContract 合同管理
     * @return 结果
     */
    public int insertBusiContract(BusiContract busiContract);

    /**
     * 修改合同管理
     *
     * @param busiContract 合同管理
     * @return 结果
     */
    public int updateBusiContract(BusiContract busiContract);

    /**
     * 删除合同管理
     *
     * @param contractId 合同管理ID
     * @return 结果
     */
    public int deleteBusiContractById(Long contractId);

    /**
     * 批量删除合同管理
     *
     * @param contractIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiContractByIds(String[] contractIds);

    public int selectCount();
}

