import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

public class TriangleAreaTest {
    @DataProvider(name = "validNumbers")
    public Object[][] provideValidNumbers() {
        return new Object[][]{
                {2, 5, 5},
                {10.5, 15, 78.75},
                {13, 3, 19.5},
                {1, 1, 0.5}
        };
    }

    @Test(dataProvider = "validNumbers")
    public void testAreaWithValidInput(double sideA, double height, double expected) {
        assertEquals(Task.TriangleArea.getArea(sideA, height), expected, 0.001);
    }

    @DataProvider(name = "invalidNumbers")
    public Object[][] provideInvalidNumbers() {
        return new Object[][]{
                //отрицательные значения
                {-10.5, 15},
                {13, -3},
                {-11, -6},
                //нулевые значения
                {0, 5},
                {8, 0},
                {0, 0}
        };
    }

    @Test(dataProvider = "invalidNumbers",
            expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithInvalidInput(double invalidSideA, double invalidHeight) {
        Task.TriangleArea.getArea(invalidSideA, invalidHeight);
    }
}