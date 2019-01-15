package by.it.dziomin.jd01_11;

import java.util.*;

public class SetC<T> extends ListA<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T o) {
        checkSize();

        boolean isUnique = !contains(o);
        if (isUnique) {
            elements[size++] = o;
            return true;
        }

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T e : c) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            if (remove(o)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        setElements((T[]) new Object[]{});
        setSize(0);
    }

    protected T[] elements() {
        return this.elements;
    }

    protected void setElements(T[] elements) {
        this.elements = elements;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    //   ---------Fiction------------


    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }




    @Override
    public boolean retainAll(Collection c) {
        return false;
    }
}
