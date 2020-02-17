public class QuickSort extends AlgMonitor{
	QuickSort(int[] list){
		super(list);
		name = "Quick";
	}
	
	
	public void run(int[] list) {
		quickSort(list, 0, list.length - 1);
	}
	public void quickSort(int[] list, int first, int last) {
		if(last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	//partition the array{first...last]
	public int partition(int[] list, int first, int last) {
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