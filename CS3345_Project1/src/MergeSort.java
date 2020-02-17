public class MergeSort extends AlgMonitor{
	MergeSort(int[] list){
		super(list);
		name = "Merge Sort";
	}
	public void run(int[] list) {
		startTime = System.currentTimeMillis();
		mergeSort(list);
		endTime = System.currentTimeMillis();

	}
	public void mergeSort(int[] list) {
		if(list.length > 1) {
			//merge sort the first half
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			run(firstHalf);
			//merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2,  secondHalf,  0,  secondHalfLength);
			run(secondHalf);
			//merge first half with second half into list
			merge(firstHalf, secondHalf, list);
		}
	}
	public void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0; //current index in list1
		int current2 = 0; //current index in list2
		int current3 = 0; //current index in temp
		while(current1 < list1.length && current2 < list2.length) {
			if(list1[current1] < list2[current2]) {
				compare();
				temp[current3++] = list1[current1++];
				move();
			}
			else {
				temp[current3++] = list2[current2++];
				move();
			}
		}
		while(current1 < list1.length){
			compare();
			temp[current3++] = list1[current1++];
			move();
		}
		while(current2 < list2.length) {
			compare();
			temp[current3++] = list2[current2++];
			move();
		}
	}
}