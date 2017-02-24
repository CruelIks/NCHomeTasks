package Task01;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ApplicationTest {

    private Application testedInstance = new Application();

    @Test
    public void testGetNumbersOnInteger(){
        List<Integer> list = new ArrayList<>();
        List<Integer> result;

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        result = testedInstance.getNumbers(list, 5);

        assertTrue(result.size() == 4);
        assertTrue(result.get(0) == 6);
        assertTrue(result.get(1) == 7);
        assertTrue(result.get(2) == 8);
        assertTrue(result.get(3) == 9);

    }

    @Test
    public void testGetNumbersOnDouble(){
        List<Double> list = new ArrayList<>();
        list.add(2.45);
        list.add(2.65);
        list.add(3.0);

        List<Double> result = testedInstance.getNumbers(list, 2.5);

        assertTrue("Размер полученного массива = 2", result.size() == 2);
    }
}
