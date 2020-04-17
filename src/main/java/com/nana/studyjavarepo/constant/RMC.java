package com.nana.studyjavarepo.constant;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/14  14:04
 * Description:推荐最小定位信息
 * $GPRMC,<1>,<2>,<3>,<4>,<5>,<6>,<7>,<8>,<9>,<10>,<11><CR><LF>
 * Modified By:
 */
public enum RMC {
    RMC,                        //标识
    Time,                       //UTC时间,hhmmss.sss格式
    Warning,                    //状态(Navigation receiver warning)，A=定位，V=未定位
    Latitude,                   //纬度ddmm.mmmm
    NS,                         //N（北纬）或S（南纬）
    Longitude,                  //经度dddmm.mmmm
    EW,                         //E（东经）或W（西经）
    Speed,                      //速度，节，Knots
    CourseMadeGood,           //方位角，度
    Date,                       //UTC日期，DDMMYY格式
    MagneticVariation,         //磁偏角，（000 - 180）度
    MagneticVariationEW,      //磁偏角方向，E=东W=西
    CheckSum
}
