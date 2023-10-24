package ru.sberbank.edu;

/**
 * Hello world!
 *
 */
public class StorageFileDb implements Storage {
    @Override
    public void save(String data) {
        System.out.println("DB " + data);
    }
}
