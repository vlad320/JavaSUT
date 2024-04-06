import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static ArrayList<GPSNavigator> navigators = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createObject(navigators, scanner);
                    break;
                case 2:
                    displayProperties(navigators);
                    break;
                case 3:
                    changeProperty(navigators, scanner);
                    break;
                case 4:
                    removeObjectFromArray(navigators, scanner);
                    break;
                case 5:
                    calculateDevicesCount(navigators);
                    break;
                case 6:
                    int totalSum = calculateTotalSum();
                    System.out.println("Общая сумма: " + totalSum);
                    break;
                case 7:
                    System.out.println("Введите производителя:");
                    String manufacturer = scanner.next();
                    int sumByManufacturer = calculateSumByManufacturer(manufacturer);
                    System.out.println("Сумма по производителю " + manufacturer + ": " + sumByManufacturer);
                    break;
                case 8:
                    exitProgram();
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Создать новый объект");
        System.out.println("2. Просмотреть свойства объекта");
        System.out.println("3. Изменить свойство объекта");
        System.out.println("4. Удалить объект из массива");
        System.out.println("5. Вычислить количество устройств");
        System.out.println("6. Вычислить общую сумму");
        System.out.println("7. Вычислить сумму по производителю");
        System.out.println("8. Выход из программы");
    }

    private static void exitProgram() {
        System.out.println("Программа завершена.");
        System.exit(0); // Завершить программу
    }




     static void createObject(ArrayList<GPSNavigator> navigators, Scanner scanner) {
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


    static void displayProperties(ArrayList<GPSNavigator> navigators) {
        System.out.println("| ## | Производитель   | Модель          | Цена            |");
        for (int i = 0; i < navigators.size(); i++) {
            GPSNavigator navigator = navigators.get(i);
            System.out.printf("| %2d | %-15s | %-15s | %-15s |\n",
                    i + 1, navigator.getManufacturer(), navigator.getModel(), navigator.getPrice());
        }
    }

    static void changeProperty(ArrayList<GPSNavigator> navigators, Scanner scanner) {
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

    static int calculateTotalSum() {
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


    static int calculateSumByManufacturer(String manufacturer) {
        int sum = 0;
        for (GPSNavigator navigator : navigators) {
            if (navigator.getManufacturer().equals(manufacturer)) {
                sum += navigator.getPrice();
            }
        }
        return sum;
    }


}

