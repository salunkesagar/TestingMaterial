
public class stringbasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "hello";
		String b = "hello";
		//In above case only one refrence will be created
		
		String a1 = new String("Hello");
		String b1 =  new String("Hello");
		//In above case two different references will be created 
				
	}

}
