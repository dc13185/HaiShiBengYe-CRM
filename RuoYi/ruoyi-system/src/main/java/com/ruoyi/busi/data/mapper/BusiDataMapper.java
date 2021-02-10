package com.ruoyi.busi.data.mapper;

import java.util.Date;
import java.util.List;
import com.ruoyi.busi.data.domain.BusiData;

/**
 * 经营数据Mapper接口
 *
 * @author ruoyi
 * @date 2021-02-09
 */
public interface BusiDataMapper
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
     * 删除经营数据
     *
     * @param officeAddressCount 经营数据ID
     * @return 结果
     */
    public int deleteBusiDataById(Long officeAddressCount);

    /**
     * 批量删除经营数据
     *
     * @param officeAddressCounts 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiDataByIds(String[] officeAddressCounts);


    /**
     * 查业务员数量
     * @return 结果
     */
    public Long queryOfficeUserStaff(BusiData busiData);

    public Long queryOfficeAddress(BusiData busiData);

    /**
     * 查报价单数量
     * @return 结果
     */
    public Long queryQuotationCount(BusiData busiData);

    public Double queryQuotationAllPrice(BusiData busiData);


    public Double queryContractAllPrice(BusiData busiData);

    public Long queryContractCount(BusiData busiData);


    public Double querySignContractPrice(BusiData busiData);


    public Double queryRepaymentAmount(BusiData busiData);

    public Long queryDeilverCount(BusiData busiData);

    public Long queryOverCount(BusiData busiData);
}
