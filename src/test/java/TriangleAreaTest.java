import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleAreaTest {
    @ParameterizedTest
    @CsvSource({
            "2, 5, 5",
            "10.5, 15, 78.75",
            "13, 3, 19.5",
            "1, 1, 0.5"
    })
    void testAreaWithValidInput(double sideA, double height, double expected) {
        assertEquals(expected, Task.TriangleArea.getArea(sideA, height), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            //отрицательные значения
            "-10.5, 15",
            "13, -3",
            "-11, -6",
            //нулевые значения
            "0, 5",
            "8, 0",
            "0, 0"
    })
    void testAreaWithInvalidInput(double invalidSideA, double invalidHeight) {
        assertThrows(IllegalArgumentException.class, () -> {
            Task.TriangleArea.getArea(invalidSideA, invalidHeight);
        }, "Значения основания и высоты не должны быть <= 0");
    }
}