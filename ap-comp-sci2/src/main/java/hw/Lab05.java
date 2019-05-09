package hw;

import java.util.Stack;

public class Lab05 {

    public void roll(Stack<String> stack, int n, int k) {
        if(n < 0 || k < 0 || n > stack.size()) 
            throw new RuntimeException("roll: argument out of range");
        for(int i = 0; i < k; i++) {
            String[] tmp = new String[n];
            for(int j = 0; j < n; j++) {
                tmp[j] = stack.pop();
            }
            for(int j = 0; j < n; j++) {
                stack.push(tmp[j]);
            }
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A"); stack.push("B"); stack.push("C"); stack.push("D");
        Lab05 lab05 = new Lab05();
        lab05.roll(stack, 4, 1);
//        lab05.roll(stack, 3, 2);
//        lab05.roll(stack, 2, 4);
    }

}

