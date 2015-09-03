package dsa;

public class Tree
{

	Node	root;

	public Tree()
	{

	}

	public Tree(int data)
	{
		root = new Node(data);
	}

	public Node addNode(Node parent, int lr, int data)
	{
		Node node = new Node(data);
		if (lr < 1)
			parent.left = node;
		else
			parent.right = node;

		return node;
	}

	public class Node
	{
		public int	data;
		public Node	left;
		public Node	right;

		public Node(int data)
		{
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args)
	{
		Tree t = new Tree();
		Tree.Node head = t.new Node(1);
		t.root = head;

		Node n2 = t.addNode(head, -1, 2);
		Node n3 = t.addNode(head, 1, 3);

		Node n4 = t.addNode(n2, -1, 4);
		Node n5 = t.addNode(n2, -1, 5);

		Node n6 = t.addNode(n3, -1, 6);
		Node n7 = t.addNode(n3, -1, 7);

	}

	public static Tree fiiledTree()
	{

		Tree t = new Tree();
		Tree.Node head = t.new Node(1);
		t.root = head;
		Node n2 = t.addNode(head, -1, 2);
		Node n3 = t.addNode(head, 1, 3);
		Node n4 = t.addNode(n2, -1, 4);
		Node n5 = t.addNode(n2, 1, 5);
		Node n6 = t.addNode(n3, -1, 6);
		Node n7 = t.addNode(n3, 1, 7);

		return t;
	}

	public static Tree fiiledTreeForDia()
	{

		Tree t = new Tree();
		Tree.Node head = t.new Node(1);
		t.root = head;
		Node n2 = t.addNode(head, -1, 2);
		Node n3 = t.addNode(head, 1, 3);
		Node n4 = t.addNode(n2, -1, 4);
		Node n5 = t.addNode(n2, 1, 5);
		Node n6 = t.addNode(n5, -1, 6);
		Node n7 = t.addNode(n6, 1, 7);
		Node n8 = t.addNode(n4, -1, 8);

		return t;
	}
}
