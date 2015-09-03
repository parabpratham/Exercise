package Files;

public class BOProperties
{
	public BOProperties()
	{
	}

	public BOProperties(String propertyName, String propertyType, String propertyDBname, String propertyDBtype)
	{
		this.propertyName = propertyName;
		this.propertyType = propertyType;
		this.propertyDBname = propertyDBname;
		this.propertyDBtype = propertyDBtype;
	}

	String	propertyName;
	String	propertyType;
	String	propertyDBname;
	String	propertyDBtype;
}
