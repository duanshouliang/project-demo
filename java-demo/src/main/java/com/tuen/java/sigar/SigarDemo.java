package com.tuen.java.sigar;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class SigarDemo {
    public static void main(String[] args) {
        getCpuInfo();
    }

    public static void getCpuInfo(){
        Sigar sigar = new Sigar();
        try {
            CpuInfo[] cpuInfos = sigar.getCpuInfoList();
//            CpuPerc[] cpuPercs = sigar.getCpuPercList();


            for(int i=0;i<cpuInfos.length;i++){
                CpuInfo cpuInfo = cpuInfos[i];
                System.out.println("第"+(i+1)+"个cpu信息");
                System.out.println("cpu的总量MHz" + cpuInfo.getMhz());
                System.out.println("CPU生产商:    " + cpuInfo.getVendor());// 获得CPU的卖主，如：Intel
                System.out.println("CPU类别:    " + cpuInfo.getModel());// 获得CPU的类别，如：Celeron
                System.out.println("CPU缓存数量:    " + cpuInfo.getCacheSize());// 缓冲存储器数量
                System.out.println("");
            }
        } catch (SigarException e) {
            e.printStackTrace();
        }
    }
}
