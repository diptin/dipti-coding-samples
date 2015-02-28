package org.diptin.trees;

import java.util.LinkedList;
import java.util.List;

public class IterativeTraversal {

	/**
	 * This class performs traversal of binary tree iteratively->
	 * Inorder, Preorder and Postorder
	 * @param args
	 * @author Dipti
	 * @param <E>
	 */
	
    public static <E> List<E> traverseInorder(BinaryTree<E> bTree) 
	{
		TreeNode<E> node = bTree.getRootOfTree();
		LinkedList<TreeNode<E>> stack = new LinkedList<>();
		List<E> outList = new LinkedList<>();
		
		while (node!=null || !stack.isEmpty())
		{
			while (node!=null)
			{
				stack.push(node);
				node = node.getLeftChild();
			}
			
			node = stack.pop();
//			System.out.print(node.getElement() + "\t");
			outList.add(node.getElement());
			node = node.getRightChild();
		}
		return outList;
	}
	
	public static <E> List<E> traversePreorder(BinaryTree<E> bTree) 
	{
		TreeNode<E> node = bTree.getRootOfTree();
		LinkedList<TreeNode<E>> stack = new LinkedList<>();
		List<E> outList = new LinkedList<>();
		do{
			while (node!=null)
			{
//				System.out.print(node.getElement() + "\t");
				outList.add(node.getElement());
				if (node.hasRightChild())
					stack.push(node.getRightChild());
				node = node.getLeftChild();
			}
			if(!stack.isEmpty())
				node = stack.pop();
		} while (node!=null);
		return outList;
	}
	
	public static <E> List<E> traversePostorder(BinaryTree<E> bTree) 
	{
		TreeNode<E> node = bTree.getRootOfTree();
		LinkedList<TreeNode<E>> stackTemp = new LinkedList<>();
		LinkedList<TreeNode<E>> stackMain = new LinkedList<>();
		
		while (node != null)
		{
			if (node.hasLeftChild())
				stackTemp.push(node.getLeftChild());
			if (node.hasRightChild())
				stackTemp.push(node.getRightChild());
			stackMain.push(node);
			if (stackTemp.isEmpty())
				node = null;
			else
				node = stackTemp.pop();
		}
		
		List<E> outList = new LinkedList<>();
		
		while (!stackMain.isEmpty())
		{
			node = stackMain.pop();
//			System.out.print(node.getElement() + "\t");
			outList.add(node.getElement());
		}
		return outList;
	}
}
