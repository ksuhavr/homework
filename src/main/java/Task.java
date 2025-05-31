public class Task {
    public static class MyArraySizeException extends RuntimeException {
        public MyArraySizeException() {
            super("Размер массива должен быть 4х4");
        }
    }

    public static class MyArrayDataException extends RuntimeException {
        public MyArrayDataException(int row, int col, String value) {
            super(String.format("Неверные данные в ячейке [%d][%d]: '%s'", row, col, value));
        }
    }

    public static class ArrayProcessor {
        public static int processArray(String[][] array) {
            if (array == null || array.length != 4) {
                throw new MyArraySizeException();
            }
            for (String[] row : array) {
                if (row == null || row.length != 4) {
                    throw new MyArraySizeException();
                }
            }

            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j, array[i][j]);
                    }
                }
            }

            return sum;
        }

        public static void generateIndexOutOfBounds(String[][] array) {
            try {
                String value = array[4][4];
                System.out.println("Значение: " + value);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
            }
        }
    }
}