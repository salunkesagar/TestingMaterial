package Arrays;

public class multiArrayDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int a[][] = new int [2][2];
		int a [][] = {{1,4},{2,0}};
		int min = a[0][0];
		int mincolumn = 0;
		for(int i=0; i<2;i++)
		{
			for(int j=0; j<2; j++)
			{
				if(a[i][j]<min)
				{
					min = a[i][j];
					System.out.println(min);
					mincolumn =j;
				}
			}
		}
		int k=0;
		int max =  a[0][mincolumn];
		while(k<2)
		{
			if(a[k][mincolumn]>max)
			{
				max = a[k][mincolumn];
				
			}
			k++;
		}
		System.out.println(max);
		
		
	}

}
