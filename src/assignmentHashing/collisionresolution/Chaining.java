package assignmentHashing.collisionresolution;

import java.util.LinkedList;

public class Chaining {
	private LinkedList<Integer>[] chainedArray;
	private int chainedArraySize;
	
	
	public Chaining(int[] hashArray, int n) {
		this.chainedArray = (LinkedList<Integer>[]) new LinkedList<?>[n];
		this.chainedArraySize = n;
		for (int i = 0; i < n; i++) {
			this.chainedArray[i] = new LinkedList<Integer>();
		}
	}

	public void processHashingWithChaining(int k, int[] itemToStore) {
		printUtility.printDataToInsert(itemToStore);	
		for (int i = 0; i < k; i++) {
			this.insert(itemToStore[i]);
			this.printLinkedListArray();
		}
		
	}

	private void printLinkedListArray() {
		System.out.println("---------------------------------");
		System.out.println("Hashed chained array.  (size= "+this.chainedArraySize+")");
		System.out.print("[");
		for (int i = 0; i < chainedArraySize; i++) {
			System.out.print("(");
			for(int j=0;j< getChainedArray()[i].size();j++) {
				System.out.print(getChainedArray()[i].get(j)+", ");
			}
			System.out.print("), ");
		}
		System.out.println("]");
	}

	private void insert(int data) {
		int key = hash(data);
		this.getChainedArray()[key].addFirst(data);
	}
	
	private int hash(int data) {
		int key = data % this.chainedArraySize;
		return key;
	}

	public LinkedList<Integer>[] getChainedArray() {
		return chainedArray;
	}

	public void setChainedArray(LinkedList<Integer>[] chainedArray) {
		this.chainedArray = chainedArray;
	}

}
