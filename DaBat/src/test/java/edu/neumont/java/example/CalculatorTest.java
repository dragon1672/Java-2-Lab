package edu.neumont.java.example;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void testMultiplyBasic() {
        Assert.assertEquals((Integer)24, calculator.multiply(4, 6));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testWithNullFirstParameter() {
        calculator.multiply((Integer)null, 4);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testWithNullSecondParameter() {
        calculator.multiply(6, (Integer)null);
    }
}
