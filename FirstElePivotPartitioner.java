// You can (and should) add "implements Partitioner" below once you have the implementation ready

public class FirstElePivotPartitioner implements Partitioner{
	public int partition(String[] array, int low, int high) {
		if(low == high) {
			return low;
        }
		
        int pivotIndex = high - 1;
        swap(array, low, pivotIndex);
        String pivot = array[pivotIndex];
        
		int smallerBeforeIdx = low;
		int largerAfterIdx = high - 2;
		
		while(largerAfterIdx >= smallerBeforeIdx) {
			if((array[smallerBeforeIdx]).compareTo(pivot) > 0) {
				swap(array, smallerBeforeIdx, largerAfterIdx);
				largerAfterIdx -= 1;
		    }
	        else {
	        	smallerBeforeIdx += 1;
	        }
		}
		
		swap(array, smallerBeforeIdx, pivotIndex);
		
		return smallerBeforeIdx;
	}
	
	public static void swap(String[] array, int i1, int i2) {
		String temp = array[i1];
	        array[i1] = array[i2];
	        array[i2] = temp;
	}
	
}


//	Source: https://www.geeksforgeeks.org/implement-quicksort-with-first-element-as-pivot/