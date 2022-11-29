package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		StepDefinition s = new StepDefinition();
		if(StepDefinition.place_id == null)
		{
		s.add_place_payload("Sagar", "English", "Pune");
		s.user_calls_with_request("AddPlaceAPI", "Post");
		s.verfiy_place_id_created_maps_to_using("Sagar", "GetPlaceAPI");
		}
	}

}
