
public class methodDemo {
	
	
	int a =4;
	public void getData()
	{
			System.out.println("Hello");
			
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create object of class
		methodDemo m = new methodDemo();
		methodDemo1 m1 = new methodDemo1();
		m1.setData();
		
		//call method using . operator
		m.getData();
		System.out.println(m.a);
		
	}

}
