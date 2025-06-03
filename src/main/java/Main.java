public class Main {
    public static void main(String[] args) {
        //факториал числа
        long factorial = Task.FactorialCalculator.calculateFactorial(4);
        System.out.println("Факториал 4 = " + factorial);

        //площадь треугольника
        double area = Task.TriangleArea.getArea(15,5);
        System.out.println("\nПлощадь треугольника равна " + area);

        //арифметические действия с двумя целыми числами
        int resultAddition = Task.ArithmeticOperations.addition(5, 6);
        System.out.println("\nСумма чисел " + resultAddition);
        int resultSubtraction = Task.ArithmeticOperations.subtraction(5, 6);
        System.out.println("Разность чисел " + resultSubtraction);
        double resultDivision = Task.ArithmeticOperations.division(5, 6);
        System.out.println("Частное чисел " + resultDivision);
        int resultMultiplication = Task.ArithmeticOperations.multiplication(5, 6);
        System.out.println("Произведение чисел " + resultMultiplication);

        //сравнение двух целых чисел
        System.out.println();
        String compare = Task.ComparingNumbers.compareNumbers(17,8);
        System.out.println(compare);
    }
}