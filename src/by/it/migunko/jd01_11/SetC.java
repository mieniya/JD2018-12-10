package by.it.migunko.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class SetC<E> implements Set<E> {
    private E[] array = (E[]) new Object[]{};
    private int size = 0;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(array[i]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean add(E element) {
        if (size == array.length)
            array = Arrays.copyOf(array, (size * 3) / 2 + 1);
        if (!contains(element))
            array[size++] = element;
        return false;
    }

    public int indexOf(Object o) {
        if (o == null)
            for (int i = 0; i < size; i++) {
                if (array[i] == null)
                    return i;
            }
        else
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i]))
                    return i;
            }
        return -1;
    }


    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i > -1) {
            System.arraycopy(array, i + 1, array, i, size - i - 1);
            size--;
        }
        return (i > -1);
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
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c != null && c.size() != 0) {
            for (E element : c) {
                add(element);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<E> iterator = (Iterator<E>) c.iterator();
        while (iterator.hasNext())
            if (!contains(iterator.next()))
                return false;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> myIterator = c.iterator();
        while (myIterator.hasNext()) {
            remove((E) myIterator.next());
        }
        return true;
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
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }
}
