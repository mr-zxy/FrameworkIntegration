package com.common.core.domain;

import cn.hutool.http.HttpUtil;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;


public class IpLocation {
    public static String getCityInfo(String ip) throws IOException {
        String url=System.getProperty("user.dir")+"/ip2region.db";
        System.out.printf("url"+url);
        File file= new File(url);;
        if (!file.exists()) {
            System.out.printf("Error: Invalid ip2region.db file, filePath：" + file.getPath());
            return null;
        }
        //查询算法
        int algorithm = DbSearcher.BTREE_ALGORITHM; //B-tree
        //DbSearcher.BINARY_ALGORITHM //Binary
        //DbSearcher.MEMORY_ALGORITYM //Memory
        try {
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config, file.getPath());
            Method method;
            switch (algorithm){
                case DbSearcher.BTREE_ALGORITHM:
                    method = searcher.getClass().getMethod("btreeSearch", String.class);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    method = searcher.getClass().getMethod("binarySearch", String.class);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    method = searcher.getClass().getMethod("memorySearch", String.class);
                    break;
                default:
                    return null;
            }
            DataBlock dataBlock;
//            if (!Util.isIpAddress(ip)) {
//                System.out.printf("Error: Invalid ip address");
//                return null;
//            }
            dataBlock  = (DataBlock) method.invoke(searcher, ip);
            return dataBlock.getRegion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCityByIp(String ip) throws IOException {
        String cityIpString = getCityInfo(ip);
        System.out.println(cityIpString);
        return cityIpString;
    }
    
//    public static void main(String[] args) throws Exception {
//        String ip="204.124.181.253";
//        String cityIpString = getCityInfo(ip);
//        System.out.println(cityIpString);
//        String[] splitIpString = cityIpString.split("\\|");
//        cityIpString =splitIpString[3].replaceAll("市","");
//        System.err.println(cityIpString);
//    }

}
