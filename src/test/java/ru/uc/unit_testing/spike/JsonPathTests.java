package ru.uc.unit_testing.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import ru.uc.unit_testing.model.Item;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTests {

    private DocumentContext getJsonWith3Items() {
        String json = "[\n" +
                "  {\"id\": 10001,\"name\":\"Pensil\",\"quantity\": 10 },\n" +
                "  {\"id\": 10002,\"name\":\"Pen\",\"quantity\": 100 },\n" +
                "  {\"id\": 10003,\"name\":\"Eraser\",\"quantity\": 15 }\n" +
                "]";

        return JsonPath.parse(json);
    }
    
    @Test
    public void jsonHas3Items  () {
        DocumentContext json = getJsonWith3Items();

        int length = json.read("$.length()");

        assertThat(length).isEqualTo(3);
    }
    
    @Test
    public void jsonContainsIds_10001_10002_10003 () {
        DocumentContext json = getJsonWith3Items();
        List<Integer> ids = json.read("$..id");
        assertThat(ids).isEqualTo(Arrays.asList(10001,10002,10003));
    }
    
    @Test
    public void idOfEraserIs_10003 () throws JSONException {
        DocumentContext json = getJsonWith3Items();

        JSONArray result = (JSONArray) json.read("$.[?(@.name=='Eraser')]");

        JSONAssert.assertEquals("[{id:10003}]", result, false);//        assertThat(item).isEqualTo("[{\"id\":10003}]") ;
    }
}
