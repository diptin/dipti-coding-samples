package org.diptin.trees.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.diptin.trees.BinaryTree;
import org.diptin.trees.IterativeTraversal;
import org.diptin.trees.TreeNode;
import org.junit.Test;

public class IterativeTraversalTest {
	
	private BinaryTree<Integer> bTree;
	
	public IterativeTraversalTest()
	{
		TreeNode<Integer> root = new TreeNode<>(1);
		root.leftChild(new TreeNode<>(2));
		root.rightChild(new TreeNode<>(3));
		TreeNode<Integer> left = root.getLeftChild();
		TreeNode<Integer> right = root.getRightChild();
		left.leftChild(new TreeNode<>(4));
		left.rightChild(new TreeNode<>(5));
		right.leftChild(new TreeNode<>(6));
		left.getRightChild().rightChild(new TreeNode<>(7));
		right.getLeftChild().rightChild(new TreeNode<>(8));
		
		bTree = new BinaryTree<>(root);
	}

	@Test
	public void testTraverseInorder() {
		Integer[] arr = {4,2,5,7,1,6,8,3};
		List<Integer> expected = Arrays.asList(arr); 
		assertEquals(expected, IterativeTraversal.traverseInorder(bTree));
	}

	@Test
	public void testTraversePreorder() {
		Integer[] arr = {1,2,4,5,7,3,6,8};
		List<Integer> expected = Arrays.asList(arr); 
		assertEquals(expected, IterativeTraversal.traversePreorder(bTree));
	}

	@Test
	public void testTraversePostorder() {
		Integer[] arr = {4,7,5,2,8,6,3,1};
		List<Integer> expected = Arrays.asList(arr); 
		assertEquals(expected, IterativeTraversal.traversePostorder(bTree));
	}

}
