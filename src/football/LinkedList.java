package football;

import java.util.*;

public class LinkedList<E> implements List{
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
        return (E) result.data;
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

    public boolean add(Object value){
        ListNode<E> current = back.prev;
        current.next = new ListNode<>();
        current.next.data = value;
        current.next.next = back;
        current.next.prev = current;
        back.prev = current.next;
        size++;
        return true;
    }

    public void add(int index, Object value){
        ListNode<E> current = nodeAt(index - 1);
        ListNode<E> after = current.next;
        current.next = new ListNode<>();
        current.next.data = value;
        current.next.next = after;
        current.next.prev = current;
        back.prev = current.next;
        size++;
    }

    public void addAll(List<E> other) {
        for (E obj : other) {
            add(obj);
        }
    }

    public E remove(int index) {
        ListNode<E> current = nodeAt(index - 1);
        current.next = current.next.next;
        current.next.prev = current;
        size--;
        return (E) current;
    }

    public E set(int index, Object value) {
        ListNode<E> current = nodeAt(index);
        current.data = (E) value;
        return (E) current;
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

    public Iterator iterator() {
        return new LinkedIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }
    @Override
    public ListIterator listIterator() {
        return null;
    }
    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
    @Override
    public boolean retainAll(Collection c) {
        return false;
    }
    @Override
    public boolean removeAll(Collection c) {
        return false;
    }
    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }
    @Override
    public boolean addAll(Collection c) {
        return false;
    }
    @Override
    public boolean containsAll(Collection c) {
        return false;
    }
    @Override
    public boolean remove(Object o) {
        return false;
    }
    @Override
    public Object[] toArray() {
        return new Object[0];
    }
    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

}
