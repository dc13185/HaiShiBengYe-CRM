package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiSupplierAnnexMapper;
import com.ruoyi.busi.domain.BusiSupplierAnnex;
import com.ruoyi.busi.service.IBusiSupplierAnnexService;
import com.ruoyi.common.core.text.Convert;

/**
 * 供应商附件中间Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-29
 */
@Service
public class BusiSupplierAnnexServiceImpl implements IBusiSupplierAnnexService 
{
    @Autowired
    private BusiSupplierAnnexMapper busiSupplierAnnexMapper;

    /**
     * 查询供应商附件中间
     * 
     * @param id 供应商附件中间ID
     * @return 供应商附件中间
     */
    @Override
    public BusiSupplierAnnex selectBusiSupplierAnnexById(Long id)
    {
        return busiSupplierAnnexMapper.selectBusiSupplierAnnexById(id);
    }

    /**
     * 查询供应商附件中间列表
     * 
     * @param busiSupplierAnnex 供应商附件中间
     * @return 供应商附件中间
     */
    @Override
    public List<BusiSupplierAnnex> selectBusiSupplierAnnexList(BusiSupplierAnnex busiSupplierAnnex)
    {
        return busiSupplierAnnexMapper.selectBusiSupplierAnnexList(busiSupplierAnnex);
    }

    /**
     * 新增供应商附件中间
     * 
     * @param busiSupplierAnnex 供应商附件中间
     * @return 结果
     */
    @Override
    public int insertBusiSupplierAnnex(BusiSupplierAnnex busiSupplierAnnex)
    {
        return busiSupplierAnnexMapper.insertBusiSupplierAnnex(busiSupplierAnnex);
    }

    /**
     * 修改供应商附件中间
     * 
     * @param busiSupplierAnnex 供应商附件中间
     * @return 结果
     */
    @Override
    public int updateBusiSupplierAnnex(BusiSupplierAnnex busiSupplierAnnex)
    {
        return busiSupplierAnnexMapper.updateBusiSupplierAnnex(busiSupplierAnnex);
    }

    /**
     * 删除供应商附件中间对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiSupplierAnnexByIds(String ids)
    {
        return busiSupplierAnnexMapper.deleteBusiSupplierAnnexByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商附件中间信息
     * 
     * @param id 供应商附件中间ID
     * @return 结果
     */
    @Override
    public int deleteBusiSupplierAnnexById(Long id)
    {
        return busiSupplierAnnexMapper.deleteBusiSupplierAnnexById(id);
    }
}
