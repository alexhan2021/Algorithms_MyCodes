package chapter1.exercise;

import chapter1.demo.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 1.3.4 Write a stack client Parentheses that reads in a text stream from standard input
 * and uses a stack to determine whether its parentheses are properly balanced. For example,
 * your program should print true for [()]{}{[()()]()} and false for [(]).
 */
public class EX_1_3_4 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        boolean matched = true;
        while (!StdIn.isEmpty()) {
            char userInput = StdIn.readChar();
            if (userInput == '{' || userInput == '[' || userInput == '(') {
                stack.push(userInput);
            } else {
                try {
                    char inStack = stack.pop();
                    if ((userInput == '}' && inStack != '{') || (userInput == ']' && inStack != '[') || (userInput == ')' && inStack != '('))
                        matched = false;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    matched = false;
                    break;
                }

            }
        }
        System.out.println(matched);
    }
}
