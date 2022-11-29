package funcionOverloading_OverRiding;

public class childClass extends parentClass{
	
	public void getData() {
		System.out.println("This is child method");
	}
	public void m1(int a, String b) {
		System.out.println(a +" "+b);
		System.out.println("This is child method");
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		childClass c1 = new childClass();
		c1.getData();
		c1.m1(5,"hello");
	}

}
