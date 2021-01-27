package com.ruoyi.busi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.busi.mapper.OfficeStaffMapper;
import com.ruoyi.busi.domain.OfficeStaff;
import com.ruoyi.busi.service.IOfficeStaffService;
import com.ruoyi.common.core.text.Convert;

/**
 * 办事处及人员Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
@Service
public class OfficeStaffServiceImpl implements IOfficeStaffService 
{
    @Autowired
    private OfficeStaffMapper officeStaffMapper;

    /**
     * 查询办事处及人员
     * 
     * @param officeStaffId 办事处及人员ID
     * @return 办事处及人员
     */
    @Override
    public OfficeStaff selectOfficeStaffById(Long officeStaffId)
    {
        return officeStaffMapper.selectOfficeStaffById(officeStaffId);
    }

    /**
     * 查询办事处及人员列表
     * 
     * @param officeStaff 办事处及人员
     * @return 办事处及人员
     */
    @Override
    public List<OfficeStaff> selectOfficeStaffList(OfficeStaff officeStaff)
    {
        return officeStaffMapper.selectOfficeStaffList(officeStaff);
    }

    /**
     * 新增办事处及人员
     * 
     * @param officeStaff 办事处及人员
     * @return 结果
     */
    @Override
    public int insertOfficeStaff(OfficeStaff officeStaff)
    {
        return officeStaffMapper.insertOfficeStaff(officeStaff);
    }

    /**
     * 修改办事处及人员
     * 
     * @param officeStaff 办事处及人员
     * @return 结果
     */
    @Override
    public int updateOfficeStaff(OfficeStaff officeStaff)
    {
        return officeStaffMapper.updateOfficeStaff(officeStaff);
    }

    /**
     * 删除办事处及人员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOfficeStaffByIds(String ids)
    {
        return officeStaffMapper.deleteOfficeStaffByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除办事处及人员信息
     * 
     * @param officeStaffId 办事处及人员ID
     * @return 结果
     */
    @Override
    public int deleteOfficeStaffById(Long officeStaffId)
    {
        return officeStaffMapper.deleteOfficeStaffById(officeStaffId);
    }
}
