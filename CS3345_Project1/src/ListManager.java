import java.io.*;

public class ListManager{
	protected int[][] arr;
	protected AlgMonitor[] operations = new AlgMonitor[7];
	protected int length = 0;
	protected String arraysCSV = "arrays.csv";
	protected File arraysFile;
	protected String resultsCSV = "results.csv";
	protected File resultsFile;
	protected String relevantCSV = "relevant.csv";
	protected File relevantFile;
	protected String dataType;
	/*store the number of operations for each sort method, in this order
	 * Insertion, selection, quick, merge, heap, radix	 */
	protected ListManager(int l, String s){
		setLength(l);
		setDataType(s);
		makeRandom();
		arraysFile = new File(arraysCSV);
		try{
			arraysFile.createNewFile();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		resultsFile = new File(resultsCSV);
		try{
			resultsFile.createNewFile();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		relevantFile = new File(relevantCSV);
		try{
			relevantFile.createNewFile();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void setDataType(String s) {
		dataType = s;
	}

	protected ListManager() {
		
	}
	protected void append(String str, File file) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
			out.write(str);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void printResults() {
		String temp = "";
		if(resultsFile.length() == 0) {
			temp += "Metric,";
			for(int i = 0; i < 7; i++) {
				temp += operations[i].name();
				if(i<6) {
					temp += ",";
				}
			}
		}
		temp += "\n";
		temp += "N,";
		for(int j = 0; j < 7; j++) {
			temp += length;
			if(j < 6) {
				temp += ",";
			}
			else
				temp += "\n";
		}
		temp += "Data Type,";
		for(int j = 0; j < 7; j++) {
			temp += dataType;
			if(j < 6) {
				temp += ",";
			}
			else
				temp += "\n";
		}
		temp += "Compares,";
		for(int j = 0; j < 7; j++) {
			temp += operations[j].comparisons();
			if(j < 6) {
				temp += ",";
			}
			else
				temp += "\n";
		}
		temp += "Moves,";
		for(int j = 0; j < 7; j++) {
			temp += operations[j].movements();
			if(j < 6) {
				temp += ",";
			}
			else
				temp += "\n";
		}
		temp += "Time,";
		for(int j = 0; j < 7; j++) {
			temp += operations[j].runTime();
			if(j < 6) {
				temp += ",";
			}
		}
		append(temp, resultsFile);
	}
	protected void printRelevant() {
		String temp = "";
		if(relevantFile.length() == 0) {
			for(int i = 0; i < 4; i++) {
				temp += operations[i].name() + "Comps," 
						+ operations[i].name() + "Moves," 
						+ operations[i].name() + "Total";
				if(i<3) {
					temp += ",";
				}
			}
		}
		temp += "\n";
		for(int i = 0; i < 4; i++) {
			temp += operations[i].comparisons() + "," 
					+ operations[i].movements() + "," 
					+ (operations[i].comparisons() + operations[i].movements()) + "";
			if(i < 3) {
				temp += ",";
			}
		}
		append(temp, relevantFile);
	}
	protected void printArrays() {
		String temp = "";
		if(arraysFile.length() == 0) {
			temp += "Original Array,";
			for(int i = 0; i < 7; i++) {
				temp += operations[i].name();
				if(i<6) {
					temp += ",";
				}
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
		append(temp, arraysFile);
		
	}
	protected void printToFile() {
		printArrays();
		printResults();
		printRelevant();
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