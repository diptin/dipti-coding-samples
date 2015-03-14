package org.diptin.linkedList;

public class DoublyLinkedList<E> {

	/**
	 * This class provides a linked list with two pointers. One Pointer points to next element and
	 * second Pointer points to random element in the list. This is not a circular list i.e. next pointer of last node
	 * of the list points to null.
	 *  
	 * @author Dipti Nirmale
	 * @date 12/11/2014
	 */
	
	RandomListNode<E> start;
	
	public DoublyLinkedList() {
		start = new RandomListNode<>();
	}
	public DoublyLinkedList (E element) {
		start = new RandomListNode<E>(element);
	}
	public DoublyLinkedList (RandomListNode<E> rNode) {
		start = rNode;
	}

	
	public DoublyLinkedList<E> copyList() {
		if (start == null)
			return null;
		
		if (start.next == null)
			return new DoublyLinkedList<>(start);
			
		DoublyLinkedList<E> newList = new DoublyLinkedList<>();
		
		RandomListNode<E> head = start;
		RandomListNode<E> newHead;
		while (head != null) {
			newHead = new RandomListNode<E>(head.element);
			newHead.next = head.next;
			head.next = newHead;
			head = newHead.next;
		}
		head = start;
		while (head != null) {
			head.next.random = head.random.next;
			head = head.next.next;
		}
		head = start;
		newHead = head.next;
		RandomListNode<E> temp = newHead;
		
		while (temp.next != null) {
			head.next = temp.next;
			temp.next = temp.next.next;
			head = head.next;
			temp = temp.next;
		}
		temp.next = null;
		head.next = null;
		newList.start = newHead;
		return newList;
	}
	
	public int getLength() {
		int length = 0;
		RandomListNode<E> head = start;
		while (head != null) {
			length ++;
			head = head.next;
		}
		return length;
	}
	
	public void printList() {
		if (start == null) {
			System.out.println("The list is empty");
			return;
		}		
		RandomListNode<E> head = start;
		while (head != null) {
			head.printRNode();
			head = head.next;
		}
	}
	
	public static void main(String args[]) {
		DoublyLinkedList<Integer> randomDL = new DoublyLinkedList<>(50);
		RandomListNode<Integer> head = randomDL.start;
		head.next = new RandomListNode<Integer>(100);
		RandomListNode<Integer> random = new RandomListNode<Integer>(200); 
		head.random = random;
		head = head.next;
		head.next = random;
		head.random = head;
		head = head.next;
		head.random = randomDL.start;
		System.out.println("The length of Random Doubly Linked List is := " + randomDL.getLength());
		randomDL.printList();
		DoublyLinkedList<Integer> cloneList = randomDL.copyList();
		System.out.println("The length of new copied List is := " + cloneList.getLength());
		cloneList.printList();
//		randomDL.start.printRNode();
	}

}

class RandomListNode<E> {
	E element;
	RandomListNode<E> next;
	RandomListNode<E> random;
	
	public RandomListNode() {
		element = null;
	}
	public RandomListNode(E element) {
		this.element = element;
	}
	
	public void printRNode() {
		System.out.println("\nRandom List Element: " + element);
		
		System.out.print("Next Pointer points to: " );
		if (next == null)
			System.out.println("null");
		else
			System.out.println(next.element);
		
		System.out.print("Random Pointer points to: ");
		if (random == null)
			System.out.println("null");
		else
			System.out.println(random.element);
	}
}
