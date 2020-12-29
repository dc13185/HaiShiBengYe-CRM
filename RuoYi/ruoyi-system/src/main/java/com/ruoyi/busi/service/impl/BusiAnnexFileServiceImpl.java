package com.ruoyi.busi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.BusiAnnexFileMapper;
import com.ruoyi.busi.domain.BusiAnnexFile;
import com.ruoyi.busi.service.IBusiAnnexFileService;
import com.ruoyi.common.core.text.Convert;

/**
 * 附件Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-29
 */
@Service
public class BusiAnnexFileServiceImpl implements IBusiAnnexFileService 
{
    @Autowired
    private BusiAnnexFileMapper busiAnnexFileMapper;

    /**
     * 查询附件
     * 
     * @param annexId 附件ID
     * @return 附件
     */
    @Override
    public BusiAnnexFile selectBusiAnnexFileById(Long annexId)
    {
        return busiAnnexFileMapper.selectBusiAnnexFileById(annexId);
    }

    /**
     * 查询附件列表
     * 
     * @param busiAnnexFile 附件
     * @return 附件
     */
    @Override
    public List<BusiAnnexFile> selectBusiAnnexFileList(BusiAnnexFile busiAnnexFile)
    {
        return busiAnnexFileMapper.selectBusiAnnexFileList(busiAnnexFile);
    }

    /**
     * 新增附件
     * 
     * @param busiAnnexFile 附件
     * @return 结果
     */
    @Override
    public int insertBusiAnnexFile(BusiAnnexFile busiAnnexFile)
    {
        busiAnnexFile.setCreateTime(DateUtils.getNowDate());
        return busiAnnexFileMapper.insertBusiAnnexFile(busiAnnexFile);
    }

    /**
     * 修改附件
     * 
     * @param busiAnnexFile 附件
     * @return 结果
     */
    @Override
    public int updateBusiAnnexFile(BusiAnnexFile busiAnnexFile)
    {
        return busiAnnexFileMapper.updateBusiAnnexFile(busiAnnexFile);
    }

    /**
     * 删除附件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiAnnexFileByIds(String ids)
    {
        return busiAnnexFileMapper.deleteBusiAnnexFileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除附件信息
     * 
     * @param annexId 附件ID
     * @return 结果
     */
    @Override
    public int deleteBusiAnnexFileById(Long annexId)
    {
        return busiAnnexFileMapper.deleteBusiAnnexFileById(annexId);
    }
}
