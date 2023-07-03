package Test_Classes;

import java.io.IOException;

import org.testng.Assert;

import Common_API_Methods.API_Methods_Post;
import RequestRepository.Post_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Post_Tc1 {
	public static void extractor() throws IOException {
		
	int statusCode = API_Methods_Post.ResponsestatusCode(Post_Req_Repository.BaseURI(),Post_Req_Repository.post_Resource(),Post_Req_Repository.Post_Req_TC1());
	//System.out.println(statusCode);
	
	String ResponseBody = API_Methods_Post.ResponseBody(Post_Req_Repository.BaseURI(),Post_Req_Repository.post_Resource(),Post_Req_Repository.Post_Req_TC1());
	//System.out.println(ResponseBody);
	
	JsonPath jspResponse = new JsonPath(ResponseBody);
	String res_name = jspResponse.getString("name");
    String res_job = jspResponse.getString("job");
    String res_createdAt = jspResponse.getString("createdAt");
    res_createdAt = res_createdAt.substring(0,11);
    
    //Assert.assertEquals(res_name,"vikas");
	//Assert.assertEquals(res_job,"tester");
	
	
	}

}
