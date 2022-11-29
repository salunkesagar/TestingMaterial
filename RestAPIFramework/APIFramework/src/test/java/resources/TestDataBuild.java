package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	public AddPlace AddPlacePayload(String name, String language, String address)
	{
		AddPlace a = new AddPlace();
    	a.setAccuracy(50);
    	a.setAddress(address);
    	a.setLanguage(language);
    	a.setName(name);
    	a.setPhone_number("(+91) 983 893 3937");
    	a.setWebsite("http://google.com");
    	List<String> ml = new ArrayList<String>();
    	ml.add("shoe par");
    	ml.add("shop");
    	a.setTypes(ml);
    	Location l = new Location();
    	l.setLat(-38.383494);
    	l.setLng(33.427362);
    	a.setLocation(l);
    	return a;
	}
	
	public String DeletePlaceAPI(String placeid) {
		return "{\r\n\"place_id\":\""+placeid+"\"\r\n}";
	}

}
