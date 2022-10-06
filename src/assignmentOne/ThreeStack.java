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
	int data[];
	
	public ThreeStack() {
		data = new int[n]; //creating a array for storing three stack. it contain by default 0 value.
	}
	
	
	public static void main(String[] args) {
		
	}
	
	public boolean isEmpty(String stackName) {
		if(stackName.equalsIgnoreCase("stack1")) {
			if(pointer1 == m-1) {
				return true;
			}
		} else if(stackName.equalsIgnoreCase("stack2")) {
			if(pointer2 == m) {
				return true;
			}
		} else if(stackName.equalsIgnoreCase("stack3")) {
			if(pointer3 == (m+m)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean isFull(String stackName) {
		if(stackName.equalsIgnoreCase("stack1")) {
			if(pointer1 == 0) {
				return true;
			}
		} else if(stackName.equalsIgnoreCase("stack2")) {
			if(pointer2 == (m+m-1)) {
				return true;
			}
		} else if(stackName.equalsIgnoreCase("stack3")) {
			if(pointer3 == ((m+m+m)-1)) {
				return true;
			}
		}
		return false;
	}
	
	public void push(String stackName, int data) {
		if(stackName.equalsIgnoreCase("stack1")) {
			if(this.isFull(stackName)) {
				System.out.println("stack :"+stackName+" is full.");
			}
		} else if(stackName.equalsIgnoreCase("stack2")) {
			
		} else if(stackName.equalsIgnoreCase("stack3")) {
			
		}
			
	}
	
	
	
	
	
	/*
	 * References : https://github.com/srsandy/Data-Structures-and-Algorithms-in-Java-2nd-Edition-by-Robert-Lafore/blob/master/Chapter-04/StackApp.java
	 */
	
//	if(stackName.equalsIgnoreCase("stack1")) {
//		
//	} else if(stackName.equalsIgnoreCase("stack2")) {
//		
//	} else if(stackName.equalsIgnoreCase("stack3")) {
//		
//	}
}
