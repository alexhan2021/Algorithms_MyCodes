package chapter1.exercise;

import chapter1.demo.Stack;

/**
 * 1.3.12 Write an iterable Stack client that has a static method copy() that takes a stack
 * of strings as argument and returns a copy of the stack. Note : This ability is a prime
 * example of the value of having an iterator, because it allows development of such functionality
 * without changing the basic API.
 */
public class EX_1_3_12 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        for (String str:stack){
            System.out.println(str);
        }
        System.out.println("==================");
        Stack<String> copy = copy(stack);
        for (String str:copy){
            System.out.println(str);
        }
    }

    public static <Item> Stack<Item> copy(Stack<Item> stack){
        Stack<Item> copy = new Stack<>();
        Stack<Item> copy2 = new Stack<>();
        for(Item item: stack){
            copy.push(item);
        }
        for(Item item: copy){
            copy2.push(item);
        }
        return copy2;
    }
}
