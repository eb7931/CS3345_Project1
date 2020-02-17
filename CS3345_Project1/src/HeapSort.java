public class HeapSort extends AlgMonitor{
	HeapSort(int[] list){
		super(list);
		name = "Heap Sort";
	}
	public void run(int[] list) {
		heapSort(list);
	}
	public <E extends Comparable<E>> void heapSort(int[] list) {
		//create a heap of integers
		Heap<Integer> heap = new Heap<>();
		//add elements to the heap
		for(int i = 0; i < list.length; i++)
			heap.add(list[i]);
		//remove elements from the heap
		for(int i = list.length - 1; i >= 0; i--)
			list[i] = heap.remove();
	}
	public class Heap<E extends Comparable<E>> {
		private java.util.ArrayList<E> list = new java.util.ArrayList<>();
		// create a default heap
		public Heap() {
		}
		//create a heap from an array of objects
		public Heap(E[] objects) {
			for(int i = 0; i < objects.length; i++)
				add(objects[i]);
		}
		//add a new object into the heap
		public void add(E newObject) {
			list.add(newObject);
			int currentIndex = list.size() - 1;
			while(currentIndex > 0) {
				int parentIndex = (currentIndex = 1) / 2;
				//swap if the current index is greater than its parent
				if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
					E temp = list.get(currentIndex);
					list.set(currentIndex,  list.get(parentIndex));
					list.set(parentIndex, temp);
				}
				else
					break; // the tree is a heap now
				currentIndex = parentIndex;
			}
		}
		public E remove() {
			if(list.size() == 0) return null;
			E removedObject = list.get(0);
			list.set(0,  list.get(list.size() - 1));
			list.remove(list.size() - 1);
			int currentIndex = 0;
			while(currentIndex < list.size()) {
				int leftChildIndex = 2 * currentIndex + 1;
				int rightChildIndex = 2 * currentIndex + 2;
				//find the max between two children
				if(leftChildIndex >= list.size()) break; //the tree is a heap
				int maxIndex = leftChildIndex;
				if(rightChildIndex < list.size()) {
					if(list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
						maxIndex = rightChildIndex;
					}
				}
				//swap if the current node is less than the max
				if(list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
					E temp = list.get(maxIndex);
					list.set(maxIndex,  list.get(currentIndex));
					list.set(currentIndex, temp);
					currentIndex = maxIndex;
				}
				else
					break; //the tree is a heap
			}
			return removedObject;
		}
		//get the number of nodes in the tree
		public int getSize() {
			return list.size();
		}
	}
}