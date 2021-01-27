package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.MaterialSupplierMapper;
import com.ruoyi.busi.domain.MaterialSupplier;
import com.ruoyi.busi.service.IMaterialSupplierService;
import com.ruoyi.common.core.text.Convert;

/**
 * 材料供应商Service业务层处理
 *
 * @author ruoyi
 * @date 2020-12-25
 */
@Service
public class MaterialSupplierServiceImpl implements IMaterialSupplierService
{
    @Autowired
    private MaterialSupplierMapper materialSupplierMapper;

    /**
     * 查询材料供应商
     *
     * @param supplierId 材料供应商ID
     * @return 材料供应商
     */
    @Override
    public MaterialSupplier selectMaterialSupplierById(String supplierId)
    {
        return materialSupplierMapper.selectMaterialSupplierById(supplierId);
    }

    /**
     * 查询材料供应商列表
     *
     * @param materialSupplier 材料供应商
     * @return 材料供应商
     */
    @Override
    public List<MaterialSupplier> selectMaterialSupplierList(MaterialSupplier materialSupplier)
    {
        return materialSupplierMapper.selectMaterialSupplierList(materialSupplier);
    }

    /**
     * 新增材料供应商
     *
     * @param materialSupplier 材料供应商
     * @return 结果
     */
    @Override
    public int insertMaterialSupplier(MaterialSupplier materialSupplier)
    {
        return materialSupplierMapper.insertMaterialSupplier(materialSupplier);
    }

    /**
     * 修改材料供应商
     *
     * @param materialSupplier 材料供应商
     * @return 结果
     */
    @Override
    public int updateMaterialSupplier(MaterialSupplier materialSupplier)
    {
        return materialSupplierMapper.updateMaterialSupplier(materialSupplier);
    }

    /**
     * 删除材料供应商对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialSupplierByIds(String ids)
    {
        return materialSupplierMapper.deleteMaterialSupplierByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除材料供应商信息
     *
     * @param supplierId 材料供应商ID
     * @return 结果
     */
    @Override
    public int deleteMaterialSupplierById(String supplierId)
    {
        return materialSupplierMapper.deleteMaterialSupplierById(supplierId);
    }
}
