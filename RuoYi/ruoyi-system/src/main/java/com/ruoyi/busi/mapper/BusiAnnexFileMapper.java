package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.BusiAnnexFile;

/**
 * 附件Mapper接口
 *
 * @author ruoyi
 * @date 2020-12-29
 */
public interface BusiAnnexFileMapper
{
    /**
     * 查询附件
     *
     * @param annexId 附件ID
     * @return 附件
     */
    public BusiAnnexFile selectBusiAnnexFileById(Long annexId);

    public List<BusiAnnexFile> selectBusiAnnexFileBySupplierId(String supplierId);


    /**
     * 查询附件列表
     *
     * @param busiAnnexFile 附件
     * @return 附件集合
     */
    public List<BusiAnnexFile> selectBusiAnnexFileList(BusiAnnexFile busiAnnexFile);

    /**
     * 新增附件
     *
     * @param busiAnnexFile 附件
     * @return 结果
     */
    public int insertBusiAnnexFile(BusiAnnexFile busiAnnexFile);

    /**
     * 修改附件
     *
     * @param busiAnnexFile 附件
     * @return 结果
     */
    public int updateBusiAnnexFile(BusiAnnexFile busiAnnexFile);

    /**
     * 删除附件
     *
     * @param annexId 附件ID
     * @return 结果
     */
    public int deleteBusiAnnexFileById(Long annexId);

    /**
     * 批量删除附件
     *
     * @param annexIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiAnnexFileByIds(String[] annexIds);
}
