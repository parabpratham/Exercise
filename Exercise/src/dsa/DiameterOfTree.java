package dsa;

public class DiameterOfTree
{

	/*
	 * Diameter of tree is defined as A longest path or route between any two
	 * nodes in a tree. The path may or may not for through the root.
	 * @Diameter(T) = max( Diameter(T.left), Diameter(T.right),
	 * Height(T.left)+Height(T.right)+1 )
	 */

	private static class Data
	{
		public int	height;
		public int	diameter;
	}

	private static void diameter(Tree.Node root, Data d)
	{
		if (root == null)
		{
			d.height = 0;
			d.diameter = 0;
			return;
		}
		diameter(root.left, d); // get data in left subtree
		int hLeft = d.height;
		int dLeft = d.diameter;
		diameter(root.right, d); // overwrite with data in right tree
		d.diameter = Math.max(Math.max(dLeft, d.diameter), hLeft + d.height + 1);
		d.height = Math.max(hLeft, d.height) + 1;
	}

	public static void main(String[] args)
	{

		DiameterOfTree.Data data = new DiameterOfTree.Data();
		Tree t = Tree.fiiledTreeForDia();
		diameter(t.root, data);
		System.out.println(data.diameter);

	}
}
