package assignmentHashing.collisionresolution;

public class DoubleHashingProbing {
	private int[] hashedArray;
	private int arraySize;
	
	public DoubleHashingProbing(int[] hashedArray, int arraySize) {
		super();
		this.hashedArray = hashedArray;
		this.arraySize = arraySize;
	}
	
	
	
	/**
	 * 
	 * @param n = size of hash array.
	 * @param hashArray 
	 * @param k = item to store
	 * @param itemToStore 
	 */
	public void processhashingWithDoubleHashing(int n, int[] hashArray, int k, int[] itemToStore) {
		printUtility.printDataToInsert(itemToStore);
		for (int i = 0; i < k; i++) {
			this.insert(itemToStore[i]);
			printUtility.printHashedArray(hashArray);
		}	
	}

	private  void insert(int data) {
		int key = hash1(data);
		int temp = key;
		int i = 1; //iteration count.
		//find the position to insert data.
		while(hashedArray[key] != 0) {
			key = (key + i * this.hash2(key)) % this.arraySize;
			i = i+1;
		}
		hashedArray[key] = data;
	}
	
	/*
	 *  first hash function  
	 */
	private int hash1(int data) {
		int key = data % arraySize;
		return key;
	}
	
	
	/*
	 *  Second hash function
	 */
	private int hash2(int key) {
		int primeNumber = getPrime();
		return  primeNumber - key % primeNumber;
	}
	
	 /* Function to get prime number less than table size for myhash2 function */  
    public int getPrime()  
    {  
        for (int i = this.arraySize - 1; i >= 1; i--)  
            {  
                int fact = 0;  
                for (int j = 2; j <= (int) Math.sqrt(i); j++)  
                    if (i % j == 0)  
                        fact++;  
                if (fact == 0)  
                    return i;  
            }  
       /* Return a prime number */  
        return 3;  
    }  
	
	
	
	
}
