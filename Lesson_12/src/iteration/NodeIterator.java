package iteration;

import java.util.Iterator;

public class NodeIterator implements Iterator<Node> {

    private Node current;

    public NodeIterator(Node current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return (current != null);
    }

    @Override
    public Node next() {
        if (current == null) return null;

        Node retVal = current;

        current = current.getNext();

        return retVal;
    }
}
