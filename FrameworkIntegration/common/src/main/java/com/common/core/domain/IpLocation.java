package com.common.core.domain;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;
import org.apache.commons.io.FileUtils;
import cn.hutool.core.io.IoUtil;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

public class IpLocation {
    @Autowired
    private static ResourceLoader resourceLoader;

    public static String getCityInfo(String ip) throws IOException {
        File file = new File(IpLocation.class.getResource("/city/a.txt").getFile());
        FileInputStream x = new FileInputStream(file);
        byte[] bys = new byte[1024];
        int len;
        while ((len = x.read(bys)) != -1) {
            System.out.print(new String(bys, 0, len));
        }

        return "";
//
//        //db
//        String dbPath = IpLocation.class.getResource("/city/ip2region.db").getPath();
//        System.out.println("dbPath："+dbPath);
//
//        File file = new File(dbPath);
//        if (file.exists() == false) {
//            System.out.println("Error: Invalid ip2region.db file");
//        }
//
//        //查询算法
//        int algorithm = DbSearcher.BTREE_ALGORITHM; //B-tree
//        //DbSearcher.BINARY_ALGORITHM //Binary
//        //DbSearcher.MEMORY_ALGORITYM //Memory
//        try {
//            DbConfig config = new DbConfig();
//            DbSearcher searcher = new DbSearcher(config, "/city/ip2region.db");
//
//            //define the method
//            Method method = null;
//            switch (algorithm) {
//                case DbSearcher.BTREE_ALGORITHM:
//                    method = searcher.getClass().getMethod("btreeSearch", String.class);
//                    break;
//                case DbSearcher.BINARY_ALGORITHM:
//                    method = searcher.getClass().getMethod("binarySearch", String.class);
//                    break;
//                case DbSearcher.MEMORY_ALGORITYM:
//                    method = searcher.getClass().getMethod("memorySearch", String.class);
//                    break;
//            }
//
//            DataBlock dataBlock = null;
//            if (Util.isIpAddress(ip) == false) {
//                System.out.println("Error: Invalid ip address");
//            }
//
//            dataBlock = (DataBlock) method.invoke(searcher, ip);
//
//            return dataBlock.getRegion();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
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
