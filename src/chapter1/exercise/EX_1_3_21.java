package chapter1.exercise;

/**
 * 1.3.21 Write a method find() that takes a linked list and a string key as arguments
 * and returns true if some node in the list has key as its item field, false otherwise.
 */
public class EX_1_3_21 {
    public static void main(String[] args) {

    }

    private static class LinkedList<Item> {
        private int N;
        private Node first;

        public void add(Item item) {
            Node oldfirst = first;
            first = new Node();
            first.data = item;
            N++;
        }

        public boolean find(Item item) {
            Node node = first;
            while (!node.data.equals(item) && node.next != null) {
                node = node.next;
            }
            return false;
        }

        private class Node {
            Item data;
            Node next;
        }
    }
}
