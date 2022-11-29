package javaprogram;

import java.util.HashMap;

public class ArrayDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {1,2,2,3,4,6,6,6,9};
	
		HashMap<Integer, Boolean> hm = new HashMap();
		
		for(int i=0;i<a.length;i++)
		{
			if(hm.get(a[i] )== null)
			{
				System.out.println(a[i]);
				hm.put(a[i], true);
			}
		}
	}
	

}
