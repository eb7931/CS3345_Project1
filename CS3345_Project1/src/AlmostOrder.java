public class AlmostOrder extends ListManager{
	AlmostOrder(int l){
		super(l);
		partialSort();
		copyArr();
	}
	private void partialSort() {
		int i = length/2;
		int[] temp = new int[i];
		for(int j = 0; j < i; j++) {
			temp[j] = arr[0][j];
		}
		Sort.insertionSort(temp);
		for(int j = 0; j < i; j++) {
			arr[0][j] = temp[j];
		}
		
			
	}
}