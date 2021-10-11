package chapter1.exercise;

import java.util.Iterator;

/**
 * 1.3.7 Add a method peek() to Stack that returns the most recently inserted item on
 * the stack (without popping it).
 */
public class EX_1_3_7 {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("Coming!");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }

    private static class Stack<Item> implements Iterable<Item> {
        private Node first;
        private int N;

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return N;
        }

        public void push(Item item) {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            N++;
        }

        public Item pop() {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }

        public Item peek() {
            if (first != null)
                return first.item;
            return null;
        }

        @Override
        public Iterator<Item> iterator() {
            return new ListIterator();
        }

        private class Node {
            Item item;
            Node next;
        }

        private class ListIterator implements Iterator<Item> {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }

}
