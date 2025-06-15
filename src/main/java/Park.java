import java.util.ArrayList;
import java.util.List;

//Задание 3 Park
public class Park {
    private String parkName;
    private String workingHours;
    private List<Attraction> attractions;

    public class Attraction {
        private String name;
        private double price;

        public Attraction(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " (цена: " + price + " BYN)";
        }
    }

    public Park(String parkName, String workingHours) {
        this.parkName = parkName;
        this.workingHours = workingHours;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(String name, double price) {
        attractions.add(new Attraction(name, price));
    }

    public void printInfo() {
        System.out.println("Название парка: " + parkName);
        System.out.println("Время работы: " + workingHours);
        System.out.println("Аттракционы:");
        for (Attraction attraction : attractions) {
            System.out.println(" — " + attraction);
        }
    }

    public static void createNewPark() {
        Park park = new Park("Парк Горького", "9:00-21:00");
        park.addAttraction("Колесо обозрения", 21.90);
        park.addAttraction("Дикий поезд", 11.30);
        park.addAttraction("Ракушки", 15.50);

        park.printInfo();
    }
}