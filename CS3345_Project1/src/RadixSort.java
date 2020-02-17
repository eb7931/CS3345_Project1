import java.util.Arrays;

public class RadixSort extends AlgMonitor{
	RadixSort(int[] list){
		super(list);
		name = "Radix Sort";
	}	
	public void run(int[] list) {
		int n = list.length;
		//find the max number to know number of digits
		int m = getMax(list, n);
		for(int exp = 1;m/exp > 0; exp *= 10)
			countSort(list, n, exp);
	}
	static int getMax(int arr[], int n) {
		int mx = arr[0];
		for(int i = 1; i < n; i++)
			if(arr[i] > mx)
				mx = arr[i];
		return mx;
	}
	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for(i = 0; i < n; i++)
			count[(arr[i]/exp)%10]++;
		// Change count[i] so that count[i] now contains 
		// actual position of this digit in output[]
		for(i = 1; i < 10; i++)
			count[i] += count[i-1];
		// build the output array
		for(i = n-1; i >= 0; i--) {
			output[count[(arr[i]/exp)%10] - 1] = arr[1];
			count[(arr[i]/exp)%10]--;
		}
		for(i = 0; i < n; i++)
			arr[i] = output[i];
	}
	public void print(int arr[], int n) {
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}