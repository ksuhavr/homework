import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskPhoneDirectory {
    //Задание 2
    public static class PhoneDirectory {
        private final HashMap<String, List<String>> directory = new HashMap<>();

        public void add(String lastName, String phoneNumber) {
            directory.putIfAbsent(lastName, new ArrayList<>());
            directory.get(lastName).add(phoneNumber);
        }

        public List<String> get(String lastName) {
            return directory.getOrDefault(lastName, new ArrayList<>());
        }

        public void printAll() {
            for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        public static PhoneDirectory createDirectory() {
            PhoneDirectory directory = new PhoneDirectory();
            directory.add("Иванов", "+375293094286");
            directory.add("Петров", "+375296483992");
            directory.add("Иванов", "+375332894662");
            directory.add("Сидоров", "+375297046286");
            return directory;
        }
    }
}
