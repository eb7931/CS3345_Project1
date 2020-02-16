import java.io.*;
import java.util.*;
public class Sort{
	private static int operations = 0;
	public static int insertionSort(int[] list) {
		operations = 0;
		InsertionSort.sort(list);
		return operations;
	}
	public static int[] selectionSort(int[] list) {
		operations = 0;
		int[] newList = new int[list.length];
		
		
		return newList;
	}
	public static int[] quickSort(int[] list) {
		operations = 0;
		int[] newList = new int[list.length];
		
		
		return newList;
	}
	public static int[] mergeSort(int[] list) {
		operations = 0;
		int[] newList = new int[list.length];
		
		
		return newList;
	}
	public static int[] heapSort(int[] list) {
		operations = 0;
		int[] newList = new int[list.length];
		
		
		return newList;
	}
	public static int[] radixSort(int[] list) {
		operations = 0;
		int[] newList = new int[list.length];
		
		
		return newList;
	}
	
	public static class InsertionSort {
		public static void sort(int[] list) {
			for(int i = 1; i < list.length; i ++) {
				/* inset list[i] into a sorted sublist list[0...i-1] so
				 * that list[0...i is sorted */
				int currentElement = list[i];
				int k;
				for(k = i-1; k >= 0 && list[k] >currentElement; k--) {
					list[k + 1] = list [k];
				}
				list[k + 1] = currentElement;
			}
		}
	}
	
	public static class SelectionSort{
		public static void selectionSort(double[] list) {
			for(int i = 0; i < list.length - 1; i++) {
				//find the minimum in the list[i...list.length-1]
				double currentMin = list[i];
				int currentMinIndex = i;
				for(int j = i + 1; j < list.length; j++) {
					if(currentMin > list[j]) {
						currentMin = list[j];
						currentMinIndex = j;
					}
				}
				//swap list[i] with list[currentMinIndex] if necessary
				if(currentMinIndex != i) {
					list[currentMinIndex] = list[i];
					list[i] = currentMin;
				}
			}
		}
	}
	
	public static class QuickSort{
		public static void quickSort(int[] list) {
			quickSort(list, 0, list.length - 1);
		}
		public static void quickSort(int[] list, int first, int last) {
			if(last > first) {
				int pivotIndex = partition(list, first, last);
				quickSort(list, first, pivotIndex - 1);
				quickSort(list, pivotIndex + 1, last);
			}
		}
		//partition the array{first...last]
		public static int partition(int[] list, int first, int last) {
			int pivot = list[first];//choose the first element as the pivot
			int low = first + 1;//index for forward switch
			int high = last; // index for backward search
			
			while(high > low) {
				// search from left
				while(low <= high && list[low] <= pivot)
					low++;
				//search backward from right
				while(low <= high && list[high] > pivot)
					high--;
				//swap two element in the list
				if(high>low) {
					int temp = list[high];
					list[high] = list[low];
					list[low] = temp;
				}
			}
			while(high > first && list[high] >= pivot)
				high--;
			//swap pivot with list[high]
			if(pivot > list[high]) {
				list[first] = list[high];
				list[high] = pivot;
				return high;
			}
			else {
				return first;
			}
		}
	}
	
	public static class Heap<E extends Comparable<E>> {
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
	public static class HeapSort{
		//heap sort method
		public static <E extends Comparable<E>> void heapSort(E[] list) {
			//create a heap of integers
			Heap<E> heap = new Heap<>();
			//add elements to the heap
			for(int i = 0; i < list.length; i++)
				heap.add(list[i]);
			//remove elements from the heap
			for(int i = list.length - 1; i >= 0; i--)
				list[i] = heap.remove();
		}
		//to use, heapSort(list); where list is an array of integers
	}
	
	public static class MergeSort{
	//the method for sorting the numbers
		public static void mergeSort(int[] list) {
			if(list.length > 1) {
				//merge sort the first half
				int[] firstHalf = new int[list.length / 2];
				System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
				mergeSort(firstHalf);
				//merge sort the seconid half
				int secondHalfLength = list.length - list.length / 2;
				int[] secondHalf = new int[secondHalfLength];
				System.arraycopy(list, list.length / 2,  secondHalf,  0,  secondHalfLength);
				mergeSort(secondHalf);
				//merge first half with second half into list
				merge(firstHalf, secondHalf, list);
				
			}
		}
		public static void merge(int[] list1, int[] list2, int[] temp) {
			int current1 = 0; //current index in list1
			int current2 = 0; //current index in list2
			int current3 = 0; //current index in temp
			while(current1 < list1.length && current2 < list2.length) {
				if(list1[current1] < list2[current2])
					temp[current3++] = list1[current1++];
				else
					temp[current3++] = list2[current2++];
			}
			while(current1 < list1.length)
				temp[current3++] = list1[current1++];
			while(current2 < list2.length)
				temp[current3++] = list2[current2++];
		}
		// use mergeSort(list); where list is an array of integers
	}
	
	
	
	public static class Radix{
		static int getMax(int arr[], int n) {
			int mx = arr[0];
			for(int i = 1; i < n; i++)
				if(arr[i] > mx)
					mx = arr[i];
			return mx;
		}
		static void countSort(int arr[], int n, int exp) {
			int output[] = new int[n];
			int i;
			int count[] = new int[10];
			Arrays.fill(count, 0);
			for(i = 0; i < n; i++)
				count[(arr[i]/exp)%10]++;
			// Change count[i] so that count[i] now contains 
			// actual position of this digit in output[]
			for(i = 1; i < 10; i++)
				count[i] += count[i-1];
			// build the output array
			for(i = n-1; i >= 0; i--) {
				output[count[(arr[i]/exp)%10] - 1] = arr[1];
				count[(arr[i]/exp)%10]--;
			}
			for(i = 0; i < n; i++)
				arr[i] = output[i];
		}
		static void radixsort(int arr[], int n) {
			//find the max number to know number of digits
			int m = getMax(arr, n);
			for(int exp = 1;m/exp > 0; exp *= 10)
				countSort(arr, n, exp);
		}
		static void print(int arr[], int n) {
			for(int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");
		}
		/*call using radixsort(arr, n) where arr is an array and n is the array length
		 * 
		 */
		
	}
}