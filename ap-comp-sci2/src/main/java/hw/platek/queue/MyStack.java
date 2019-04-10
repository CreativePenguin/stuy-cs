package hw.platek.queue;

public interface MyStack<E> {
    
    int size();
    boolean empty();
    void push(E val);
    E peek();
    E pop();
    
}
