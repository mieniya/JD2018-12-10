package by.it.dziomin.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListA<T> implements List<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        String delimeter = ", ";
        for (int i = 0; i < size(); i++) {
            out.append(elements()[i]);
            if (i != size() - 1) {
                out.append(delimeter);
            }
        }
        out.append("]");
        return out.toString();
    }

    @Override
    public boolean add(T t) {
        checkSize();
        elements()[size()] = t;
        setSize(size() + 1);
        return true;
    }

    @Override
    public void add(int index, T element) {
        checkSize();
        System.arraycopy(elements(), index, elements(), index + 1, size() - index);
        elements()[index] = element;
        setSize(size() + 1);
    }

    @Override
    public T remove(int index) {
        T returnElement = elements()[index];
        System.arraycopy(elements(), index + 1, elements(), index, size() - index - 1);
        setSize(size() - 1);
        return returnElement;
    }

    @Override
    public boolean remove(Object t) {
        int index = indexOf(t);
        if (index > -1) {
            remove(index);
        }
        return index > -1;
    }

    @Override
    public T get(int index) {
        return elements()[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++) {
                if (elements()[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (o.equals(elements()[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public T set(int index, T element) {
        if (size() != 0 && index >= 0 && index < size()) {
            T returnElement = elements()[index];
            elements()[index] = element;
            return returnElement;
        }
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        setElements(Arrays.copyOf(elements(), size() + c.size()));

        System.arraycopy(c.toArray(), 0, elements(), size(), c.size());
        setSize(size() + c.size());
        return true;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements(), size());
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(elements(), size(), a.getClass());
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

    protected void checkSize() {
        if (size() == elements().length) {
            setElements(Arrays.copyOf(elements(), (int) (elements().length * 1.5 + 1)));
        }
    }


    //---------Fiction----------------

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
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
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
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
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

}
