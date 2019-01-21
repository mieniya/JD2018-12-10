package by.it.subach.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private static Object ob = new Object();
    private HashMap<T, Object> map = new HashMap<>();


    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(T t) {
        map.put(t, ob);
        return false;
    }

    @Override
    public boolean isEmpty() {
        if(map.size() == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if(map.containsKey(o)){
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(map.remove(o) == ob){
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean b = false;
        Iterator<?> iter = c.iterator();
        while (iter.hasNext()){
            b = contains(iter.next());
        }
        return b;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean b = false;
        for(T t: c){
            b = add(t);
        }
        return b;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean b = false;
        Iterator<?> iter = c.iterator();
            while (iter.hasNext()){
                b = remove(iter.next());

            }

        return b;
    }

    @Override
    public String toString() {
        if(map.size() == 0){
            return "[]";
        }
        Iterator<T> iter = map.keySet().iterator();
        StringBuilder sb = new StringBuilder("[");
        String delimiter = ", ";
        if(!iter.hasNext()){
            sb.append("]");
        }
        while (iter.hasNext()){
            sb.append(iter.next());
            if(iter.hasNext()){
                sb.append(delimiter);
            }
        }
        sb.append("]");
        return sb.toString();
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
        map.clear();

    }
}
