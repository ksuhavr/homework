import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Task.FactorialCalculator.calculateFactorial(0), 1L);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(Task.FactorialCalculator.calculateFactorial(1), 1L);
    }

    @DataProvider(name = "validNumbers")
    public Object[][] provideValidNumbers() {
        return new Object[][]{
                {2, 2L},
                {3, 6L},
                {4, 24L},
                {5, 120L}
        };
    }

    @Test(dataProvider = "validNumbers")
    public void testFactorialOfVariousNumbers(int input, long expected) {
        assertEquals(Task.FactorialCalculator.calculateFactorial(input), expected);
    }

    @DataProvider(name = "negativeNumbers")
    public Object[][] provideNegativeNumbers() {
        return new Object[][]{
                {-1},
                {-2},
                {-5},
                {-10},
                {Integer.MIN_VALUE}
        };
    }

    @Test(dataProvider = "negativeNumbers",
            expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber(int negativeNumber) {
        Task.FactorialCalculator.calculateFactorial(negativeNumber);
    }

    @Test
    public void testFactorialOfLargeNumber() {
        Task.FactorialCalculator.calculateFactorial(20);
    }
}