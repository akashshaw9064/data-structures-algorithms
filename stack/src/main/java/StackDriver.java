import java.util.Scanner;

public class StackDriver {
    public static void main(String[] args) {
        Stack stack = new Stack();
        while(true){
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("0. Exit");
            for (int i = 0; i < 80; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter a number to push: ");
                        int x = stack.push(sc.nextInt());
                        System.out.println(x + " pushed onto stack");
                    }
                    case 2 -> System.out.println(stack.pop() + " popped out");
                    case 3 -> System.out.println(stack.peek() + " is on top of the stack");
                    case 4 -> stack.display();
                    case 0-> System.exit(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
