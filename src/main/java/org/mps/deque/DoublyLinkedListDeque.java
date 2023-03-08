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

        if(size == 0){
            last = first;
        }

        size++;
    }

    @Override
    public void append(T value) {
        last = new DequeNode<>(value, last, null);

        if(size == 0){
            first = last;
        }

        size++;
    }

    @Override
    public void deleteFirst() {
        DequeNode<T> newFirst = first;

        if(size == 1){
            first.setItem(null);
        }else {
            /*
            newFirst = first.getNext();
            first.setItem(null);
            first.setNext(null);
            first.setPrevious(null);
            first = next;
            first.setPrevious(null);
            */
        }

        size--;
    }

    @Override
    public void deleteLast() {
        DequeNode<T> newLast = last;

        if(size == 1){
            last.setItem(null);
        }else{
            /*
            previous.setNext(null);
            last.setItem(null);
            last.setPrevious(null);
            last.setNext(null);
            last=previous;
            */
        }

        size--;
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
