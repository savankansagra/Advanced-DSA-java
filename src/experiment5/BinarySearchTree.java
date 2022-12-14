package experiment5;

/**
 * Interface for various BST Implementation.
 * 
 */
public interface BinarySearchTree extends BinaryTree {

	/**
	 * Searches for a node with the given search key.
	 * 
	 * @param key the search key.
	 * @return the node or <code>null</code> if no node with the given search key exists.
	 */
	Node searchNode(int key);
	
	/**
	 * Inserts a node with the given key.
	 * 
	 * @param key the key of the node to be inserted.
	 */
	void insertNode(int key);
	
	/**
	 * Deletes the node with the given key.
	 * 
	 * @param key the key node to be deleted.
	 */
	void deleteNode(int key);
	
}
