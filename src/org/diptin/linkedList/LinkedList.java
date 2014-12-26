package org.diptin.linkedList;

public class LinkedList<E>
{	
	/**
	 * This class provides a Singly Linked List.
	 * @author Dipti Nirmale 
	 */
	
	Node<E> start;
		
	LinkedList()
	{
		start = null;
	}
	
	LinkedList(E num)
	{
		start = new Node<E>(num);
	}
	
	public LinkedList<E> creatLinkedList(Node<E> list_start)
	{
		start = list_start;
		return this;
	}
	
	public Node<E> getFirstNode()
	{
		return start;
	}
	
	
	public boolean isEmpty()
	{
		if (start==null)
			return true;
		return false;
	}
	
	public void append(E num){
		if(this.start==null)
			this.start = new Node<E>(num);
		else{
			Node<E> head = start;
			while (head.getNext()!=null)
				head = head.getNext();
			head.next(new Node<E>(num));
		}
	}
	
	public void printList(){
		Node<E> head = start;
		while (head!=null)
		{
			System.out.print(head.getElement() + " -> ");
			head = head.getNext();
		}
		System.out.println("/");
	}
}

class Node<E>{
	
	private E data;
	private Node<E> next;
	
	Node(E num)
	{
		this.data = num;
		this.next = null;
	}
	
	public Node<E> getNext()
	{
		if (this.next==null) 
			return null;
		return this.next;
	}
	
	void next(Node<E> nextNode)
	{
		this.next = nextNode;
	}
	
	public E getElement()
	{
		return this.data;
	}
	
	public boolean hasNext()
	{
		if (this.next==null)
			return false;
		return true;
	}
}
