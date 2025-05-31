public class Task {
    //Задание 1
    public static class Animal {
        private static int totalAnimals = 0;
        protected String name;

        public Animal(String name) {
            totalAnimals++;
            this.name = name;
        }

        public static int getTotalAnimals() {
            return totalAnimals;
        }

        public void run(int lengthRun) {
            System.out.println("Животное пробежало " + lengthRun + " м");
        }

        public void swim(int lengthSwim) {
            System.out.println("Животное проплыло " + lengthSwim + " м");
        }
    }

    public static class Dog extends Animal {
        private static int totalDogs = 0;
        private static final int MAX_RUN = 500;
        private static final int MAX_SWIM = 10;

        public Dog(String name) {
            super(name);
            totalDogs++;
        }

        public static int getTotalDogs() {
            return totalDogs;
        }

        public void run(int lengthRun) {
            if (lengthRun <= MAX_RUN && lengthRun >= 0) {
                System.out.println(name + " пробежал " + lengthRun + " м");
            } else {
                System.out.println(name + " не может столько бежать");
            }
        }

        public void swim(int lengthSwim) {
            if (lengthSwim <= MAX_SWIM && lengthSwim >= 0) {
                System.out.println(name + " проплыл " + lengthSwim + " м");
            } else {
                System.out.println(name + " не может столько плыть");
            }
        }
    }

    public static class Cat extends Animal {
        private static int totalCats;
        private static final int MAX_RUN = 200;
        private boolean isHungry = true;
        private int fullness;

        public Cat(int fullness, String name) {
            super(name);
            this.fullness = fullness;
            totalCats++;
        }

        public static int getTotalCats() {
            return totalCats;
        }

        public void run(int lengthRun) {
            if (lengthRun <= MAX_RUN && lengthRun >= 0) {
                System.out.println(name + " пробежал " + lengthRun + " м");
            } else {
                System.out.println(name + " не может столько бежать");
            }
        }

        public void swim(int lengthSwim) {
            System.out.println(name + " не умеет плавать");
        }

        public void eat(Bowl bowl) {
            if (isHungry && bowl.decreaseFood(fullness)) {
                isHungry = false;
                System.out.println(name + " поел и теперь сыт");
            } else if (!isHungry) {
                System.out.println(name + " уже не голоден");
            } else {
                System.out.println(name + " не смог поесть, в миске недостаточно еды");
            }
        }

        public boolean isHungry() {
            return isHungry;
        }

        public static void feedCats(Cat[] catsArray, Bowl bowl) {
            for (Cat cat : catsArray) {
                cat.eat(bowl);
            }
        }
    }

    public static class Bowl {
        private int food;

        public Bowl(int food) {
            this.food = food;
        }

        public boolean decreaseFood(int amount) {
            if (food >= amount) {
                food -= amount;
                return true;
            }
            return false;
        }

        public void addFood(int amount) {
            food += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске: " + food);
        }

        public int getFood() {
            return food;
        }
    }

    public static void animalsApp() {
        //создаем животных
        Dog dog = new Dog("Бобик");
        Cat cat1 = new Cat(3, "Мурзик");
        Cat cat2 = new Cat(5, "Маруся");
        Cat cat3 = new Cat(20, "Персик");
        //тестируем бег и плавание
        dog.run(300);
        dog.swim(5);
        cat1.run(200);
        cat1.swim(10);
        //проверяем подсчет животных
        System.out.println("Всего животных: " + Animal.getTotalAnimals());
        System.out.println("Всего собак: " + Dog.getTotalDogs());
        System.out.println("Всего котов: " + Cat.getTotalCats());
        //миска
        Bowl bowl = new Bowl(18);
        Cat[] catsArray = {cat1, cat2, cat3};
        Cat.feedCats(catsArray, bowl);
        //проверяем сытость
        for (Cat currentCat : catsArray) {
            System.out.println(currentCat.name + " сыт: " + !currentCat.isHungry());
        }
        //добавляем еду
        bowl.addFood(10);
        Cat.feedCats(catsArray, bowl);
    }

    //Задание 2
    public interface Shape {
        default void setFillColor(String fillColor) {
            System.out.println("Цвет заливки: " + fillColor);
        }

        default void setBorderColor(String borderColor) {
            System.out.println("Цвет границы: " + borderColor);
        }

        double getPerimeter();

        double getArea();

        default void printInfo() {
            System.out.println("Периметр: " + getPerimeter());
            System.out.println("Площадь: " + getArea());
        }
    }

    public static class Rectangle implements Shape {
        private int width;
        private int height;
        private String fillColor;
        private String borderColor;

        public Rectangle(int width, int height, String fillColor, String borderColor) {
            this.width = width;
            this.height = height;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        public void setFillColor(String fillColor) {
            this.fillColor = fillColor;
            System.out.println("Цвет заливки: " + fillColor);
        }

        public void setBorderColor(String borderColor) {
            this.borderColor = borderColor;
            System.out.println("Цвет границ: " + borderColor);
        }

        @Override
        public double getPerimeter() {
            return (width + height) * 2;
        }

        @Override
        public double getArea() {
            return width * height;
        }
    }

    public static class Triangle implements Shape {
        private int sideA;
        private int sideB;
        private int sideC;
        private int height;
        private String fillColor;
        private String borderColor;

        public Triangle(int sideA, int sideB, int sideC, int height, String fillColor, String borderColor) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.height = height;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        public void setFillColor(String fillColor) {
            this.fillColor = fillColor;
            System.out.println("Цвет заливки: " + fillColor);
        }

        public void setBorderColor(String borderColor) {
            this.borderColor = borderColor;
            System.out.println("Цвет границ: " + borderColor);
        }

        @Override
        public double getPerimeter() {
            return sideA + sideB + sideC;
        }

        @Override
        public double getArea() {
            return (sideA * height) / 2;
        }
    }

    public static class Circle implements Shape {
        private int radius;
        private String fillColor;
        private String borderColor;

        public Circle(int radius, String fillColor, String borderColor) {
            this.radius = radius;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        public void setFillColor(String fillColor) {
            this.fillColor = fillColor;
            System.out.println("Цвет заливки: " + fillColor);
        }

        public void setBorderColor(String borderColor) {
            this.borderColor = borderColor;
            System.out.println("Цвет границ: " + borderColor);
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    public static void shapeApp() {
        //прямоугольник
        System.out.println();
        System.out.println("Прямоугольник:");
        Rectangle rectangle = new Rectangle(10, 20, "Зеленый", "Желтый");
        rectangle.setFillColor("Зеленый");
        rectangle.setBorderColor("Желтый");
        rectangle.printInfo();
        //треугольник
        System.out.println();
        System.out.println("Треугольник:");
        Triangle triangle = new Triangle(9, 12, 8, 6, "Красный", "Оранжевый");
        triangle.setFillColor("Красный");
        triangle.setBorderColor("Оранжевый");
        triangle.printInfo();
        //круг
        System.out.println();
        System.out.println("Круг:");
        Circle circle = new Circle(10, "Розовый", "Голубой");
        circle.setFillColor("Розовый");
        circle.setBorderColor("Голубой");
        circle.printInfo();
    }
}