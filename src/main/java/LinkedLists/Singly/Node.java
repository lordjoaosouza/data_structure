package LinkedLists.Singly;

class Node<Type extends Comparable<Type>> implements Comparable<Node<Type>> {

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

    @Override
    public int compareTo(Node<Type> other) {
        return this.info.compareTo(other.getInfo());
    }
}
