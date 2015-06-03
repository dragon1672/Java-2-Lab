package utils;

import java.util.*;

/**
 * Created by Anthony on 6/2/2015.
 */
@SuppressWarnings("ALL")
public class RandomSet<T> extends AbstractSet<T> {
    Stack<T> list = new Stack<>();
    Set<T> set = new HashSet<>();
    Map<T,Integer> indexMap = new HashMap<>();

    public RandomSet(){}
    RandomSet(Collection<? extends T> c){
        c.forEach(this::add);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    @Override
    public boolean add(T t) {
        if(set.contains(t)) {
            return false;
        }
        set.add(t);
        indexMap.put(t,list.size());
        list.add(t);
        return true;
    }

    private static <T> void swap(List<T> list, int a, int b) {
        T tmp = list.get(a);
        list.set(a,list.get(b));
        list.set(b,tmp);
    }

    @Override
    public boolean remove(Object o) {
        if(!set.contains(o)) {
            return false;
        }
        set.remove(o);
        int index = indexMap.get(o);
        swap(list,index,list.size()-1);
        list.pop();
        indexMap.remove(o);
        return true;
    }

    @Override
    public void clear() {
        list.clear();
        set.clear();
        indexMap.clear();
    }

    public T getRandom() {
        return getRandom(new Random());
    }

    public T getRandom(Random rng) {
        return list.get(rng.nextInt(list.size()));
    }
}
