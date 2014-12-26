package org.diptin.linkedList;

public class PairSwapper<E> {

	/**
	 * This class provides methods for pairwise swapping of consecutive nodes in singly linked list
	 * @author Dipti
	 * @param E is List Node type
	 */
	
	public void swapPairs(LinkedList<E> list)
	{
		if (list.isEmpty())
			return;
	
		if (!list.getFirstNode().hasNext())
			return;
		
		Node<E> start = list.getFirstNode();
		Node<E> head = start;
		Node<E> curNode = start.getNext();
		
		start = curNode;
	    Node<E> lastNode = head;
		
	    while(head!=null && head.hasNext())
		{
			head.next(curNode.getNext());
			curNode.next(head);
			lastNode = head;
			if(lastNode!=null && lastNode.hasNext())
			{
				head = lastNode.getNext();
				curNode = head.getNext();
				if(curNode!=null)
					lastNode.next(curNode);
			}
		}
		list.start = start;
	}
	
	public Node<E> recSwapPairs(Node<E> start) {
		if (start == null)
			return null;
		
		if (!start.hasNext())
			return start;
		
		Node<E> head = start.getNext();
		Node<E> temp = head.getNext();
		
		head.next(start);
		start.next(recSwapPairs(temp));
		
		return head;
	}
	
	public static void main(String[] args) {
		PairSwapper<Integer> ps = new PairSwapper<>();
		LinkedList<Integer> lnList = new LinkedList<Integer>(50);
		try{
			lnList.append(15);
			lnList.append(80);
			lnList.append(100);
			lnList.append(150);
		//	lnList.append(200);
		
			System.out.println("The original list is : ");
			lnList.printList();

			System.out.println("List after pair swapping of elements iterative way : ");
			ps.swapPairs(lnList);
			lnList.printList();
			
			System.out.println("List after pair swapping of elements recursive way : ");
			lnList.start = ps.recSwapPairs(lnList.start);
			lnList.printList();
		}
		catch(Exception e)
		{
		   e.printStackTrace();
		}
	}

}
