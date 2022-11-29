package funcionOverloading_OverRiding;

public class functionOverLoaingDemo {
	
	public void getData(int a )
	{
		
		System.out.println(a);
	}
	
	public void getData(String a)
	{
		
		System.out.println(a);
	}
	public  void getData(int a , int b)
	{
		
		System.out.println(a +" "+ b);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		functionOverLoaingDemo ab =  new functionOverLoaingDemo();
		ab.getData(1);
		ab.getData("hello");
		ab.getData(4, 5);
		
	}

}
