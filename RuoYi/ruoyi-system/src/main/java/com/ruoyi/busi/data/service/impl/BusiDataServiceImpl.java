package com.ruoyi.busi.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.data.mapper.BusiDataMapper;
import com.ruoyi.busi.data.domain.BusiData;
import com.ruoyi.busi.data.service.BusiDataService;
import com.ruoyi.common.core.text.Convert;

/**
 * 经营数据Service业务层处理
 *
 * @author ruoyi
 * @date 2021-02-09
 */
@Service
public class  BusiDataServiceImpl implements BusiDataService
{
    @Autowired
    private BusiDataMapper busiDataMapper;

    /**
     * 查询经营数据
     *
     * @param officeAddressCount 经营数据ID
     * @return 经营数据
     */
    @Override
    public BusiData selectBusiDataById(Long officeAddressCount)
    {
        return busiDataMapper.selectBusiDataById(officeAddressCount);
    }

    /**
     * 查询经营数据列表
     *
     * @param busiData 经营数据
     * @return 经营数据
     */
    @Override
    public List<BusiData> selectBusiDataList(BusiData busiData)
    {
        return busiDataMapper.selectBusiDataList(busiData);
    }

    /**
     * 新增经营数据
     *
     * @param busiData 经营数据
     * @return 结果
     */
    @Override
    public int insertBusiData(BusiData busiData)
    {
        return busiDataMapper.insertBusiData(busiData);
    }

    /**
     * 修改经营数据
     *
     * @param busiData 经营数据
     * @return 结果
     */
    @Override
    public int updateBusiData(BusiData busiData)
    {
        return busiDataMapper.updateBusiData(busiData);
    }

    /**
     * 删除经营数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiDataByIds(String ids)
    {
        return busiDataMapper.deleteBusiDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除经营数据信息
     *
     * @param officeAddressCount 经营数据ID
     * @return 结果
     */
    @Override
    public int deleteBusiDataById(Long officeAddressCount)
    {
        return busiDataMapper.deleteBusiDataById(officeAddressCount);
    }
}
