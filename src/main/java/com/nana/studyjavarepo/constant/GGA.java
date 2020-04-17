package com.nana.studyjavarepo.constant;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/14  13:54
 * Description:GPS定位信息
 * $GPGGA，(1)，(2)，(3)，(4)，(5)，(6)，(7)，(8)，(9)，M，(10)，M，(11)，(12)＊hh(CR)(LF)
 * $GPGGA,022934.000,3112.4220,N,12135.2359,E,1,10,0.92,8.0,M,8.3,M,,*57
 * Modified By:
 */
public enum GGA {
    GGA,                //标识
    Time,               //UTC时间,hhmmss.sss格式
    Latitude,           //纬度ddmm.mmmm
    NS,                 //N（北纬）或S（南纬）
    Longitude,          //经度dddmm.mmmm
    EW,                 //E（东经）或W（西经）
    FixQuality,        //GPS状态，0=不可用(FIX NOT valid)，1=单点定位(GPS FIX)，2=差分定位(DGPS)
    NumOfUsed,        //正在使用的卫星数量
    HDOP,               //HDOP水平精度因子（0.5 - 99.9）
    Altitude,           //海拔高度（-9999.9 - 99999.9）
    AltitudeOfUnit,   //海拔高度单位：M（米）
    Geoid,              //大地水准面的高度 WGS84
    GeoidOfUnit,      //大地水准面的高度单位：M（米）
    DGPSDeltaTime,    //差分时间
    DGPSId,            //差分站ID号
    CheckSum            //检查位

}
