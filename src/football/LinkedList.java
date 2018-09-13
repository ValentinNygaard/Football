package football;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList<E> {
    private ListNode<E> front;
    private ListNode<E> back;
    private int size;

    public LinkedList() {
        front = new ListNode<E>();
        back = new ListNode<E>();
        clear();
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        ListNode<E> result = nodeAt(index);
        return (E) result;
    }

    public int indexOf(Object value) {
        int index = 0;
        ListNode<E> current = front.next;
        while (current != back) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(Object value) {
        if (indexOf(value) != -1) {
            return true;
        }
        return false;
    }
/*
    public void add(E object){
        ListNode<E> current;
        current = back.prev;
        current.next = new ListNode<>(object,back,back.prev);
        back = current;
        size++;
    }
*/
    public void add(int index, E object){
        int test;

    }
/*
    public void addAll(List<E> other) {
        for (E obj : other) {
            add(obj);
        }

    }
*/
    public void remove(int index) {
        //checkIndex(index);
        ListNode<E> current = nodeAt(index - 1);
        current.next = current.next.next;
        current.next.prev = current;
        size--;
    }

    public void set(int index, E value) {
        int test;

    }

    public void clear() {
        front.next = back;
        back.prev = front;
        size = 0;
    }


    private ListNode<E> nodeAt(int index) {
        ListNode<E> current;
        if (index < size / 2) {
            current = front;
            for (int i = 0; i < index + 1; i++) {
                current = current.next;
            }
        } else {
            current = back;
            for (int i = size; i >= index + 1; i--) {
                current = current.prev;
            }
        }
        return current;
    }



    private class LinkedIterator implements Iterator<E> {

        private ListNode<E> current;
        private boolean removeOK;

        public LinkedIterator() {
            current = front.next;
            removeOK = false;
        }
        public boolean hasNext() {
            return current != back;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.data;
            current = current.next;
            removeOK = true;
            return result;
        }

        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ListNode<E> prev2 = current.prev.prev;
            prev2.next = prev2;
            size--;
            removeOK = false;

        }
    }


}
