package chapter1.exercise;

/**
 * 1.3.14 Develop a class ResizingArrayQueueOfStrings that implements the queue
 * abstraction with a fixed-size array, and then extend your implementation to use array
 * resizing to remove the size restriction.
 */
public class EX_1_3_14 {

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings(5);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
    }

    private static class ResizingArrayQueueOfStrings {
        private int capacity;
        private String[] data;
        private int N;
        private int head;
        private int tail;

        public ResizingArrayQueueOfStrings(int cap) {
            data = new String[cap];
            capacity = cap;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void enqueue(String str) {
            if (isFull()) resize(capacity*2);
            data[(tail++) % capacity] = str;
            N++;
        }

        public String dequeue() {
            if (isEmpty()) return null;
            String str = data[(head++) % capacity];
            N--;
            return str;
        }

        public boolean isFull() {
            return (tail + 1) % capacity == head;
        }

        private void resize(int newCapacity){
            String[] temp = new String[newCapacity];
            int tempHead = head;
            for (int i = 0; i < N; i++) {
                temp[i] = data[(head++)%capacity];
            }
            data = temp;
            capacity = newCapacity;
        }

    }
}
