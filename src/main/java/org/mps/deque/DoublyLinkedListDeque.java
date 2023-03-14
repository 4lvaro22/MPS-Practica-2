package org.mps.deque;

import java.util.Comparator;

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

    private DequeNode<T> getNode(int index){
        DequeNode<T> selectedNode = first;
        T indexValue = null;
        int i = 0;
        if(index <= (this.size() / 2)){
            while (i <= (this.size() / 2) && indexValue == null){
                if(i == index){
                    indexValue = selectedNode.getItem();
                }
                i ++;
                selectedNode = selectedNode.getNext();
            }
        }else{
            i = this.size() - 1;
            while (i > (this.size() / 2) && indexValue == null){
                if(i == index){
                    indexValue = selectedNode.getItem();
                }
                i --;
                selectedNode = selectedNode.getPrevious();
            }
        }

        return selectedNode;
    }

    @Override
    public T get(int index) {
        return this.getNode(index).getItem();
    }

    @Override
    public boolean contains(T value) {
        DequeNode<T> current = first;

        while(current != null){
            if(current.getItem() == value){
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    @Override
    public void remove(T value) {
        DequeNode<T> current = first;
        DequeNode<T> previous = null;
        DequeNode<T> next = null;
        
        while(current != null){
            if(current.getItem() == value){
                previous.setNext(current.getNext());
                next.setPrevious(current.getPrevious());
                current = null;
            }

            previous = current.getPrevious();
            next = current.getNext();
            current = current.getNext();
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        int n = this.size();
        for (int i = 1; i < n; ++i) {
            T key = this.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(this.get(j), key) > 0) {
                this.getNode(j+1).setItem(this.get(j));
                j = j - 1;
            }
            this.getNode(j+1).setItem(key);
        }
    }
}
