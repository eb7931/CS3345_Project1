import java.io.*;

public class ListManager{
	protected int[][] arr;
	protected AlgMonitor[] operations = new AlgMonitor[7];
	protected int length = 0;
	protected String csv;
	/*store the number of operations for each sort method, in this order
	 * Insertion, selection, quick, merge, heap, radix	 */
	protected ListManager(int l){
		setLength(l);
		makeRandom();
		csv = "arrays.csv";
	}
	protected ListManager() {
		
	}
	protected void append(String str) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(csv, true));
			out.write(str);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void printToFile() {
		String temp = "";
		temp += "Original Array,";
		for(int i = 0; i < 7; i++) {
			temp += operations[i].name();
			if(i<6) {
				temp += ",";
			}
			
		}
		for(int i = 0; i < length; i++) {
			if(i != 0);
			temp += "\n";
			for(int j = 0; j < 8; j++) {
				temp += Integer.toString(arr[j][i]);
				if(j < 7) {
					temp += ",";
				}
			}
		}
		append(temp);
	}
	public int length() {
		return length;
	}
	private void makeRandom() {
		arr = new int[8][length];
		for(int i = 0; i < length; i++) {
			arr[0][i] = (int)(Math.random() * 10000000);
		}
	}
	private void setLength(int l) {
		length = l;
	}
	protected void copyArr() {
		for(int i = 1; i < 8; i++) {
			System.arraycopy(arr[0], 0, arr[i], 0, length);
		}
	}
	protected void sortAll(){
		operations[0] = new InsertionSort(arr[1]);
		operations[1] = new SelectionSort(arr[2]);
		operations[2] = new QuickSort(arr[3]);
		operations[3] = new MergeSort(arr[4]);
		operations[4] = new HeapSort(arr[5]);
		operations[5] = new RadixSort(arr[6]);
		operations[6] = new BucketSort(arr[7]);
		printToFile();
	}
	protected void sort() {
		for(int i = 1; i < arr[0].length; i ++) {
			/* inset list[i] into a sorted sublist list[0...i-1] so
			 * that list[0...i is sorted */
			int currentElement = arr[0][i];
			int k;
			for(k = i-1; k >= 0 && arr[0][k] >currentElement; k--) {
				arr[0][k + 1] = arr[0][k];
			}
			arr[0][k + 1] = currentElement;
		}
	}
	protected void sort(int[] list) {
		for(int i = 1; i < list.length; i ++) {
			/* inset list[i] into a sorted sublist list[0...i-1] so
			 * that list[0...i is sorted */
			int currentElement = list[i];
			int k;
			for(k = i-1; k >= 0 && list[k] >currentElement; k--) {
				list[k + 1] = list[k];
			}
			list[k + 1] = currentElement;
		}
	}
}