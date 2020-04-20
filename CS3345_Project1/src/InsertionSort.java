public class InsertionSort extends AlgMonitor{
	InsertionSort(int[] list){
		super(list);
		name = "Insertion Sort";
	}
	public void run(int[] list) {
		startTime = System.currentTimeMillis();
		for(int i = 1; i < list.length; i ++) {
			compare();
			/* inset list[i] into a sorted sublist list[0...i-1] so
			 * that list[0...i is sorted */
			int currentElement = list[i];
			int k;
			for(k = i-1; k >= 0 && list[k] > currentElement; k--) {
				//System.out.println(Integer.toString(list[k]) + " is less than " + Integer.toString(list[i]));
				compare();
				list[k + 1] = list [k];
				move();
			}
			if(list[k+1] != currentElement) {
				list[k + 1] = currentElement;
				move();
			}
		}
		
		
		
		
		endTime = System.currentTimeMillis();
	}
}