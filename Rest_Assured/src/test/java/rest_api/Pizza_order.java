package rest_api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;


public class Pizza_order {
	public String url="https://order-pizza-api.herokuapp.com/api";
	public String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2Njg2NzI3NjYsIm5iZiI6MTY2ODY3Mjc2NiwianRpIjoiNmFhOTI5NmYtZTA1YS00ODQ3LWI5NGUtMDUzN2UwNjZhMGQzIiwiZXhwIjoxNjY4NjczNjY2LCJpZGVudGl0eSI6InRlc3QiLCJmcmVzaCI6ZmFsc2UsInR5cGUiOiJhY2Nlc3MifQ.s0nVsYI2C8ck2ofPg8EvmpvIRTJ0hIeDp86WJJ9lg70";

	@Test(enabled = false, priority = 1)
	public void create_token() {
		JSONObject j1=new JSONObject();
		j1.put("username", "test");
		j1.put("password", "test");
		RestAssured.baseURI=url;
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(j1.toJSONString()).when().post("/auth").then().log().all();
		
	}
	
	@Test(enabled = true,priority = 2)
	public void create_order() {
		JSONObject j2=new JSONObject();
		j2.put("Crust", "Thin");
		j2.put("Flavor", "Beef");
		j2.put("Size", "L");
		j2.put("Table_No", "10");
		RestAssured.baseURI=url;
		given().auth().oauth2(token).contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(j2.toJSONString()).when().post("/orders").then().log().all();
	}
	

}
