package collections;

public class MyLinkedList<T> {

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node<T> current = tail;

            tail.setNext(newNode);

            newNode.setPrevious(current);

            tail = newNode;
        }

        size++;
    }


    @Override
    public String toString() {
        Node<T> current = tail;
        if (current.getNext() != null) {
            System.out.println("Current node is: " + current);
            current = current.getNext();
        }

        return "MyLinkedList{" +
                "size=" + size +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
