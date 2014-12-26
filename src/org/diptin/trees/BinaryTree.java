package org.diptin.trees;

import java.util.LinkedList;

public class BinaryTree<E> {
/**
 * This class gives Binary Tree and its traversal
 * @param E Type of Element in Tree node
 * @author Dipti Nirmale
 */
	private TreeNode<E> root;

	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(E element) {
		root = new TreeNode<>(element);
	}
	
	public BinaryTree(TreeNode<E> root) {
		this.root = root;
	}
	
	public TreeNode<E> createTreeNode(E element) {
		TreeNode<E> node = new TreeNode<>(element);
		return node;
	}
	
	public TreeNode<E> getRootOfTree() {
		return root;
	}
	
//	public void setRootOfTree(TreeNode<E> node) {
//		root = node;
//	}
			
	public int getHeightOfTree(TreeNode<E> root) {
		if (root == null)
			return 0;
		
		int heightOfLeftSubTree = 0;
		int heightOfRightSubTree = 0;
		
		if (root.hasLeftChild()) 
			heightOfLeftSubTree = getHeightOfTree(root.leftChild); 
			
		if (root.hasRightChild())
			heightOfRightSubTree = getHeightOfTree(root.rightChild);
		
		int height = 1 + Math.max(heightOfLeftSubTree, heightOfRightSubTree);
		return height;
	}
	
	public void traverseInorder(TreeNode<E> root) {
		if (root == null)
			return;
		
		traverseInorder(root.getLeftChild());
		System.out.print("\t" + root.getElement());
		traverseInorder(root.getRightChild());
	}
	public void traversePreorder(TreeNode<E> root) {
		if (root == null)
			return;
		
		System.out.print("\t" + root.getElement());
		traversePreorder(root.getLeftChild());
		traversePreorder(root.getRightChild());
	}
	public void traversePostorder(TreeNode<E> root) {
		if (root == null)
			return;
		
		traversePostorder(root.getLeftChild());
		traversePostorder(root.getRightChild());
		System.out.print("\t" + root.getElement());
	}	
	
	// Level Order Traversal
	public void traverseBfs(TreeNode<E> root) {
		
		if (root == null)
			return;
		
		LinkedList<TreeNode<E>> queue = new LinkedList<>();
		queue.push(root);
		
		while (!queue.isEmpty()) {
			root = queue.pollLast();
			System.out.print("\t" + root.getElement());
			if (root.hasLeftChild())
				queue.push(root.getLeftChild());
			if (root.hasRightChild())
				queue.push(root.getRightChild());
		}
	}
}

class TreeNode<E> {
	E element;
	TreeNode<E> leftChild;
	TreeNode<E> rightChild;
	
	public TreeNode() {
		element = null;
		leftChild = null;
		rightChild = null;
	}
	
	public TreeNode(E element) {
		this.element = element;
		leftChild = null;
		rightChild = null;
	}
	
	public E getElement() {
		return element;
	}
	
	public void element(E value) {
		this.element = value;
	} 
	
	public TreeNode<E> getLeftChild() {
		return leftChild;
	}
	
	public TreeNode<E> getRightChild() {
		return rightChild;
	}
	
	public void leftChild(TreeNode<E> left) {
		leftChild = left;
	}
	
	public void rightChild(TreeNode<E> right) {
		rightChild = right;
	}
	
	public boolean hasLeftChild()
	{
		if (leftChild == null)
			return false;
		else
			return true;
	}
	
	public boolean hasRightChild()
	{
		if (rightChild == null)
			return false;
		else
			return true;
	}
}
