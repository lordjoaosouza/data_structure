package LinkedLists.Doubly;

class Node<Type extends Comparable<Type>> implements Comparable<Node<Type>> {

    private Type info;
    private Node<Type> next;
    private Node<Type> prev;

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

    Node<Type> getPrev() {
        return this.prev;
    }

    void setPrev(Node<Type> previous) {
        this.prev = previous;
    }

    @Override
    public int compareTo(Node<Type> other) {
        return this.info.compareTo(other.getInfo());
    }
}
