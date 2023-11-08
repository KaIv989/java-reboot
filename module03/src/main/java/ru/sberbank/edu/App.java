package ru.sberbank.edu;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        CustomArrayImpl<String> arrayList = new CustomArrayImpl<>();
        System.out.println("getCapacity" + arrayList.getCapacity());
        arrayList.add(11);
        System.out.println("getCapacity" + arrayList.getCapacity());
        System.out.println(arrayList.size());
        arrayList.add(22);
        System.out.println("getCapacity" + arrayList.getCapacity());
        arrayList.add(33);

        arrayList.remove(1);
        System.out.println(arrayList.size());
        System.out.println("getCapacity" + arrayList.getCapacity());

        }
    }
