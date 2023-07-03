package Test_Classes;

import org.testng.Assert;

import Common_API_Methods.API_Methods_Put;
import RequestRepository.Put_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Put_Tc1 {
	public static void extractor() {
		
	int statusCode = API_Methods_Put.ResponsestatusCode(Put_Req_Repository.BaseURI(),Put_Req_Repository.Put_Resource(),Put_Req_Repository.Put_Req_TC1());
	System.out.println(statusCode);
	
	String ResponseBody = API_Methods_Put.ResponseBody(Put_Req_Repository.BaseURI(),Put_Req_Repository.Put_Resource(),Put_Req_Repository.Put_Req_TC1());
	System.out.println(ResponseBody);
	
	JsonPath jspResponse = new JsonPath(ResponseBody);
	String res_name = jspResponse.getString("name");
    String res_job = jspResponse.getString("job");
    String res_updatedAt = jspResponse.getString("updatedAt");
    res_updatedAt = res_updatedAt.substring(0,11);
    
    Assert.assertEquals(res_name,"morpheus");
	Assert.assertEquals(res_job,"zion resident");
	
	}

}
