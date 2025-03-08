package iteration;

import java.util.Iterator;

public class Node<T> implements Iterable<T> {

    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }


    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter<>(this);
    }


    private class Iter<T> implements Iterator<T> {
        private Node<T> current;

        public Iter(Node<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public T next() {
            if (current == null) return null;

            Node<T> retVal = current;

            current = current.getNext();

            return retVal.data;
        }

        @Override
        public void remove() {
            current = current.getNext();
        }
    }

}
