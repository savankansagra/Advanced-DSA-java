package assignmentOne;

class Node{
	public int data;
	public Node next;
	
	Node(int data){
		this.data = data;
	}
	
	Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
}

public class StackADTLinkedList {
	
	/*
	WAP to implement Stack ADT using Linked list with the basic operations as
	Create(), Is Empty(), Push(), Pop(), IsFull() with appropriate prototype to a
	functions.
	 */
	
	Node start;
	Node pointer;
	
	
	public boolean isEmpty() {
		if(start == null) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		return false; // because we can create the node untill memory full.
	}
	
	public void create(int data) { //create first node of linked list.
		start = new Node(data);
		pointer = start;
	}
	
	public void push(int data) { //insert node into linked list.
		if(this.isFull()) {
			System.out.println("stack is full.");
		} else if( start == null ) {
			create(data);
		} else {
			Node temp = new Node(data);
			pointer.next = temp;
			pointer = pointer.next;
		}
	}
	
	public int pop() {
		if(this.isEmpty()) {
			System.out.println("stack is empty.");
			return -1;
		} else if(start == pointer) {
			int data = pointer.data;
			pointer = null;
			start = null;
			return data;
		} else {
			int data = pointer.data;
			// Point to last to second node.
			Node stPointer = start;
			Node prePointer = start;
			while(stPointer.next != null) {
				prePointer = stPointer;
				stPointer = stPointer.next;
			}
			prePointer.next = null; //deleting the last node.
			return data;
		}
	}
	
	public int peek() {
		if(this.isEmpty()) {
			System.out.println("stack is empty.");
			return -1;
		} else {
			int data = pointer.data;
			return data;
		}
	}
	
	
}
