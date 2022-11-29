package javaprogram;

import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayDuplicateSet {
	
	public static void main(String[] args) {
	
		
		int[] a = {1,2,2,4,5,4,3,6};
		LinkedHashSet<Integer> st = new LinkedHashSet();
		for(int i=0;i<a.length;i++)
		{
			st.add(a[i]);
		}
		System.out.println(st);
	}
	

}
