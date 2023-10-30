import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class SequentialSearch {
    public static void main(String[] args) {
        try {
            // Чтение входного файла
            List<Integer> numbers = new ArrayList<>();
            Path pathInput = Paths.get("C:\\Java projects\\DM_1_Task\\src\\inputSequential.txt");
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
                comparisons += sequentialSearch(numbers, i);
            }

            // Вычисление среднего числа сравнений
            double averageComparisons = (double) comparisons / numbers.size();

            // Запись результата в выходной файл
            FileWriter writer = new FileWriter("C:\\Java projects\\DM_1_Task\\src\\outputSequential.txt");
            writer.write(String.valueOf(averageComparisons));
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Функция последовательного поиска
    public static int sequentialSearch(List<Integer> numbers, int target) {
        int comparisons = 0;
        for (int num : numbers) {
            comparisons++;
            if (num == target) {
                return comparisons;
            }
        }
        return comparisons;
    }
}
