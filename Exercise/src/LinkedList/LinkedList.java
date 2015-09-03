package LinkedList;


	public class LinkedList
	{
		Node first=null;
		
		void addNode(String temp)
		{
			if(this.first==null)
			{
				addFirst(temp);
			}
			else
			{
				Node tempNode = this.first;
			
				while(tempNode.next != null)
				{
					tempNode = tempNode.next;
				}
				
			  addNode(temp,tempNode);
			}
		}
		void addFirst(String temp)
		{
			this.first  = new Node();
			this.first.s = temp; 
		}

		static void addNode(String temp,Node afterNode)
		{
			Node tempNode = new Node();
			tempNode.s = temp;
			tempNode.next  = afterNode.next;
		
		 	afterNode.next = tempNode;
		 	
		}

		 void addNode(String temp,String prev)
		{

			Node tempNode = this.first;
			
				while(!tempNode.s.equals(prev))
				{
					tempNode = tempNode.next;
				}
				
			addNode(temp,tempNode);	
			
		}
		 void show()
		 {
		 	if(first==null)
		 	{
		 		System.out.println("List is Empty");
		 	}
		 	else
		 	{
		 	Node tempNode = first;
		 	int counter =1;
		 	while(tempNode != null)
		 	{
		 		System.out.println(counter++ + "> Value = " + tempNode.s);
		 		tempNode = tempNode.next;
		 	}
		 	}
		 }
		
}


