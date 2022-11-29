package javaprogram;

public class String_Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "Sagar Salunke";
		String[] a1 = a.split("\\s");
		String s ="";
		for(int i=a1.length-1;i>=0;i--)
		{
			s= s + a1[i];
		}
		System.out.println(s+" ");
	}

}
