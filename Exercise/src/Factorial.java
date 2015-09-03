import java.io.ObjectInputStream.GetField;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int n,factorial=1;
		
		//String temp = javax.swing.JOptionPane.showInputDialog("Please Enter a number whose Factorial is to be found");
		n = Integer.parseInt("2");
		
		
  		for(int count =n;count>1;count--)
		{
			factorial = factorial * count ;
		}
			
		System.out.println("Factorial is \n" + factorial);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		String date = "1-01-2011";
		Date actDate = getNextDate(Calendar.getInstance(), dateFormat.parse(date));
		System.out.println(Calendar.getInstance().getTime()+" - "+actDate);
		
		dateFormat = new SimpleDateFormat(date);
		actDate = dateFormat.parse(date);
		System.out.println(actDate);
	}
	
	public static Date getNextDate(Calendar calendar, Date prevDate) {
		Date calculatedPrevDate = prevDate;
		calendar.setTime(calculatedPrevDate);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calculatedPrevDate = calendar.getTime();
		return calculatedPrevDate;
	}

}
