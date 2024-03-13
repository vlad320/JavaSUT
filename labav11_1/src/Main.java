import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод 2 массивов
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new LinkedList<>();

        System.out.println("Введите 6 компонентов для первого массива:");
        for (int i = 0; i < 6; i++) {
            arr1.add(scanner.nextInt());
        }

        System.out.println("Введите 5 компонентов для второго массива:");
        for (int i = 0; i < 5; i++) {
            arr2.add(scanner.nextInt());
        }

        // Возвести компоненты каждого массива в квадрат
        List<Integer> squaredArr1 = squareElements(arr1);
        List<Integer> squaredArr2 = squareElements(arr2);

        // Найти минимальное значение в каждом массиве
        int min1 = findMinElement(squaredArr1);
        int min2 = findMinElement(squaredArr2);

        System.out.println("Минимальный элемент в первом массиве: " + min1);
        System.out.println("Минимальный элемент во втором массиве: " + min2);
    }

    // Метод для возведения компонентов массива в квадрат
    public static List<Integer> squareElements(List<Integer> arr) {
        List<Integer> squaredArr = new ArrayList<>();
        for (Integer element : arr) {
            squaredArr.add(element * element);
        }
        return squaredArr;
    }

    // Метод для поиска минимального элемента в массиве
    public static int findMinElement(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            throw new IllegalArgumentException("The input list cannot be null or empty.");
        }

        int min = arr.getFirst();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        return min;
    }
}