package utils.Predicates;

/**
 * Created by Anthony on 2/9/2015.
 */
public class FalsePredicate<T> implements Predicate<T> {
    @Override public boolean Invoke(T val) { return false; }
}
