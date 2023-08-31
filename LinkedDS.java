
public class LinkedDS<T> implements SequenceInterface<T> {

    private Node[] array; //1-D array of linked lists
    private int size; //the number of items in the sequence
    private T[] alphabet; //the possible item values (e.g., the decimal digits)
    private T firstItem; //the first item
    private T lastItem; //the last item
	private Node firstNode; // to keep track of nodes
	private Node addedNode;//  Most recently added node, also the last node

    public LinkedDS(T[] alphabet){
		int size = 0;
		T firstItem; 
		T lastItem;
		this.alphabet= alphabet;
		array = new Node[alphabet.length];
		
    }
    

    /** Add a new Object to the logical start of the sequence in O(1) time
	 * @param item the item to be added.
	 */
	public void push(T item){
		if( size ==0){
			firstItem= item;
			lastItem= item;
			size++;
		}else if(array[constantRuntimeHelper(item)] == null){
			firstNode = new Node(constantRuntimeHelper(firstItem));
			array[constantRuntimeHelper(item)] = firstNode;
			firstItem = item;
			size++;

		}else if (array[constantRuntimeHelper(item)] != null){

			addedNode = new Node(constantRuntimeHelper(firstItem));
			addedNode.next = array[constantRuntimeHelper(item)];
			array[constantRuntimeHelper(item)] = addedNode;
			firstItem=item;
			size ++;
			 
		} 

	}

    /** Delete the item at the logical start of the sequence in O(1) item
	 * @return the deleted item
	 * @throws EmptySequenceException if the sequence is empty
	 */
	public T pop(){
		T result;
		if(size == 0){
			 throw new EmptySequenceException("The Sequence is Empty");
		}
		else if(size>1){
				 result = firstItem;
				firstNode = array[constantRuntimeHelper(firstItem)];
				firstNode.next = addedNode;
				array[constantRuntimeHelper(firstItem)] = addedNode;
				firstItem = alphabet[firstNode.item];
				size--;
				return result;
		}else {
			result = firstItem;
			array[constantRuntimeHelper(firstItem)] = null;
			size--;

		return result;
				

		}
    }




	/** Check if the sequence is empty in O(1) time
	 * @return true if the sequence is empty, and false otherwise
	 */
	public boolean isEmpty(){
		boolean result = false;
		if(size == 0){
			result = true;

		}
       			 return result;
    	}

	/** Return the number of items in the sequence in O(1) time
	 * @return the number of items currently in the sequence
	 */
	public int size(){
        return size;
    }

	/**
	 * @return the the logically first item in the sequence in O(1) time
	 */
	public T first(){
        return firstItem;
    }

	/**
	 * @return the the logically last item in the sequence in O(1) time
	 */
	public T last(){
        return lastItem;
    }

    /** Return the number of times in the sequence that an item appears.
     * The running time is O(frequency of item in sequence).
	 * @param item an T item
	 * @return the number of occurences in the sequence of item
	 */
	public int getFrequencyOf(T item){
		int result = 0;
		Node addedNode;
		firstNode = array[constantRuntimeHelper(item)];
		if(firstNode == null){
			 result =0;
		}else if(firstNode != null){
			while(firstNode != null){
			addedNode= firstNode.next;
			firstNode = addedNode;
				result++;
			} 
		
		}
		if(item.equals(lastItem) ){
			result++;
			
	
		}
		
		return result;
    }


	/** Return the number of times in the sequence that an ordered pair of 
	 * items appear in the sequence. The running time is O(frequency of first 
	 * item).
	 * @param first the first item in the ordered pait
	 * @param second the second item in the ordered pair
	 * @return the number of occurences in the sequence of (first, second)
	 */
	public int getFrequencyOf(T first, T second){
		Node addedNode;
		int count = 0;
		firstNode = array[constantRuntimeHelper(first)];

		while(firstNode != null){
			if(firstNode.item == constantRuntimeHelper(second) ){
					count++;
			}
				addedNode = firstNode.next;
				firstNode = addedNode;

			}
		

		return count;
    }

	
	// this will provide which linked list to iterate and return its length/ gets used for removing or adding to the individual linked lists
	// Called constantRuntimeHelper becuase there was a runtime requirement for the assignment and I thought I was clever.
	public int constantRuntimeHelper(T item){
			int desiredIndex =0;
			for(int i=0; i<alphabet.length;i++){
				if(item == alphabet[i]){
					desiredIndex = i;
				}
			}

			return desiredIndex;
	}
	
	// Node Class
    private static class Node {
        private int item; //index in alphabet of item
        private Node next;
    
        private Node(int item){
            this.item = item;
            next = null;
        }
    }
}
