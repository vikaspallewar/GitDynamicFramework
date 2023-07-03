package Test_Classes;

import org.testng.Assert;

import Common_API_Methods.API_Methods_Patch;
import RequestRepository.Patch_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_Tc1 {
	public static void extractor() {
		
	int statusCode = API_Methods_Patch.ResponsestatusCode(Patch_Req_Repository.BaseURI(),Patch_Req_Repository.Patch_Resource(),Patch_Req_Repository.Patch_Req_TC1());
	System.out.println(statusCode);
	
	String ResponseBody = API_Methods_Patch.ResponseBody(Patch_Req_Repository.BaseURI(),Patch_Req_Repository.Patch_Resource(),Patch_Req_Repository.Patch_Req_TC1());
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
