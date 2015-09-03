package dsa;

import dsa.Tree.Node;

public class BTBoundary
{
	/*
	 * Print a full binary tree's boundary in counterclockwise order
	 * 
	 * 			1
	 *       2      3
	 *     4  5    6  7
	 *     
	 *     1-2-4-5-6-7-3
	 */

	public static void main(String[] args)
	{

		Tree t = Tree.fiiledTree();

		// preorder traversal of leftmost elements
		printLeftMost(t);

		// inorder of the leaf nodes
		inorderTraverse(t.root);

		// postorder for rightmost
		printRightMost(t.root.right);
	}

	private static void printRightMost(Tree.Node cuurenNode)
	{

		if (cuurenNode.right != null)
			printRightMost(cuurenNode.right);
		if (cuurenNode.left != null || cuurenNode.right != null)
		{
			System.out.print(cuurenNode.data + " ");
		}
	}

	private static void inorderTraverse(Node cuurenNode)
	{
		if (cuurenNode.left != null)
			inorderTraverse(cuurenNode.left);
		if (cuurenNode.left == null && cuurenNode.right == null)
			System.out.print(cuurenNode.data + " ");
		if (cuurenNode.right != null)
			inorderTraverse(cuurenNode.right);

	}

	private static void printLeftMost(Tree t)
	{
		Tree.Node cuurenNode = t.root;
		while (cuurenNode.left != null && cuurenNode.right != null)
		{
			System.out.print(cuurenNode.data + " ");
			cuurenNode = cuurenNode.left;
		}
	}
}
