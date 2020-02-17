public class QuickSort extends AlgMonitor{
	QuickSort(int[] list){
		super(list);
		name = "Quick";
	}
	
	
	public void run(int[] list) {
		startTime = System.currentTimeMillis();
		quickSort(list, 0, list.length - 1);
		endTime = System.currentTimeMillis();
	}
	public void quickSort(int[] list, int first, int last) {
		if(last > first) {
			compare();
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
			compare();
			// search from left
			while(low <= high && list[low] <= pivot) {
				compare();
				low++;
			}
			//search backward from right
			while(low <= high && list[high] > pivot) {
				compare();
				high--;
			}
			//swap two element in the list
			if(high>low) {
				compare();
				int temp = list[high];
				move();
				list[high] = list[low];
				move();
				list[low] = temp;
				move();
			}
		}
		while(high > first && list[high] >= pivot) {
			compare();
			high--;
		}
		//swap pivot with list[high]
		if(pivot > list[high]) {
			compare();
			list[first] = list[high];
			move();
			list[high] = pivot;
			move();
			return high;
		}
		else {
			return first;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}