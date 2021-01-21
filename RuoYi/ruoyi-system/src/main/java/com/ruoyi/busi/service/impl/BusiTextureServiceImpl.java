package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiTextureMapper;
import com.ruoyi.busi.domain.BusiTexture;
import com.ruoyi.busi.service.IBusiTextureService;
import com.ruoyi.common.core.text.Convert;

/**
 * 材质管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-21
 */
@Service
public class BusiTextureServiceImpl implements IBusiTextureService 
{
    @Autowired
    private BusiTextureMapper busiTextureMapper;

    /**
     * 查询材质管理
     * 
     * @param textureId 材质管理ID
     * @return 材质管理
     */
    @Override
    public BusiTexture selectBusiTextureById(Long textureId)
    {
        return busiTextureMapper.selectBusiTextureById(textureId);
    }

    /**
     * 查询材质管理列表
     * 
     * @param busiTexture 材质管理
     * @return 材质管理
     */
    @Override
    public List<BusiTexture> selectBusiTextureList(BusiTexture busiTexture)
    {
        return busiTextureMapper.selectBusiTextureList(busiTexture);
    }

    /**
     * 新增材质管理
     * 
     * @param busiTexture 材质管理
     * @return 结果
     */
    @Override
    public int insertBusiTexture(BusiTexture busiTexture)
    {
        return busiTextureMapper.insertBusiTexture(busiTexture);
    }

    /**
     * 修改材质管理
     * 
     * @param busiTexture 材质管理
     * @return 结果
     */
    @Override
    public int updateBusiTexture(BusiTexture busiTexture)
    {
        return busiTextureMapper.updateBusiTexture(busiTexture);
    }

    /**
     * 删除材质管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiTextureByIds(String ids)
    {
        return busiTextureMapper.deleteBusiTextureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除材质管理信息
     * 
     * @param textureId 材质管理ID
     * @return 结果
     */
    @Override
    public int deleteBusiTextureById(Long textureId)
    {
        return busiTextureMapper.deleteBusiTextureById(textureId);
    }
}
