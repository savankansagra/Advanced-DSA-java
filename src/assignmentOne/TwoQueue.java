package assignmentOne;

public class TwoQueue {
	
	/*
	WAP to implement 2 overlapping queues in an array of size ‘N’. There are facing in
	opposite direction to eachother. Give IsEmpty(i), Insert(i), Delete(i) and IsFull(i)
	routines for ith queue
	 */

	int n;
	int front1, rear1;
	int front2, rear2;
	int a[];
	
	public TwoQueue() {
		n = 20;
		front1 = rear1 = -1;
		front2 = rear2 = n;
		a = new int[n];
	}
	
	public TwoQueue(int n, int front1, int rear1, int front2, int rear2, int[] a) {
		super();
		this.n = n;
		this.front1 = front1;
		this.rear1 = rear1;
		this.front2 = front2;
		this.rear2 = rear2;
		this.a = a;
	}
	
	public boolean isEmpty(int queueNumber) {
		if(queueNumber == 1) {
			if(rear1 == -1) {
				return true;
			}
		} else if(queueNumber == 2) {
			if(rear2 == n) {
				return true;
			}
		} 
		return false;
	}
	
	public boolean isFull(int queueNumber) {		
		if(rear1 == rear2) {
			return true;
		}
		return false;
	}
	
	public void insert(int queueNumber, int data) {
		if(queueNumber == 1) {
			if(isFull(queueNumber)) {
				System.out.println("Queue :"+queueNumber+" is full");
			} else {
				if(isEmpty(queueNumber)) {
					rear1 = 0;
					front1 = 0;
					a[rear1] = data;
				} else {
					rear1++;
					a[rear1] = data;
				}
			}
		} else if(queueNumber == 2) {
			if(isFull(queueNumber)) {
				System.out.println("Queue :"+queueNumber+" is full");
			} else {
				if(isEmpty(queueNumber)) {
					rear2 = n-1;
					front2 = n-1;
					a[rear2] = data;
				} else {
					rear2--;
					a[rear2] = data;
				}
			}
		} 
	}
	
	public int delete(int queueNumber) {
		if(queueNumber == 1) {
			if(this.isEmpty(queueNumber)) {
				System.out.println("Queue :"+queueNumber+" is Empty.");
			} else {
				if(front1 == rear1) { //queue contain only one element.
					int data = a[front1];
					front1 = -1;
					rear1 = -1;
					return data;
				} else {
					int data = a[front1];
					front1--;
					return data;
				}
			}
		} else if(queueNumber == 2) {
			if(this.isEmpty(queueNumber)) {
				System.out.println("Queue :"+queueNumber+" is Empty.");
			} else {
				if(front2 == rear2) { //queue contain only one element.
					int data = a[front2];
					front1 = n;
					rear1 = n;
					return data;
				} else {
					int data = a[front2];
					front2++;
					return data;
				}
			}
		} 
		
		
		return -1;
	}
	
	
	
}
