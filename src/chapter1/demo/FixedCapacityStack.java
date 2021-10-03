package chapter1.demo;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length) resize(a.length * 2);
        a[N++] = item;
    }

    public Item pop() {
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return a[--N];
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Item[] tmp = (Item[]) new Object[max];
        System.arraycopy(a, 0, tmp, 0, N);
        a = tmp;
    }
}
