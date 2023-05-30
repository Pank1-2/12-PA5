// You can (and should) add "implements Partitioner" below once you have the implementation ready
public class WebPartitioner implements Partitioner{
	
//	Author: Hearen. Github Link: https://github.com/pedrovgs/Algorithms/blob/master/src/main/java/com/github/pedrovgs/problem80/QuickSort.java
//		License Link: https://github.com/pedrovgs/Algorithms/blob/master/LICENSE.txt
//	
//	Changes made to Code: 
//	- Since this uses an int list, I changed it to use String lists to adapt to the problem. 
//	- Since I had to change this to string, I had to use compareTo methods instead of comparators generally used for ints. 
//	- I also made the methods public instead of private. 
//	- Lastly, I added the swap method that was included in a different file of theirs since the file including the partition extended the file with the swap. 
//	
//	Given the test cases I have written, the code is not buggy
//	
//	The worst case in the scenario is if it was given a sorted list. The tight big O bound would be n^2.
	
	public void quickSort(String[] numbers, int left, int right) {
	    if (left < right) {
	      int pivotIndex = partition(numbers, left, right);
	      quickSort(numbers, left, pivotIndex - 1);  //sort left of pivot
	      quickSort(numbers, pivotIndex, right);  //sort right of pivot
	    }
	 }

	public int partition(String[] numbers, int left, int right) {
	    String pivot = numbers[right];
	    int i = left - 1;
	    
	    for (int j = left; j < right; ++j) {
	    	if (numbers[j].compareTo(pivot) < 0) {
	    		swap(numbers, ++i, j);
	    	}
	    }
	    
	    swap(numbers, ++i, right);
	    return i;
	    
	}
	 
	protected void swap(String[] numbers, int i, int j) {
		    String temp = numbers[i];
		    numbers[i] = numbers[j];
		    numbers[j] = temp;
	}
	
}
