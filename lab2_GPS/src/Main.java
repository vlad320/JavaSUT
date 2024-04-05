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
                    GPSNavigator.createObject(navigators, scanner);
                    break;
                case 2:
                    GPSNavigator.displayProperties(navigators);
                    break;
                case 3:
                    GPSNavigator.changeProperty(navigators, scanner);
                    break;
                case 4:
                    GPSNavigator.removeObjectFromArray(navigators, scanner);
                    break;
                case 5:
                    GPSNavigator.calculateDevicesCount(navigators);
                    break;
                case 6:
                    int totalSum = GPSNavigator.calculateTotalSum();
                    System.out.println("Общая сумма: " + totalSum);
                    break;
                case 7:
                    System.out.println("Введите производителя:");
                    String manufacturer = scanner.next();
                    int sumByManufacturer = GPSNavigator.calculateSumByManufacturer(manufacturer);
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
}
