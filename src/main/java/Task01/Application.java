package Task01;

import java.util.ArrayList;
import java.util.List;

/**
 *  NC Home tasks
 *  Task 1
 *
 *
 */
public class Application {

    /**
     *  Реализуйте метод, принимающий в качестве параметров список чисел и некоторое значение.
     *  Метод должен возвратить список чисел, которые больше этого значения
    */
    public <T extends Number & Comparable> List<T> getNumbers(List<T> ourList, T value) {

        if (ourList == null | value == null | ourList.size() == 0){
            throw new IllegalArgumentException("Bad argument's");
        }

        List<T> result = new ArrayList<T>();

        for (T t : ourList) {

            if (t.compareTo(value) > 0) {
                result.add(t);
            }
        }
        return result;
    }

}
