package ru.sberbank.edu;
import java.io.*;

/**
 * Записываем локально в файл
 *
 */
public class StorageFileLocal implements Storage {
    @Override
    public void save(String data){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("res_file.txt"))){
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Сохранили локально " + data);
    }
}
