package cosc2007lab8;

public class Heap {
	private int MAX_HEAP_SIZE = 127;
	private int[] items;
	private int currentSize;

	public Heap() {
		items = new int[MAX_HEAP_SIZE];
		currentSize = 0;
	}

	public void heapInsert(int item) {
		items[currentSize] = item;// insert at the currentSize position
		int tempCurrentSize = currentSize;// save current size for later use
		int parent = (tempCurrentSize - 1) / 2;// get parent
		int temp;
		while ((parent >= 0) && (items[tempCurrentSize] > items[parent])) {// swap if child > parent
			temp = items[parent];
			items[parent] = items[tempCurrentSize];
			items[tempCurrentSize] = temp;
			tempCurrentSize = parent;
			parent = (tempCurrentSize - 1) / 2;
		}
		currentSize += 1;
	}

	public void heapDelete()	{
	items[0] = items[currentSize-1];
	items[currentSize-1] = 0;
	//fixHeap()
	}

	public int heapGet(int item) {
		for(int i = 0; i < currentSize; i++) {
			if(items[i] == item){
				return items[i];
			}
		}
		return -1;
	}
//	public int heapGet(int item) {
//		return heapGet(item, items, 0, currentSize - 1);// current size - 1 point to the last element
//	}
//
//	private int heapGet(int item, int[] arr, int start, int end) {
//		int mid = (start + end) / 2;
//
//		if (arr[mid] == item)
//			return arr[mid];
//		if (start > end)
//			return -1;
//
//		if (arr[mid] < item) {// go right
//			return heapGet(item, arr, mid + 1, end);
//		} else {
//			return heapGet(item, arr, start, mid - 1);
//		}
//
//	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public void heapDeleteAll() {
		items = null;

	}

	// syso -> ctrl + space + enter ==>System.out.println
	public void printHeap() {
		System.out.print('[');
		for (int i = 0; i < currentSize - 1; i++) {
			System.out.print(items[i] + " ");
		}
		System.out.println(items[currentSize - 1] + "]");
	}

}
