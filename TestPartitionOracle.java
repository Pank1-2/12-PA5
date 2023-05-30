import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is an example of how to implement the Partitioner interface to implement
 * a concrete Partitioner. You can use this bad implementation to test your PartitionOracle,
 * to ensure that it works in detecting a bad Partitioner. You should add a correct implementation
 * of a Partitioner here, maybe one from class, to verify that your PartitionOracle also works
 * correctly on good implementations. Once you implement part 2, you can also test those Partitioner
 * implementations here as well.
 * 
 */

class CopyFirstElementPartition implements Partitioner {
    public int partition(String[] strs, int low, int high) {
        if (high - low < 1)
            return 0;
        for (int i = 0; i < strs.length; i += 1) {
            strs[i] = strs[0];
        }
        return 0;
    } 
}

public class TestPartitionOracle {
    @Test
    public void testCopyFirstElementPartition() {
        CounterExample ce = PartitionOracle.findCounterExample(new CopyFirstElementPartition());
        System.out.println(ce);
        assertNotNull(ce);
    }
    
    @Test
    public void testWebPartitioner() {
        CounterExample ce = PartitionOracle.findCounterExample(new WebPartitioner());
        System.out.println(ce);
        assertNotNull(ce);
    }
    
    @Test
    public void testCentralPartition() {
        CounterExample ce = PartitionOracle.findCounterExample(new CentralPivotPartitioner());
        System.out.println(ce);
        assertNotNull(ce);
    }
    
    @Test
    public void testCentralPartition2() {
      Partitioner p = new CentralPivotPartitioner();
      String[] input = {"z", "b", "g", "f", "d"};
      int pivot = p.partition(input, 0, 5);

      assertArrayEquals(new String[] {"f", "b", "d", "g", "z"} , input);
      assertEquals(3, pivot);
    }
    
    @Test
    public void testFirstEleParition() {
        CounterExample ce = PartitionOracle.findCounterExample(new FirstElePivotPartitioner());
        System.out.println(ce);
        assertNotNull(ce);
    }
    
    @Test
    public void testFirstElePartition2() {
      Partitioner p = new FirstElePivotPartitioner();
      String[] input = {"e", "b", "g", "f", "d"};
      int pivot = p.partition(input, 0, 5);

      assertArrayEquals(new String[] {"d", "b", "e", "g", "f"} , input);
      assertEquals(2, pivot);
    }
    
    @Test
    public void testInputPartition() {
    	String[] inputs = PartitionOracle.generateInput(10);
    	for (int i = 0; i < inputs.length; i++) {
    	}
    	
    	assertEquals(10, inputs.length);
    }
    
}




