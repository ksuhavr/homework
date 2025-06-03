public class Task {
    //факториал числа
    public static class FactorialCalculator {
        public static long calculateFactorial(int number) {
            if (number < 0) {
                throw new IllegalArgumentException("Число должно быть >= 0");
            }
            if (number == 0 || number == 1) {
                return 1;
            }
            long result = 1;
            for (int i = 2; i <= number; i++) {
                result = result * i;
            }
            return result;
        }
    }

    //площадь треугольника
    public static class TriangleArea {
        public static double getArea(double sideA, double height) {
            if (sideA <= 0 || height <= 0) {
                throw new IllegalArgumentException("Основание и высота должны быть > 0");
            }
            return (sideA * height) / 2;
        }
    }

    //арифметические действия с двумя целыми числами
    public static class ArithmeticOperations {
        public static int addition(int a, int b) {
            return a + b;
        }

        public static int subtraction(int a, int b) {
            return a - b;
        }

        public static double division(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("На ноль делить нельзя");
            }
            return (double) a / b;
        }

        public static int multiplication(int a, int b) {
            return a * b;
        }
    }

    //сравнение двух целых чисел
    public static class ComparingNumbers {
        public static String compareNumbers(int a, int b) {
            if (a > b) return "a > b";
            if (a < b) return "a < b";
            return "a = b";
        }
    }
}