
package rest_api;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class Rest_assured_api {
	public String url="https://reqres.in/api/users?page=2";
	@Test(enabled = false)
	public void get_tc1() {
		Response rep=RestAssured.get(url);
		int actual=rep.statusCode();
		Assert.assertEquals(actual, 200);
	}
	
	@Test(enabled = false)
	public void get_tc2() {
		given().get(url).then().statusCode(200).log().all();
		
	}
	
	@Test(enabled = false)
	public void get_tc3() {
		given().get(url).then().statusCode(200).body("data.first_name", hasItems("George"));
}
	@Test(enabled = false)
	public void post_tc4() {
		JSONObject jo= new JSONObject();
		jo.put("name", "Thejus");
		jo.put("job", "tester");
		given().body(jo.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	}
	
	@Test(enabled = false)
	public void put_tc5() {
		JSONObject jo= new JSONObject();
		jo.put("name", "Thejus.R");
		jo.put("job", "tester");
		given().body(jo.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void delete_tc6() {
		
		given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	}
	
	@Test(enabled = true)
	public void register_tc7() {
		JSONObject j1=new JSONObject();
		j1.put("email", "thejus@gmail.com");
		j1.put("password", "qwerty");
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(j1.toJSONString()).when().post("https://reqres.in/api/register").then().log().all();
	}
}
