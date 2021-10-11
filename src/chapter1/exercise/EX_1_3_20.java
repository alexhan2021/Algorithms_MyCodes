package chapter1.exercise;

import chapter1.demo.Queue;

/**
 * 1.3.20 Write a method delete() that takes an int argument k and deletes the kth element
 * in a linked list, if it exists.
 */
public class EX_1_3_20 {

    public static void main(String[] args) {
        int k = 2;
        LinkedList<String> list = new LinkedList<>();
        list.add("111");
//        list.add("222");
//        list.add("333");
//        list.add("444");
//        list.add("555");
        System.out.println(list.delete(k));
    }

    private static class LinkedList<Item> {
        private int N;
        private Node first;

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

        public boolean delete(int index) {
            if (index > size() || index < 1) return false;
            Node target = first, targetPre = first;
            for (int i = 1; i < index; i++) {
                targetPre = target;
                target = target.next;
            }
            if(target == first){
                first = null;
            }else{
                targetPre.next = target.next;
            }
            N--;
            return true;
        }

        private class Node {
            Item data;
            Node next;
        }
    }
}
