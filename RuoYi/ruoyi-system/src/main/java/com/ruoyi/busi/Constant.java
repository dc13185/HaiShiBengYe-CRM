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
        busiPriceService.restart();
    }


    private enum Ping {
//        HB("湖北省","HB"),
        BJ("北京市","BJ"),
        TJ("天津市","TJ"),
        HEB("河北省","HEB"),
        SX("山西省","SX"),
        NMG("内蒙古自治区","NMG"),
        LN("辽宁省","LN"),
        JL("吉林省","JL"),
        HLJ("黑龙江省","HLJ"),
        SH("上海市","SH"),
        JS("江苏省","JS"),
        ZJ("浙江省","ZJ"),
        AH("安徽省","AH"),
        FJ("福建省","FJ"),
        JX("江西省","JX"),
        SD("山东省","SD"),
        HN("河南省","HN"),
        HB("湖北省","HB"),
        HUN("湖南省","HUN"),
        GD("广东省","GD"),
        GX("广西壮族自治区","GX"),
        HAN("海南省","HAN"),
        CQ("重庆市","CQ"),
        SC("四川省","SC"),
        GZ("贵州省","GZ"),
        YN("云南省","YN"),
        XZ("西藏自治区","XZ"),
        SHX("陕西省","SHX"),
        GS("甘肃省","GS"),
        QH("青海省","QH"),
        NX("宁夏回族自治区","NX"),
        XJ("新疆维吾尔自治区","XJ"),
        XG("香港特别行政区","XG"),
        AM("澳门特别行政区","AM"),
        TW("台湾省","TW");
        private String name;
        private String pinyin;

        Ping(String name, String pinyin) {
            this.name = name;
            this.pinyin = pinyin;
        }
    }

    public static String getSfPinyin(String name){
        for (Ping value : Ping.values()) {
            if (value.name.equals(name)){
                return value.pinyin;
            }
        }
        return null;
    }




}
