package stepdefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	
	@Before("@DeletePlace")
	
	public void getPlaceID() throws IOException
	{
		StepDefinition m = new StepDefinition();
		if(StepDefinition.place_id==null)
		{
			m.add_place_payload_with("xyz", "German", "Germany");
			m.user_calls_api_with_request("AddPlaceAPI", "POST");
			m.verify_place_id_created_maps_to_using("xyz", "GetPlaceAPI");
		}


		
		
	}
}
