package by.it.dziomin.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListB<T> extends ListA<T> implements List<T> {


       //указанные в taskB методы реализованы в ListA ()
       // (ListB extends ListA)



    //  ------Fiction------------------
    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        super.sort(c);
    }

    @Override
    public Spliterator<T> spliterator() {
        return super.spliterator();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return super.iterator();
    }


//    @Override
//    public <T1> T1[] toArray(T1[] a) {
//        return super.toArray(a);
//    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return super.retainAll(c);
    }

    @Override
    public void clear() {
        super.clear();
    }


    @Override
    public int lastIndexOf(Object o) {
        return super.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return super.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return super.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex);
    }
}
