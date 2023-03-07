package org.mps.deque;

/**
 * Class representing a node of a double-ended queue (deque). Each node has references to
 * the next and previous nodes.
 * The previous and next of the first and last node of the deque is {@code null}.
 *
 * @param <T> the type of elements held in the deque.
 */
class DequeNode<T> {
    private T item;
    private DequeNode<T> previous;
    private DequeNode<T> next;

    DequeNode(T item, DequeNode<T> previous, DequeNode<T> next) {
        this.item = item;
        this.previous = previous;
        this.next = next;
    }

    T getItem() {
        return item;
    }

    void setItem(T item) {
        this.item = item;
    }

    DequeNode<T> getPrevious() {
        return previous;
    }

    void setPrevious(DequeNode<T> previous) {
        this.previous = previous;
    }

    DequeNode<T> getNext() {
        return next;
    }

    void setNext(DequeNode<T> next) {
        this.next = next;
    }

    boolean isFirstNode() {
        return previous == null;
    }

    boolean isLastNode() {
        return next == null;
    }

    boolean isNotATerminalNode() {
        return !(isFirstNode() || isLastNode());
    }
}
