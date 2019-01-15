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
    public boolean add(E e) {
        // надо ли увеличиваь массив
        if (countElementsInCollection == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        for (int i = 0; i < elements.length; i++) {
            // не отрабатывает сравнение
            if (Objects.equals(elements[i], equals(e))) {
//            if (elements[i].equals(e)) {
                return false;
            }
        }
        elements[countElementsInCollection++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < elements.length; i++) {
            // не отрабатывает сравнение
            if (Objects.equals(elements[i], equals(o))) {
                System.arraycopy(elements, i + 1, elements, i, countElementsInCollection - i - 1);
                countElementsInCollection--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < elements.length; i++) {
            // не отрабатывает сравнение
            if (Objects.equals(elements[i], equals(o))) {
                 return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return countElementsInCollection==0? true:false;
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
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
