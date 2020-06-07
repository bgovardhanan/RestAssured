package RestBasics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base {
 
  @BeforeClass
  @Parameters ({"username", "password", "URI"})
  public void beforeClass(String username, String password, String URI) {
	  RestAssured.authentication=RestAssured.preemptive().basic(username,password);
	  RestAssured.baseURI=URI;
  }

}
