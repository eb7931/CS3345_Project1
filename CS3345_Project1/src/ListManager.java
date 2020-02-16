public class ListManager{
	protected int[][] arr;
	protected int[] operations = new int[6];
	protected int length = 0;
	/*store the number of operations for each sort method, in this order
	 * Insertion, selection, quick, merge, heap, radix	 */
	protected ListManager(int l){
		setLength(l);
		makeRandom();
	}
	protected ListManager() {
		
	}
	private void makeRandom() {
		arr = new int[7][length];
		for(int i = 0; i < length; i++) {
			arr[0][i] = (int)(Math.random() * 10000000);
		}
	}
	private void setLength(int l) {
		length = l;
	}
	protected void copyArr() {
		for(int i = 1; i < 7; i++) {
			System.arraycopy(arr[0], 0, arr[i], 0, length);
		}
	}
}