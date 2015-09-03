
public class PrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int count =0,number = 2;
		System.out.println("Prime numbers are :");
		while(count < 10)
		{
			if( isPrime(number) == true)
			{				
			  System.out.println(number);
			  count++;
			}
			number++;
			
		}
	}
	static boolean isPrime(int numberToCheck)
	{
		for(int counter=2;counter< numberToCheck /2;counter++)
		{
			if(numberToCheck % counter == 0)
				return false;
		}
		return true;
	}
}
