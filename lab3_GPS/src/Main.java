

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<GPSNavigator> navigators = new ArrayList<>();
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
                    float totalSum = calculateTotalSum();
                    System.out.println("Общая сумма: " + totalSum);
                    break;
                case 7:
                    System.out.println("Введите производителя:");
                    String manufacturer = scanner.next();
                    int sumByManufacturer = calculateSumByManufacturer(manufacturer);
                    System.out.println("Сумма по производителю " + manufacturer + ": " + sumByManufacturer);
                    break;
                case 8:
                    readFromFile(navigators, scanner);
                    break;
                case 9:
                    saveToFile(navigators, scanner);
                    break;
                case 10:
                    exitProgram();
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
    private static void saveToFile(ArrayList<GPSNavigator> navigators,Scanner scanner) {
        System.out.println("Введите имя файла для сохранения данных:");
        String filename = scanner.next();
        try {
            FileWriter writer = new FileWriter(filename);
            for (GPSNavigator navigator : navigators) {
                writer.write(navigator.getManufacturer() + "," + navigator.getModel() + "," + navigator.getPrice() + "\n");
            }
            writer.close();
            System.out.println("Данные успешно сохранены в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных в файл.");
        }
    }
    private static void readFromFile(ArrayList<GPSNavigator> navigators, Scanner scanner) {
        System.out.println("Введите имя файла:");
        String filename = scanner.next();
        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                GPSNavigator navigator = parseLineToNavigator(line);
              if (navigator != null && !isDuplicateNavigator(navigator, navigators)) {
                    navigators.add(navigator);
               }
            }
            System.out.println("Данные успешно загружены из файла.");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }

    // функция чтобы не дублировалось
    private static boolean isDuplicateNavigator(GPSNavigator navigator, ArrayList<GPSNavigator> navigators) {
        for (GPSNavigator existingNavigator : navigators) {
            if (existingNavigator.getManufacturer().equals(navigator.getManufacturer()) &&
                    existingNavigator.getModel().equals(navigator.getModel()) &&
                    existingNavigator.getPrice() == navigator.getPrice()) {
                System.out.println("Навигатор с такими же данными уже существует.");
                return true;
            }
        }
        return false;
    }
    private static GPSNavigator parseLineToNavigator(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            System.out.println("Неверный формат строки: " + line);
            return null;
        }

        try {
            String manufacturer = parts[0].trim();
            String model = parts[1].trim();
            float price = Float.parseFloat(parts[2].trim());
            return new GPSNavigator(manufacturer, model, price);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования числа в строке: " + line);
            return null;
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
        System.out.println("8. Считать с файла ");
        System.out.println("9. Сохранить в файлы");
        System.out.println("10. Выход из программы");
    }
    private static void createObject(ArrayList<GPSNavigator> navigators, Scanner scanner) {
        System.out.println("Введите производителя:");
        String manufacturer = scanner.next();
        System.out.println("Введите модель:");
        String model = scanner.next();
        System.out.println("Введите цену:");
        float price = scanner.nextFloat();

        if (price < 0) {
            System.out.println("Цена не может быть отрицательной.");
            return;
        }

        navigators.add(new GPSNavigator(manufacturer, model, price));
    }
    private static void displayProperties(ArrayList<GPSNavigator> navigators) {
        System.out.println("| ## | Производитель   | Модель          | Цена       |");
        for (int i = 0; i < navigators.size(); i++) {
            GPSNavigator navigator = navigators.get(i);
            System.out.printf("| %2d | %-15s | %-15s | %-10s |\n",
                    i + 1, navigator.getManufacturer(), navigator.getModel(), navigator.getPrice());
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
    public static float calculateTotalSum() {
        float totalSum = 0; // Объявление переменной
        for (GPSNavigator navigator : navigators) {
            totalSum += navigator.getPrice();
        }
        return totalSum;
    }
    public static int calculateSumByManufacturer(String manufacturer) {
        int sum = 0;
        for (GPSNavigator navigator : navigators) {
            if (navigator.getManufacturer().equals(manufacturer)) {
                sum += navigator.getPrice();
            }
        }
        return sum;
    }
    private static void exitProgram() {
        System.out.println("Программа завершена.");
        System.exit(0); // Завершить программу
    }
}