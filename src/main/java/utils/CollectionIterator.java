package utils;

import utils.Predicates.Predicate;

import java.util.List;
import java.util.Set;

/**
 * Created by Anthony on 6/1/2015.
 */
public interface CollectionIterator<T> extends Iterable<T> {
    static <T> CollectionIterator<T> convert(Iterable<T> base) {
        return base::iterator;
    }

    default CollectionIterator<T> filter(Predicate<T> theTest) {
        return convert(CollectionUtils.filter(this, theTest));
    }
    default <SelectType> CollectionIterator<T> filter(Predicate<SelectType> theTest, CollectionUtils.Selector<T, SelectType> selector) {
        return convert(CollectionUtils.filter(this, theTest, selector));
    }

    default int count() {
        return CollectionUtils.count(this);
    }

    default boolean isEmpty() {
        return CollectionUtils.isEmpty(this);
    }

    default CollectionIterator<T> reverse() {
        return convert(CollectionUtils.reverse(this));
    }

    default T firstOrDefault() {
        return CollectionUtils.firstOrDefault(this);
    }
    default T firstOrDefault(Predicate<T> condition) {
        return CollectionUtils.firstOrDefault(this, condition);
    }

    default List<T> toList() {
        return CollectionUtils.toList(this);
    }

    default Set<T> toSet() {
        return CollectionUtils.toSet(this);
    }

    default CollectionIterator<T> appendCollection(Iterable<T> toAdd) {
        return convert(CollectionUtils.join(this, toAdd));
    }

    default <OUT> CollectionIterator<OUT> select(CollectionUtils.Selector<T, OUT> selector) {
        return convert(CollectionUtils.select(this, selector));
    }

    default T aggregate(T seed, CollectionUtils.AggregateFunction<T> aggregator) {
        return CollectionUtils.aggregate(this, seed, aggregator);
    }

    default CollectionIterator<T> subCollection(int startingIndex) {
        return convert(CollectionUtils.subCollection(this, startingIndex));
    }
    default CollectionIterator<T> subCollection(int startingIndex, int length) {
        return convert(CollectionUtils.subCollection(this, startingIndex, length));
    }
}
