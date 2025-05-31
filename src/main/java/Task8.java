public class Task8 {
    public static void printStringMultipleTimes(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }
    public static void main(String[] args) {
        printStringMultipleTimes("Love", 5);
    }
}
