package com.ruoyi.busi.service;

import java.util.List;
import com.ruoyi.busi.domain.MaterialSupplier;

/**
 * 材料供应商Service接口
 *
 * @author ruoyi
 * @date 2020-12-25
 */
public interface IMaterialSupplierService
{
    /**
     * 查询材料供应商
     *
     * @param supplierId 材料供应商ID
     * @return 材料供应商
     */
    public MaterialSupplier selectMaterialSupplierById(String supplierId);

    /**
     * 查询材料供应商列表
     *
     * @param materialSupplier 材料供应商
     * @return 材料供应商集合
     */
    public List<MaterialSupplier> selectMaterialSupplierList(MaterialSupplier materialSupplier);

    /**
     * 新增材料供应商
     *
     * @param materialSupplier 材料供应商
     * @return 结果
     */
    public int insertMaterialSupplier(MaterialSupplier materialSupplier);

    /**
     * 修改材料供应商
     *
     * @param materialSupplier 材料供应商
     * @return 结果
     */
    public int updateMaterialSupplier(MaterialSupplier materialSupplier);

    /**
     * 批量删除材料供应商
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialSupplierByIds(String ids);

    /**
     * 删除材料供应商信息
     *
     * @param supplierId 材料供应商ID
     * @return 结果
     */
    public int deleteMaterialSupplierById(String supplierId);
}
