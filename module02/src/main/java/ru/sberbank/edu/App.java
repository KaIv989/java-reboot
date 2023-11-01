package ru.sberbank.edu;

/**
 * Программа, которая принимает на вход файл, содержащий некую инфомацию на нескольких строках.
 * Собирает статистику: сколько строк, какая строка самая длинная, сколько всего пробелов.
 * Результат записывает в другой файл.
 * Может сохоранять в бд или в файл.
 */
public class App
{
    public static void main( String[] args )
    {

        ProcessingData file = new ProcessingData();
        file.fileStatistics(new StorageFileLocal());
        file.fileStatistics(new StorageFileDb());

    }
}
