public class Task6 {
    public static void checkNumberPositive(int number) {
        if (number >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }
    public static void main(String[] args) {
        checkNumberPositive(10);
    }
}
