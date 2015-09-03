
public class Palindrome {
	
	public static void main(String[] args)
	{
//		String input,output;
//		
//		input = javax.swing.JOptionPane.showInputDialog("Enter A string");
//		
//		int index;
//		 output = input.substring(0,0);
//		for(index=0;index<input.length();index++)
//		{
//			output = input.charAt(index) + output;
//		}
//		
//		if(input.equals(output)==true)
//		{
//			System.out.println(input + " is a Palindrome");
//			
//		}
//		else
//		{
//			System.out.println(input + " is a not a Palindrome" + output);
//			
//		}
//		
//		boolean ispal=true;
//		int len = input.length();
//		for(index=0;index<= len/2;index++)
//		{
//			if(input.charAt(index) != input.charAt(len-index -1))
//			ispal=false;
//		}
//		if(ispal)
//		{
//			System.out.println(input + " is a Palindrome");
//			
//		}
//		else
//		{
//			System.out.println(input + " is a not a Palindrome " + input.length());
//			
//		}
		
		String query = "select TO_Char(colDate,'DD-MM-YYYY') from table where a < b ";
		
		int startIndex = query.indexOf('(')+1;
		int endIndex = query.indexOf(')');
		String quString = query.substring(startIndex,endIndex);
		System.out.println(quString);
		String[] queryPa = quString.split(",");
		System.out.println(queryPa[0]+" & "+queryPa[1]);
		String fromTabString = query.substring(endIndex+1,query.length());
		String[] queryPaA = fromTabString.split(" ");
		String tablename = queryPaA[1];
		
	}

}
