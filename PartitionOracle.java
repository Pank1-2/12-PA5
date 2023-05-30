// These are some imports that the course staff found useful, feel free to use them
// along with other imports from java.util.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PartitionOracle {

    /**
     * Feel free to use this method to call partition. It catches any exceptions or
     * errors and returns a definitely-invalid pivot (-1) to turn errors into
     * potential failures. For example, in testPartition, you may use
     * 
     * runPartition(p, someArray, someLow, someHigh)
     * 
     * instead of
     * 
     * p.partition(someArray, someLow, someHigh)
     * 
     * @param p
     * @param strs
     * @param low
     * @param high
     * @return
     */
    public static int runPartition(Partitioner p, String[] strs, int low, int high) {
        try {
            return p.partition(strs, low, high);
        } catch (Throwable t) {
            return -1;
        }
    }

    // The three methods below are for you to fill in according to the PA writeup.
    // Feel free to make other helper methods as needed.

    public static String isValidPartitionResult(String[] before, int low, int high, int pivot, String[] after) {
    	if (pivot < 0) {
			return "invalid: pivot is negative";
		}
    	
    	if (pivot >= high) {
			return "invalid: pivot out of bounds";
		}
    	
    	if (high > after.length) {
			return "invalid: high out of bounds";
		}
		
    	if (low < 0) {
			return "invalid: low out of bounds";
		}
    	
//		if (before.length == after.length) {
//			for (int i = 0; i < after.length; i++) {
//				if (after[i].equals(null)) {
//					return "Invalid: There is a null value after partition";
//				}
//			}
//		}
		
		for (int i = 0; i < before.length; i++) {
			if (Arrays.asList(after).contains(before[i]) != true) {
				return "after array doesn't have same elements as before";
			}
		}
		
		if (before.length != after.length) {
			return ("invalid: beginning array and resulting array isn't the same length");
		}
		
		String afterP = after[pivot];
		
		int smallBeforeLHS = low;
		for (int left = smallBeforeLHS; left < pivot; left++) {
			if ((after[left]).compareTo(afterP) > 0) {
				return ("Item before pivot too large");
			}
		}
		
		
		int smallBeforeRHS = pivot + 1;
		for (int right = smallBeforeRHS; right < high; right++) {
			if ((after[right]).compareTo(afterP) < 0) {
				return ("Item after pivot too small");
			}
		}
		
		for(int i = 0; i < low; i++) {
			if(!before[i].equals(after[i])) {
				return("elements before low do not match");
			}
		}
		
		for(int i = high; i < before.length; i++) {
			if(!before[i].equals(after[i])) {
				return("elements after high do not match");
			}
		}
		
		return null;
    }

    public static String[] generateInput(int n) {
    	String[] random = new String[n];
    	Random r = new Random();
    	
    	for(int i = 0; i < n; i++) {
    		char c = (char) ('a' + r.nextInt(26));
    		random[i] = Character.toString(c);
    	}

        return random;
    }
    

    public static CounterExample findCounterExample(Partitioner p) {
    	ArrayList<String[]> inputEx = new ArrayList<>();
    	for(int i = 0; i < 50; i++) {
        	String[] arr = generateInput(100);
        	inputEx.add(arr);
    	}
    	
    	for(String[] input: inputEx) {
        	String[] original = Arrays.copyOf(input, input.length);
        	int pIndex = runPartition(p, original, 0, input.length - 1);
        	String result = isValidPartitionResult(input, 0, input.length - 1, pIndex, original);
        	if (result != null) {
        		CounterExample counter = new CounterExample(input, 0, input.length - 1, pIndex, original, result);
        		return counter;
        	}
    	}
   
    	return null;
    	
    }

}
