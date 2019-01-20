package by.it.kushnerov.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<E> implements Set<E> {


    private int size = 0;
    private E[] elements = (E[]) new Object[]{};


    @Override
    public boolean add(E e) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        if (!contains(e))
            elements[size++] = e;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i > -1) {
            System.arraycopy(elements, i + 1, elements, i, size - i - 1);
            size--;
        }
        return true;
    }

    private int indexOf(Object o) {
        int index = -1;
        if (o == null)
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                    index = i;
            }
        else
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    index = i;
            }
        return index;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(c!=null && c.size()!=0) {
            for (E e : c) {
                add(e);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if(contains(o)) return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            out.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        out.append("]");
        return out.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size=0;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
