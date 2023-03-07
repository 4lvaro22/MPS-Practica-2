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
        // TODO
    }

    @Override
    public T first() {
        // TODO
        return null;
    }

    @Override
    public T last() {
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }
}
