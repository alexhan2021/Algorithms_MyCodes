package chapter1.exercise;

import chapter1.demo.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 1.3.9 Write a program that takes from standard input an expression without left parentheses
 * and prints the equivalent infix expression with the parentheses inserted. For
 * example, given the input:
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * your program should print
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class EX_1_3_9 {
    public static void main(String[] args) {
        Stack<String> val = new Stack<>();
        Stack<String> ope = new Stack<>();
        Stack<String> result = new Stack<>();
        String str;
        while (!StdIn.isEmpty()) {
            str = StdIn.readString();
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                ope.push(str);
            } else if (str.equals(")")) {
                String left = val.pop();
                if (left == null) left = result.pop();
                String right = val.pop();
                if (right == null) right = result.pop();
                String tmp = "(" + right + ope.pop() + left + str;
                result.push(tmp);
            } else {
                val.push(str);
            }
        }

        System.out.println("Test");
        System.out.println(result.pop());

    }
}
