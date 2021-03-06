package com.ruoyi.busi.service;

import java.util.List;
import com.ruoyi.busi.domain.BusiContract;

/**
 * 合同管理Service接口
 *
 * @author ruoyi
 * @date 2021-01-25
 */
public interface IBusiContractService
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
     * 批量删除合同管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiContractByIds(String ids);

    /**
     * 删除合同管理信息
     *
     * @param contractId 合同管理ID
     * @return 结果
     */
    public int deleteBusiContractById(Long contractId);

    public int selectCount();
}
