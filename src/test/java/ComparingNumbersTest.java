import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

public class ComparingNumbersTest {
    @DataProvider(name = "validInput")
    public Object[][] provideValidInput() {
        return new Object[][]{
                {2, 10, "a < b"},
                {-2, 10, "a < b"},
                {2, -10, "a > b"},
                {-2, -10, "a > b"},
                {2, 2, "a = b"},
                {-2, -2, "a = b"},
                //с нулем
                {0, -10, "a > b"},
                {-2, 0, "a < b"},
                {0, 10, "a < b"},
                {2, 0, "a > b"},
                {0, 0, "a = b"},
        };
    }

    @Test(dataProvider = "validInput")
    public void testComparingNumbersWithValidInput(int a, int b, String expected) {
        assertEquals(Task.ComparingNumbers.compareNumbers(a, b), expected,
                String.format("Ошибка при сравнении %d и %d", a, b));
    }
}