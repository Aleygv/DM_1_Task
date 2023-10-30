import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class InterpolationSearch {
    public static void main(String[] args) {
        try {
            // Чтение входного файла
            List<Integer> numbers = new ArrayList<>();
            Path pathInput = Paths.get("C:\\Java projects\\DM_1_Task\\src\\inputInterpolation.txt");
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
                comparisons += interpolationSearch(numbers, i);
            }

            // Вычисление среднего числа сравнений
            double averageComparisons = (double) comparisons / numbers.size();

            // Запись результата в выходной файл
            FileWriter writer = new FileWriter("C:\\Java projects\\DM_1_Task\\src\\outputInterpolation.txt");
            writer.write(String.valueOf(averageComparisons));
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Функция интерполяционного поиска
    public static int interpolationSearch(List<Integer> numbers, int target) {
        int comparisons = 0;
        int low = 0;
        int high = numbers.size() - 1;
        while (low <= high && target >= numbers.get(low) && target <= numbers.get(high)) {
            comparisons++;
            if (low == high) {
                if (numbers.get(low) == target) {
                    return comparisons;
                }
                return comparisons;
            }

            // Расчет позиции для интерполяции
            int pos = low + ((target - numbers.get(low)) * (high - low)) / (numbers.get(high) - numbers.get(low));

            // Проверка найденного элемента
            if (numbers.get(pos) == target) {
                return comparisons;
            } else if (numbers.get(pos) < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return comparisons;
    }
}