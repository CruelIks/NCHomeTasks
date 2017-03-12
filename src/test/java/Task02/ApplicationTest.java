package Task02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Admin on 03.03.2017.
 */
public class ApplicationTest {

    private Application testedInstance = new Application();

    @Test
    public void testRemoveDuplicates(){

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
            list.add(i);
        }

        testedInstance.removeDuplicatesFromList(list);


        assertTrue("Размер массива = 50", list.size() == 50);

        for (int i = 0; i < 50; i++) {
            assertTrue(i == list.get(i));
        }

    }
}
