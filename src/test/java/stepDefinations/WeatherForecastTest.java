package stepDefinations;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import pojo.wind;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.DominentCond;
import pojo.Fcst;
import pojo.ForecastData;

public class WeatherForecastTest {

	List<DominentCond> weatherData=new ArrayList();;
	RequestSpecification rqSpec;
	ResponseSpecification rsSpec;
	Response response;
	@Given("^Get the Forecast for \"([^\"]*)\"$")
	public void get_the_Forecast_for(String city) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String [] cityInfo = city.split(";");
		String cityStr="";
		
			for(int i=0;i<cityInfo.length;i++) {
				if(i<cityInfo.length-1)
				cityStr+=cityInfo[i]+",";
				else
					cityStr+=cityInfo[i];
			}
		rqSpec = new RequestSpecBuilder().setBaseUri("http://api.openweathermap.org").addQueryParam("q",cityStr)
				  .addQueryParam("appid", "4465077ee138be794d598c4f857ee8dc")
				  .setContentType(ContentType.JSON).build();
		
		rqSpec = given().log().all().spec(rqSpec);
		
		
		
	}

	@When("^User Calls the \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void user_Calls_the_with_http_request(String endPoint, String protocol) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(protocol=="Post")
		response = rqSpec.when().post("data/2.5/forecast").then().extract().response();
		else
			response = rqSpec.when().get("data/2.5/forecast").then().log().all().extract().response();
	}



	@Then("^Data returned$")
	public void data_returned(DataTable fcstData) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<Map<String, String>> table = fcstData.asMaps(String.class, String.class);

			for (Map<String, String> dataMap : table) {
				wind w = new wind(Double.valueOf(dataMap.get("speed")),Integer.valueOf(dataMap.get("deg")));
				DominentCond dc = new DominentCond(w);
				
				weatherData.add(dc);
			}
			

			ForecastData fd = response.body().as(ForecastData.class);
			int i=0;
			for(DominentCond dc:fd.getList()) {
				assertEquals(weatherData.get(i++), dc);
			}
			
			
		String resp = response.asString();
		JsonPath jp = new JsonPath(resp);
		
		int cnt = jp.getInt("cnt");
		
		//Assert.assertTrue("pass", cnt>32);
	
	}

	
}
