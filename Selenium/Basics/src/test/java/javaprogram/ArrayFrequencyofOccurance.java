package javaprogram;

import java.util.HashMap;

public class ArrayFrequencyofOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {1,2,2,3,3,44,5,5,9,};
		HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
		
		for(int a1 : a)
		{
			if(hm.containsKey(a1))
			{
				hm.put(a1, hm.get(a1)+1);
			}
			else
			{
				hm.put(a1, 1);
			}
		}
		System.out.println(hm);
		
	}

}
