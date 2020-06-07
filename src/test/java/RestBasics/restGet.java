package RestBasics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

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
  public void getlocal(String geturl) {
	  Response resp = RestAssured.get(geturl);
	  System.out.println("Time " + resp.getTime()); // + "milli sec" + resp.getTimeIn(null) + "seconds");
	  int code = resp.getStatusCode();
	  System.out.println(resp.asString());
	  System.out.println("Code is " + code);
	  System.out.println("Time " + resp.getTime() + "milli sec" + resp.getTimeIn(TimeUnit.SECONDS) + "seconds");
	  Assert.assertEquals(code, 200);
	  
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
