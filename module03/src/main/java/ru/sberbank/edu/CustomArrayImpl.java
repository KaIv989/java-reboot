package ru.sberbank.edu;

import java.util.Collection;

/**
 *
 * @Реализовать класс CustomArrayImpl<T>, который представляет динамический массив
 * Класс CustomArrayImpl реализует интерфейс CustomArray
 * Класс CustomArrayImpl может хранить объекты любого типа
 * Класс CustomArrayImpl может динамически расширяться
 * Изучить внутреннюю реализацию ArrayList
 */
public class CustomArrayImpl<T> implements CustomArray {

    private int size = 0;
    private Object[] elementData;

    public CustomArrayImpl(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public CustomArrayImpl() {
        this.elementData = new Object[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object item) {
        try {
            if(getCapacity() - size() == 0){
                ensureCapacity(getCapacity() + 1);}
            elementData[size()] = item;
            size++;
            return true;
        }
        catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addAll(Object[] items) {
        try {
            if ((getCapacity() - size()) < items.length ) {
                ensureCapacity(getCapacity() + items.length);
            }
            Object[] temp = elementData;
            System.arraycopy(temp, 0, elementData, 0, temp.length);
            System.arraycopy(items, 0, elementData, size(), items.length);
            size += items.length;
            return true;
        }
        catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addAll(Collection items) {
        Object[] arrayItem = items.toArray();
        return addAll(arrayItem);
    }

    @Override
    public boolean addAll(int index, Object[] items) {
        try {
            if ((getCapacity() - size()) < items.length ) {
                ensureCapacity(getCapacity() + items.length);
            }
            Object[] temp = new Object[size()];
            System.arraycopy(elementData, 0, temp, 0, size());
            System.arraycopy(temp, 0, elementData, 0, index);
            System.arraycopy(items, 0, elementData, index, items.length);
            System.arraycopy(temp, index, elementData, index + items.length, size() - index);
            size += items.length;
            return true;
        }
        catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public Object set(int index, Object item) {
        return elementData[index] = item;
    }

    @Override
    public void remove(int index) {
        try {
            Object[] temp = elementData;
            elementData = new Object[temp.length];
            System.arraycopy(temp, 0, elementData, 0, index);
            System.arraycopy(temp, index + 1, elementData, index, temp.length - index - 1);
            size--;
        }
        catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean remove(Object item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
            return true;
        } else
            return false;
    }

    @Override
    public boolean contains(Object item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Object item) {
        int index = -1;
            for (int i = 0; i <= elementData.length - 1;) {
                if(elementData[i] == null || elementData[i].equals(item)) {
                    index = i;
                    break;
                }
                i++;
            }
        return index;
    }

    @Override
    public void ensureCapacity(int newElementsCount) {
        Object[] temp = elementData;
        elementData = new Object[newElementsCount];
        System.arraycopy(temp, 0, elementData, 0, temp.length);
    }

    @Override
    public int getCapacity() {
        return elementData.length;
    }

    @Override
    public void reverse() {
        try {
            Object[] temp = toArray();
            elementData = new Object[temp.length];
            int j = 0;
            for (int i = temp.length - 1; i >= 0; i--) {
                elementData[j] = temp[i];
                j++;
            }
        }
        catch (ClassCastException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Object[] toArray() {
        Object[] val = new Object[size()];
        for (int i = 0; i < size(); i++) {
            val[i]= elementData[i];
        }
        return val;
    }
}