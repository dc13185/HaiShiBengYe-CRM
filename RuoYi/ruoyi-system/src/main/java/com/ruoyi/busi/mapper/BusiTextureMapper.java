package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.BusiTexture;

/**
 * 材质管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-21
 */
public interface BusiTextureMapper 
{
    /**
     * 查询材质管理
     * 
     * @param textureId 材质管理ID
     * @return 材质管理
     */
    public BusiTexture selectBusiTextureById(Long textureId);

    /**
     * 查询材质管理列表
     * 
     * @param busiTexture 材质管理
     * @return 材质管理集合
     */
    public List<BusiTexture> selectBusiTextureList(BusiTexture busiTexture);

    /**
     * 新增材质管理
     * 
     * @param busiTexture 材质管理
     * @return 结果
     */
    public int insertBusiTexture(BusiTexture busiTexture);

    /**
     * 修改材质管理
     * 
     * @param busiTexture 材质管理
     * @return 结果
     */
    public int updateBusiTexture(BusiTexture busiTexture);

    /**
     * 删除材质管理
     * 
     * @param textureId 材质管理ID
     * @return 结果
     */
    public int deleteBusiTextureById(Long textureId);

    /**
     * 批量删除材质管理
     * 
     * @param textureIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiTextureByIds(String[] textureIds);
}
