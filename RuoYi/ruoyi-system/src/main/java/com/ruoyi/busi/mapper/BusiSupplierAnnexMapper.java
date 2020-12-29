package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.BusiSupplierAnnex;

/**
 * 供应商附件中间Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-29
 */
public interface BusiSupplierAnnexMapper 
{
    /**
     * 查询供应商附件中间
     * 
     * @param id 供应商附件中间ID
     * @return 供应商附件中间
     */
    public BusiSupplierAnnex selectBusiSupplierAnnexById(Long id);

    /**
     * 查询供应商附件中间列表
     * 
     * @param busiSupplierAnnex 供应商附件中间
     * @return 供应商附件中间集合
     */
    public List<BusiSupplierAnnex> selectBusiSupplierAnnexList(BusiSupplierAnnex busiSupplierAnnex);

    /**
     * 新增供应商附件中间
     * 
     * @param busiSupplierAnnex 供应商附件中间
     * @return 结果
     */
    public int insertBusiSupplierAnnex(BusiSupplierAnnex busiSupplierAnnex);

    /**
     * 修改供应商附件中间
     * 
     * @param busiSupplierAnnex 供应商附件中间
     * @return 结果
     */
    public int updateBusiSupplierAnnex(BusiSupplierAnnex busiSupplierAnnex);

    /**
     * 删除供应商附件中间
     * 
     * @param id 供应商附件中间ID
     * @return 结果
     */
    public int deleteBusiSupplierAnnexById(Long id);

    /**
     * 批量删除供应商附件中间
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiSupplierAnnexByIds(String[] ids);
}
