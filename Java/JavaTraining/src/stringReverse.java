
public class stringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "madam";
		String s1="";
		for(int i=s.length()-1;i>=0;i--)
		{
			s1 = s1 + s.charAt(i);
		}
		System.out.println(s1);
		
		if(s.equals(s1))
		{
			System.out.println("String is palindrome");
		}
		else
		{
			System.out.println("String is not palindrome");
		}

	}

}
