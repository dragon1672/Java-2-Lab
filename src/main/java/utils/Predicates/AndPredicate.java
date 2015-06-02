package utils.Predicates;

/**
 * Created by Anthony on 1/22/2015.
 */
public class AndPredicate<T> implements Predicate<T> {
    private final Predicate<? super T> a,b;
    public AndPredicate(Predicate<? super T> a, Predicate<? super T> b) {
        this.a = a;
        this.b = b;
    }
    public boolean Invoke(T val) {
        return a.Invoke(val) && b.Invoke(val);
    }
}