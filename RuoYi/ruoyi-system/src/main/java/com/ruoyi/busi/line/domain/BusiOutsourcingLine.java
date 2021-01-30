package com.ruoyi.busi.line.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 外购泵系列对象 busi_outsourcing_line
 *
 * @author ruoyi
 * @date 2021-01-30
 */
public class BusiOutsourcingLine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long outsourcingLineId;

    /** 泵系列 */
    @Excel(name = "泵系列")
    private String outsourcingLine;

    /**  */
    @Excel(name = "")
    private String supplierId;

    public void setOutsourcingLineId(Long outsourcingLineId)
    {
        this.outsourcingLineId = outsourcingLineId;
    }

    public Long getOutsourcingLineId()
    {
        return outsourcingLineId;
    }
    public void setOutsourcingLine(String outsourcingLine)
    {
        this.outsourcingLine = outsourcingLine;
    }

    public String getOutsourcingLine()
    {
        return outsourcingLine;
    }


    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("outsourcingLineId", getOutsourcingLineId())
            .append("outsourcingLine", getOutsourcingLine())
            .append("supplierId", getSupplierId())
            .toString();
    }
}
