import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.List;

public class BucketSort extends AlgMonitor{
	BucketSort(int[] list){
		super(list);
		name = "Bucket Sort";
	}
	public void run(int[] list) {
		startTime = System.currentTimeMillis();
		bucketSort(list);
		endTime = System.currentTimeMillis();
	}

	public void bucketSort(int[] input) {
	    // get hash codes
		final int[] code = hash(input);
	
		// create and initialize buckets to ArrayList: O(n)
		List[] buckets = new List[code[1]];
		for (int i = 0; i < code[1]; i++) {
			buckets[i] = new ArrayList();
		}
	
		// distribute data into buckets: O(n)
		for (int i : input) {
			buckets[hash(i, code)].add(i);
			move();
		}

		// sort each bucket O(n)
		for (List bucket : buckets) {
			Collections.sort(bucket);
		}

		int ndx = 0;
		// merge the buckets: O(n)
	    	for (int b = 0; b < buckets.length; b++) {
		    	for (int v = 0;v < buckets[b].size(); v++) {
		    		input[ndx++] = v;
		    		move();
		      	}
	    	}
	    }

	  private int[] hash(int[] input) {
		  int m = input[0];
		  for (int i = 1; i < input.length; i++) {
			  if (m < input[i]) {
				compare();
	    	  	m = input[i];
	    	  	move();
	    	  }
		  }
	    return new int[] { m, (int) Math.sqrt(input.length) };
	  }

	  private int hash(int i, int[] code) {
		  return (int) ((double) i / code[0] * (code[1] - 1));
	  }



	
	
	
	
	
	
	/*
	public <E extends Comparable<E>> void bucketSort(int[] list) {
		E[] bucket = (E[])new java.util.ArrayList[10000000+1];
		// Distribute the elements from list to buckets 
		for (int i = 0; i < list.length; i++) {
			int key = list[i]; // Assume element has the getKey() method
			if (bucket[key] == null)      
				bucket[key] = (E) new java.util.ArrayList<E>(); 
			((ArrayList) bucket[key]).add(list[i]);  
		}
		
		int k = 0;
		for(int i = 0; i < bucket.length; i++) {
			if(bucket[i] != null) {
				for(int j = 0; j < ((ArrayList) bucket[i]).size(); j++)
					list[k++] = (int) ((ArrayList) bucket[i]).get(j);
			}
		}
		
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
	}*/
}