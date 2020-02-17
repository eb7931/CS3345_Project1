public class SelectionSort extends AlgMonitor{
	SelectionSort(int[] list){
		super(list);
		name = "Selection";
	}
	public void run(int[] list) {
		startTime = System.currentTimeMillis();


		for(int i = 0; i < list.length - 1; i++) {
			//find the minimum in the list[i...list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			for(int j = i + 1; j < list.length; j++) {
				if(currentMin > list[j]) {
					compare();
					currentMin = list[j];
					move();
					currentMinIndex = j;
					move();
				}
			}
			//swap list[i] with list[currentMinIndex] if necessary
			if(currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				move();
				list[i] = currentMin;
				move();
			}
		}
		endTime = System.currentTimeMillis();
	}
}