package resources;

public enum APIResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource1;
	

	APIResources(String resource) {
		// TODO Auto-generated constructor stub
		this.resource1 = resource;
		
	}
	
	public String getResource()
	{
		return resource1;
	}

}
