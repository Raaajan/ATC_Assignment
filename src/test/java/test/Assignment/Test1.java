package test.Assignment;

import org.testng.annotations.Test;

import body.Body;
import body.body1;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.Create;
import pojo.Payload;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import static io.restassured.RestAssured.given;

@Test
class Test1  {

		
	//one plain get req
	// get req with head auth
	// post req direct
	// post req with pojo class
	// post req with headers
	
	// share to 
	 
	public void getres() {
		RestAssured.baseURI = "https://reqres.in";
		
		given().log().all().when().get("/api/users/2").then().log().all().statusCode(200);
		
	}
	
	public void postreq() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		String st = Body.reqbody();
		given().log().all().body(st).when().post("/api/users").then().log().all().statusCode(201);
	}
	
	
	public void reqwithheader() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		String bodyheader = body1.body1forheader();
		given().header("Content-Type", "application/json")
		.body(bodyheader)
		.log().all().when().post("/api/login").then().log().all().statusCode(200);
	
	}
	
	public void postreqwithpojo() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		Payload p = new Payload();
		Create py = p.createpayload("Rajan", "Testing");
		
		given().log().all().body(py).when().post("/api/users").then().log().all().statusCode(201);
	}
	
	public void getreswithauth() {
		RestAssured.baseURI = "https://postman-echo.com";
		
		 given().header("Content-Type", "application/json")
		.auth().basic("postman", "password").log().all()
		.when().get("/basic-auth").then().log().all().statusCode(200);
		
	}
	
	}






