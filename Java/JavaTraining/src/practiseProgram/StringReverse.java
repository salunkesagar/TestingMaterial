package practiseProgram;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="madam";
		String s1="";
		for (int i=s.length()-1;i>=0;i--)
		{
			s1 = s1 + s.charAt(i);
		}
		System.out.println(s1);
		if(s.equals(s1))
		{
			System.out.println("palimdrome");
		}
		else
		{
			System.out.println("Not palindrome");
		}
		
	}

}
