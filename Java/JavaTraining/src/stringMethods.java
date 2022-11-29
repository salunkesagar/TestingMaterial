import javax.swing.plaf.synth.SynthOptionPaneUI;

public class stringMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a= " hello";
		System.out.println(a.charAt(1));
		System.out.println(a.indexOf("l"));
		System.out.println(a.length());
		System.out.println(a.substring(2, 5));
		System.out.println(a.substring(2));
		System.out.println(a.toUpperCase());
		System.out.println(a.concat("World"));
		System.out.println(a.trim());
		System.out.println(a.replace("e", "a"));
		String arr[] = a.split("l");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		

	}

}
