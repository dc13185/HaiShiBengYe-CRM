package com.ruoyi.busi;

import com.ruoyi.busi.domain.BusiPrice;
import com.ruoyi.busi.service.IBusiPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Dong.Chao
 * @Classname Constant
 * @Description
 * @Date 2021/2/2 12:04
 * @Version V1.0
 */
@Service
public class Constant {


    @Autowired
    private IBusiPriceService busiPriceService;

    /** 人工费用工时 */
    public static Double LABOR_COSTCOE_FFICIENT;

    /** 制造费用工时 */
    public static Double MAKE_COEFFICIENT;

    /** 外购件配套管理费比例 */
    public static Double PROPORTION_MANAGEMENT;

    /** 税金及附加比例 */
    public static Double TAX_AND_ADDITIONAL_RATIO;

    /** 包装运输费比例 */
    public static Double PACKING_AND_TRANSPORTATION_COSTS;


    /** 配件毛利率 */
    public static Double ACCESSORIES_GROSS_MARGIN;

    /** 外购泵配套管理费比例 */
    public static Double PROPORTION_OF_MANAGEMENT_FEE_PURCHASED;

    @PostConstruct
    public void init(){
        restart();
    }

    private void restart(){
        List<BusiPrice> busiPrices = busiPriceService.selectBusiPriceList(new BusiPrice());
        LABOR_COSTCOE_FFICIENT = busiPrices.get(0).getPriceDate();
        MAKE_COEFFICIENT = busiPrices.get(1).getPriceDate();
        PROPORTION_MANAGEMENT = busiPrices.get(2).getPriceDate();
        TAX_AND_ADDITIONAL_RATIO = busiPrices.get(3).getPriceDate();
        PACKING_AND_TRANSPORTATION_COSTS = busiPrices.get(4).getPriceDate();
        ACCESSORIES_GROSS_MARGIN = busiPrices.get(5).getPriceDate();
        PROPORTION_OF_MANAGEMENT_FEE_PURCHASED = busiPrices.get(6).getPriceDate();
    }


}
