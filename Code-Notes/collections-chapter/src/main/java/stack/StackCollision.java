package stack;

/*
To use this Stack in your own code, you fully specify the package—or change the
name of the class—when you create one; otherwise, you’ll probably collide with
the Stack in java.util. For example, if we import java.util.* into the above
example, we must use package names to prevent collisions:

Even though java.util.Stack exists, ArrayDeque produces a much better Stack
and so is preferable.

You can also control the selection of the "preferred" Stack implementation using an
explicit import:

import yourpackage.Stack;

Now any reference to Stack will select the onjava version, and to select java.util.Stack
you must use full qualification.
 */

public class StackCollision {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        for (String s : "My dog has fleas Stack".split(" ")) {
            stack.push(s);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
        System.out.println();

        java.util.Stack<String> stack2 = new java.util.Stack<>();

        for (String s : "My dog has fleas Stack Java Util".split(" ")) {
            stack2.push(s);
        }

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop() + " ");
        }
    }
}
