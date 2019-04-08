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
        int x = 2, y = 7;

        Assert.assertEquals(x+y, Calculator.add(x, y));
    }

    @Test
    public void test_addNegativeNumbers_shouldBeAdded(){
        int x = -2, y = -7;

        Assert.assertEquals(x+y, Calculator.add(x, y));
    }

    @Test
    public void test_subtractPositiveNumbers_shouldBeSubtracted(){
        int x = 7, y = 2;

        Assert.assertEquals(x-y, Calculator.subtract(x, y));
    }

    @Test
    public void test_subtractNegativeNumbers_shouldBeAdded(){
        int x = -7, y = -2;

        Assert.assertEquals(x-y, Calculator.subtract(x, y));
    }

    @Test
    public void test_subtractLargerNumberFromSmallerNumber_shouldBeSubtracted(){
        int x = -2, y = -7;

        Assert.assertEquals(x-y, Calculator.subtract(x, y));
    }
}