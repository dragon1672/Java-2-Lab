package utils;

import utils.FunctionInterfaces.Functions.Function2;
import utils.Predicates.Predicate;

import java.util.*;

/**
 * Created by Anthony on 1/20/2015.
 */
@SuppressWarnings("unused")
public class CollectionUtils {
    //region Helper Classes =====================================================================================================

    public interface Selector<IN, OUT> {
        OUT Select(IN obj);
    }

    public interface AggregateFunction<T> extends Function2<T,T,T> {
        @Override
        T Invoke(T toBuild, T current);
    }


    //endregion

    //region Where calls ========================================================================================================

    public static <T> Iterable<T> filter(Iterable<T> elements, Predicate<? super T> theTest) {
        return filter(elements, theTest, obj -> obj);
    }

    public static <T, SelectType> Iterable<T> filter(Iterable<T> elements, Predicate<SelectType> theTest, Selector<? super T, SelectType> selector) {
        return () -> new Iterator<T>() {
            final Iterator<T> back = elements.iterator();
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
            final List<T> back = collection;
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
            final T[] back = collection;
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
        if(collection instanceof List) {
            return (List<T>)collection;
        }
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
        if(collection instanceof Set) {
            return (Set<T>)collection;
        }
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
            final T[] backingData = prams;
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

    /**
     * Joins collections together
     * Will iterate in the same order they are passed in
     * @param collections
     * @param <T> type of collection
     * @return hook to iterate over all the collections
     */
    @SafeVarargs
    public static <T> Iterable<T> join(Iterable<T> ... collections) {
        return selectMany(toIterable(collections));
    }

    public static <T> Iterable<T> selectMany(Iterable<Iterable<T>> collection) {
        return () -> new Iterator<T>() {
            final Iterator<Iterator<T>> backingData = select(collection, Iterable::iterator).iterator();
            Iterator<T> current = null;

            @Override
            public boolean hasNext() {
                if(current != null && current.hasNext()) return true;
                while((current == null || !current.hasNext()) && backingData.hasNext()) {
                    current = backingData.next();
                }
                return (current != null && current.hasNext());
            }

            @Override
            public T next() {
                return current.next();
            }
        };
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static <T> Iterable<T> emptyIterable() {
        return toIterable();
    }

    //endregion

    public static <T, OUT> Iterable<OUT> select(Iterable<T> collection, Selector<? super T, OUT> selector) {
        return () -> new Iterator<OUT>() {
            final Iterator<T> backing = collection.iterator();

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


    /**
     *
     * @param collection
     * @param aggregator
     * @param <T>
     * @return
     */
    public static <T> T aggregate(Iterable<T> collection, T seed, AggregateFunction<T> aggregator) {
        T aggregated = seed;
        for(T current : collection) {
            aggregated = aggregator.Invoke(aggregated,current);
        }
        return aggregated;
    }

    //region SubIndexing ========================================================================================================

    public static <T> Iterable<T> subCollection(Iterable<T> collection, int startingIndex) {
        return subCollection(collection, startingIndex,Integer.MAX_VALUE);
    }

    public static <T> Iterable<T> subCollection(Iterable<T> collection, int startingIndex, int length) {
        return () -> new Iterator<T>() {
            final Iterator<T> backbone = collection.iterator();
            int index = 0;
            @Override
            public boolean hasNext() {
                while(backbone.hasNext() // still stuff left
                        && index < startingIndex // before start
                        && index > startingIndex + length) { // haven't gone over the end
                    backbone.next(); // trash
                    index++;
                }
                return backbone.hasNext();
            }

            @Override
            public T next() {
                return backbone.next();
            }
        };
    }

    public static <T> Iterable<T> subCollection(List<T> collection, int startingIndex) {
        if(startingIndex == 0) return collection;
        return subCollection(collection, startingIndex,Integer.MAX_VALUE);
    }

    public static <T> Iterable<T> subCollection(List<T> collection, int startingIndex, int length) {
        if (startingIndex == 0 && collection.size() <= length) return collection;
        return () -> new Iterator<T>() {
            final List<T> backbone = collection;
            int index = startingIndex;

            @Override
            public boolean hasNext() {
                return index < backbone.size() && index < startingIndex + length;
            }

            @Override
            public T next() {
                return backbone.get(index++);
            }
        };
    }

    public static <T> Iterable<T> subCollection(T[] collection, int startingIndex) {
        if(startingIndex == 0) return toIterable(collection);
        return subCollection(collection, startingIndex,Integer.MAX_VALUE);
    }

    public static <T> Iterable<T> subCollection(T[] collection, int startingIndex, int length) {
        if(startingIndex == 0 && collection.length <= length) return toIterable(collection);
        return () -> new Iterator<T>() {
            final T[] backbone = collection;
            int index = startingIndex;
            @Override
            public boolean hasNext() {
                return index < backbone.length && index < startingIndex + length;
            }

            @Override
            public T next() {
                return backbone[index++];
            }
        };
    }



    //endregion //*/

    public static <T> boolean anyMatch(Iterable<T> collection, Predicate<? super T> theTest) {
        for(T t : collection) if(theTest.Invoke(t)) return true;
        return false;
    }
    public static <T> boolean allMatch(Iterable<T> collection, Predicate<? super T> theTest) {
        for(T t : collection) if(!theTest.Invoke(t)) return true;
        return false;
    }
    public static <T> boolean noneMatch(Iterable<T> collection, Predicate<? super T> theTest) {
        for(T t : collection) if(theTest.Invoke(t)) return false;
        return true;
    }


}