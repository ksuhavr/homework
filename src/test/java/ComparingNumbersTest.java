import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ComparingNumbersTest {
    @ParameterizedTest
    @CsvSource({
            "2, 10, 'a < b'",
            "-2, 10, 'a < b'",
            "2, -10, 'a > b'",
            "-2, -10, 'a > b'",
            "2, 2, 'a = b'",
            "-2, -2, 'a = b'",
            //с нулем
            "0, -10, 'a > b'",
            "-2, 0, 'a < b'",
            "0, 10, 'a < b'",
            "2, 0, 'a > b'",
            "0, 0, 'a = b'"
    })
    void testComparingNumbersWithValidInput(int a, int b, String expected) {
        assertEquals(expected, Task.ComparingNumbers.compareNumbers(a, b),
                String.format("Ошибка при сравнении %d и %d", a, b));
    }
}