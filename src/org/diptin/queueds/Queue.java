package org.diptin.queueds;

public class Queue {
	
 	 private int arr[];
 	 private int head, tail;
 	 
 	 public Queue(int size){
 		 this.arr = new int[size];
 		 head = tail = 0;
 	 }
 	 
 	 public void addToQueue(int element){
 		 if(isQueueFull())
 			 System.out.println("The Queue is already full; can not add new entry into the Queue.");
 		 else{
 			 if(tail==arr.length-1){
 				 arr[tail]=element;
 				 tail = 0;
 			 }
 			 else{
 			     arr[tail]=element;
 			     tail++;
 			 }
 		 }
 	 }
 	 
 	 public int removeFromQueue()
 	 {
 		 if(isQueueEmpty())
 			 return -1;
 		 else{
 			 int temp = arr[head];
 			 if(head==arr.length-1)
 				 head = 0;
 			 else
 				 head++;
 			 return temp;
 		 }
 	 }
 	 
 	 public boolean isQueueFull()
 	 {
 		 if(head==0 && tail==arr.length-1)
 			 return true;
 		 if(tail == head-1)
 			 return true;
 		 return false;
 	 }
 	 public boolean isQueueEmpty()
 	 {
 		 if(head==tail)
 			 return true;
 		 return false;
 	 }
 	 public int getFirstElement()
 	 {
 		 return arr[head];
 	 } 	 
 	 public int getLastElement()
 	 {
 		 return arr[tail-1];
 	 }
 	 
 	 public int QueueSize()
 	 {
 		 return arr.length;
 	 }
 	 
}
