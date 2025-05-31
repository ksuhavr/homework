//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
        };
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"5", "6", "7", "8"},
                {"9", "10"},
        };
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "X", "11", "12"},
                {"13", "14", "15", "16"},
        };

        //Обработка корректного массива
        try {
            System.out.println("Сумма корректного массива: " + Task.ArrayProcessor.processArray(correctArray));
        } catch (Task.MyArraySizeException | Task.MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        //Обработка массива с неправильным размером
        try {
            System.out.println("Сумма массива с неправильным размером: " + Task.ArrayProcessor.processArray(wrongSizeArray));
        } catch (Task.MyArraySizeException e) {
            System.err.println("Ошибка размера массива: " + e.getMessage());
        } catch (Task.MyArrayDataException e) {
            System.err.println("Ошибка данных: " + e.getMessage());
        }

        //Обработка массива с некорректными данными
        try {
            System.out.println("Сумма массива с некорректными данными: " + Task.ArrayProcessor.processArray(wrongDataArray));
        } catch (Task.MyArraySizeException | Task.MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        //Демонстрация выхода за границы
        System.out.println("\nДемонстрация ArrayIndexOutOfBoundsException: ");

        Task.ArrayProcessor.generateIndexOutOfBounds(correctArray);
    }
}