package Human;

import java.util.Comparator;

public class NewComparator implements Comparator<Human>{

	public int compare(Human h1, Human h2) {
		
		return h1.getName().compareToIgnoreCase(h2.getName());
	}

	
}
