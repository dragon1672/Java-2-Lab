package utils;

import utils.FunctionInterfaces.Actions.Action1;
import utils.FunctionInterfaces.Functions.Function1;

/**
 * Created by Anthony on 5/12/2015.
 * Since null ref exceptions are mean, this will attempt to call method
 */
@SuppressWarnings({"unused", "SuspiciousNameCombination"})
public class NullSafeCalls {
    public static <Z> boolean NullSafeCall(Z z, Action1<Z> caller) {
        if (z != null)
            caller.Invoke(z);
        return z != null;
    }

    public static <Y, Z> boolean NullSafeCall(Y y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <X, Y, Z> boolean NullSafeCall(X x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <W, X, Y, Z> boolean NullSafeCall(W w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <V, W, X, Y, Z> boolean NullSafeCall(V v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <U, V, W, X, Y, Z> boolean NullSafeCall(U u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <T, U, V, W, X, Y, Z> boolean NullSafeCall(T t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <S, T, U, V, W, X, Y, Z> boolean NullSafeCall(S s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(R r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(Q q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(P p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(O o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(N n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(M m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(L l, Function1<M, L> m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(K k, Function1<L, K> l, Function1<M, L> m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(J j, Function1<K, J> k, Function1<L, K> l, Function1<M, L> m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(I i, Function1<J, I> j, Function1<K, J> k, Function1<L, K> l, Function1<M, L> m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(H h, Function1<I, H> i, Function1<J, I> j, Function1<K, J> k, Function1<L, K> l, Function1<M, L> m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(G g, Function1<H, G> h, Function1<I, H> i, Function1<J, I> j, Function1<K, J> k, Function1<L, K> l, Function1<M, L> m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(F f, Function1<G, F> g, Function1<H, G> h, Function1<I, H> i, Function1<J, I> j, Function1<K, J> k, Function1<L, K> l, Function1<M, L> m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(E e, Function1<F, E> f, Function1<G, F> g, Function1<H, G> h, Function1<I, H> i, Function1<J, I> j, Function1<K, J> k, Function1<L, K> l, Function1<M, L> m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(D d, Function1<E, D> e, Function1<F, E> f, Function1<G, F> g, Function1<H, G> h, Function1<I, H> i, Function1<J, I> j, Function1<K, J> k, Function1<L, K> l, Function1<M, L> m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(C c, Function1<D, C> d, Function1<E, D> e, Function1<F, E> f, Function1<G, F> g, Function1<H, G> h, Function1<I, H> i, Function1<J, I> j, Function1<K, J> k, Function1<L, K> l, Function1<M, L> m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(B b, Function1<C, B> c, Function1<D, C> d, Function1<E, D> e, Function1<F, E> f, Function1<G, F> g, Function1<H, G> h, Function1<I, H> i, Function1<J, I> j, Function1<K, J> k, Function1<L, K> l, Function1<M, L> m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> boolean NullSafeCall(A a, Function1<B, A> b, Function1<C, B> c, Function1<D, C> d, Function1<E, D> e, Function1<F, E> f, Function1<G, F> g, Function1<H, G> h, Function1<I, H> i, Function1<J, I> j, Function1<K, J> k, Function1<L, K> l, Function1<M, L> m, Function1<N, M> n, Function1<O, N> o, Function1<P, O> p, Function1<Q, P> q, Function1<R, Q> r, Function1<S, R> s, Function1<T, S> t, Function1<U, T> u, Function1<V, U> v, Function1<W, V> w, Function1<X, W> x, Function1<Y, X> y, Function1<Z, Y> z, Action1<Z> caller) {
        Z data = NullSafeGets.NullSafeGet(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z);
        return data != null && NullSafeCall(data, caller);
    }
}
