package Arrays;

public class multiArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = new int[2][2];
		a[0][0] = 1;
		a[0][1] = 2;
		a[1][0] = -1;
		a[1][1] = 4;
		int min = a[0][0];
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				
				if(a[i][j]<min)
				{
					min=a[i][j];
							
					System.out.println(min);
				}
				//System.out.println(a[i][j]);
			}
		}
		

	}

}
