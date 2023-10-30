package SortTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class InsertionSort {
    public static void main(String[] args) {
        try {
            // Чтение входного файла
            List<Integer> numbers = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            while (line != null) {
                numbers.add(Integer.parseInt(line));
                line = reader.readLine();
            }
            reader.close();

            // Вызов функции сортировки вставками
            int comparisons = insertionSort(numbers);

            // Запись отсортированного массива в выходной файл
            FileWriter writer = new FileWriter("output.txt");
            for (int num : numbers) {
                writer.write(String.valueOf(num));
                writer.write("\n");
            }
            // Запись числа сравнений во вторую строку выходного файла
            writer.write(String.valueOf(comparisons));
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Функция сортировки вставками
    public static int insertionSort(List<Integer> numbers) {
        int comparisons = 0;
        int n = numbers.size();
        for (int i = 1; i < n; i++) {
            int key = numbers.get(i);
            int j = i - 1;
            while (j >= 0 && numbers.get(j) > key) {
                numbers.set(j + 1, numbers.get(j));
                j--;
                comparisons++;
            }
            numbers.set(j + 1, key);
        }
        return comparisons;
    }
}
