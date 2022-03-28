package io.github.structure;

import java.util.Arrays;
import java.util.Collection;

public class ArrayList<E>{
    
    transient int modCount = 0;
    transient Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException(
                    "Illegal capacity " + initialCapacity);
        }
    }
    
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= elementData.length) {
            elementData = Arrays.copyOf(elementData,
                    minCapacity + ((minCapacity >> 1) != 0 ? (minCapacity >> 1) : 1));
            //if the initial capacity equal to one (size >> 1 == 0) add one manually
        }
    }
    
    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("Illegal index " + index);
        }
    }
    
    public boolean add(E object) {
        ensureCapacity((size + 1));
        elementData[size++] = object;
        return true;
    }
    
    public boolean add(int index, E object) {
        rangeCheck(index);
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData,index + 1, size - index);
        elementData[index] = object;
        size++;
        return true;
    }
    
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacity(size + numNew);
        System.arraycopy(a,0, elementData, size,numNew);
        size += numNew;
        return numNew != 0;
    }
    
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }
    
    public void set(int index, E object) {
        elementData[index] = object;
    }
    
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;     //clear to let GC do its work
        return oldValue;
    }

    public void trimToSize() {
        if (size < elementData.length) {
            elementData = (size == 0) 
                    ? EMPTY_ELEMENTDATA 
                    : Arrays.copyOf(elementData,size);
        }
    }
    
    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) 
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(elementData[i])) 
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList testArray = new ArrayList(0);
        testArray.add(1);
        testArray.add(2);
        testArray.add(3);
//        testArray.add(2,6);
//        testArray.set(0, 9);
        testArray.remove(2);
//        testArray.addAll("1);
        for (int i = 0; i < testArray.size; i ++) System.out.println(testArray.get(i));
    }
}
