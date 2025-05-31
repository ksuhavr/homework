import java.util.Arrays;

public class Task14 {
    public static int [] arrayFilling (int len, int initialValue) {
        int [] arr = new int [len];
        Arrays.fill(arr, initialValue);
        return arr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayFilling(10, 2)));
    }
}
