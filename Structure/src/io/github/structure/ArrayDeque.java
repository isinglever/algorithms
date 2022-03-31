package io.github.structure;

public class ArrayDeque<E> {
    transient Object[] elements;
    transient int head;
    transient int tail;
    
    public ArrayDeque() {
        elements = new Object[16];
    }
    
    private void doubleCapacity() {
        int p = head;
        int n = elements.length;
        int r = n - p;
        int newCapacuity = n << 1;
        if (newCapacuity < 0) {
            throw new IllegalStateException("Deque is too big");
        }
        Object[] a  = new Object[newCapacuity];
        System.arraycopy(elements, p, a, 0, r);
        System.arraycopy(elements, 0, a, r, p);
        elements = a;
        head = 0;
        tail = n;
    }
    
    public void addFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        elements[head = (head - 1) & (elements.length - 1)] = e;
        if (head == tail) {
            doubleCapacity();
        }
    }
    
    public void addLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        elements[tail] = e;
        if ((tail = (tail + 1) & (elements.length - 1)) == head) {
            doubleCapacity();
        }
    }
    
    public E pollFirst() {
        int h = head;
        E result = (E) elements[h];
        if (result == null) {
            return null;
        }
        elements[h] = null;
        head = (head + 1) & (elements.length - 1);
        return result;
    }
    
    public E pollLast() {
        int t = (tail - 1) & (elements.length - 1);
        E result = (E) elements[t];
        if (result == null) {
            return null;
        }
        elements[t] = null;
        tail = t;
        return result;
    }
}
