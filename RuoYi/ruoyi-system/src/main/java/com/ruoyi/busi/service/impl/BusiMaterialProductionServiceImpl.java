package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiMaterialProductionMapper;
import com.ruoyi.busi.domain.BusiMaterialProduction;
import com.ruoyi.busi.service.IBusiMaterialProductionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 材料产品Service业务层处理
 *
 * @author ruoyi
 * @date 2021-01-01
 */
@Service
public class BusiMaterialProductionServiceImpl implements IBusiMaterialProductionService
{
    @Autowired
    private BusiMaterialProductionMapper busiMaterialProductionMapper;

    /**
     * 查询材料产品
     *
     * @param materialId 材料产品ID
     * @return 材料产品
     */
    @Override
    public BusiMaterialProduction selectBusiMaterialProductionById(Long materialId)
    {
        return busiMaterialProductionMapper.selectBusiMaterialProductionById(materialId);
    }


    @Override
    public BusiMaterialProduction selectBusiMaterialProductionBySupplierId(String supplierId,String type)
    {
        return busiMaterialProductionMapper.selectBusiMaterialProductionBySupplierId(supplierId, type);
    }

    /**
     * 查询材料产品列表
     *
     * @param busiMaterialProduction 材料产品
     * @return 材料产品
     */
    @Override
    public List<BusiMaterialProduction> selectBusiMaterialProductionList(BusiMaterialProduction busiMaterialProduction)
    {
        return busiMaterialProductionMapper.selectBusiMaterialProductionList(busiMaterialProduction);
    }

    /**
     * 新增材料产品
     *
     * @param busiMaterialProduction 材料产品
     * @return 结果
     */
    @Override
    public int insertBusiMaterialProduction(BusiMaterialProduction busiMaterialProduction)
    {
        return busiMaterialProductionMapper.insertBusiMaterialProduction(busiMaterialProduction);
    }

    /**
     * 修改材料产品
     *
     * @param busiMaterialProduction 材料产品
     * @return 结果
     */
    @Override
    public int updateBusiMaterialProduction(BusiMaterialProduction busiMaterialProduction)
    {
        return busiMaterialProductionMapper.updateBusiMaterialProduction(busiMaterialProduction);
    }

    /**
     * 删除材料产品对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiMaterialProductionByIds(String ids)
    {
        return busiMaterialProductionMapper.deleteBusiMaterialProductionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除材料产品信息
     *
     * @param materialId 材料产品ID
     * @return 结果
     */
    @Override
    public int deleteBusiMaterialProductionById(Long materialId)
    {
        return busiMaterialProductionMapper.deleteBusiMaterialProductionById(materialId);
    }
}
