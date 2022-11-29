package javaprogram;

import java.util.HashMap;

public class DuplicateCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a ="Sagar Salunke";
		char[]  a1 = a.toCharArray();
		HashMap<Character, Integer> hm =  new HashMap();
		for(char ch:a1)
		{
			if(hm.containsKey(ch))
			{
				hm.put(ch, hm.get(ch)+1);
				
					
				
			}
			else
			{
				hm.put(ch, 1);
			}
		}
		System.out.println(hm);

	}

}
