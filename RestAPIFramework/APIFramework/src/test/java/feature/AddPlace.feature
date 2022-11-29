Feature: Validating Place APIs
@AddPlace
Scenario Outline: Verify if place being successfully added using AddPlace API
Given Add Place Payload "<name>" "<language>" "<address>"
When User calls "AddPlaceAPI" with "Post" request
Then The API call is successful with status code 200
And "status" in response is "OK"
And "scope" in response is "APP"	
And verfiy place_id created maps to "<name>" using "GetPlaceAPI"

Examples:
		|name| |language| |address|
		|abc|  |English |      |Pune|
	#	|pqr|  |Marathi|   |Indore|
 
 
 
 @DeletePlace
 Scenario: Verify DeletePlaceAPI functionality working
 Given DeletePlaceAPI Payload
 When User calls "DeletePlaceAPI" with "Post" request
Then The API call is successful with status code 200
And "status" in response is "OK"
 