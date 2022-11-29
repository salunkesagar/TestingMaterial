package AbstractClass;

public class abstractDemo1 extends abstarctDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		abstractDemo1 a = new abstractDemo1();
		a.m1();
		a.m2();
		a.m3();
		System.out.println(a.b);
		System.out.println(a.c);
		
		System.out.println(a.d);
		

	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		System.out.println("This is m3 from abstarct class");
		
	}

}
