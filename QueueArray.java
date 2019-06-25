import java.util.Iterator;

//-----------------------------------------------------
// Author: Gülfem Akpýnar
// ID: 55534353160
// Assignment: 1
// Question: 1
// Description: This class defines a String queue by using array
//-----------------------------------------------------
import java.util.Iterator;

public class QueueArray implements Iterable<String> {

	// assign index numbers to zero because there is not any Strings in queue.
	private int lastIndex = 0;
	private int firstIndex = 0;

	// create string array to store strings that enqueued.
	private String[] item = new String[8];

	public int arraySize()
	// --------------------------------------------------------
	// Summary: returns array size
	// --------------------------------------------------------
	{
		return item.length;
	}

	public void enqueue(String s)
	// --------------------------------------------------------
	// Summary: add s to the array
	// Precondition: s is a String
	// --------------------------------------------------------
	{
		// checks whether array is full or not. if array is full, resize the
		// array.
		if (this.Size() == item.length)
			this.resize(item.length * 2);
		item[lastIndex++] = s;
	}

	public String dequeue()
	// --------------------------------------------------------
	// Summary: remove first String in array and return it.
	// --------------------------------------------------------
	{
		// assing first string to s.
		String s = item[firstIndex++];
		// copy and paste the items in the array starting from 0th index to
		// prevent any errors.
		CP();
		// checks whether array's fullness is less than one-fourth of the array.
		// if it is less, it resize the array
		if (this.Size() == item.length / 4)
			this.resize(item.length / 2);
		// return s.
		return s;
	}

	public int Size()
	// --------------------------------------------------------
	// Summary: returns the number of Strings in the queue.
	// --------------------------------------------------------
	{
		return lastIndex - firstIndex;
	}

	public boolean isEmpty()
	// --------------------------------------------------------
	// Summary: returns whether queue is empty or not.
	// --------------------------------------------------------
	{
		return (this.Size() == 0);
	}

	private void resize(int capacity)
	// --------------------------------------------------------
	// Summary: creates an array with size equals to capacity and take all
	// strings in items array.
	// Then give then in the array that just created. assign this array to item.
	// Precondition: capacity is integer.
	// --------------------------------------------------------
	{
		String[] temp = new String[capacity];
		for (int i = firstIndex; i < lastIndex; i++) {
			temp[i - firstIndex] = item[i];

		}
		// assign first item to zero.
		// assign last item to half of the capacity.
		firstIndex = 0;
		lastIndex = capacity / 2;
		item = temp;
	}

	// --------------------------------------------------------
	// Summary: copy and paste the items in the array starting from 0th index to
	// prevent any errors.
	// --------------------------------------------------------
	public void CP() {

		for (int i = firstIndex; i < lastIndex; i++) {
			item[i - firstIndex] = item[i];

		}

		firstIndex = 0;
		lastIndex = Size() - 1;

	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator();
	}

	public class ArrayIterator implements Iterator {
		// assign i to first Strings index due to starting from the first.
		private int i = firstIndex;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			// if i is not equal to last that means that there is not any item
			// except from item in index i.
			return i != lastIndex;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			// items in queue is start from first and go to last by incrementing
			// i by one.
			return item[i++];
		}

	}

}
