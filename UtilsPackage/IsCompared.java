import java.util.ArrayList;
import java.util.Comparator;

public class IsCompared {

    public static <E extends Comparable<E>> Boolean isSorted(ArrayList<E> list) {
        ArrayList<E> list1 = new ArrayList<>(list);
        list1.sort(Comparable::compareTo);
        return list.equals(list1);
    }

    public static <E extends Comparable<E>> Boolean isReversed(ArrayList<E> list) {
        ArrayList<E> list1 = new ArrayList<>(list);
        list1.sort(Comparator.reverseOrder());
        System.out.println("isReversedMethod after reversed: " + list + "\nis reversed method before reversing: " + list1);
        return list.equals(list1);
    }
