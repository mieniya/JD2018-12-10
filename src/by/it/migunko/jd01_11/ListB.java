package by.it.migunko.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class ListB<E> implements List<E>{
    private E[] elements = (E[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(E e) {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, size+1);
        elements[size++] = e;
        return true;
    }

    @Override
    public void add(int index, E e) {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, size+1);
        System.arraycopy(elements, index, elements, index +1, size - index);
        elements[index] = e;
        size++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimeter = "";

        for (int i = 0; i < size; i++) {
            sb.append(delimeter).append(elements[i]);
            delimeter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E remove(int index) {
        E element = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        size--;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1)
            remove(index);
        return (index > -1);
    }

    @Override
    public int indexOf(Object o) {
        return  0;
    }

    @Override
    public E set(int index, E element) {
        E setElement = elements[index];
        elements[index] = element;
        return setElement;
    }

    public boolean addAll(Collection c) {
        elements = Arrays.copyOf(elements, (size+c.size()));
        Iterator iter = c.iterator();
        int counter = size;
        while (iter.hasNext()) {
            this.set(counter, (E) iter.next());
            counter++;
        }
        size+=c.size();
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
