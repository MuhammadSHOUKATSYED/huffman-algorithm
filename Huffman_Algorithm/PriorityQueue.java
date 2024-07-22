package Data_Structures_Final_Project;
import java.util.*;
public class PriorityQueue {
   int front;
   int rear;
   int capacity;
   BTNode queue[];
   public PriorityQueue(int size){
	   front=0;
	   rear=0;
	   capacity=size;
	   this.queue= new BTNode[capacity];
   }
   public void queueEnqueue(BTNode btnode) {
	   if(capacity==rear) {
		   System.out.println("Capacity is full");
		   return;
	   }
	   else {
		   queue[rear]=btnode;
		   rear++;
		   bubblesort();
	   }
	   return;
   }
   public void bubblesort() {
	    BTNode temp;
    	for(int i=front;i<rear-1;i++) {
    		int flag=0;
    		for(int j=front;j<rear-1-i;j++) {
    			if(queue[j].frequency>queue[j+1].frequency) {
    				temp=queue[j];
    				queue[j]=queue[j+1];
    				queue[j+1]=temp;
    				flag=1;
    			}
    			
    		}
    		if(flag==0) {
    			break;
    		}
    		
    	}
   }
   public BTNode deletemin() {
	  BTNode deletedmin=queue[0];
	   if(front==rear) {
		   System.out.println("Queue is Empty");
	   }
	   else {
		   for(int i=0;i<rear-1;i++) {
			   queue[i]=queue[i+1];
		   }
		   rear--;
	   }
	   return deletedmin;
   }
   public void Front() {
        if(front==rear) {
		   System.out.println("Queue is Empty");
		   return;
	   }
        System.out.println("Front element of the Queue is: "+queue[front].frequency+"\t"+queue[front].data);
   return;
   }
   public void makeNull() {
	   front=rear;
   }
   public BTNode peek() {
	   return queue[front];
   }
   public boolean Empty() {
	   if(front==rear) {
		  return true;
	   }
	   else {
		   return false;
	   }
   }
   public int size() {
	   return rear;
   }
   public void queueDisplay() {
	int index;
	if(front==rear) {
		System.out.println("Queue is Empty");
		return;
	}
	for(index=front;index<rear;index++) {
		 System.out.println("\t\tFrequency: "+queue[index].frequency+"\t"+"Character: "+queue[index].data);	
	}
	return;
   }
}
