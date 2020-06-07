package RestBasics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;

public class restPut {
  @Test
  @Parameters ({"puturl"})
  public void update(String puturl) {
	  RequestSpecification req = RestAssured.given();
	  JSONObject json = new JSONObject();
	  
	  json.put("id", "3");
	  json.put("author", "Author update 3");
	  json.put("title", "title update 3");
	  
	  
	  req.headers("Content-Type", "application/json");
	  req.body(json.toString());
	  
	  Response res = req.put(puturl);
	  System.out.println("res code for update " + res.getStatusCode());
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Update");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Update");
  }

}
