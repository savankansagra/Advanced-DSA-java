package assignmentHashing.collisionresolution;

public class LinearProbing {
	private int[] hashedArray;
	private int arraySize;
	
	public LinearProbing(int[] hashedArray, int arraySize) {
		super();
		this.hashedArray = hashedArray;
		this.arraySize = arraySize;
	}
	
	public void insert(int data) {
		int key = hash(data);
		int temp = key;
		int i = 1; //iteration count.
		//find the position to insert data.
		while(hashedArray[key] != 0) {
			key = hash(temp+i);
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
	 * divisor as hash function.
	 * 
	 * @param data
	 * @return
	 */
	private int hashDivisor(int data) {
		int key = data / arraySize;
		return key;
	}
	
	/**
	 * trucate digit as hash function.
	 * 
	 * @param data
	 * @return
	 */
	private int hashTruncate(int data) {
		String dataString = String.valueOf(data);
		String keyString = dataString.substring(dataString.length()-1,dataString.length());
		int key = Integer.parseInt(keyString);
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
		key = key % this.arraySize;
		return key;
	}
	
	
	private int hashDigitalFolding(int data) {
		// find the most repeated characters.
		return 0;
	}
	
	
	/**
	 * 
	 * @param n = size of hash array.
	 * @param hashArray 
	 * @param k = item to store
	 * @param itemToStore 
	 */
	public void processHashingWithLinearProbing(int n, int[] hashArray, int k, int[] itemToStore) {
		printUtility.printDataToInsert(itemToStore);
		for (int i = 0; i < k; i++) {
			this.insert(itemToStore[i]);
			printUtility.printHashedArray(hashArray);
		}	
	}
	
	
}
