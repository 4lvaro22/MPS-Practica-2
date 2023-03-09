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
        if(value == null){
            throw new DoubleEndedQueueException("No se puede asignar a un nodo un elemento que sea nulo");
        }

        DequeNode<T> aux = new DequeNode<>(value, null, first);

        if (first != null) {
            first.setPrevious(aux);
        }

        first = aux;

        if(this.size() == 0){
            last = first;
        }

        size++;
    }

    @Override
    public void append(T value) {
        if(value == null){
            throw new DoubleEndedQueueException("No se puede asignar a un nodo un elemento que sea nulo");
        }

        DequeNode<T> aux = new DequeNode<>(value, last, null);

        if (last != null) {
            last.setNext(aux);
        }

        last = aux;

        if(this.size() == 0){
            first = last;
        }

        size++;
    }

    @Override
    public void deleteFirst() {
        if(this.size() == 0){
            throw new DoubleEndedQueueException("No existen elementos para borrar de la lista");
        }
        DequeNode<T> newFirst = first.getNext();

        first.setNext(null);
        first.setPrevious(null);
        first.setItem(null);

        if(size == 1){
            first = null;
            last = null;
        }else{
            newFirst.setPrevious(null);
            first = newFirst;
        }

        size--;
    }

    @Override
    public void deleteLast() {
        if(size == 0){
            throw new DoubleEndedQueueException("No existen elementos para borrar de la lista");
        }
        DequeNode<T> newLast = last.getPrevious();

        last.setNext(null);
        last.setPrevious(null);
        last.setItem(null);

        if(this.size() == 1){
            first = null;
            last = null;
        }else{
            newLast.setPrevious(null);
            last = newLast;
        }

        size--;
    }

    @Override
    public T first() {
        if(this.size() == 0){
            throw new DoubleEndedQueueException("No existe un nodo en la lista para obtener el elemento");
        }
        return first.getItem();
    }

    @Override
    public T last() {
        if(this.size() == 0){
            throw new DoubleEndedQueueException("No existe un nodo en la lista para obtener el elemento");
        }
        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }
}
