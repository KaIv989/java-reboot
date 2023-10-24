package ru.sberbank.edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessingData {
    public void fileStatistics(Storage storage) {
        int countLine = 0;
        int longest = 0;
        int countSpaces = 0;

        String longestLine = "";
        String resCountLine = "";
        String resCountSpaces = "";

        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("my_file.txt"))) {
            while ((line = reader.readLine()) != null) {
                countLine++;
                if (line.length() > longest) {
                    longest = line.length();
                    longestLine = "самая длинная строка под номером: " + countLine;
                }
                countSpaces += line.length() - line.replaceAll(" ", "").length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        resCountLine = "Всего строк = " + countLine;

        resCountSpaces = "всего пробелов = " + countSpaces;
        storage.save("Результат: " + resCountLine + "\n" + longestLine + "\n" + resCountSpaces + "\n");
    }
}
