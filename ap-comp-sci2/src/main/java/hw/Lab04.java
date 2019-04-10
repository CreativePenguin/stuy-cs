package hw;

import hw.platek.queue.ArrayStack;
import hw.platek.queue.FullStackException;
import hw.platek.queue.MyStack;
import java.util.EmptyStackException;

public class Lab04<E> extends ArrayStack<E> {

    public Lab04(int cap) {
        super(cap);
    }

    public void transferTo(MyStack<E> rhs) {
        while(top < this.size()) {
            try {
                push(pop());
            }
            catch(EmptyStackException e) {
                return;
            } catch(FullStackException e) {
                return;
            }
        }
    }

    private void q2() {
        Lab04<Number> A = new Lab04<>(100);
        for(int i = 0; i < A.size(); i++) {
            A.push(i);
        }
        Lab04<Number> B = new Lab04<>(5);
        Lab04<Number> C = new Lab04<>(3);
        A.transferTo(C);
        C.transferTo(B);
        A.transferTo(C);
        C.transferTo(B);
        B.transferTo(A);
        A.transferTo(C);
        C.transferTo(A);
        System.out.println("The size of B is:" + B.size());
    }

}
