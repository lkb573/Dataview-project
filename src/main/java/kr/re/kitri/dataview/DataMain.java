package kr.re.kitri.dataview;

import kr.re.kitri.dataview.model.Item;
import kr.re.kitri.dataview.service.ApiService;

import java.util.List;

public class DataMain {

    public static void main(String[] args) {

        ApiService service = new ApiService();
        String searchKey = "불꽃";
        String json = service.getJsonFromApi(searchKey);
        List<Item> list = service.getItemListFromJson(json);
        System.out.println(list);

    }
}
