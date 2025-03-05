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

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }


    @Override
    public String toString() {
        Node<T> current = head;  // null

        StringBuilder sb = new StringBuilder();
        sb.append("\n[");

        while (current != null) {
            sb.append(current.getData() + ", ");
            current = current.getNext();
        }
        sb.append("]");

        return "MyLinkedList" +
                "\n{" +
                "size=" + size +
                sb +
                "\n}";
    }
}
