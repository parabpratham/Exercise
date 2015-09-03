package Human;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.*;


public class Test {

	public static void main(String[] args)
	{
//		Employee emp;
//		emp = new Employee("Pra",22,"male","bank",17000);
//		emp.talk();
//		System.out.println("");
//		//emp.input();
//		emp.talk();
//		emp.goToWork();
//		emp.calcualteSalary();
////		
//		
//		Employee h1 = new Employee("Pra",22,"male","IT",12000);
//		Object h2 = new Human("Pra",22,"male");
//		
//		if(h1.equals(h2))
//			System.out.println(h1);	
//		else
//			System.out.println("Not Equals");
//		
//		 StringTokenizer st = new StringTokenizer(h1.toString());
//	     while (st.hasMoreTokens()) {
//	         System.out.print(st.nextToken()+",");
//	     }
//	     System.out.println("");
//	     String[] s= h1.toString().split(":");
//	     for(String si:s)
//	     {
//	    	 System.out.print(si+",");
//	     }
//	     
//	     int n= javax.swing.JOptionPane.showInternalConfirmDialog(null, st) ;
		
		
//		List<Human> humans = new LinkedList<Human>();
//		humans.add(new Human("Pra",22,"male"));
//		humans.add(new Human("Pra1",25,"male"));
//		humans.add(new Human("Pra2",22,"male"));
//		humans.add(new Human("Pra3",21,"male"));
//		Human h1 = new Employee("Pra",20,"male","IT",12000);
//		humans.add(h1);
//		Collections.sort(humans);
//		for(Human h:humans)
//		{
//			System.out.println(h);
//		}
//		System.out.println("");
//		NewComparator nam = new NewComparator();
//		Collections.sort(humans,nam);
//		for(Human h:humans)
//		{
//			System.out.println(h);
//		}
		
		String name= "name";
		String[] names = name.split(",");
		int i =0;
		for(String string: names)
		{
				System.out.println(i++ + " " + string);
		}
	}

}
