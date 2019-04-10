package hw;

//import hw.platek.queue.MyQueueKt;
import java.util.Queue;
import java.util.Stack;
import java.util.NoSuchElementException;
import java.util.Collection;
import hw.platek.queue.Deque;

public final class Lab06<E> implements Deque<E> {

    int size; int cap;
    E[] deque;

    public Lab06(int cap) {
        size = 0; this.cap = cap;
        deque = (E[]) new Object[cap];
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E getFirst() {
        if(isEmpty()) throw new IllegalStateException();
        return deque[0];
    }
    @Override
    public E getLast() {
        if(isEmpty()) throw new IllegalStateException();
        return deque[size];
    }

    @Override
    public void addFirst(E val) {
        for(int i = deque.length - 1; i >= 0; i--) {
            deque[i + 1] = deque[i];
        }
        deque[0] = val;
        size++;
    }
    @Override
    public void addLast(E val) {
        deque[++size] = val;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()) throw new IllegalStateException();
        E tmp = deque[0];
        for(int i = 1; i < deque.length; i++) {
            deque[i] = deque[i + 1];
        }
        deque[0] = null;
        size--;
        return tmp;
    }
    @Override
    public E removeLast() {
        if(isEmpty()) throw new IllegalStateException();
        E tmp = deque[size];
        deque[size] = null;
        size--;
        return tmp;
    }

    @Override
    public String toString() {
        String val = "";
        for(E i : deque)
            val += i.toString();
        return val;
    }

    public static class Queue<E> {

        private Stack<E> s1 = new Stack<>();
        private Stack<E> s2 = new Stack<>();
        int size = 0;
        boolean isS1 = true;

        public boolean add(E e) {
            if(s1.size() + s2.size() >= size) throw new IllegalStateException();
            if(isS1) s1.push(e); else s2.push(e);
            size++;
            return true;
        }

        public boolean offer(E e) {
            try { return add(e); }
            catch(IllegalStateException m) { return false; }
        }

        public E remove() {
            if(s1.empty() && s2.empty()) throw new NoSuchElementException();
            Stack<E> tmp1 = isS1 ? s1 : s2;
            Stack<E> tmp2 = isS1 ? s2 : s1;
            while(!tmp1.empty())
                tmp2.push(tmp1.pop());
            E val = tmp2.pop();
            isS1 = !isS1;
            return val;
        }

        public E poll() {
            try { return remove(); }
            catch(NoSuchElementException e) { return null; }
        }

        public E peek() {
            try { return element(); }
            catch(NoSuchElementException e) { return null; }
        }

        public E element() {
            if(s1.empty() && s2.empty()) throw new NoSuchElementException();
            Stack<E> tmp1 = isS1 ? s1 : s2;
            Stack<E> tmp2 = isS1 ? s2 : s1;
            while(!tmp1.empty()) {
                tmp2.push(tmp1.pop());
            }
            E val = tmp2.peek();
            isS1 = !isS1;
            return val;
        }

    }

    public static void main(String[] args) {
        Deque<Integer> t = new Lab06<>(6);
        t.addFirst(3); t.addFirst(2); t.addFirst(1);
        t.addLast(4); t.addLast(5); t.addLast(6);
        System.out.println(t);
    }

}

