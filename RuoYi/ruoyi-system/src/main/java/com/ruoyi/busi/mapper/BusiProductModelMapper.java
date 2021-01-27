package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.BusiProductModel;

/**
 * 产品模型管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
public interface BusiProductModelMapper 
{
    /**
     * 查询产品模型管理
     * 
     * @param modelId 产品模型管理ID
     * @return 产品模型管理
     */
    public BusiProductModel selectBusiProductModelById(Long modelId);

    /**
     * 查询产品模型管理列表
     * 
     * @param busiProductModel 产品模型管理
     * @return 产品模型管理集合
     */
    public List<BusiProductModel> selectBusiProductModelList(BusiProductModel busiProductModel);

    /**
     * 新增产品模型管理
     * 
     * @param busiProductModel 产品模型管理
     * @return 结果
     */
    public int insertBusiProductModel(BusiProductModel busiProductModel);

    /**
     * 修改产品模型管理
     * 
     * @param busiProductModel 产品模型管理
     * @return 结果
     */
    public int updateBusiProductModel(BusiProductModel busiProductModel);

    /**
     * 删除产品模型管理
     * 
     * @param modelId 产品模型管理ID
     * @return 结果
     */
    public int deleteBusiProductModelById(Long modelId);

    /**
     * 批量删除产品模型管理
     * 
     * @param modelIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiProductModelByIds(String[] modelIds);
}
