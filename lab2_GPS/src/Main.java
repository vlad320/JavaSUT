import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<GPSNavigator> navigators = new ArrayList<>();


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
        System.out.println("6. Выход из программы");
    }

    private static void createObject(ArrayList<GPSNavigator> navigators, Scanner scanner) {
        System.out.println("Введите производителя:");
        String manufacturer = scanner.next();
        System.out.println("Введите модель:");
        String model = scanner.next();
        navigators.add(new GPSNavigator(manufacturer, model));
    }

    private static void displayProperties(ArrayList<GPSNavigator> navigators) {
        System.out.println("| ## | Производитель   | Модель          |");
        for (int i = 0; i < navigators.size(); i++) {
            GPSNavigator navigator = navigators.get(i);
            System.out.printf("| %2d | %-15s | %-15s |\n",
                    i + 1, navigator.getManufacturer(), navigator.getModel());
        }
    }
    private static void changeProperty(ArrayList<GPSNavigator> navigators, Scanner scanner) {
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
            default:
                System.out.println("Неверный выбор.");
                break;
        }
    }


    private static void removeObjectFromArray(ArrayList<GPSNavigator> navigators, Scanner scanner) {
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

    private static void calculateDevicesCount(ArrayList<GPSNavigator> navigators) {
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

    private static void exitProgram() {
        System.out.println("Программа завершена.");
        System.exit(0); // Завершить программу
    }
}