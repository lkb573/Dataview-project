package kr.re.kitri.dataview;
import org.json.JSONArray;

import java.sql.Connection;

public class InsertController {

    public static void main(String[] args) {

        InsertService service = new InsertService();
        String parameter = "&cat1=A02&cat2=A0207&areaCode=6&numOfRows=300&MobileOS=ETC&MobileApp=DaView&_type=json";
        JSONArray json = service.getJsonFromApi(parameter);
        Connection conn = service.getConnection();
        System.out.println(service.insertItemFromDB(json,conn));
    }
}
