package org.diptin.trees;

public class TreeNode<E> {
	private E element;
	private TreeNode<E> leftChild;
	private TreeNode<E> rightChild;

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