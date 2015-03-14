package org.diptin.linkedList;

public class ListReversal<E> {

	/**
	 * This class is for reversal of singly linked list
	 * @author Dipti
	 * @param E is List node type
	 */
	
	public void reverse(LinkedList<E> list)
	{
		if (list.isEmpty())
				return;
		
		if (!list.getFirstNode().hasNext())
			return;
		
		Node<E> curNode = list.getFirstNode();
		Node<E> head = curNode.getNext();
		Node<E> nextNode = curNode;
		
		curNode = head.getNext();
		nextNode.next(null);
		
		while(curNode!=null)
		{
			head.next(nextNode);
			nextNode = head;
			head = curNode;
			curNode = curNode.getNext();
		}
		head.next(nextNode);
		list.start = head;
	}
	
	public static void main(String[] args) {
		
		ListReversal<Integer> lr = new ListReversal<>();
		LinkedList<Integer> lnList = new LinkedList<Integer>(50);
		
		try{
			lnList.append(15);
			lnList.append(80);
			lnList.append(100);
			lnList.append(150);
			lnList.append(200);
			
			System.out.println("Original Linked List is : ");
			lnList.printList();
			
			System.out.println("Reversed linked list is : ");
			lr.reverse(lnList);
			lnList.printList();			
		}
		catch(Exception e)
		{			
		   e.printStackTrace();
		}
	}

}
