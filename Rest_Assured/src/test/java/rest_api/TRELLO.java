package rest_api;

import org.testng.annotations.Test;
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

import io.restassured.RestAssured;

public class TRELLO {
	public String url ="https://api.trello.com";
	public String id_;
	JSONObject J2=new JSONObject();
	
	@Test(enabled = true)
	public void create_board() {
		
		RestAssured.baseURI=url;
	 Response R=given().queryParam("name", "ThejusR6")
			 .queryParam("key", "eaaad188c2bc47a6e6791ce7fa1eed91")
			 .queryParam("token", "0e1f8c2961d0a178eb74fd04619a796472d37bf857d5156bb3cfe710819e5ba9")
			 .body(J2.toJSONString()).when().post("/1/boards/").then().extract().response();
	 String S=R.asString();
	 JsonPath jp=new JsonPath(S);
		id_=jp.get("id");
	    System.out.println(id_);
	    
	}
	
	@Test(enabled = false)
	public void delete() {
		RestAssured.baseURI=url;
		given().queryParam("name", "ThejusR6")
		.queryParam("key", "eaaad188c2bc47a6e6791ce7fa1eed91")
		.queryParam("token", "0e1f8c2961d0a178eb74fd04619a796472d37bf857d5156bb3cfe710819e5ba9")
		.body(J2.toJSONString()).when().delete("/1/boards/"+id_).then().log().all();
		
	}

}
