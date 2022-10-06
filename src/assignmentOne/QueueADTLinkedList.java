package assignmentOne;


public class QueueADTLinkedList {
	/*
	WAP to implement Queue ADT using Linked list with the basic functions of
	Create(), IsEmpty(), Insert(), Delete() and IsFull() with suitable prototype to a
	functions 
	 */
	Node front;
	Node rear;
	int size;
	
	public boolean isEmpty() {
		if(size==0 && front==rear) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		return false; //till memory became the full.
	}
	
	public void create(int data) { //create first node in list.
		rear = front = new Node(data);
		size = 1;
	}
	
	public void insert(int data) {
		if(isFull()) {
			System.out.println("Queue is full.");
		} else {
			if(isEmpty()) {
				create(data);
			} else {
				Node temp = new Node(data);
				rear.next = temp;
				rear = rear.next;
				size++;
			}
		}
	}
	
	public int delete() {
		if(isEmpty()) {
			System.out.println("Queue is empty.");
		} else if(size == 1) { //Queue contain only one element.
			int data = front.data;
			front = rear = null;
			size = 0;
			return data;
		} else {
			int data = front.data;
			front = front.next;
			size--;
			return data;
		}
		return -1;
	}
	

}
