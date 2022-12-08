package assignmentHashing.collisionresolution;

public class QuadraticProbing {
	private int[] hashedArray;
	private int arraySize;
	
	public QuadraticProbing(int[] hashedArray, int arraySize) {
		super();
		this.hashedArray = hashedArray;
		this.arraySize = arraySize;
	}
	
	/*
	 * if collion then insert element at i**2 position ahead. i=iteration.
	 * 
	 */
	public void insert(int data) {
		int key = hash(data);
		int temp = key;
		int i = 1; //iteration count.
		//find the position to insert data.
		while(hashedArray[key] != 0) {
			key = hash(temp+i*i);
			i = i+1;
		}
		hashedArray[key] = data;
	}


	/**
	 * modulo as hash function.
	 * 
	 * @param data
	 * @return
	 */
	private int hash(int data) {
		int key = data % arraySize;
		return key;
	}
	
	
	/**
	 * 
	 * @param n = size of hash array.
	 * @param hashArray 
	 * @param k = item to store
	 * @param itemToStore 
	 */
	public void processHashingWithQuadraticProbing(int n, int[] hashArray, int k, int[] itemToStore) {
		printUtility.printDataToInsert(itemToStore);
		for (int i = 0; i < k; i++) {
			this.insert(itemToStore[i]);
			printUtility.printHashedArray(hashArray);
		}	
	}
	

}