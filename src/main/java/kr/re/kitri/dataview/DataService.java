package kr.re.kitri.dataview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class DataService {
    private static String Address;
    private static URL url;
    private static BufferedReader br;
    private static HttpURLConnection conn;
    private static String protocol = "GET";
    private static String searchKey = "불꽃";

    public static void main(String[] args) {


        String keyword = null;
        try {
            keyword = URLEncoder.encode(searchKey, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("serakey 오류");
            e.printStackTrace();
        }
        Address = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword?ServiceKey=mTy6RIO%2FUanpU8PccBrEB%2BJgzQk5jV%2BbKB2ezfRspybCOoVYDMXegKeGvrzhtwJz44WCumfb%2BbXcBDPf28nLtQ%3D%3D&keyword="+keyword+"&areaCode=6&arrange=C&listYN=Y&pageNo=1&numOfRows=100&MobileOS=ETC&MobileApp=AppTesting&_type=json";
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
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("br 에러");
            e.printStackTrace();
        }


    }

}
