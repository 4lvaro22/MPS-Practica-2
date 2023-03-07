package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        first = new DequeNode<>(value, null, first);
    }

    @Override
    public void append(T value) {
        last = new DequeNode<>(value, last, null);
    }

    @Override
    public void deleteFirst() {
        DequeNode<T> next = first.getNext();
        first.setItem(null);
        first.setNext(null);
        first.setPrevious(null);
        first = next;
        first.setPrevious(null);
    }

    @Override
    public void deleteLast() {
        DequeNode<T> previous = last.getPrevious();
        previous.setNext(null);
        last.setItem(null);
        last.setPrevious(null);
        last.setNext(null);
        last=previous;
    }

    @Override
    public T first() {
        return first.getItem();
    }

    @Override
    public T last() {
        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }
}
