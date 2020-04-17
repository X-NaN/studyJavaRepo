package com.nana.studyjavarepo.constant;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/14  14:11
 * Description:可见卫星信息
 * $GPGSV, <1>,<2>,<3>,<4>,<5>,<6>,<7>,…,<4>,<5>,<6>,<7>,*hh<CR><LF>
 * 例如， $GPGSV，2，1，08，06，33，240，45，10，36，074，47，16，21，078，44，17，36，313，42*78
 * 每条语句最多包括四颗卫星的信息，每颗卫星的信息有四个数据项，即：
 * 　 　　(4)－卫星号，(5)－仰角，(6)－方位角，(7)－信噪比。
 * 第<4>,<5>,<6>,<7>项个别卫星会重复出现，每行最多有四颗卫星。
 * Modified By:
 */
public enum GSV {
    GSV,                    //标识
    TotalNumOfSentence,  //GSV语句总数
    SentenceNo,            //本GSV语句编号
    TotalNumOfSV,        //可见卫星总数

    Prn1,                   //卫星1 PRN（伪随机噪声码）
    Elevation1,             //卫星1仰角（00 - 90）度
    Azimuth1,               //卫星1方位角（00 - 359）度
    Snr1,                   //卫星1信噪比（00－99）dB

    Prn2,
    Elevation2,
    Azimuth2,
    Snr2,

    Prn3,
    Elevation3,
    Azimuth3,
    Snr3,

    Prn4,
    Elevation4,
    Azimuth4,
    Snr4,
    CheckSum
}
