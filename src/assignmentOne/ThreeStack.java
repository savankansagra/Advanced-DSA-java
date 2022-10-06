package assignmentOne;

public class ThreeStack {
	
	/*
	WAP to implement a 3-stacks of size ‘m’ in an array of size ‘n’ with all the basic
	operations such as IsEmpty(i), Push(i), Pop(i), IsFull(i) where ‘i’ denotes the stack
	number (1,2,3), m =	n/3. Stacks are not overlapping each other. Leftmost stack
	facing the left direction and other two stacks are facing in the right direction.
	 */
	
	int n = 30; // total size of array
	int m = n/3; // size of single stack
	int pointer1 = m-1;
	int pointer2 = m;
	int pointer3 = m+m;
	int a[];
	
	public ThreeStack() {
		a = new int[n]; //creating a array for storing three stack. it contain by default 0 value.
	}
	
	
	public static void main(String[] args) {
		
	}
	
	public boolean isEmpty(int stackNumber) {
		if(stackNumber == 1) {
			if(pointer1 == m-1) {
				return true;
			}
		} else if(stackNumber == 2) {
			if(pointer2 == m) {
				return true;
			}
		} else if(stackNumber == 3) {
			if(pointer3 == (m+m)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean isFull(int stackNumber) {
		if(stackNumber == 1) {
			if(pointer1 == -1) {
				return true;
			}
		} else if(stackNumber == 2) {
			if(pointer2 == (m+m)) {
				return true;
			}
		} else if(stackNumber == 3) {
			if(pointer3 == (m+m+m)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void push(int stackNumber, int data) {
		if(stackNumber == 1) {
			if(this.isFull(stackNumber)) {
				System.out.println("stack :"+stackNumber+" is full.");
			} else {
				a[pointer1] = data;
				pointer1--;
			}
		} else if(stackNumber == 2) {
			if(this.isFull(stackNumber)) {
				System.out.println("stack :"+stackNumber+" is full.");
			} else {
				a[pointer2] = data;
				pointer2++;
			}
		} else if(stackNumber == 3) {
			if(this.isFull(stackNumber)) {
				System.out.println("stack :"+stackNumber+" is full.");
			} else {
				a[pointer3] = data;
				pointer3++;
			}
		}
	}
	
	
	public int pop(int stackNumber) {
		if(stackNumber == 1) {
			if(this.isEmpty(stackNumber)) {
				System.out.println("stack: "+stackNumber+" is empty.");
				return -1;
			} else {
				int data = a[pointer1];
				pointer1++;
				return data;
			}
		} else if(stackNumber == 2) {
			if(this.isEmpty(stackNumber)) {
				System.out.println("stack: "+stackNumber+" is empty.");
				return -1;
			} else {
				int data = a[pointer2];
				pointer2--;
				return data;
			}
		} else if(stackNumber == 3) {
			if(this.isEmpty(stackNumber)) {
				System.out.println("stack: "+stackNumber+" is empty.");
				return -1;
			} else {
				int data = a[pointer3];
				pointer3++;
				return data;
			}
		}
		return -1;
	}
	
	
	
	
	
	
	
	/*
	 * References : https://github.com/srsandy/Data-Structures-and-Algorithms-in-Java-2nd-Edition-by-Robert-Lafore/blob/master/Chapter-04/StackApp.java
	 */
}
