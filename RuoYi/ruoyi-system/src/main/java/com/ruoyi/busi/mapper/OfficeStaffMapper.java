package com.ruoyi.busi.mapper;

import java.util.List;
import com.ruoyi.busi.domain.OfficeStaff;

/**
 * 办事处及人员Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-06
 */
public interface OfficeStaffMapper 
{
    /**
     * 查询办事处及人员
     * 
     * @param officeStaffId 办事处及人员ID
     * @return 办事处及人员
     */
    public OfficeStaff selectOfficeStaffById(Long officeStaffId);

    /**
     * 查询办事处及人员列表
     * 
     * @param officeStaff 办事处及人员
     * @return 办事处及人员集合
     */
    public List<OfficeStaff> selectOfficeStaffList(OfficeStaff officeStaff);

    /**
     * 新增办事处及人员
     * 
     * @param officeStaff 办事处及人员
     * @return 结果
     */
    public int insertOfficeStaff(OfficeStaff officeStaff);

    /**
     * 修改办事处及人员
     * 
     * @param officeStaff 办事处及人员
     * @return 结果
     */
    public int updateOfficeStaff(OfficeStaff officeStaff);

    /**
     * 删除办事处及人员
     * 
     * @param officeStaffId 办事处及人员ID
     * @return 结果
     */
    public int deleteOfficeStaffById(Long officeStaffId);

    /**
     * 批量删除办事处及人员
     * 
     * @param officeStaffIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteOfficeStaffByIds(String[] officeStaffIds);
}
