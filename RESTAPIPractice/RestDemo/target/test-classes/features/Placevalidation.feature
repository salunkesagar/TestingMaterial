Feature: Validating Google MAP APIs 

@Addplace
Scenario Outline: Verify if place being successfully added by AddPlace API 

	Given AddPlace Payload with "<name>" "<language>" "<address>" 
	When user calls "AddPlaceAPI" API with "POST" request 
	Then API call get success with status code 200 
	And The "status" in body is "OK" 
	And The "scope" in body is "APP" 
	And verify placeID created maps to "<name>" using "GetPlaceAPI"	
	Examples: 
	
		|name| |language| |address|
		|abc| |English| |Pune|
		|pqr | |Spanish| |Mumbai|
		
@DeletePlace		
Scenario: Verify if place being succesfully deleted by DeletePlace API

	Given DeletePlace payload
	When user calls "DeletePlaceAPI" API with "POST" request 
	Then API call get success with status code 200 
	And The "status" in body is "OK"
	