package com.nana.studyjavarepo.io;

import javax.print.DocFlavor;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/14  14:18
 * Description:
 * Modified By:
 */
public class NmeaParse {
    private String nmeaFile;
    private int deviceId;
    private String deviceName;

    static int maxFixInfoId = -1;             //当前定位信息Id
    static int maxStatelliteInfoId = -1;      //当前定位信息Id
    String curTime = "";                      //当前定位时间
    String curDate = "";                      //当前定位时间
    String startTime = "";                    //定位开始时间（收个定位成功时间）
    String endTime = "";                      //定位结束时间

    public NmeaParse(String nmeaFile, int deviceId, String deviceName) {
        this.nmeaFile = nmeaFile;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }

}
