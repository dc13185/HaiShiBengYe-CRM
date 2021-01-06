package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiProductModelMapper;
import com.ruoyi.busi.domain.BusiProductModel;
import com.ruoyi.busi.service.IBusiProductModelService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产品模型管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
@Service
public class BusiProductModelServiceImpl implements IBusiProductModelService 
{
    @Autowired
    private BusiProductModelMapper busiProductModelMapper;

    /**
     * 查询产品模型管理
     * 
     * @param modelId 产品模型管理ID
     * @return 产品模型管理
     */
    @Override
    public BusiProductModel selectBusiProductModelById(Long modelId)
    {
        return busiProductModelMapper.selectBusiProductModelById(modelId);
    }

    /**
     * 查询产品模型管理列表
     * 
     * @param busiProductModel 产品模型管理
     * @return 产品模型管理
     */
    @Override
    public List<BusiProductModel> selectBusiProductModelList(BusiProductModel busiProductModel)
    {
        return busiProductModelMapper.selectBusiProductModelList(busiProductModel);
    }

    /**
     * 新增产品模型管理
     * 
     * @param busiProductModel 产品模型管理
     * @return 结果
     */
    @Override
    public int insertBusiProductModel(BusiProductModel busiProductModel)
    {
        return busiProductModelMapper.insertBusiProductModel(busiProductModel);
    }

    /**
     * 修改产品模型管理
     * 
     * @param busiProductModel 产品模型管理
     * @return 结果
     */
    @Override
    public int updateBusiProductModel(BusiProductModel busiProductModel)
    {
        return busiProductModelMapper.updateBusiProductModel(busiProductModel);
    }

    /**
     * 删除产品模型管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiProductModelByIds(String ids)
    {
        return busiProductModelMapper.deleteBusiProductModelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品模型管理信息
     * 
     * @param modelId 产品模型管理ID
     * @return 结果
     */
    @Override
    public int deleteBusiProductModelById(Long modelId)
    {
        return busiProductModelMapper.deleteBusiProductModelById(modelId);
    }
}
