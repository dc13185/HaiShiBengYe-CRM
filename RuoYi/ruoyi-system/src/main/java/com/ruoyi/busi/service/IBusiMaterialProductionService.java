package com.ruoyi.busi.service;

import java.util.List;
import com.ruoyi.busi.domain.BusiMaterialProduction;

/**
 * 材料产品Service接口
 * 
 * @author ruoyi
 * @date 2021-01-01
 */
public interface IBusiMaterialProductionService 
{
    /**
     * 查询材料产品
     * 
     * @param materialId 材料产品ID
     * @return 材料产品
     */
    public BusiMaterialProduction selectBusiMaterialProductionById(Long materialId);

    /**
     * 查询材料产品列表
     * 
     * @param busiMaterialProduction 材料产品
     * @return 材料产品集合
     */
    public List<BusiMaterialProduction> selectBusiMaterialProductionList(BusiMaterialProduction busiMaterialProduction);

    /**
     * 新增材料产品
     * 
     * @param busiMaterialProduction 材料产品
     * @return 结果
     */
    public int insertBusiMaterialProduction(BusiMaterialProduction busiMaterialProduction);

    /**
     * 修改材料产品
     * 
     * @param busiMaterialProduction 材料产品
     * @return 结果
     */
    public int updateBusiMaterialProduction(BusiMaterialProduction busiMaterialProduction);

    /**
     * 批量删除材料产品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiMaterialProductionByIds(String ids);

    /**
     * 删除材料产品信息
     * 
     * @param materialId 材料产品ID
     * @return 结果
     */
    public int deleteBusiMaterialProductionById(Long materialId);
}
