import java.util.ArrayList;
import java.util.Scanner;

public class GPSNavigator {
    // Вычисляемое свойство
    private int devicesCount;

    // Другие свойства
    private String manufacturer;
    private String model;
    private static int price;
    private int totalSum;
    // Конструктор по умолчанию
    public GPSNavigator() {
        this("", "");
    }

    // Конструктор с параметрами
    public GPSNavigator(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    // Геттер и сеттер для вычисляемого свойства
    public int getDevicesCount() {
        return devicesCount;
    }

    public void setDevicesCount(int devicesCount) {
        this.devicesCount = devicesCount;
    }

    // Геттеры и сеттеры для других свойств
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }
    public int getTotalSum() {
        return totalSum;
    }

    public GPSNavigator(String manufacturer, String model, int price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }


    public static void createObject(ArrayList<GPSNavigator> navigators, Scanner scanner) {
        System.out.println("Введите производителя:");
        String manufacturer = scanner.next();
        System.out.println("Введите модель:");
        String model = scanner.next();
        System.out.println("Введите цену:");
        int price = scanner.nextInt();

        if (price < 0) {
            System.out.println("Цена не может быть отрицательной.");
            return;
        }

        navigators.add(new GPSNavigator(manufacturer, model, price));
    }


    public static void displayProperties(ArrayList<GPSNavigator> navigators) {
        System.out.println("| ## | Производитель   | Модель          | Цена            |");
        for (int i = 0; i < navigators.size(); i++) {
            GPSNavigator navigator = navigators.get(i);
            System.out.printf("| %2d | %-15s | %-15s | %-15s |\n",
                    i + 1, navigator.getManufacturer(), navigator.getModel(), navigator.getPrice());
        }
    }

    public static void changeProperty(ArrayList<GPSNavigator> navigators, Scanner scanner) {
        System.out.println("Введите номер элемента (1-" + navigators.size() + "):");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= navigators.size()) {
            System.out.println("Неверный индекс.");
            return;
        }

        GPSNavigator navigator = navigators.get(index);

        System.out.println("Выберите свойство для изменения:");
        System.out.println("1. Производитель");
        System.out.println("2. Модель");
        System.out.println("3. Цену");
        int propertyChoice = scanner.nextInt();

        switch (propertyChoice) {
            case 1:
                System.out.println("Введите новое имя производителя:");
                navigator.setManufacturer(scanner.next());
                break;
            case 2:
                System.out.println("Введите новую модель:");
                navigator.setModel(scanner.next());
                break;
            case 3:
                System.out.println("Введите новую цену:");
                navigator.setPrice(Integer.parseInt(scanner.next()));
            default:
                System.out.println("Неверный выбор.");
                break;
        }
    }

    public static int calculateTotalSum() {
        int totalSum = 0; // Объявление переменной
        for (GPSNavigator navigator : Main.navigators) {
            totalSum += navigator.getPrice();
        }
        return totalSum;
    }

    static void removeObjectFromArray(ArrayList<GPSNavigator> navigators, Scanner scanner) {
        System.out.println("Введите номер элемента (1-" + navigators.size() + "):");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= navigators.size()) {
            System.out.println("Неверный индекс.");
            return;
        }

        System.out.println("Вы уверены, что хотите удалить элемент " + (index + 1) + "? (y/n)");
        String confirmation = scanner.next();

        if (confirmation.equalsIgnoreCase("y")) {
            navigators.remove(index);
            System.out.println("Элемент " + (index + 1) + " удален.");
        } else {
            System.out.println("Удаление отменено.");
        }
    }


    static void calculateDevicesCount(ArrayList<GPSNavigator> navigators) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя производителя:");
        String manufacturer = scanner.nextLine();

        int deviceCount = 0;
        for (GPSNavigator navigator : navigators) {
            if (navigator.getManufacturer().equals(manufacturer)) {
                deviceCount++;
            }
        }

        System.out.println("Количество устройств производителя " + manufacturer + ": " + deviceCount);
    }


    public static int calculateSumByManufacturer(String manufacturer) {
        int sum = 0;
        for (GPSNavigator navigator : Main.navigators) {
            if (navigator.getManufacturer().equals(manufacturer)) {
                sum += navigator.getPrice();
            }
        }
        return sum;
    }


}
