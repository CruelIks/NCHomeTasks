package Task02;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  NC Home task's
 *  Task 2
 */
public class Application {

    /**
     * Функция удаляет дубликаты из списка
     * @param list Список из которого необходимо удалить дубликаты
     * */
    public <T> void removeDuplicatesFromList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        }

        Set<T> set = new HashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
    }


}
