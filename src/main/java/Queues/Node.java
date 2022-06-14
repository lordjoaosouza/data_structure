package Queues;

class Node<Type> {

    private Type info;
    private Node<Type> next;

    Node(Type info) {
        this.info = info;
    }

    Type getInfo() {
        return this.info;
    }

    void setInfo(Type info) {
        this.info = info;
    }

    Node<Type> getNext() {
        return this.next;
    }

    void setNext(Node<Type> next) {
        this.next = next;
    }
}
