package org.mps.deque;

import java.util.Comparator;

/**
 * A double-ended queue or deque is a linear collection that supports element
 * insertion, retrieval and removal at both ends.
 *
 * @param <T> the type of elements held in this deque
 */
public interface DoubleEndedQueue<T> {
    // Basic operations

    /**
     * Inserts the specified element at the front of this deque.
     *
     * @param value the value to be inserted
     */
    void prepend(T value);

    /**
     * Inserts the specified element at the end of this deque.
     *
     * @param value the value to be inserted
     */
    void append(T value);


    /**
     * Deletes the first element of this deque.
     *
     * @throws DoubleEndedQueueException if the deque is empty
     */
    void deleteFirst();

    /**
     * Deletes the last element of this deque.
     *
     * @throws DoubleEndedQueueException if the deque is empty
     */
    void deleteLast();

    /**
     * Returns the first element of this deque.
     *
     * @throws DoubleEndedQueueException if the deque is empty
     */
    T first();

    /**
     * Returns the last element of this deque.
     *
     * @throws DoubleEndedQueueException if the deque is empty
     */
    T last();

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
    int size();

    // Complex operations

    /**
     * Returns the element at the specified position in this deque.
     * Element at the front of the deque is at position 0.
     *
     * @param index of the element to return
     * @return the element at the specified position in this deque
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T get(int index);

    /**
     * Returns {@code true} if this deque contains the specified element.
     * <p>
     * More formally, returns {@code true} if and only if this deque contains at least one
     * element {@code e} such that {@code Objects.equals(e, value)}.
     *
     * @param value whose presence in this deque is to be tested
     * @return {@code true} if this deque contains the specified element
     */
    boolean contains(T value);

    /**
     * Removes the first occurrence of the specified element from this deque, if it is present.
     *
     * @param value to be removed from this deque, if present
     */
    void remove(T value);

    /**
     * Sorts this deque according to the order induced by the specified {@code Comparator}.
     *
     * <h3>Implementation Requirements:</h3>
     * The implementation must use an in-place sorting algorithm; i.e., it is not allowed to
     * allocate any new object on the heap.
     *
     * @param comparator the {@code Comparator} used to compare deque elements
     */
    void sort(Comparator<? super T> comparator);
}