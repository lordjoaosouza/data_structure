package LinkedLists.Circular.Singly;

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
                newNode.setNext(newNode);
                this.head = newNode;
                this.tail = newNode;
            } else if (newNode.compareTo(this.head) < 0) {
                Node<Type> next = this.head;
                this.head = newNode;
                this.head.setNext(next);
                this.tail.setNext(this.head);
            } else if (newNode.compareTo(this.tail) > 0) {
                this.tail.setNext(newNode);
                this.tail = newNode;
                this.tail.setNext(this.head);
            } else {
                Node<Type> greater = this.head;
                do {
                    if (greater.compareTo(newNode) > 0) {
                        break;
                    }

                    greater = greater.getNext();
                } while (greater != this.head);

                Node<Type> prev = this.head;
                do {
                    if (prev.getNext() == greater) {
                        break;
                    }

                    prev = prev.getNext();
                } while (prev != this.head);

                newNode.setNext(greater);
                prev.setNext(newNode);
            }

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
                        Node<Type> prev = this.head;
                        do {
                            if (prev.getNext() == this.tail) {
                                break;
                            }

                            prev = prev.getNext();
                        } while (prev != this.head);

                        this.tail = prev;
                    } else {
                        Node<Type> prev = this.head;
                        do {
                            if (prev.getNext() == found) {
                                break;
                            }

                            prev = prev.getNext();
                        } while (prev != this.head);

                        prev.setNext(found.getNext());
                    }

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
