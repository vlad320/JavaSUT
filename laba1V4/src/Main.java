import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод 2 массивов
        int[] arr1 = new int[6];
        int[] arr2 = new int[5];

        System.out.println("Введите 6 компонентов для первого массива:");
        for (int i = 0; i < 6; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.println("Введите 5 компонентов для второго массива:");
        for (int i = 0; i < 5; i++) {
            arr2[i] = scanner.nextInt();
        }

        // Возвести компоненты каждого массива в квадрат
        int[] squaredArr1 = squareElements(arr1);
        int[] squaredArr2 = squareElements(arr2);

        // Найти минимальное значение в каждом массиве
        int min1 = findMinElement(squaredArr1);
        int min2 = findMinElement(squaredArr2);

        System.out.println("Минимальный элемент в первом массиве: " + min1);
        System.out.println("Минимальный элемент во втором массиве: " + min2);
    }

    // Метод для возведения компонентов массива в квадрат
    public static int[] squareElements(int[] arr) {
        int[] squaredArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            squaredArr[i] = arr[i] * arr[i];
        }
        return squaredArr;
    }

    // Метод для поиска минимального элемента в массиве
    public static int findMinElement(int[] arr) {
        int min = arr.getFirst();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        return min;
    }
}
