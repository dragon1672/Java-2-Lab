package utils.Predicates;

/**
 * Created by Anthony on 1/22/2015.
 */
public class OrPredicate<T> implements Predicate<T> {
    private final Predicate<? super T> a;
    private final Predicate<? super T> b;
    public OrPredicate(Predicate<? super T> a, Predicate<? super T> b) {
        this.a = a;
        this.b = b;
    }
    public boolean Invoke(T val) {
        return a.Invoke(val) || b.Invoke(val);
    }
}