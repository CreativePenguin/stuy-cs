package hw.platek.queue;
//Stop using checked exceptions, when all we're using the exception for is throwing another exception. That defeats the purpose of checked exceptions and just makes the code longer, as those are only for when there's a 

public interface Deque<E> {
   
    public int size();
    public boolean isEmpty();
    
    public E getFirst();
    public E getLast();
    
    public void addFirst(E val);
    public void addLast(E val);
   
    public E removeFirst();
    public E removeLast();
   
}

