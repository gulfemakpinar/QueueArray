
public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create a queue
		QueueArray first = new QueueArray();

		for (int i = 1; i <= 20; i++) {

			// add a String from the queue and print it
			System.out.println("equeued item: " + i);
			first.enqueue("" + i);

			// print other Strings in queue
			System.out.println("Strings in queue:");
			for (String s : first) {
				System.out.print(s + " ");
			}

			// print array size to see if resizing is correct or not.
			System.out.println("\narray size:");
			System.out.print(first.arraySize());
			System.out.println();
		}

		// print all Strings in queue
		System.out.println("all Strings in queue:");
		for (String s : first) {
			System.out.print(s + " ");
		}
		System.out.println();

		for (int i = 1; i <= 20; i++) {

			// get a String from the queue and print it
			System.out.println("dequeued item:");
			System.out.println(first.dequeue());

			// print other Strings in queue
			System.out.println("other items:");
			for (String s : first) {
				System.out.print(s + " ");
			}

			// print array size to see if resizing is correct or not.
			System.out.println("\narray size:");
			System.out.print(first.arraySize());
			System.out.println();
		}

	}

}
