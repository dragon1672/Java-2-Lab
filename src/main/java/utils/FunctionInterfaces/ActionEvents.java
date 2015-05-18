package utils.FunctionInterfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony on 5/18/2015.
 */
public class ActionEvents {
    public static class ActionEvent8<Pram1, Pram2, Pram3, Pram4, Pram5, Pram6, Pram7, Pram8> {
        private List<Actions.Action8<Pram1, Pram2, Pram3, Pram4, Pram5, Pram6, Pram7, Pram8>> subscribedEvents = new ArrayList<>();
        public  void Subscribe(Actions.Action8<Pram1, Pram2, Pram3, Pram4, Pram5, Pram6, Pram7, Pram8> toAdd) { subscribedEvents.add(toAdd); }
        public  void Invoke(Pram1 pram1, Pram2 pram2, Pram3 pram3, Pram4 pram4, Pram5 pram5, Pram6 pram6, Pram7 pram7, Pram8 pram8) {
            for (Actions.Action8<Pram1, Pram2, Pram3, Pram4, Pram5, Pram6, Pram7, Pram8> fun : subscribedEvents) {
                fun.Invoke(pram1, pram2, pram3, pram4, pram5, pram6, pram7, pram8);
            }
        }
    }
    public static class ActionEvent7<Pram1, Pram2, Pram3, Pram4, Pram5, Pram6, Pram7> {
        private List<Actions.Action7<Pram1, Pram2, Pram3, Pram4, Pram5, Pram6, Pram7>> subscribedEvents = new ArrayList<>();
        public  void Subscribe(Actions.Action7<Pram1, Pram2, Pram3, Pram4, Pram5, Pram6, Pram7> toAdd) { subscribedEvents.add(toAdd); }
        public  void Invoke(Pram1 pram1, Pram2 pram2, Pram3 pram3, Pram4 pram4, Pram5 pram5, Pram6 pram6, Pram7 pram7) {
            for (Actions.Action7<Pram1, Pram2, Pram3, Pram4, Pram5, Pram6, Pram7> fun : subscribedEvents) {
                fun.Invoke(pram1, pram2, pram3, pram4, pram5, pram6, pram7);
            }
        }
    }
    public static class ActionEvent6<Pram1, Pram2, Pram3, Pram4, Pram5, Pram6> {
        private List<Actions.Action6<Pram1, Pram2, Pram3, Pram4, Pram5, Pram6>> subscribedEvents = new ArrayList<>();
        public  void Subscribe(Actions.Action6<Pram1, Pram2, Pram3, Pram4, Pram5, Pram6> toAdd) { subscribedEvents.add(toAdd); }
        public  void Invoke(Pram1 pram1, Pram2 pram2, Pram3 pram3, Pram4 pram4, Pram5 pram5, Pram6 pram6) {
            for (Actions.Action6<Pram1, Pram2, Pram3, Pram4, Pram5, Pram6> fun : subscribedEvents) {
                fun.Invoke(pram1, pram2, pram3, pram4, pram5, pram6);
            }
        }
    }
    public static class ActionEvent5<Pram1, Pram2, Pram3, Pram4, Pram5> {
        private List<Actions.Action5<Pram1, Pram2, Pram3, Pram4, Pram5>> subscribedEvents = new ArrayList<>();
        public  void Subscribe(Actions.Action5<Pram1, Pram2, Pram3, Pram4, Pram5> toAdd) { subscribedEvents.add(toAdd); }
        public  void Invoke(Pram1 pram1, Pram2 pram2, Pram3 pram3, Pram4 pram4, Pram5 pram5) {
            for (Actions.Action5<Pram1, Pram2, Pram3, Pram4, Pram5> fun : subscribedEvents) {
                fun.Invoke(pram1, pram2, pram3, pram4, pram5);
            }
        }
    }
    public static class ActionEvent4<Pram1, Pram2, Pram3, Pram4> {
        private List<Actions.Action4<Pram1, Pram2, Pram3, Pram4>> subscribedEvents = new ArrayList<>();
        public  void Subscribe(Actions.Action4<Pram1, Pram2, Pram3, Pram4> toAdd) { subscribedEvents.add(toAdd); }
        public  void Invoke(Pram1 pram1, Pram2 pram2, Pram3 pram3, Pram4 pram4) {
            for (Actions.Action4<Pram1, Pram2, Pram3, Pram4> fun : subscribedEvents) {
                fun.Invoke(pram1, pram2, pram3, pram4);
            }
        }
    }
    public static class ActionEvent3<Pram1, Pram2, Pram3> {
        private List<Actions.Action3<Pram1, Pram2, Pram3>> subscribedEvents = new ArrayList<>();
        public  void Subscribe(Actions.Action3<Pram1, Pram2, Pram3> toAdd) { subscribedEvents.add(toAdd); }
        public  void Invoke(Pram1 pram1, Pram2 pram2, Pram3 pram3) {
            for (Actions.Action3<Pram1, Pram2, Pram3> fun : subscribedEvents) {
                fun.Invoke(pram1, pram2, pram3);
            }
        }
    }
    public static class ActionEvent2<Pram1, Pram2> {
        private List<Actions.Action2<Pram1, Pram2>> subscribedEvents = new ArrayList<>();
        public  void Subscribe(Actions.Action2<Pram1, Pram2> toAdd) { subscribedEvents.add(toAdd); }
        public  void Invoke(Pram1 pram1, Pram2 pram2) {
            for (Actions.Action2<Pram1, Pram2> fun : subscribedEvents) {
                fun.Invoke(pram1, pram2);
            }
        }
    }
    public static class ActionEvent1<Pram1> {
        private List<Actions.Action1<Pram1>> subscribedEvents = new ArrayList<>();
        public  void Subscribe(Actions.Action1<Pram1> toAdd) { subscribedEvents.add(toAdd); }
        public  void Invoke(Pram1 pram1) {
            for (Actions.Action1<Pram1> fun : subscribedEvents) {
                fun.Invoke(pram1);
            }
        }
    }
    public static class ActionEvent {
        private List<Actions.Action> subscribedEvents = new ArrayList<>();
        public  void Subscribe(Actions.Action toAdd) { subscribedEvents.add(toAdd); }
        public  void Invoke() { subscribedEvents.forEach(Actions.Action::Invoke); }
    }
}
