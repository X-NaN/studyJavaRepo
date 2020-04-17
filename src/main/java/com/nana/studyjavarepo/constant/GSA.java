package com.nana.studyjavarepo.constant;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/14  14:09
 * Description:当前卫星信息
 * $GPGSA,<1>,<2>,<3>,<3>,,,,,<3>,<3>,<3>,<4>,<5>,<6>,<7><CR><LF>
 * 例如，$GPGSA,A,3,14,29,25,32,31,26,22,10,16,193,,,1.60,0.92,1.31*3E
 * 最多可接收12颗卫星信息。
 * Modified By:
 */
public enum GSA {
    GSA,                //标识
    FixMode1,          //定位模式，A=自动选择，M=手动选择
    FixMode2,          //定位类型，1=未定位，2=2D定位，3=3D定位
    Prn1,               //卫星PRN（伪随机噪声码）
    Prn2,
    Prn3,
    Prn4,
    Prn5,
    Prn6,
    Prn7,
    Prn8,
    Prn9,
    Prn10,
    Prn11,
    Prn12,
    PDOP,               //PDOP综合位置精度因子（0.5 - 99.9）
    HDOP,               //HDOP水平精度因子（0.5 - 99.9）
    VDOP,               //VDOP垂直精度因子（0.5 - 99.9）
    CheckSum
}
