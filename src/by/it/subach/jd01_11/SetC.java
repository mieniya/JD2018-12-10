package by.it.subach.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private int capacity = 0;
    private HashMap<T, Object> hashSet = new HashMap<T, Object>();



    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public String toString() {
//        Iterator<?> iter = hashSet;
        return super.toString();
    }

    //    --------------------------------------------------------------------------
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
