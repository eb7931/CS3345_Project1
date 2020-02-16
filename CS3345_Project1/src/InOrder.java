public class InOrder extends ListManager{
	InOrder(int l){
		super(l);
		Sort.insertionSort(arr[0]);
		copyArr();
	}
}