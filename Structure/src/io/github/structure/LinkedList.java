package io.github.structure;

import java.util.Collection;
import java.util.NoSuchElementException;

public class LinkedList<E> {
    
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }

    transient int size;
    transient Node<E> first;
    transient Node<E> last;
    
    public LinkedList() {
        
    }
    
    public LinkedList(Collection<? extends E> c) {
        this();
//        addAll()
    }
    
    E unlink(Node<E> e) {
        final E element = e.item;
        final Node<E> next = e.next;
        final Node<E> prev = e.prev;
        
        if (prev == null) {
            first = next;
        } else  {
            prev.next = next;
        }
        
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        
        e.item = null; 
        size--;
        
        return element;
    }
    
    Node<E> node(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index " + index);
        }
        
        Node<E> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }
    
    public E getFrist() {
        Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.item;
    }
    
    public E getLast() {
        Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.item;
    }
    
    public E removeLast() {
        Node<E> l = last;
        if (l == last) {
            throw new NoSuchElementException();
        }
        return unlink(l);
    }
    
    public E removeFirst() {
        Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return unlink(f);
    }
    
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        }
        if (o != null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item.equals(o)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
    
    public E remove(int index) {
        return unlink(node(index));
    }
    
//    public void addAll()
    
    public void add(int index, E element) {
        
    }
    
    public void addFirst(E e) {
        final Node<E> f = first;
        Node<E> x = new Node<>(null, e, f);
        first = x;
        if (f == null) {
            last = x;
        } else {
            f.prev = x;
        }
        size++;
    }
    
    public void addLast(E e) {
        final Node<E> l = last;
        Node<E> x = new Node<>(l, e, null);
        if (l == null) {
            first = x;
        } else {
            l.next = x;
        }
        size++;
    }
    
    public E get(int index) {
        return node(index).item;
    }
    
    public boolean offer(E e) {
        
    }
    
    public E peek() {
        
    }
    
    public E poll() {
        
    }
    
    public E pop() {
        
    }
    
    public void push(E e) {
        
    }
    
    public E remove() {
        
    }
    
}
