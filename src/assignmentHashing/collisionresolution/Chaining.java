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
	
	/**
	 * module as hashing function.
	 * 
	 * @param data
	 * @return
	 */
	private int hash(int data) {
		int key = data % this.chainedArraySize;
		return key;
	}
	
	/**
	 * divisor as hash function.
	 * 
	 * @param data
	 * @return
	 */
	private int hashDivisor(int data) {
		int key = data / this.chainedArraySize;
		return key;
	}
	
	
	/**
	 * folding hash function.
	 * 
	 * @param data
	 * @Return
	 */
	private int hashFolding(int data) {
		// divide the data into length of 2.
		int groupSize = 2;
		int key = 0;
		String dataString = String.valueOf(data);
		for(int i=0;i<dataString.length()/groupSize;i++) {
			int start = i*groupSize;
			int end = i*groupSize + groupSize;
			String subData = dataString.substring(start, end);
			int subDataInteger = Integer.parseInt(subData);
			key += subDataInteger;
		}
		key = key % this.chainedArraySize;
		return key;
	}
	
	
	
	
	public LinkedList<Integer>[] getChainedArray() {
		return chainedArray;
	}

	public void setChainedArray(LinkedList<Integer>[] chainedArray) {
		this.chainedArray = chainedArray;
	}

}
