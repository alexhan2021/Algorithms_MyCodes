package chapter1.exercise;

import chapter1.demo.Queue;
import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

/**
 * 1.3.15 Write a Queue client that takes a command-line argument k and prints the kth
 * from the last string found on standard input (assuming that standard input has k or
 * more strings).
 */
public class EX_1_3_15 {

    public static void main(String[] args) {
//        int k = Integer.parseInt(args[1]);
        int k = 2;
        Queue<String> queue = new Queue<>();
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }

        int kth = queue.size() - k;//kth item in the queue, index start from zero.
        String str = null;

        Iterator<String> itr = queue.iterator();
        int i = -1;
        while (itr.hasNext()){
            i++;
            if(i == kth){
                str = itr.next();
                break;
            }
            itr.next();
        }
        System.out.println(str);
    }
}
