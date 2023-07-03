package RequestRepository;

public class Retry_Post_Repository {
	public static String BaseURI() {
		String baseURI = "https://reqres.in/";
		return baseURI;
	}
	public static String post_Resource() {
	String post_Resource = "api/users";
	return post_Resource;
	}
	public static String Retry_Post_TC1() {
		String RequestBody = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		return RequestBody;
		
		
		
	}

}
