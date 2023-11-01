package ru.sberbank.edu;

/**
 * Записываем в БД
 *
 */
public class StorageFileDb implements Storage {
    @Override
    public void save(String data) {
        System.out.println("Сохранили в DB " + data);
    }
}
