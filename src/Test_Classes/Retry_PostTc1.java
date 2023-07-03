package Test_Classes;

import org.testng.Assert;
import Common_API_Methods.Retry_API_Methods_Post;
import RequestRepository.Retry_Post_Repository;
import io.restassured.path.json.JsonPath;

public class Retry_PostTc1 {
	public static void extractor() {
		
		for(int i=0; i<5; i++) {
		
		int statusCode = Retry_API_Methods_Post.ResponsestatusCode(Retry_Post_Repository.BaseURI(),Retry_Post_Repository.post_Resource(),Retry_Post_Repository.Retry_Post_TC1());
		
		//if(statusCode==200) {
		if(statusCode==201) {
			
			System.out.println("status Code is correct ");
		
		String ResponseBody = Retry_API_Methods_Post.ResponseBody(Retry_Post_Repository.BaseURI(),Retry_Post_Repository.post_Resource(),Retry_Post_Repository.Retry_Post_TC1());
		System.out.println(ResponseBody);
		
		String RequestBody = Retry_Post_Repository.Retry_Post_TC1();
		validator(ResponseBody,RequestBody);
		break;
		}
		else {
			System.out.println("status code is incorrect");
		}
	}
}	
	
	public static void validator(String ResponseBody, String RequestBody) {
		
		JsonPath jspResponse = new JsonPath(ResponseBody);
		String res_name = jspResponse.getString("name");
	    String res_job = jspResponse.getString("job");
	    String res_createdAt = jspResponse.getString("createdAt");
	    res_createdAt = res_createdAt.substring(0,11);
	    
	    Assert.assertEquals(res_name,"morpheus");
		Assert.assertEquals(res_job,"leader");
		
		
		}

	}


