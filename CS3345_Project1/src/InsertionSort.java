public class InsertionSort extends AlgMonitor{
	InsertionSort(int[] list){
		super(list);
		name = "Insertion";
	}
	public void run(int[] list) {
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