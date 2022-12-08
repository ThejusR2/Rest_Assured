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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Shopping_cart {
	public String url="http://rest-api.upskills.in/api/rest/";
	public String header="Basic c2hvcHBpbmdfb2F1dGhfY2xpZW50OnNob3BwaW5nX29hdXRoX3NlY3JldA";
	public String token="c6a550f001ae07dfb5f9373e1d94190035042188";
	public String t;
	
	@Test(enabled = false)
	public void get_token() {
	    
		RestAssured.baseURI=url;
		given().header("Authorization", header).contentType(ContentType.JSON).accept(ContentType.JSON)
		.when().post("oauth2/token/client_credentials").then().log().all();
		
	}
	
	@Test(enabled = false)
	public void register() {
		JSONObject B=new JSONObject();
		JSONArray B1=new JSONArray();
		JSONArray B2=new JSONArray();
		JSONObject B3=new JSONObject();
		B.put("firstname", "Thejus");
		B.put("lastname", "R");
		B.put("email", "rahuldravid@gmail.com");
		B.put("password", "dravid09");
		B.put("confirm", "dravid09");
		B.put("telephone", "1-541-754-3010");
		B.put("customer_group_id", "1");
		B.put("agree", "1");
		B3.put("1", "+364545454");
		B1.add(B3);
		B2.add(B1);
		B.put("custom_field", B2);
		B.put("account", B1);
		RestAssured.baseURI=url;
		given().auth().oauth2(token).contentType(ContentType.JSON).accept(ContentType.JSON).body(B.toJSONString())
		.when().post("/register").then().log().all();
		
	}
	@Test(enabled = false)
	public void forgot_password() {
		JSONObject P=new JSONObject();
		P.put("email", "rahuldravid@gmail.com");
		RestAssured.baseURI=url;
		given().auth().oauth2(token).contentType(ContentType.JSON).accept(ContentType.JSON).body(P.toJSONString())
		.when().post("/forgotten").then().log().all();
	}
	
	@Test(enabled = false)
	public void login() {
		JSONObject L=new JSONObject();
		L.put("email", "rahuldravid@gmail.com");
		L.put("password", "dravid09");
		RestAssured.baseURI=url;
		given().auth().oauth2(token).contentType(ContentType.JSON).accept(ContentType.JSON).body(L.toJSONString())
		.when().post("/login").then().log().all();
	}
	
	@Test(enabled = false)
	public void get_acc_detail() {
		RestAssured.baseURI=url;
		given().auth().oauth2(token).contentType(ContentType.JSON).accept(ContentType.JSON)
		.when().get("/account").then().log().all();
	}
	
	@Test(enabled = false)
	public void update_acc() {
		JSONObject U=new JSONObject();
		JSONArray U1=new JSONArray();
		JSONArray U2=new JSONArray();
		JSONObject U3=new JSONObject();
		U.put("firstname", "Thejus");
		U.put("lastname", "Gowda");
		U.put("email", "rahuldravid@gmail.com");
		U.put("telephone", "1-541-754-3010");
		U3.put("1", "+364545454");
		U1.add(U3);
		U2.add(U1);
		U.put("custom_field", U2);
		U.put("account", U1);
		RestAssured.baseURI=url;
		given().auth().oauth2(token).contentType(ContentType.JSON).accept(ContentType.JSON).body(U.toJSONString())
		.when().put("/account").then().log().all();
	}
	
	@Test
	public void logout() {
		RestAssured.baseURI=url;
		given().auth().oauth2(token).contentType(ContentType.JSON).accept(ContentType.JSON)
		.when().post("/logout").then().log().all();
		
	}

}
