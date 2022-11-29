package testData;

import java.util.ArrayList;
import java.util.List;

import pojo.AddLocation;
import pojo.Location1;

public class TestDataBuild {
	public AddLocation addPlacePayload(String name, String language, String address)
	{
		AddLocation a = new AddLocation();
		Location1 l = new Location1();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		a.setAccuracy(50);
		a.setAddress(address);
		a.setLanguage(language);
		a.setName(name);
		a.setPhone_number("(+91) 983 893 3937");
		a.setWebsite("http://google.com");
		a.setLocation(l);
		List<String> ml = new ArrayList<String>();
		ml.add("shoe park");
		ml.add("shop");
		a.setTypes(ml);
		
		return a;
		
	}
	
	public String deletePlace(String placeID)
	{
		return "{\r\n"
				+ "    \"place_id\":\""+placeID+"\"\r\n"
				+ "}";
	}

}
