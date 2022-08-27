package stack;

public class StackTest2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }
}
