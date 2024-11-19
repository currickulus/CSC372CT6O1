import java.util.ArrayList;
import java.util.Comparator;
//imports array and comparator
public class Sorter {//sorts the list from the index position from either the
    //number or the name I think here is why it's backward
    public static <T> void selectionSort(ArrayList<T> list, Comparator<? super T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;

                }
            }
            if (minIndex != i) {
                T temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
            }

        }
    }
}
