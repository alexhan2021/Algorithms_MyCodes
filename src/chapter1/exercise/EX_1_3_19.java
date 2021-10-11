package chapter1.exercise;

/**
 * 1.3.19 Give a code fragment that removes the last node in a linked list whose first node
 * is first.
 */
public class EX_1_3_19 {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
//        System.out.println(list.removeLastItem());
        list.add("111");
        list.add("222");
        System.out.println(list.removeLastItem());
        list.add("333");
        list.add("444");
        list.add("555");
        System.out.println(list.removeLastItem());
    }

    private static class LinkedList<Item> {

        private Node first;

        private int N;

        public void add(Item item) {
            Node oldFirst = first;
            first = new Node();
            first.data = item;
            first.next = oldFirst;
            N++;
        }

        public int size() {
            return N;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public Item removeLastItem() {
            if (isEmpty()) return null;
            Node last = first, penultimate = first;
            while ((last.next) != null) {
                penultimate = last;
                last = last.next;
            }
            Item item = last.data;
            if (last == first) {// for only one items in list
                first = null;
            } else {
                penultimate.next = null;
            }
            N--;
            return item;
        }

        private class Node {
            Item data;
            Node next;
        }
    }
}
