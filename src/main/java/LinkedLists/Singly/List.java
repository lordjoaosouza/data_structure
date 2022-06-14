package LinkedLists.Singly;

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
            while (curr != null) {
                if (curr.getInfo().equals(searched.getInfo())) {
                    return curr;
                }

                curr = curr.getNext();
            }
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
                Node<Type> next = this.head;
                this.head = newNode;
                this.head.setNext(next);
            } else if (newNode.compareTo(this.tail) > 0) {
                this.tail.setNext(newNode);
                this.tail = newNode;
            } else {
                Node<Type> greater = this.head;
                while (greater != null) {
                    if (greater.compareTo(newNode) > 0) {
                        break;
                    }

                    greater = greater.getNext();
                }

                Node<Type> prev = this.head;
                while (prev.getNext() != greater) {
                    prev = prev.getNext();
                }

                newNode.setNext(greater);
                prev.setNext(newNode);
            }

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
                        while (prev != null) {
                            if (prev.getNext() == this.tail) {
                                break;
                            }

                            prev = prev.getNext();
                        }

                        this.tail = prev;
                        this.tail.setNext(null);
                    } else {
                        Node<Type> prev = this.head;
                        while (prev.getNext() != found) {
                            prev = prev.getNext();
                        }

                        prev.setNext(found.getNext());
                    }
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
