public class ReverseOrder extends ListManager{
	ReverseOrder(int l,String s){
		super(l,s);
		sort();
		invert();
		copyArr();
		sortAll();
	}
	private void invert() {
		int[] temp = new int[length];
		for(int i = 0; i < length; i++) {
			temp[i] = arr[0][length - 1 - i];
		}
		for(int i = 0; i < length; i++) {
			arr[0][i] = temp[i];
		}
	}
}