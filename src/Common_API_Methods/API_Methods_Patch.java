package Common_API_Methods;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class API_Methods_Patch {
	public static int ResponsestatusCode(String BaseURI, String Resource, String RequestBody) {
		
		RestAssured.baseURI = BaseURI;
		

		int statusCode = given().header("Content-Type","application/json").body(RequestBody).when().patch(Resource).then().extract().statusCode();
		return statusCode;
	}
		public static String ResponseBody(String BaseURI, String Resource, String RequestBody) {
			RestAssured.baseURI = BaseURI;
			
		String ResponseBody = given().header("Content-Type","application/json").body(RequestBody).
			when().patch(Resource).then().extract().response().asPrettyString();
		return ResponseBody;
		}
}
