package by.it.zagurskaya.jd01_11;

import java.util.*;

class SetC<E> implements Set<E> {

    private E[] elements = (E[]) new Object[0];
    private int countElementsInCollection = 0;


    @Override
    public int size() {
        return countElementsInCollection;
    }

    @Override
    public boolean add(E element) {
        if (contains(element)) {
            return false;
        }

        if (countElementsInCollection == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }

        elements[countElementsInCollection++] = element;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < countElementsInCollection; i++) {
            // не отрабатывает сравнение
            if (Objects.equals(elements[i], object)) {
                System.arraycopy(elements, i + 1, elements, i, countElementsInCollection - i - 1);
                countElementsInCollection--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        for (int i = 0; i < countElementsInCollection; i++) {
            // не отрабатывает сравнение
            if (Objects.equals(elements[i], object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return countElementsInCollection == 0;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.size() == 0) {
            return false;
        }

        if (countElementsInCollection + collection.size() >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length + collection.size());
        }

        // System.arraycopy(collection.toArray(), 0, elements, countElementsInCollection, collection.size());
        int oldCountElementsInCollection = countElementsInCollection;
        for (E element : collection) {
            if (!contains(element)) {
                elements[countElementsInCollection] = element;
                countElementsInCollection = countElementsInCollection + 1;
            }

        }


        return oldCountElementsInCollection != countElementsInCollection;
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
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int oldSize = size();
        for (Object o : c) {
            remove(o);
        }
        return oldSize != size();
    }

    @Override
    public void clear() {
    }
}
