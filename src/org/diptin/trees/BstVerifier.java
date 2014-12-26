package org.diptin.trees;

import java.util.ArrayList;
import java.util.ListIterator;


public class BstVerifier<E extends Comparable<E>> {

	/**
	 * This code verifies if given binary tree is Binary Search Tree.
	 * @author Dipti Nirmale
	 */
	
	private static Integer LEFTMAX = Integer.MIN_VALUE;
	private static Integer RIGHTMAX = Integer.MAX_VALUE;
		
	@SuppressWarnings("unchecked")
	public void verifyBST(BinaryTree<E> bTree) {
		if (bTree.getRootOfTree() == null) {
			System.out.println("The tree is empty");
		}
		else
		{
			boolean isBst = false;
			TreeNode<E> root = bTree.getRootOfTree();
			if(isNodeBST(root)) {
				isBst = true;
				if (root.hasLeftChild())
					isBst = recVerifyBst(root.getLeftChild(), (E)LEFTMAX, root.getElement());
				if (isBst && root.hasRightChild())
					isBst = recVerifyBst(root.getRightChild(), root.getElement(), (E)RIGHTMAX);				
			}
			if (isBst == true)
				System.out.println("The tree is BST");
			else
				System.out.println("The tree is NOT BST");
		}
	}
	
	private boolean recVerifyBst(TreeNode<E> node, E leftMax, E rightMax) {
		if (node == null)
			return true;
		
		if (!isNextSmaller(node.getElement(), leftMax)) 
			return false;
		
		if (isNextSmaller(node.getElement(), rightMax))
			return false;
		
		if (isNodeBST(node)) {
			if (node.hasLeftChild())
				recVerifyBst(node.getLeftChild(), leftMax, node.getElement());
			if (node.hasRightChild())
				recVerifyBst(node.getRightChild(), node.getElement(), rightMax);
		}
		return true;
	}
	
	private boolean isNodeBST (TreeNode<E> node)
	{
		boolean isBst = true;
		if (node.hasLeftChild() && !isNextSmaller(node.getElement(), node.getLeftChild().getElement()))
			isBst = false;
		if (isBst && node.hasRightChild() && isNextSmaller(node.getElement(), node.getRightChild().getElement()))
			isBst = false;
		return isBst;
	}
	
	public void verifyBSTInorder(BinaryTree<E> bTree) {
		if (bTree.getRootOfTree() == null)
			System.out.println("The tree is empty");
		else {
			ArrayList<E> arrl = new ArrayList<>();
			traverseInorder(bTree.getRootOfTree(), arrl);
			
			if (isListSorted(arrl))
				System.out.println("The tree is Binary Search Tree");
			else
				System.out.println("The tree is NOT Binary Search Tree");
		}
	}
	
	private void traverseInorder (TreeNode<E> root, ArrayList<E> arrl) {
		if (root == null)
			return;
		traverseInorder(root.getLeftChild(), arrl);
		arrl.add(root.getElement());
		traverseInorder(root.getRightChild(), arrl);
		return;
	}
	
	private boolean isListSorted(ArrayList<E> arrl)
	{
		E min = arrl.get(0);
		ListIterator<E> lit = arrl.listIterator();
		while (lit.hasNext()) {
			E next = lit.next();
			if (isNextSmaller(min, next))
				return false;
			min = next;
		}
		return true;
	}
	
	private boolean isNextSmaller(E first, E next) {
		if (first.compareTo(next) <= 0)
			return false;
		return true;
	}

	public static void main(String[] args) {
		
		Integer[] arr = {10, 90, 50, 30, 40, 70, 70};
//		Integer[] arr = {10, 20, 30, 40, 50, 60, 70};
		BinTreeDriver<Integer> btd = new BinTreeDriver<>();
		BinaryTree<Integer> bTree = btd.createBinaryTree(arr);
		
		BstVerifier<Integer> bstVerf = new BstVerifier<>();
//		bstVerf.verifyBSTInorder(bTree);
		bstVerf.verifyBST(bTree);
		
		
		System.out.println("In order traversal of Binary tree");
		bTree.traverseInorder(bTree.getRootOfTree());
		
		System.out.println("\nPre order traversal of Binary tree");
		bTree.traversePreorder(bTree.getRootOfTree());
		
		System.out.println("\nPost order traversal of Binary tree");
		bTree.traversePostorder(bTree.getRootOfTree());
		
		System.out.println("\nLevel order (BFS) traversal of Binary tree");
		bTree.traverseBfs(bTree.getRootOfTree());
		
//		BinaryTree<Integer> bTree= new BinaryTree<>(10);
//	    TreeNode<Integer> left = bTree.createTreeNode(new Integer(20));
//	    TreeNode<Integer> right = bTree.createTreeNode(new Integer(30));
//	    TreeNode<Integer> root = bTree.getRootOfTree();
//	    root.leftChild(left);
//	    root.rightChild(right);
//	    left = bTree.createTreeNode(40);
//	    right.leftChild(left);  
//	    bTree.traverseInorder(root);
//	    System.out.println(root.getElement());
//	    System.out.println(bTree.getHeightOfTree(root));
	}

}
