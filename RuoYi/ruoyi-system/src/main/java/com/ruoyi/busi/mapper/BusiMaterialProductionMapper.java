package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.BusiMaterialProduction;
import org.apache.ibatis.annotations.Param;

/**
 * 材料产品Mapper接口
 *
 * @author ruoyi
 * @date 2021-01-01
 */
public interface BusiMaterialProductionMapper
{
    /**
     * 查询材料产品
     *
     * @param materialId 材料产品ID
     * @return 材料产品
     */
    public BusiMaterialProduction selectBusiMaterialProductionById(Long materialId);

    public BusiMaterialProduction selectBusiMaterialProductionBySupplierId(@Param("supplierId") String supplierId, @Param("type") String type,@Param("materialName") String materialName);

    /**
     * 查询材料产品列表
     *
     * @param busiMaterialProduction 材料产品
     * @return 材料产品集合
     */
    public List<BusiMaterialProduction> selectBusiMaterialProductionList(BusiMaterialProduction busiMaterialProduction);

    public List<BusiMaterialProduction>  selectBusiMaterialProductionListExport(BusiMaterialProduction busiMaterialProduction);


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
     * 删除材料产品
     *
     * @param materialId 材料产品ID
     * @return 结果
     */
    public int deleteBusiMaterialProductionById(Long materialId);

    /**
     * 批量删除材料产品
     *
     * @param materialIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiMaterialProductionByIds(String[] materialIds);
}
