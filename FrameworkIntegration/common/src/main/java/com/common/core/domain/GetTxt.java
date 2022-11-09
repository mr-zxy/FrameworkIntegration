package com.common.core.domain;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GetTxt {
    public String getT() throws IOException {
        ClassLoader classLoader = GetTxt.class.getClassLoader();
        InputStream appUrl = classLoader.getResourceAsStream("city/a.txt");
        String appString=inputStream2Str(appUrl);
        return appString;
    }
    public static String inputStream2Str(InputStream is) throws IOException {
        StringBuffer sb;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(is));

            sb = new StringBuffer();

            String data;
            while ((data = br.readLine()) != null) {
                sb.append(data).append("\n");
            }
        } finally {
            br.close();
        }

        return sb.toString();
    }
}
