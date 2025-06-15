//Задание 1, 2 Product
public class Product {
    private String name;
    private String productionDate;
    private String producer;
    private String country;
    private double price;
    private boolean bookingStatus;

    public Product(String name, String productionDate, String producer,
                   String country, double price, boolean bookingStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.producer = producer;
        this.country = country;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public void info() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + producer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price + " BYN");
        System.out.println("Состоние бронирования покупателем: " + (bookingStatus ? "Забронировано" : "Свободно"));
        System.out.println();
    }

    public static void product() {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("IPhone 14 Pro max", "20.09.2023",
                "Apple", "China", 7890, true);
        productsArray[2] = new Product("MacBookPro", "13.10.2024",
                "Apple", "China", 15690, false);
        productsArray[3] = new Product("Samsung Galaxy A26", "10.05.2024",
                "Samsung Corp.", "Korea", 6590, true);
        productsArray[4] = new Product("Lenovo IdeaPad", "30.07.2023",
                "Lenovo", "China", 12390, false);
        System.out.println("Список всех товаров:");
        for (Product product : productsArray) {
            product.info();
        }
    }
}