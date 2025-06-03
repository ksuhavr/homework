import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ArithmeticOperationsTest {
    @Nested
    class AdditionTest {
        @ParameterizedTest
        @CsvSource({
                "2, 5, 7",
                "-2, 5, 3",
                "2, -5, -3",
                "-2, -5, -7",
                "0, 0, 0"
        })
        void testAdditionWithValidInput(int a, int b, int expected) {
            assertEquals(expected, Task.ArithmeticOperations.addition(a, b));
        }
    }

    @Nested
    class SubtractionTest {
        @ParameterizedTest
        @CsvSource({
                "2, 5, -3",
                "-2, 5, -7",
                "2, -5, 7",
                "-2, -5, 3",
                "0, 0, 0"
        })
        void testSubtractionWithValidInput(int a, int b, int expected) {
            assertEquals(expected, Task.ArithmeticOperations.subtraction(a, b));
        }
    }

    @Nested
    class DivisionTest {
        @ParameterizedTest
        @CsvSource({
                "2, 5, 0.4",
                "-2, 5, -0.4",
                "2, -5, -0.4",
                "-2, -5, 0.4",
                "0, 5, 0.0"
        })
        void testDivisionWithValidInput(int a, int b, double expected) {
            assertEquals(expected, Task.ArithmeticOperations.division(a, b));
        }

        @ParameterizedTest
        @CsvSource({
                "0, 0",
                "-1, 0",
                "1, 0"
        })
        void testDivisionWithZero(int a, int b) {
            assertThrows(ArithmeticException.class, () -> {
                Task.ArithmeticOperations.division(a, b);
            }, "Деление на ноль должно вызывать исключение");
        }
    }

    @Nested
    class MultiplicationTest {
        @ParameterizedTest
        @CsvSource({
                "2, 5, 10",
                "-2, 5, -10",
                "2, -5, -10",
                "-2, -5, 10",
                "0, 5, 0",
                "0, -2, 0",
                "2, 0, 0",
                "-2, 0, 0"
        })
        void testMultiplicationWithValidInput(int a, int b, double expected) {
            assertEquals(expected, Task.ArithmeticOperations.multiplication(a, b));
        }
    }
}