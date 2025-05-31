public class Task13 {
    public static void main(String[] args) {
        int size = 5;
        int [][] table = new int [5][5];
        for (int i = 0; i < size; i++) {
            table [i][i] = 1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(table [i][j] + " ");
            }
            System.out.println();
        }
    }
}
