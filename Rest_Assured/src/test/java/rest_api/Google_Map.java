package rest_api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
public class Google_Map {
	
	public String key="qaclick123";
	public String place_id;
	
	@Test
	public void add() {
		JSONObject a1=new JSONObject();
		JSONArray a2=new JSONArray();
		JSONObject a3=new JSONObject();
		a3.put("lat", "-38.383494");
		a3.put("lng", "33.427362");
		a2.add(a3);
		a1.put("location", a3);
		a1.put("accuracy", "50");
		a1.put("name", "Frontline House");
		a1.put("phone_number", "(+91) 983 893 3937");
		a1.put("address", "29, side layout, cohen 09");
		a1.put("types", "shoe park");
		a1.put("website", "http://google.com");
		a1.put("language", "French-IN");
		given().queryParam("key", key).contentType(ContentType.JSON)
		.accept(ContentType.JSON).body(a1.toJSONString())
		.post("http://216.10.245.166/maps/api/place/add/json/").then().log().all();
		
		JsonPath jp=new JsonPath(a1.toString());
		place_id=jp.get("place_id");
		System.out.println(a1);
	}
	
	@Test(enabled = false)
	public void delete() {
		JSONObject a4=new JSONObject();
		a4.put("place_id", place_id);
		given().queryParam("key", key).contentType(ContentType.JSON)
		.accept(ContentType.JSON).body(a4.toJSONString())
		.delete("http://216.10.245.166/maps/api/place/add/json/").then().log().all();
	}
	}
