package org.diptin.trees;

public class BinTreeDriver<E> {
	private static int START = 0;
	
	public BinTreeDriver() {
	}
	
	public BinaryTree<E> createBinaryTree (E[] arr) { 
		if (arr.length == 0)
			return null;
		BinaryTree<E> bTree = new BinaryTree<>(recursiveCreateBinTree(arr, START, arr.length - 1));
		return bTree;
	}
	 
	TreeNode<E> recursiveCreateBinTree(E[] arr, int preIndex, int lastIndex) {
		if (preIndex > lastIndex)
			return null;
		
		int mid = preIndex + (lastIndex - preIndex)/2;
		TreeNode<E> node = new TreeNode<E>(arr[mid]);
		node.leftChild(recursiveCreateBinTree(arr, preIndex, mid - 1));
		node.rightChild(recursiveCreateBinTree(arr, mid + 1, lastIndex));
		
		return node;
	}
	
}