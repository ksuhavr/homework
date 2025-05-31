public class Task5 {
    public static boolean checkSumInRange(int a, int b) {
        return (a + b >= 10) && (a + b <= 20);
    }
    public static void main(String[] args) {
        System.out.println(checkSumInRange(2, 100));
    }
}
