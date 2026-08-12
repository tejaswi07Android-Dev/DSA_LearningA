import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice {

    public static void main(String[] args) {
        String brc = " ([}}])";

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println(isValid(brc));


    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.length() % 2 == 1) {
            return false;
        }

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' ||c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                }else{
                    return false;
                }
            }

        }
        return stack.isEmpty();

    }


    public static boolean isValidT(String s) {
        if(s.length() % 2 == 1) return false;

        Stack<Character> brackets = new Stack<>();


        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                brackets.push(ch);
            }else{
                if(brackets.isEmpty()) return false;

                char curr = brackets.pop();

                if(     curr == '(' && ch != ')' ||
                        curr == '{' && ch != '}' ||
                        curr == '[' && ch != ']'){
                    return false;
                }
            }
        }

        return brackets.isEmpty();
    }
}
