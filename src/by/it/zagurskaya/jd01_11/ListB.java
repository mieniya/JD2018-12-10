package by.it.zagurskaya.jd01_11;

import java.util.*;

class ListB<E> implements List<E> {

    private E[] elements = (E[]) new Object[0];
    private int countElementsInCollection = 0;


    @Override
    public E get(int index) {

        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        E replacedElement = elements[index];
        elements[index] = element;
        return replacedElement;
    }

    @Override
    public boolean add(E e) {
        // надо ли увеличиваь массив
        if (countElementsInCollection == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[countElementsInCollection++] = e;
        return true;
    }

    @Override
    public void add(int index, E element) {
        // надо ли увеличиваь массив
        if (countElementsInCollection == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        countElementsInCollection++;
        System.arraycopy(elements, index, elements, index + 1, countElementsInCollection - index - 1);
        elements[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.size() == 0) {
            return false;
        }

        if (countElementsInCollection + c.size() >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length + c.size());
        }

        System.arraycopy(c.toArray(), 0, elements, countElementsInCollection, c.size());
        countElementsInCollection += c.size();

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1) {
            remove(index);
            return true;
        } else
            return false;
    }

    @Override
    public E remove(int index) {
        E elementInArrayAtIndex = elements[index];
        System.arraycopy(elements, index + 1, elements, index, countElementsInCollection - index - 1);
        countElementsInCollection--;
        return elementInArrayAtIndex;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < countElementsInCollection; i++) {
            if (Objects.equals(elements[i], o))
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        //[1, 2, 3, 4]
        String delimiter = "";
        for (int i = 0; i < countElementsInCollection; i++) {
            out.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        out.append("]");
        return out.toString();
    }

    @Override
    public int size() {
        return countElementsInCollection;
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
