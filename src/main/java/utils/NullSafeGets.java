package utils;

import utils.FunctionInterfaces.Functions.Function1;

@SuppressWarnings({"SuspiciousNameCombination", "unused"})
/**
 * Created by Anthony on 5/12/2015.
 * Returns null if pram is unsafe at any stage of the process because null ref exceptions are mean
 */
public class NullSafeGets {
    /**
     * If z is not null returns based off selector, otherwise returns null
     * @param z initial var
     * @param selector how to select next object from z if it isn't null
     * @param <TRet> return type
     * @param <Z> type of z
     * @return
     */
    public static <TRet, Z> TRet NullSafeGet(Z z,Function1<TRet, Z> selector) {
        if(z == null) return null;
        return selector.Invoke(z);
    }

    /**
     * Calls y.z.selector and returns null if any stage in that chain is null
     * @param y initial var
     * @param z 2nd var
     * @param selector how to get final var
     * @param <TRet> return type
     * @param <Y> first type
     * @param <Z> second type
     * @return
     */
    public static <TRet, Y, Z> TRet NullSafeGet(Y y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(y != null)
            return NullSafeGet(NullSafeGet(y, z), selector);
        return null;
    }

    public static <TRet, X, Y, Z> TRet NullSafeGet(X x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(x != null)
            return NullSafeGet(NullSafeGet(x, y, z), selector);
        return null;
    }

    public static <TRet, W, X, Y, Z> TRet NullSafeGet(W w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(w!=null)
            return NullSafeGet(NullSafeGet(w, x, y, z), selector);
        return null;
    }

    public static <TRet, V, W, X, Y, Z> TRet NullSafeGet(V v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(v!=null)
            return NullSafeGet(NullSafeGet(v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, U, V, W, X, Y, Z> TRet NullSafeGet(U u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(u!=null)
            return NullSafeGet(NullSafeGet(u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, T, U, V, W, X, Y, Z> TRet NullSafeGet(T t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(t!=null)
            return NullSafeGet(NullSafeGet(t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(S s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(s!=null)
            return NullSafeGet(NullSafeGet(s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(R r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(r!=null)
            return NullSafeGet(NullSafeGet(r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(Q q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(q!=null)
            return NullSafeGet(NullSafeGet(q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(P p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(p!=null)
            return NullSafeGet(NullSafeGet(p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(O o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(o!=null)
            return NullSafeGet(NullSafeGet(o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(N n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(n!=null)
            return NullSafeGet(NullSafeGet(n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(M m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(m!=null)
            return NullSafeGet(NullSafeGet(m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(L l, Function1<M,L> m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(l!=null)
            return NullSafeGet(NullSafeGet(l, m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(K k, Function1<L,K> l, Function1<M,L> m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(k!=null)
            return NullSafeGet(NullSafeGet(k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(J j, Function1<K,J> k, Function1<L,K> l, Function1<M,L> m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(j!=null)
            return NullSafeGet(NullSafeGet(j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(I i, Function1<J,I> j, Function1<K,J> k, Function1<L,K> l, Function1<M,L> m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(i!=null)
            return NullSafeGet(NullSafeGet(i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(H h, Function1<I,H> i, Function1<J,I> j, Function1<K,J> k, Function1<L,K> l, Function1<M,L> m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(h!=null)
            return NullSafeGet(NullSafeGet(h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(G g, Function1<H,G> h, Function1<I,H> i, Function1<J,I> j, Function1<K,J> k, Function1<L,K> l, Function1<M,L> m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(g!=null)
            return NullSafeGet(NullSafeGet(g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(F f, Function1<G,F> g, Function1<H,G> h, Function1<I,H> i, Function1<J,I> j, Function1<K,J> k, Function1<L,K> l, Function1<M,L> m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(f!=null)
            return NullSafeGet(NullSafeGet(f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(E e, Function1<F,E> f, Function1<G,F> g, Function1<H,G> h, Function1<I,H> i, Function1<J,I> j, Function1<K,J> k, Function1<L,K> l, Function1<M,L> m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(e!=null)
            return NullSafeGet(NullSafeGet(e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(D d, Function1<E,D> e, Function1<F,E> f, Function1<G,F> g, Function1<H,G> h, Function1<I,H> i, Function1<J,I> j, Function1<K,J> k, Function1<L,K> l, Function1<M,L> m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(d!=null)
            return NullSafeGet(NullSafeGet(d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(C c, Function1<D,C> d, Function1<E,D> e, Function1<F,E> f, Function1<G,F> g, Function1<H,G> h, Function1<I,H> i, Function1<J,I> j, Function1<K,J> k, Function1<L,K> l, Function1<M,L> m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(c!=null)
            return NullSafeGet(NullSafeGet(c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(B b, Function1<C,B> c, Function1<D,C> d, Function1<E,D> e, Function1<F,E> f, Function1<G,F> g, Function1<H,G> h, Function1<I,H> i, Function1<J,I> j, Function1<K,J> k, Function1<L,K> l, Function1<M,L> m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(b!=null)
            return NullSafeGet(NullSafeGet(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }

    public static <TRet, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> TRet NullSafeGet(A a, Function1<B,A> b, Function1<C,B> c, Function1<D,C> d, Function1<E,D> e, Function1<F,E> f, Function1<G,F> g, Function1<H,G> h, Function1<I,H> i, Function1<J,I> j, Function1<K,J> k, Function1<L,K> l, Function1<M,L> m, Function1<N,M> n, Function1<O,N> o, Function1<P,O> p, Function1<Q,P> q, Function1<R,Q> r, Function1<S,R> s, Function1<T,S> t, Function1<U,T> u, Function1<V,U> v, Function1<W,V> w, Function1<X, W> x, Function1<Y,X> y, Function1<Z, Y> z,Function1<TRet, Z> selector) {
        if(a!=null)
            return NullSafeGet(NullSafeGet(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z), selector);
        return null;
    }
}
