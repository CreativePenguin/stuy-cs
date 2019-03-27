package hw.platek.stack;

public interface MyStack<E> {
    
    int size();
    boolean empty();
    void push(E val);
    E peek();
    E pop();
    
}
