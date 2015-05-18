package utils;

import utils.Predicates.Predicate;

import java.util.*;

/**
 * Created by Anthony on 5/18/2015.
 */
public class CollectionUtils {
    //region Helper Classes =====================================================================================================

    public interface Selector<IN, OUT> {
        OUT Select(IN obj);
    }

    //endregion

    //region Where calls ========================================================================================================

    public static <T> Iterable<T> filter(Iterable<T> elements, Predicate<T> theTest) {
        return filter(elements, theTest, obj -> obj);
    }

    public static <T, SelectType> Iterable<T> filter(Iterable<T> elements, Predicate<SelectType> theTest, Selector<T, SelectType> selector) {
        return () -> new Iterator<T>() {
            Iterator<T> back = elements.iterator();
            Object next = null;

            @Override
            public boolean hasNext() {
                while (next == null) {
                    T tmp;
                    if (back.hasNext()) {
                        if (theTest.Invoke(selector.Select(tmp = back.next()))) {
                            next = tmp;
                        }
                    } else {
                        break;
                    }
                }
                return next != null;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                T tmp = (T)next;
                next = null;
                return tmp;
            }
        };
    }

    //endregion

    public static <T> int count(Iterable<T> collection) {
        int ret = 0;
        for (T ignored : collection) ret++;
        return ret;
    }

    @SuppressWarnings("LoopStatementThatDoesntLoop")
    public static <T> boolean isEmpty(Iterable<T> collection) {
        for (T ignored : collection) return false;
        return true;
    }

    /**
     * Returns a collection in reverse order
     * Not Lazy
     * @param collection collection to iterate backwards on
     * @param <T> collection type
     * @return handle to move over list backwards
     */
    public static <T> Iterable<T> reverse(Iterable<T> collection) {
        LinkedList<T> reversed = new LinkedList<>();
        for(T elem : collection) {
            reversed.addFirst(elem);
        }
        return reversed;
    }

    /**
     * Returns a collection in reverse order
     * @param collection collection to iterate backwards on
     * @param <T> collection type
     * @return handle to move over list backwards
     */
    public static <T> Iterable<T> reverse(List<T> collection) {
        return () -> new Iterator<T>() {
            List<T> back = collection;
            int index = collection.size()-1;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                return back.get(index--);
            }
        };
    }

    /**
     * Returns a collection in reverse order
     * @param collection collection to iterate backwards on
     * @param <T> collection type
     * @return handle to move over list backwards
     */
    @SafeVarargs
    public static <T> Iterable<T> reverse(T ... collection) {
        return () -> new Iterator<T>() {
            T[] back = collection;
            int index = collection.length-1;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                return back[index--];
            }
        };
    }


    //region FirstOrDefault =====================================================================================================

    @SuppressWarnings("LoopStatementThatDoesntLoop")
    public static <T> T firstOrDefault(Iterable<T> collection) {
        for (T t : collection) return t;
        return null;
    }

    @SafeVarargs
    public static <T> T firstOrDefault(T... collection) {
        return firstOrDefault(toIterable(collection));
    }

    public static <T> T firstOrDefault(Iterable<T> collection, Predicate<T> condition) {
        return firstOrDefault(filter(collection, condition));
    }

    public static <T> T firstOrDefault(T[] collection, Predicate<T> condition) {
        return firstOrDefault(toIterable(collection), condition);
    }

    //endregion

    //region Transform Type =====================================================================================================

    @SafeVarargs
    public static <T> List<T> toList(T... collection) {
        return toList(toIterable(collection));
    }
    public static <T> List<T> toList(Iterable<T> collection) {
        List<T> ret = new ArrayList<>();
        for (T t : collection) ret.add(t);
        return ret;
    }

    @SafeVarargs
    public static <T> Set<T> toSet(T... collection) {
        return toSet(toIterable(collection));
    }
    public static <T> Set<T> toSet(Iterable<T> collection) {
        Set<T> ret = new HashSet<>();
        for (T elem : collection) {
            if (!ret.contains(elem)) {
                ret.add(elem);
            }
        }
        return ret;
    }

    @SuppressWarnings("SpellCheckingInspection")
    @SafeVarargs
    public static <T> Iterable<T> toIterable(T... prams) {
        return () -> new Iterator<T>() {
            T[] backingData = prams;
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < backingData.length;
            }

            @Override
            public T next() {
                return backingData[index++];
            }
        };
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static <T> Iterable<T> emptyIterable() {
        return toIterable();
    }

    //endregion

    public static <T, OUT> Iterable<OUT> select(Iterable<T> collection, Selector<T, OUT> selector) {
        return () -> new Iterator<OUT>() {
            Iterator<T> backing = collection.iterator();

            @Override
            public boolean hasNext() {
                return backing.hasNext();
            }

            @Override
            public OUT next() {
                return selector.Select(backing.next());
            }
        };
    }
}
