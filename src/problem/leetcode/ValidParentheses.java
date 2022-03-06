package problem.leetcode;

import java.util.Stack;

//20
public class ValidParentheses {

    public static boolean isValid(String s) {
        if(s.length()%2 != 0 || s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if(ch == ')' || ch == '}' || ch == ']') {
                if(stack.isEmpty()) return false;
                char c = stack.pop();
                if((c == '(' && ch != ')') || (c == '{' && ch != '}') || (c == '[' && ch != ']')) {
                    return false;
                }
            }
            else {
                stack.push(ch);
            }
        }
        if(stack.size() != 0) return false;
        return true;
    }

    public static boolean isValid2(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            switch(c) {
                case ')':
                    if (stack.isEmpty()  || stack.pop() != '(') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
//        System.out.println(isValid("()[{}"));
    }
}
