package cosc2007lab8;

public class testHeap {
	public static void main(String[] args) {
		Heap h = new Heap();
		//15, 13, 11, 5, 9, 10
		h.heapInsert(5);
		h.heapInsert(13);
		h.heapInsert(11);
		h.heapInsert(9);
		h.heapInsert(10);
		h.heapInsert(15);
		System.out.println(h.heapGet(11));
		h.printHeap();
	}

}
