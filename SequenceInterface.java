
public interface SequenceInterface<T>
{
	/** Add a new Object to the logical start of the sequence in O(1) time
	 * @param item the item to be added.
	 */
	public void push(T item);

	/** Delete the item at the logical start of the sequence in O(1) item
	 * @return the deleted item
	 * @throws EmptySequenceException if the sequence is empty
	 */
	public T pop();

	/** Check if the sequence is empty in O(1) time
	 * @return true if the sequence is empty, and false otherwise
	 */
	public boolean isEmpty();

	/** Return the number of items in the sequence in O(1) time
	 * @return the number of items currently in the sequence
	 */
	public int size();

	/**
	 * @return the the logically first item in the sequence in O(1) time
	 */
	public T first();

	/**
	 * @return the the logically last item in the sequence in O(1) time
	 */
	public T last();

    /** Return the number of times in the sequence that an item appears.
     * The running time is O(frequency of item in sequence).
	 * @param item an T item
	 * @return the number of occurences in the sequence of item
	 */
	public int getFrequencyOf(T item);

	/** Return the number of times in the sequence that an ordered pair of 
	 * items appear in the sequence. The running time is O(frequency of first 
	 * item).
	 * @param first the first item in the ordered pait
	 * @param second the second item in the ordered pair
	 * @return the number of occurences in the sequence of (first, second)
	 */
	public int getFrequencyOf(T first, T second);

}
