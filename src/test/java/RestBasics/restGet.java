package RestBasics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class restGet {
 /* @Test
  public void getdata() {
	  
	  Response resp = RestAssured.get("https://reqres.in/api/users");
	  System.out.println("Time " + resp.getTime()); // + "milli sec" + resp.getTimeIn(null) + "seconds");
	  int code = resp.getStatusCode();
	  System.out.println(resp.asString());
	  System.out.println("Code is " + code);
	  System.out.println("Time " + resp.getTime() + "milli sec" + resp.getTimeIn(TimeUnit.SECONDS) + "seconds");
	  Assert.assertEquals(code, 200);
  }*/
  
  @Test
  @Parameters ({"geturl"})
  public void getlocal(String geturl) throws ParseException {
	  Response resp = RestAssured.get(geturl);
	  System.out.println("Time " + resp.getTime()); // + "milli sec" + resp.getTimeIn(null) + "seconds");
	  //int code = resp.getStatusCode();
	  //System.out.println(resp.asString());
	  //System.out.println( "body is " + resp.getBody());
	 
	  
	  //System.out.println("value is ++++" + json.get("id"));
		
		  
	  JSONArray jarray = new JSONArray(resp.asString());
	  String jsonstring = jarray.get(1).toString();
	  JSONObject json = new JSONObject(jsonstring);
	  System.out.println("id is  " + json.get("id"));
	  System.out.println(" title is " + json.getString("title"));
	  System.out.println("author is  " + json.getString("author"));
	  
	 //System.out.println("Code is " + resp.statusCode());
	 //System.out.println("Time " + resp.getTime() + "milli sec" + resp.getTimeIn(TimeUnit.SECONDS) + "seconds");
	  
	  //Assert.assertEquals(code, 200);
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Begin Get Data");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println("End Get Data");
  }

}
