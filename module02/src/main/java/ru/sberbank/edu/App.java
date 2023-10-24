package ru.sberbank.edu;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ProcessingData file = new ProcessingData();
        file.fileStatistics(new StorageFileLocal());
        System.out.println( "Hello World!" );
    }
}
