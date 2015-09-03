package Human;



public class Human implements Comparable<Human> {
	
	private String name;
	private int age;
	private String gender;
	
	Human(String name,int age,String gender)
	{
		this.name = name;
		this.age = age;
		this.gender= gender;
		
	}
	
	Human()
	{}
	
	public boolean equals(Object o)
	{
		if(!(o instanceof Human) )
				return false;
		
		Human h =(Human)o;
		if(this.name.equals(h.name))
			if(age == h.age)
				if(gender.equals(h.gender))
					return true;
		return false;
	}
	
	public String toString()
	{
		return ("NAME : "+name +" AGE : " + age + " GENDER :"+gender);
	}
	
	String getName()
	{
		return name;
	}
	
	
	void talk()
	{
		System.out.println("NAME : "+name);
		System.out.println("AGE :" + age);
		System.out.println("GENDER :"+gender);
	}
    void input()
    {
    	 
    	this.name =  javax.swing.JOptionPane.showInputDialog("Pls Enter name");
		this.age = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Pls Enter age"));
		this.gender= javax.swing.JOptionPane.showInputDialog("Pls Enter gender");
    }

	public int compareTo(Human human) {
		
			return age-human.age;
		
		 }
}
