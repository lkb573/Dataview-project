package kr.re.kitri.dataview.service;

import kr.re.kitri.dataview.model.Item;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ApiService {
    private static String Address;
    private static URL url;
    private static BufferedReader br;
    private static HttpURLConnection conn;
    private static String protocol = "GET";
//    private static String searchKey = "불꽃";

    public String getJsonFromApi(String searchKey){

        String keyword = null;
        try {
            keyword = URLEncoder.encode(searchKey, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("serakey 오류");
            e.printStackTrace();
        }
        String point = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?";
        String serviceKey = "mTy6RIO%2FUanpU8PccBrEB%2BJgzQk5jV%2BbKB2ezfRspybCOoVYDMXegKeGvrzhtwJz44WCumfb%2BbXcBDPf28nLtQ%3D%3D";
        String parameter = "&cat1=A02&cat2=A0207&areaCode=1&MobileOS=ETC&MobileApp=DaView&_type=json";

        Address = point + "ServiceKey=" + serviceKey + "&keyword=" + keyword + parameter;

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
        StringBuffer response = new StringBuffer();

        try {
            while((line = br.readLine()) != null){
                response.append(line);
            }
            return response.toString();
        } catch (IOException e) {
            System.out.println("br 에러");
            e.printStackTrace();
            return "";
        }
    }


    public List<Item> getItemListFromJson(String json) {
        JSONObject jsonObject = new JSONObject(json);
        System.out.println(jsonObject); //Json 생성확인
        JSONArray items = jsonObject.getJSONArray("items");

        List<Item> list = new ArrayList<>();

        Item item = null;
        for (Object i : items) {
            item = new Item();
            JSONObject itemObj = (JSONObject)i;
            item.setAreaCode(itemObj.getInt("areacode"));
            item.setAddr1(itemObj.getString("addr1"));
            item.setContentId(itemObj.getInt("contentid"));
            item.setEventStartDate(itemObj.getString("eventstartdate"));
            item.setEventEndDate(itemObj.getString("eventenddate"));
            item.setFirstImage(itemObj.getString("firstimage"));
            item.setMapX(itemObj.getInt("mapx"));
            item.setMapY(itemObj.getInt("mapy"));
            item.setReadCount(itemObj.getInt("readcount"));
            item.setTel(itemObj.getString("tel"));
            item.setTitle(itemObj.getString("title"));

            list.add(item);
        }

        return list;
    }
}
