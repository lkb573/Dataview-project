package kr.re.kitri.dataview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DataService {
    private static String Address;
    private static URL url;
    private static BufferedReader br;
    private static HttpURLConnection conn;
    private static String protocol = "GET";
    public static void main(String[] args) {
        Address = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=mTy6RIO%2FUanpU8PccBrEB%2BJgzQk5jV%2BbKB2ezfRspybCOoVYDMXegKeGvrzhtwJz44WCumfb%2BbXcBDPf28nLtQ%3D%3D&areaCode=1&contentTypeId=15&MobileOS=ETC&MobileApp=DaView";


        try {
            url = new URL(Address);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("URL 오류");
        }
        try {
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod(protocol);
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("conn 오류");
        }
        String line;

        try {
            while((line = br.readLine()) != null){
                System.out.println(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("br 에러");
            e.printStackTrace();
        }


    }

}
