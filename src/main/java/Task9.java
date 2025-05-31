public class Task9 {
    public static boolean checkYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 !=0) {
            return true;
        } else {
            return (year % 400 == 0);
        }
    }
    public static void main(String[] args) {
        System.out.println(checkYear(2024));
    }
}
