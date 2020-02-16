public class ReverseOrder extends ListManager{
	ReverseOrder(int l){
		super(l);
		Sort.insertionSort(arr[0]);
		invert();
		copyArr();
	}
	private void invert() {
		int[] temp = new int[length];
		for(int i = 0; i < length; i++) {
			temp[i] = arr[0][length - i];
		}
		for(int i = 0; i < length; i++) {
			arr[0][i] = temp[i];
		}
	}
}