package utils.Predicates;

/**
 * Created by Anthony on 1/22/2015.
 */
public class NotPredicate<T> implements Predicate<T> {
    private final Predicate<T> a;
    public NotPredicate(Predicate<T> a) {
        this.a = a;
    }
    public boolean Invoke(T val) {
        return !a.Invoke(val);
    }
}