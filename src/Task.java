import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Task {
    public static void main(String[] args) {
        System.out.println(countBrackets("(()"));
    }

    public static String countBrackets(String brackets) {

        int countBrackets = 0;
        StringBuilder builder = new StringBuilder();
        Deque<Map.Entry<Character, Integer>> stack = new ArrayDeque<>();

        for (int i = 0; i < brackets.length(); i++) {
            char currentBracket = brackets.charAt(i);
            if (currentBracket == '(') {
                stack.push(Map.entry(brackets.charAt(i), builder.length()));
            } else if (currentBracket == ')' && !stack.isEmpty()) {
                builder.insert(stack.pop().getValue().intValue(), '(');
                countBrackets += 2;
                builder.append(currentBracket);
            }
        }

        return countBrackets + " - " + builder.toString();
    }
}
