package io.github.structure;

import javax.xml.bind.Element;
import java.util.Arrays;

public class ArrayList<E>{
    
    transient int modCount = 0;
    transient Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayList(int initalCapacity) {
        if (initalCapacity > 0) {
            this.elementData = new Object[initalCapacity];
        } else if (initalCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal capacity " + initalCapacity);
        }
    }
    
    public void ensureCapacity(int minCapacity) {
        
    }
    
    public boolean add(E object) {
        elementData[size++] = object;
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, size + ((size >> 1) != 0 ? (size >> 1) : 1));
        }
        return true;
    }
    
    public boolean add(int index, E object) {
        return false;
    }


    public static void main(String[] args) {
        ArrayList testArray = new ArrayList(1);
        testArray.add(1);
        testArray.add(2);
        testArray.add(3);
        System.out.println(testArray.size);
    }
}
