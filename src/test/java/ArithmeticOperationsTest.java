import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

public class ArithmeticOperationsTest {
    //тесты для сложения
    @Test(dataProvider = "additionData", dataProviderClass = DataProviders.class)
    public void testAddition(int a, int b, int expected) {
        assertEquals(Task.ArithmeticOperations.addition(a, b), expected);
    }

    //тесты для вычитания
    @Test(dataProvider = "subtractionData", dataProviderClass = DataProviders.class)
    public void testSubtraction(int a, int b, int expected) {
        assertEquals(Task.ArithmeticOperations.subtraction(a, b), expected);
    }

    //тесты для деления
    @Test(dataProvider = "divisionData", dataProviderClass = DataProviders.class)
    public void testDivision(int a, int b, double expected) {
        assertEquals(Task.ArithmeticOperations.division(a, b), expected, 0.001);
    }

    @Test(dataProvider = "divisionByZeroData", dataProviderClass = DataProviders.class,
            expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero(int a, int b) {
        Task.ArithmeticOperations.division(a, b);
    }

    //тесты для умножения
    @Test(dataProvider = "multiplicationData", dataProviderClass = DataProviders.class)
    public void testMultiplication(int a, int b, double expected) {
        assertEquals(Task.ArithmeticOperations.multiplication(a, b), expected);
    }
}

//отддельный класс для DataProviders
class DataProviders {
    @DataProvider
    public static Object[][] additionData() {
        return new Object[][]{
                {2, 5, 7},
                {-2, 5, 3},
                {2, -5, -3},
                {-2, -5, -7},
                {0, 0, 0}
        };
    }

    @DataProvider
    public static Object[][] subtractionData() {
        return new Object[][]{
                {2, 5, -3},
                {-2, 5, -7},
                {2, -5, 7},
                {-2, -5, 3},
                {0, 0, 0}
        };
    }

    @DataProvider
    public static Object[][] divisionData() {
        return new Object[][]{
                {2, 5, 0.4},
                {-2, 5, -0.4},
                {2, -5, -0.4},
                {-2, -5, 0.4},
                {0, 5, 0.0}
        };
    }

    @DataProvider
    public static Object[][] divisionByZeroData() {
        return new Object[][]{
                {0, 0},
                {-1, 0},
                {1, 0}
        };
    }

    @DataProvider
    public static Object[][] multiplicationData() {
        return new Object[][]{
                {2, 5, 10},
                {-2, 5, -10},
                {2, -5, -10},
                {-2, -5, 10},
                {0, 5, 0},
                {0, -2, 0},
                {2, 0, 0},
                {-2, 0, 0}
        };
    }
}