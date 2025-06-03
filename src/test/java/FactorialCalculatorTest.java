import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

public class FactorialCalculatorTest {
    @Test
    void testFactorialOfZero() {
        assertEquals(1, Task.FactorialCalculator.calculateFactorial(0));
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, Task.FactorialCalculator.calculateFactorial(1));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120"
    })
    void testFactorialOfVariousNumbers(int input, long expected) {
        assertEquals(expected, Task.FactorialCalculator.calculateFactorial(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -5, -10, Integer.MIN_VALUE})
    void testFactorialOfNegativeNumber(int negativeNumber) {
        assertThrows(IllegalArgumentException.class, () -> {
            Task.FactorialCalculator.calculateFactorial(negativeNumber);
        }, "Число не должно быть < 0");
    }

    @Test
    void testFactorialOfLargeNumber() {
        assertDoesNotThrow(() -> {
            Task.FactorialCalculator.calculateFactorial(20);
        });
    }
}