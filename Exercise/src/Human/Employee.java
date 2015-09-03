package Human;

public class Employee extends Human {
	
	private String depart;
	private int salary;
	
	Employee()
	{}
	
	Employee(String name,int age,String gender,String depart,int salary)
	{
		super(name,age,gender);
		this.depart = depart;
		this.salary = salary;
		
	}
	void goToWork()
	{
		System.out.println("I go daily to work & do nothing");
	}
	void calcualteSalary()
	{
		System.out.println("SALARY = " + salary * 12);
	}
	
	public String toString()
	{
		return (super.toString() + " DEPARTMENT: "+depart + "SALARY: " + salary);
	}

	public boolean equals(Object o)
	{
		if(!(o instanceof Employee) )
				return false;
		Employee e =(Employee)o;
		if(!super.equals(o))
		return false;
		
		
		return(salary == e.salary && depart.equals(e.depart));
			
		
	}
	
	void talk()
	{
		super.talk();
		System.out.println("DEPARTMENT : "+depart);
		System.out.println("SALARY :" + salary);
		
	}
    void input()
    {
    	 super.input();
    	this.depart =  javax.swing.JOptionPane.showInputDialog("Pls Enter department");
		this.salary = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Pls Enter salary"));
		
    }

	

}
