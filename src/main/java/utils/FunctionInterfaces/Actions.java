package utils.FunctionInterfaces;

/**
 * Created by Anthony on 5/18/2015.
 */
public class Actions {
    public interface Action8<Pram1,Pram2,Pram3,Pram4,Pram5,Pram6,Pram7,Pram8>{ void Invoke(Pram1 a,Pram2 b,Pram3 c,Pram4 d,Pram5 e,Pram6 f,Pram7 g,Pram8 h); }
    public interface Action7<Pram1,Pram2,Pram3,Pram4,Pram5,Pram6,Pram7>{ void Invoke(Pram1 a,Pram2 b,Pram3 c,Pram4 d,Pram5 e,Pram6 f,Pram7 g); }
    public interface Action6<Pram1,Pram2,Pram3,Pram4,Pram5,Pram6>{ void Invoke(Pram1 a,Pram2 b,Pram3 c,Pram4 d,Pram5 e,Pram6 f); }
    public interface Action5<Pram1,Pram2,Pram3,Pram4,Pram5>{ void Invoke(Pram1 a,Pram2 b,Pram3 c,Pram4 d,Pram5 e); }
    public interface Action4<Pram1,Pram2,Pram3,Pram4>{ void Invoke(Pram1 a,Pram2 b,Pram3 c,Pram4 d); }
    public interface Action3<Pram1,Pram2,Pram3>{ void Invoke(Pram1 a,Pram2 b,Pram3 c); }
    public interface Action2<Pram1,Pram2>{ void Invoke(Pram1 a,Pram2 b); }
    public interface Action1<Pram1>{ void Invoke(Pram1 a); }
    public interface Action{ void Invoke(); }
}
