package ru.sberbank.edu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *Тест результата подсчета данных
 * в файле.
 */

public class FileLocalTest {
    @Test
    public void result() {
        ProcessingData file = new ProcessingData();
        String local = file.fileStatistics(new StorageFileLocal());
        String ExpectedResult = ("Результат: Всего строк = 10" + "\n" + "самая длинная строка под номером: 5" + "\n" + "всего пробелов = 27" + "\n");
        assertEquals(ExpectedResult, local);
    }
}
