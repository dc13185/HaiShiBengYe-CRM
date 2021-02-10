package com.ruoyi.busi.data.service;

import java.util.List;
import com.ruoyi.busi.data.domain.BusiData;

/**
 * 经营数据Service接口
 *
 * @author ruoyi
 * @date 2021-02-09
 */
public interface BusiDataService
{
    /**
     * 查询经营数据
     *
     * @param officeAddressCount 经营数据ID
     * @return 经营数据
     */
    public BusiData selectBusiDataById(Long officeAddressCount);

    /**
     * 查询经营数据列表
     *
     * @param busiData 经营数据
     * @return 经营数据集合
     */
    public List<BusiData> selectBusiDataList(BusiData busiData);

    /**
     * 新增经营数据
     *
     * @param busiData 经营数据
     * @return 结果
     */
    public int insertBusiData(BusiData busiData);

    /**
     * 修改经营数据
     *
     * @param busiData 经营数据
     * @return 结果
     */
    public int updateBusiData(BusiData busiData);

    /**
     * 批量删除经营数据
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiDataByIds(String ids);

    /**
     * 删除经营数据信息
     *
     * @param officeAddressCount 经营数据ID
     * @return 结果
     */
    public int deleteBusiDataById(Long officeAddressCount);
}
