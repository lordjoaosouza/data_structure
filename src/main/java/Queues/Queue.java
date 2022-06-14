package Queues;

public class Queue<Type> {

    private Node<Type> head;
    private Node<Type> tail;
    private int size;

    public boolean isEmpty() {
        return this.head == null && this.tail == null && this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public Type head() {
        return this.head.getInfo();
    }

    public void enqueue(Type value) {
        Node<Type> newNode = new Node<>(value);

        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }

        this.tail = newNode;
        this.size++;
    }

    public Type dequeue() {
        Node<Type> temp = this.head;

        this.head = this.head.getNext();

        if (this.head == null) {
            this.tail = null;
        }

        this.size--;

        return temp.getInfo();
    }
}
