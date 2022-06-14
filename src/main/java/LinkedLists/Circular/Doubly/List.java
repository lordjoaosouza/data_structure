package LinkedLists.Circular.Doubly;

public class List<Type extends Comparable<Type>> {

    private Node<Type> head;
    private Node<Type> tail;
    private int size;

    public boolean isEmpty() {
        return this.head == null && this.tail == null && this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public Node<Type> search(Node<Type> searched) {
        if (!this.isEmpty()) {
            Node<Type> curr = this.head;
            do {
                if (curr.getInfo().equals(searched.getInfo())) {
                    return curr;
                }

                curr = curr.getNext();
            } while (curr != this.head);
        }

        return null;
    }

    public void insert(Node<Type> newNode) {
        Node<Type> found = search(newNode);
        if (found == null) {
            if (this.isEmpty()) {
                this.head = newNode;
                this.tail = newNode;
            } else if (newNode.compareTo(this.head) < 0) {
                newNode.setNext(this.head);
                this.head.setPrev(newNode);
                this.head = newNode;
            } else if (newNode.compareTo(this.tail) > 0) {
                newNode.setPrev(this.tail);
                this.tail.setNext(newNode);
                this.tail = newNode;
            } else {
                Node<Type> greater = this.head;
                do {
                    if (greater.compareTo(newNode) > 0) {
                        break;
                    }

                    greater = greater.getNext();
                } while (greater != this.head);

                Node<Type> prev = greater.getPrev();
                newNode.setPrev(prev);
                newNode.setNext(greater);
                prev.setNext(newNode);
                greater.setPrev(newNode);
            }

            this.head.setPrev(this.tail);
            this.tail.setNext(this.head);
            this.size++;

            System.out.println("Successfully inserted.");
        } else {
            System.out.println("Could not insert, already inserted.");
        }
    }

    public void remove(Node<Type> node) {
        if (!this.isEmpty()) {
            Node<Type> found = search(node);
            if (found != null) {
                if (this.size == 1) {
                    this.head = null;
                    this.tail = null;
                } else {
                    if (found == this.head) {
                        this.head = this.head.getNext();
                    } else if (found == this.tail) {
                        this.tail = this.tail.getPrev();
                    } else {
                        Node<Type> prev = found.getPrev();
                        Node<Type> next = found.getNext();
                        prev.setNext(next);
                        next.setPrev(prev);
                    }

                    this.head.setPrev(this.tail);
                    this.tail.setNext(this.head);
                }

                this.size--;

                System.out.println("Successfully removed.");
            } else {
                System.out.println("Could not remove, not found.");
            }
        } else {
            System.out.println("Could not remove, empty list.");
        }
    }
}
