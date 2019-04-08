import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest{
    private Calculator Calculator;

    @Before
    public void setup(){
        Calculator = new Calculator();
    }

    @After
    public void teardown(){
        Calculator = null;
    }

    @Test
    public void test_addPositiveNumbers_shouldBeAdded(){
        int x = 10, y = 5;

        Assert.assertEquals(x+y, Calculator.add(x, y));
    }

    @Test
    public void test_addNegativeNumbers_shouldBeAdded(){
        int x = -5, y = -10;

        Assert.assertEquals(x+y, Calculator.add(x, y));
    }

    @Test
    public void test_subtractPositiveNumbers_shouldBeSubtracted(){
        int x = 9, y = 20;

        Assert.assertEquals(x-y, Calculator.subtract(x, y));
    }

    @Test
    public void test_subtractNegativeNumbers_shouldBeAdded(){
        int x = -1, y = -4;

        Assert.assertEquals(x-y, Calculator.subtract(x, y));
    }

    @Test
    public void test_subtractLargerNumberFromSmallerNumber_shouldBeSubtracted(){
        int x = -4, y = -2;

        Assert.assertEquals(x-y, Calculator.subtract(x, y));
    }
}
