package jsonParser;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJsonResponse {

	public static void printing(JSONObject json, String key) {
		System.out.println(json.get(key));
	}
	
	public static void getkey (JSONObject json, String key)
	{
		boolean keyexists = json.has(key);
		Iterator<?> itr;
		String nextkey;
		
		if(keyexists) {
			printing(json, key);
		}
		else
		{
			itr=json.keys();
			while(itr.hasNext())
			{
				nextkey = (String) itr.next();
				if (json.get(nextkey) instanceof JSONObject)
				{
					if (keyexists==false)
					{
						getkey((JSONObject) json.get(nextkey), key);
					}
				}
				else if (json.get(nextkey) instanceof JSONArray)
				{
						JSONArray jarray = json.getJSONArray(nextkey);
						for(int i=0;i<jarray.length();i++)
						{
							String string = jarray.get(i).toString();
							JSONObject innerjson = new JSONObject(string);
							if (keyexists == false)
							{
								getkey(innerjson, key);
							}
						}
						
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputjson = "{\r\n" + 
				"    \"firstName\": \"John\",\r\n" + 
				"    \"lastName\": \"Smith\",\r\n" + 
				"    \"age\": 25,\r\n" + 
				"    \"address\": {\r\n" + 
				"        \"streetAddress\": \"21 2nd Street\",\r\n" + 
				"        \"city\": \"New York\",\r\n" + 
				"        \"state\": \"NY\",\r\n" + 
				"        \"postalCode\": 10021\r\n" + 
				"    },\r\n" + 
				"    \"phoneNumbers\": [\r\n" + 
				"        {\r\n" + 
				"            \"type\": \"home\",\r\n" + 
				"            \"number\": \"212 555-1234\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"type\": \"fax\",\r\n" + 
				"            \"number\": \"646 555-4567\" \r\n" + 
				"        }\r\n" + 
				"    ] \r\n" + 
				"}";
		
		JSONObject json = new JSONObject(inputjson);
		String jsonkey = "type";
		getkey(json, jsonkey);
				
		
	}

}
