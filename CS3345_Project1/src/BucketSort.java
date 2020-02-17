import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.List;

public class BucketSort extends AlgMonitor{
	BucketSort(int[] list){
		super(list);
		name = "Bucket Sort";
	}
	public void run(int[] list) {
		startTime = System.currentTimeMillis();
		bucketSort(list);
		endTime = System.currentTimeMillis();
	}

	public void bucketSort(int[] input) {
	    // get hash codes
		final int[] code = hash(input);
	
		// create and initialize buckets to ArrayList: O(n)
		List[] buckets = new List[code[1]];
		for (int i = 0; i < code[1]; i++) {
			buckets[i] = new ArrayList();
		}
	
		// distribute data into buckets: O(n)
		for (int i : input) {
			buckets[hash(i, code)].add(i);
			move();
		}

		// sort each bucket O(n)
		for (List bucket : buckets) {
			Collections.sort(bucket);
		}

		int ndx = 0;
		// merge the buckets: O(n)
	    	for (int b = 0; b < buckets.length; b++) {
		    	for (int v = 0;v < buckets[b].size(); v++) {
		    		input[ndx++] = v;
		    		move();
		      	}
	    	}
	    }

	  private int[] hash(int[] input) {
		  int m = input[0];
		  for (int i = 1; i < input.length; i++) {
			  if (m < input[i]) {
				  compare();
	    	  	m = input[i];
	    	  	move();
	    	  }
		  }
	    return new int[] { m, (int) Math.sqrt(input.length) };
	  }

	  private int hash(int i, int[] code) {
		  return (int) ((double) i / code[0] * (code[1] - 1));
	  }

}