package SheikerSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ShakerSort {
    public static void main(String[] args) {
        String inputFile = "C:\\Java projects\\DM_1_Task\\src\\SortTask\\inputInsertionSort.txt";
        String outputFile = "C:\\Java projects\\DM_1_Task\\src\\SortTask\\outputInsertionSort.txt";

        try {
            // Чтение массива из файла
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            String[] numbers = line.split(" ");
            int[] array = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                array[i] = Integer.parseInt(numbers[i]);
            }
            reader.close();

            // Сортировка шейкерной сортировкой
            int comparisons = shakerSort(array);

            // Запись отсортированного массива и числа сравнений в файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            StringBuilder sortedArray = new StringBuilder();
            for (int num : array) {
                sortedArray.append(num).append(" ");
            }
            writer.write(sortedArray.toString().trim());
            writer.newLine();
            writer.write(String.valueOf(comparisons));
            writer.close();

            System.out.println("Сортировка выполнена успешно!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int shakerSort(int[] array) {
        int comparisons = 0;
        boolean swapped;
        int left = 0;
        int right = array.length - 1;

        do {
            swapped = false;

            // Проход слева направо
            for (int i = left; i < right; i++) {
                comparisons++;
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
            right--;

            // Проход справа налево
            for (int i = right; i > left; i--) {
                comparisons++;
                if (array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                    swapped = true;
                }
            }
            left++;

        } while (swapped);

        return comparisons;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}