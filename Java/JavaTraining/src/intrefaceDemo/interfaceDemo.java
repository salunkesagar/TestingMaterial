package intrefaceDemo;

public class interfaceDemo implements centralInterface,interface1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		centralInterface a = new interfaceDemo();
		a.m1();
		a.m2();
		System.out.println(a.a);
		
		interfaceDemo a1 = new interfaceDemo();
		a1.m3();
		
		interface1 a2 = new interfaceDemo();
		a2.m4();
		

	}

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("This m1 from interface");
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("This m2 from interface");
		
	}
	public void m3() {
		System.out.println("This is m3 from class");
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		System.out.println("This is from interface1");
		
	}

}
