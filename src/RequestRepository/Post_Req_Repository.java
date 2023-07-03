package RequestRepository;

import java.io.IOException;
import java.util.ArrayList;

import Common_API_Methods.Common_Utility_Method;

public class Post_Req_Repository {

	public static String BaseURI() {
		String baseURI = "https://reqres.in/";
		return baseURI;
	}
	public static String post_Resource() {
	String post_Resource = "api/users";
	return post_Resource;
	}
	public static String Post_Req_TC1() throws IOException {
		ArrayList<String> Req_Data = Common_Utility_Method.ReadDataExcel("Post","Tc2");
		System.out.println(Req_Data);
		String Req_Name = Req_Data.get(1);
		String Req_Job = Req_Data.get(2);
		String RequestBody = "{\r\n"
				+ "    \"name\": \""+Req_Name+"\",\r\n"
				+ "    \"job\": \""+Req_Job+"\"\r\n"
				+ "}";
		return RequestBody;
		
		
		
	}
}
