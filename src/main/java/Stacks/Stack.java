package Stacks;

public class Stack<Type> {

    private Node<Type> top;
    private int size;

    public boolean isEmpty() {
        return this.top == null && this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void push(Type value) {
        Node<Type> newNode = new Node<>(value);
        if (!this.isEmpty()) {
            newNode.setNext(this.top);
        }

        this.top = newNode;
        this.size++;
    }

    public Type pop() {
        Node<Type> curr = this.top;
        this.top = this.top.getNext();
        this.size--;

        return curr.getInfo();
    }

    public Type peek() {
        return this.top.getInfo();
    }
}
