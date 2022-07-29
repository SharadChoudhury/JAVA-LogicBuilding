package queue;


public class QueueUse {

	//Array implementation
	
	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray(3);
		for(int i = 1; i <= 5; i++){
			try {
				queue.enqueue(i);
			} catch (QueueFullException e) {
				
			}
		}
		
		
		while(! queue.isEmpty()){
			try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	
	
	//Linked list implementation
	
//	private static Scanner s = new Scanner(System.in);
//
//	public static void main(String[] args) {
//		Queue queue = new Queue();
//
//		int q = s.nextInt();
//
//		while (q > 0) {
//			int choice, input;
//			choice = s.nextInt();
//
//			switch(choice) {
//				case 1:
//					input = s.nextInt();
//					queue.enqueue(input);
//					break;
//
//				case 2:
//					System.out.println(queue.dequeue());
//					break;
//
//				case 3:
//					System.out.println(queue.front());
//					break;
//
//				case 4:
//					System.out.println(queue.getSize());
//					break; 
//
//				default: 
//					System.out.println((queue.isEmpty()) ? "true" : "false");
//			}
//
//			q -= 1;
//		}
//
//	}

}
