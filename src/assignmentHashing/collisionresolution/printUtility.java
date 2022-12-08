package assignmentHashing.collisionresolution;

public class printUtility {
	public static void printHashedArray(int[] hashArray) {
		System.out.println("---------------------------------");
		System.out.println("Hashed array.  (size= "+hashArray.length+")");
		for (int i = 0; i < hashArray.length; i++) {
			System.out.print(hashArray[i]+" ");
		}
		System.out.println();
	}



	public static void printDataToInsert(int[] itemToStore) {
		System.out.println("---------------------------------");
		System.out.println("total item to store = "+itemToStore.length);
		System.out.println("---------------------------------");
		System.out.println("item to store");
		for (int i = 0; i < itemToStore.length; i++) {
			System.out.print(itemToStore[i]+" ");
		}
		System.out.println();
	}

	
}
