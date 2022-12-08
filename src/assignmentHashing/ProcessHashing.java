package assignmentHashing;

import assignmentHashing.collisionresolution.Chaining;
import assignmentHashing.collisionresolution.DoubleHashingProbing;
import assignmentHashing.collisionresolution.LinearProbing;
import assignmentHashing.collisionresolution.QuadraticProbing;
import assignmentHashing.collisionresolution.RandomProbing;

public class ProcessHashing {
	public static void main(String[] args) {
		// input for hashing function.
		int n = 10; //hash array size
		int[] hashArray =  new int[n];

		int k = 7; // number of keys.
		int[] itemToStore = new int[k];
		itemToStore[0] = 8;
		itemToStore[1] = 10;
		itemToStore[2] = 14;
		itemToStore[3] = 17;
		itemToStore[4] = 21;
		itemToStore[5] = 18;
		itemToStore[6] = 17;
		
		
			
		// linear probing
//		LinearProbing linearProbing = new LinearProbing(hashArray, n);
//		linearProbing.processHashingWithLinearProbing(n, hashArray, k ,itemToStore);

		// Quadratic probing
//		QuadraticProbing quadraticProbing = new QuadraticProbing(hashArray, n);
//		quadraticProbing.processHashingWithQuadraticProbing(n, hashArray, k, itemToStore);
		
		// Random probing
//		RandomProbing randomProbing = new RandomProbing(hashArray, n);
//		randomProbing.processHashingWithRandomProbing(n, hashArray, k, itemToStore);
		
		// Double Hashing
//		DoubleHashingProbing doubleHashingProbing = new DoubleHashingProbing(hashArray, n);
//		doubleHashingProbing.processhashingWithDoubleHashing(n, hashArray, k, itemToStore);
		
		Chaining chaining = new Chaining(hashArray, n);
		chaining.processHashingWithChaining(k, itemToStore);
		
		
		
	}
	
	
	

	/* reference 
	 * 
	 * https://github.com/javamultiplex/data-structure/tree/c45b7ea2f15075fef878e9e8095d2e2f53c098c2/hashing
	 * 
	 * https://www.javatpoint.com/double-hashing-in-java
	 */
}
