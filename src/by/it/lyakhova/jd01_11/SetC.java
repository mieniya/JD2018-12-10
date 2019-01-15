package by.it.lyakhova.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<E> implements Set<E> {

    private E[] elements = (E[]) new Object[0];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {

        return indexOf(o)>-1;
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
    public boolean add(E e) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements, elements.length*3/2+1);
        }
        if (!contains(e)) {
            elements[size++] = e;
            return true;
        }

        return false;
    }

    public int indexOf(Object o) {
        if (o == null){
            for (int i = 0; i < size; i++) {
                if (elements[i]==null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {

                if (o.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);

            if (i>-1) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                size--;
            }
            return (i>-1);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        E[] elAdd = (E[]) c.toArray();
        for (E el :
                elAdd) {
            if (contains(el)) return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        E[] array = (E[]) c.toArray();
        for (E el :
                array) {
            add(el);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        E[] array = (E[]) c.toArray();
        for (E el :
                array) {
            remove(el);
        }
        return true;
    }

    @Override
    public void clear() {
        elements = Arrays.copyOf(elements,0);
        size = 0;

    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        //[1, 2, 4, 7, 9]
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            out.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        out.append("]");
        return out.toString();
    }

}
