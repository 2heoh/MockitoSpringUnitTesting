package ru.uc.unit_testing;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTests {

    String str = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExpectsAllElements () throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, str, true);
    }

    @Test
    public void jsonAssert_StrictFalse_DoesNotExpectsAllElements () throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\", \"price\": 10}";
        JSONAssert.assertEquals(expectedResponse, str, false);
    }

    @Test
    public void jsonAssert_StrictFalse_DoesNotExpectsEscapeCharacters () throws JSONException {
        String expectedResponse = "{id: 1,name: \"Ball\", price: 10}";
        JSONAssert.assertEquals(expectedResponse, str, false);
    }


}
