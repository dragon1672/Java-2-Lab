package utils;

/**
 * Created by Anthony on 2/5/2015.
 */
public class Tuple<T1,T2> {
    public T1 First;
    public T2 Second;

    public Tuple(T1 first, T2 second) {
        First = first;
        Second = second;
    }

    public Tuple() {}

    public T1 getFirst() {
        return First;
    }

    public void setFirst(T1 first) {
        First = first;
    }

    public T2 getSecond() {
        return Second;
    }

    public void setSecond(T2 second) {
        Second = second;
    }

    @SuppressWarnings("RedundantIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple tuple = (Tuple) o;

        if (First != null ? !First.equals(tuple.First) : tuple.First != null) return false;
        if (Second != null ? !Second.equals(tuple.Second) : tuple.Second != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = First != null ? First.hashCode() : 0;
        result = 31 * result + (Second != null ? Second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "First=" + First +
                ", Second=" + Second +
                '}';
    }
}
