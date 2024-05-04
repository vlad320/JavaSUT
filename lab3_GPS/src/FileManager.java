import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {


    public static void saveToFile(ArrayList<GPSNavigator> navigators, Scanner scanner) {
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
    public static void readFromFile(ArrayList<GPSNavigator> navigators, Scanner scanner) {
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
    public static boolean isDuplicateNavigator(GPSNavigator navigator, ArrayList<GPSNavigator> navigators) {
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
    public static GPSNavigator parseLineToNavigator(String line) {
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
}
