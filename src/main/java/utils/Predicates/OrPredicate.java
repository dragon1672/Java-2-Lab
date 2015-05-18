package utils.Predicates;

/**
 * Created by Anthony on 1/22/2015.
 */
public class OrPredicate<T> implements Predicate<T> {
    Predicate<T> a,b;
    public OrPredicate(Predicate<T> a, Predicate<T> b) {
        this.a = a;
        this.b = b;
    }
    public boolean Invoke(T val) {
        return a.Invoke(val) || b.Invoke(val);
    }
}