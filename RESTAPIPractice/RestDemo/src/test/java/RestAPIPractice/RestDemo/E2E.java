package RestAPIPractice.RestDemo;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;
import pojo.OrderDetails;
import pojo.Orders;

public class E2E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		LoginRequest rq = new LoginRequest();
		rq.setUserEmail("salunkesagarg@gmail.com");
		rq.setUserPassword("Sagar@1234");
		RequestSpecification req1 = given().log().all().spec(req).body(rq);
		LoginResponse lreq = req1.when().post("/api/ecom/auth/login").then().log().all().extract().response().as(LoginResponse.class);
		System.out.println(lreq.getToken());
		
		String token = lreq.getToken();
		String id = lreq.getUserId();
		System.out.println(lreq.getUserId());
		
		
		//AddProduct
		
		RequestSpecification AddProduct  = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("authorization",token).build();
		RequestSpecification AddP = given().log().all().spec(AddProduct)
		.param("productName", "Laptop122").param("productAddedBy", id)
		.param("productCategory", "fashion").param("productSubCategory", "shirts")
		.param("productPrice", "11020").param("productDescription", "Dell")
		.param("productFor", "men").multiPart("productImage",new File("C:/Users/Sagar Salunke/Desktop/photo1.jpg"));
		
		String addproduct = AddP.when().post("/api/ecom/product/add-product")
				.then().log().all().extract().response().asString();
		
		JsonPath js = new JsonPath(addproduct);
		String productID = js.getString("productId");
		System.out.println(productID);
		
		
//Create Order
		OrderDetails ord =  new OrderDetails();
		ord.setCountry("INDIA");
		ord.setProductOrderedId(productID);
		
		List<OrderDetails> ord1 = new ArrayList<OrderDetails>();
		ord1.add(ord);
		
		
		Orders or = new Orders();
		or.setOrders(ord1);
		
		RequestSpecification OrderReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).addHeader("authorization", token).build();
		RequestSpecification OReq = given().log().all().spec(OrderReq).body(or);
				String rep = OReq.when().post("/api/ecom/order/create-order")
				.then().extract().response().asString();
		
		System.out.println(rep);
		
		
		
		//delete product
		
		RequestSpecification delreq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON)
										.addHeader("authorization", token).build();
		RequestSpecification delreq1 = given().log().all().spec(delreq).pathParam("productId", productID);
		
		
		String res2 = delreq1.when().delete("https://rahulshettyacademy.com/api/ecom/product/delete-product/{productId}")
						.then().extract().response().asString();
		
		System.out.println(res2);
		
		
		//JsonPath js1 = new JsonPath(res2);
		//String res3 = js.getString("message");
		//Assert.assertEquals("Product Deleted Successfully", res3);
		


		
		
		

		
		
	}

}
