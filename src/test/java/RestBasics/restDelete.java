package RestBasics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class restDelete {
  @Test
  @Parameters ({"deleteurl"})
  public void delete(String deleteurl) {
	  Response res = RestAssured.delete(deleteurl);
	  System.out.println(res.getStatusCode());
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Delete Start");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Delete End");
  }

}
