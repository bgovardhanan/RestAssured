package RestBasics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class restPost {
	XSSFWorkbook workbook; 
	XSSFSheet sheet; 
	
	@Test
	@Parameters ({"posturl", "workbookpath", "postsheet"})
	public void putdata(String posturl, String workbookpath, String postsheet) throws IOException {
		//Get Excelsheet data
		workbook = new XSSFWorkbook(workbookpath);
		sheet = workbook.getSheet(postsheet);
		
		// Create Request object
		RequestSpecification req = RestAssured.given();
	//	req.header("Content-Type", "application/json");

		// Json object for body
		JSONObject json = new JSONObject();
		
		for (int i=1;i<sheet.getPhysicalNumberOfRows();i++)
		{
			for (int j=0;j<3;j++)
			{
				if (j==0)
				    json.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getNumericCellValue());
				else
					json.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
			}
			req.header("Content-Type", "application/json");
			req.body(json.toString());

			// post to server
			Response resp = req.post(posturl);

			System.out.println(resp.getStatusCode());
			Assert.assertEquals(resp.getStatusCode(), 201);
		}
			
		//json.put("id", "4");
		//json.put("title", "webdrivertitle4");
		//json.put("author", "codeauthor4");

		
		// pass the Json body to request object
		//req.body(json.toString());

		// post to server
		//Response resp = req.post(posturl);

		//System.out.println(resp.getStatusCode());
		//Assert.assertEquals(resp.getStatusCode(), 201);

	}

	@BeforeMethod
	public void beforeMethod() {

		System.out.println("Begin Create");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("End Put/Create");
	}

}
