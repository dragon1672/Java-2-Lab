package utils.FunctionInterfaces;

/**
 * Created by Anthony on 5/18/2015.
 */
public class Functions {
    public interface Function8<RetType,Pram1,Pram2,Pram3,Pram4,Pram5,Pram6,Pram7,Pram8>{ RetType Invoke(Pram1 a,Pram2 b,Pram3 c,Pram4 d,Pram5 e,Pram6 f,Pram7 g,Pram8 h); }
    public interface Function7<RetType,Pram1,Pram2,Pram3,Pram4,Pram5,Pram6,Pram7>{ RetType Invoke(Pram1 a,Pram2 b,Pram3 c,Pram4 d,Pram5 e,Pram6 f,Pram7 g); }
    public interface Function6<RetType,Pram1,Pram2,Pram3,Pram4,Pram5,Pram6>{ RetType Invoke(Pram1 a,Pram2 b,Pram3 c,Pram4 d,Pram5 e,Pram6 f); }
    public interface Function5<RetType,Pram1,Pram2,Pram3,Pram4,Pram5>{ RetType Invoke(Pram1 a,Pram2 b,Pram3 c,Pram4 d,Pram5 e); }
    public interface Function4<RetType,Pram1,Pram2,Pram3,Pram4>{ RetType Invoke(Pram1 a,Pram2 b,Pram3 c,Pram4 d); }
    public interface Function3<RetType,Pram1,Pram2,Pram3>{ RetType Invoke(Pram1 a,Pram2 b,Pram3 c); }
    public interface Function2<RetType,Pram1,Pram2>{ RetType Invoke(Pram1 a,Pram2 b); }
    public interface Function1<RetType,Pram1>{ RetType Invoke(Pram1 a); }
    public interface Function0<RetType>{ RetType Invoke(); }
    public interface Function{ void Invoke(); }
}
