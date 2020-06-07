package RestBasics;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Authorization extends Base {
  @Test
  public void authorize()  {
	  //RestAssured.authentication=RestAssured.preemptive().basic("ToolsA","TestPassword");
	  //RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
	  System.out.println(RestAssured.get().getStatusCode());
	  Assert.assertEquals(RestAssured.get().getStatusCode(), 200);
	  System.out.println("Auth complete");
	  
	  //RestAssured.given().put(path, pathParams)
	 // System.out.println(RestAssured.given().auth().oauth("", "", "", "").get().getStatusCode());
  }
}
