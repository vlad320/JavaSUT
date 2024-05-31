

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NavigatorRunner {
    public static void main(String[] args) {
        List<Navigator> navigators = new ArrayList<>();
        Scanner dataEntry = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            printMenu();

            int choice = dataEntry.nextInt();

            switch (choice) {
                case 1:
                    addGPSNavigator(navigators, dataEntry);
                    break;
                case 2:
                    addCarNavigator(navigators, dataEntry);
                    break;
                case 3:
                    printNavigators(navigators);
                    break;
                case 4:
                    navigateToByName(navigators, dataEntry);
                    break;
                case 5:
                    getCurrentLocationByName(navigators, dataEntry);
                case 6:
                    updateNavigatorByName(navigators, dataEntry);
                case 7:
                    printRouteHistoryByName(navigators, dataEntry);
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор");
            }
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("1. Добавить GPS-навигатор");
        System.out.println("2. Добавить автомобильный навигатор");
        System.out.println("3. Отобразить все навигаторы");
        System.out.println("4. Проложить маршрут по названию модели");
        System.out.println("5. Получить текущее местоположение по названию модели");
        System.out.println("6. Изменить навигатор по названию модели");
        System.out.println("7. Показать историю маршрутов по названию модели");
        System.out.println("8. Выход из программы");
        System.out.print("Выберите действие: ");
        System.out.flush();
    }

    public static void addGPSNavigator(List<Navigator> navigators, Scanner dataEntry) {
        System.out.print("Введите бренд GPS-навигатора: ");
        String brand = dataEntry.next();
        System.out.print("Введите модель GPS-навигатора: ");
        String nameModel = dataEntry.next();
        System.out.print("Введите начальную точку: ");
        String startPoint = dataEntry.next();
        navigators.add(new GPSNavigator(brand, nameModel, startPoint));
        System.out.println("GPS-навигатор добавлен");
    }

    public static void addCarNavigator(List<Navigator> navigators, Scanner dataEntry) {
        System.out.print("Введите бренд автомобильного навигатора: ");
        String brand = dataEntry.next();
        System.out.print("Введите модель автомобильного навигатора: ");
        String nameModel = dataEntry.next();
        System.out.print("Введите начальную точку: ");
        String startPoint = dataEntry.next();
        navigators.add(new CarNavigator(brand, nameModel, startPoint));
        System.out.println("Автомобильный навигатор добавлен");
    }

    public static void printNavigators(List<Navigator> navigators) {
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("| %3s | %-20s | %-20s | %-20s | %-24s |\n", "№", "Тип навигатора", "Бренд", "Модель", "Текущая точка назначения");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        int count = 1;
        for (Navigator navigator : navigators) {
            String navigatorType = navigator.getClass().getSimpleName();
            System.out.printf("| %3s | %-20s | %-20s | %-20s | %-24s |\n", count, navigatorType, navigator.getBrand(), navigator.getNameModel(), navigator.getCurrentDestination());
            count++;
        }
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }

    public static void navigateToByName(List<Navigator> navigators, Scanner dataEntry) {
        System.out.print("Введите название модели навигатора: ");
        String nameModel = dataEntry.next();
        System.out.print("Введите пункт назначения: ");
        String destination = dataEntry.next();

        for (Navigator navigator : navigators) {
            if (navigator.getNameModel().equalsIgnoreCase(nameModel)) {
                navigator.navigateTo(destination);
                return;
            }
        }

        System.out.println("Навигатор с моделью " + nameModel + " не найден.");
    }
    public static void getCurrentLocationByName(List<Navigator> navigators, Scanner dataEntry) {
        System.out.print("Введите название модели навигатора: ");
        String nameModel = dataEntry.next();

        for (Navigator navigator : navigators) {
            if (navigator.getNameModel().equalsIgnoreCase(nameModel)) {
                System.out.println(navigator.getCurrentLocation());
                return;
            }
        }

        System.out.println("Навигатор с моделью " + nameModel + " не найден.");
    }
    public static void updateNavigatorByName(List<Navigator> navigators, Scanner dataEntry) {
        System.out.print("Введите название модели навигатора для изменения: ");
        String nameModel = dataEntry.next();

        for (int i = 0; i < navigators.size(); i++) {
            Navigator navigator = navigators.get(i);
            if (navigator.getNameModel().equalsIgnoreCase(nameModel)) {
                System.out.print("Введите новый бренд: ");
                String newBrand = dataEntry.next();
                System.out.print("Введите новую модель: ");
                String newNameModel = dataEntry.next();
                System.out.print("Введите новую текущую точку назначения: ");
                String newDestination = dataEntry.next();

                if (navigator instanceof GPSNavigator) {
                    navigators.set(i, new GPSNavigator(newBrand, newNameModel, newDestination));
                } else if (navigator instanceof CarNavigator) {
                    navigators.set(i, new CarNavigator(newBrand, newNameModel, newDestination));
                }

                System.out.println("Навигатор изменен");
                return;
            }
        }

        System.out.println("Навигатор с моделью " + nameModel + " не найден.");
    }
    public static void printRouteHistoryByName(List<Navigator> navigators, Scanner dataEntry) {
        System.out.print("Введите название модели навигатора: ");
        String nameModel = dataEntry.next();

        for (Navigator navigator : navigators) {
            if (navigator.getNameModel().equalsIgnoreCase(nameModel)) {
                List<String> routeHistory = navigator.getRouteHistory();
                System.out.println("История маршрутов для модели " + nameModel + ":");
                for (String destination : routeHistory) {
                    System.out.println("- " + destination);
                }
                return;
            }
        }

        System.out.println("Навигатор с моделью " + nameModel + " не найден.");
    }
}
