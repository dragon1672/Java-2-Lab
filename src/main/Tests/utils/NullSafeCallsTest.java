package utils;

import org.junit.Assert;
import org.junit.Test;
import utils.FunctionInterfaces.Actions;

/**
 * Created by Anthony on 5/20/2015.
 */
public class NullSafeCallsTest {
    static class FooIsDeep {
        FooIsDeep insides = null;
        private utils.FunctionInterfaces.Actions.Action todo;

        FooIsDeep(int num, Actions.Action todo) {
            this.todo = todo;
            if (num > 0)
                insides = new FooIsDeep(num - 1, todo);
        }

        public FooIsDeep next() {
            return insides;
        }

        public void doit() {
            todo.Invoke();
        }
    }

    @Test
    public void testNullSafeCall() throws Exception {
        final boolean[] called = {false};
        FooIsDeep f = new FooIsDeep(0, () -> called[0] = true);
        NullSafeCalls.NullSafeCall(f, FooIsDeep::doit);
        Assert.assertTrue(called[0]);

        called[0] = false;

        f = new FooIsDeep(0, () -> called[0] = true);
        NullSafeCalls.NullSafeCall(f, FooIsDeep::next, FooIsDeep::doit);
        Assert.assertFalse(called[0]);

        called[0] = false;

        f = new FooIsDeep(1, () -> called[0] = true);
        NullSafeCalls.NullSafeCall(f, FooIsDeep::next, FooIsDeep::doit);
        Assert.assertTrue(called[0]);

        called[0] = false;

        f = new FooIsDeep(1, () -> called[0] = true);
        NullSafeCalls.NullSafeCall(f, FooIsDeep::next, FooIsDeep::next, FooIsDeep::doit);
        Assert.assertFalse(called[0]);

        called[0] = false;

        f = new FooIsDeep(2, () -> called[0] = true);
        NullSafeCalls.NullSafeCall(f, FooIsDeep::next, FooIsDeep::next, FooIsDeep::doit);
        Assert.assertTrue(called[0]);

        called[0] = false;

        f = new FooIsDeep(3, () -> called[0] = true);
        NullSafeCalls.NullSafeCall(f, FooIsDeep::next, FooIsDeep::next, FooIsDeep::next, FooIsDeep::next, FooIsDeep::doit);
        Assert.assertFalse(called[0]);
        NullSafeCalls.NullSafeCall(f, FooIsDeep::next, FooIsDeep::next, FooIsDeep::next, FooIsDeep::next, FooIsDeep::next, FooIsDeep::next, FooIsDeep::doit);
        Assert.assertFalse(called[0]);
    }
}