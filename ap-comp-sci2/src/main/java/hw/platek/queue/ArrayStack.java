package hw.platek.queue;

import java.util.EmptyStackException;

public class ArrayStack<E> implements MyStack<E> {

    private E[] stack;
    private final int CAPACITY;
    protected int top; //index position if the top

    public ArrayStack(int cap) {
        stack = (E[]) (new Object[cap]);
        CAPACITY = cap;
        top = -1;
    }

    @Override
    public int size() {
        return this.top + 1;
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public void push(E val) throws FullStackException {
        if(size() == CAPACITY) throw new FullStackException("Stack full");
        stack[++top] = val;
    }

    @Override
    public E peek() throws EmptyStackException {
        if(empty())
            throw new EmptyStackException();
        return stack[top];
    }

    @Override
    public E pop() throws EmptyStackException {
        E output = peek();
        stack[top--] = null;
        return output;
    }
}
