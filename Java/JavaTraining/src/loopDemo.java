
public class loopDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i=0;i<=10;i++)
		{
			System.out.println(i);
		}
		
		for(int i=10; i>=0; i=i-2)
		{
			System.out.println(i);
		}
		int j=0;
		while(j<=10)
		{
			System.out.println(j);
			j = j+2;
		}
		
		int k=10;
		
		do {
			System.out.println("This is do while loop");
		}while(k>12);
	}

}
