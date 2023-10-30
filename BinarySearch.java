import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        try {
            // Чтение входного файла
            List<Integer> numbers = new ArrayList<>();
            Path pathInput = Paths.get("C:\\Java projects\\DM_1_Task\\src\\inputBinary.txt");
            BufferedReader reader = new BufferedReader(new FileReader(pathInput.toFile()));
            String line = reader.readLine();
            String[] words = line.split(" ");
            for (String word : words) {
                numbers.add(Integer.parseInt(word));
            }
            reader.close();

            // Вызов функции поиска для каждого элемента
            int comparisons = 0;
            for (int i = 1; i <= numbers.size(); i++) {
                comparisons += binarySearch(numbers, i);
            }

            // Вычисление среднего числа сравнений
            double averageComparisons = (double) comparisons / numbers.size();

            // Запись результата в выходной файл
            FileWriter writer = new FileWriter("C:\\Java projects\\DM_1_Task\\src\\outputBinary.txt");
            writer.write(String.valueOf(averageComparisons));
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Функция двоичного поиска
    public static int binarySearch(List<Integer> numbers, int target) {
        int comparisons = 0;
        int low = 0;
        int high = numbers.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (numbers.get(mid) == target) {
                return comparisons;
            } else if (numbers.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return comparisons;
    }
}