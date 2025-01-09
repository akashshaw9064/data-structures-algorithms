import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        while (true) {
            menu();
            System.out.println("\nEnter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.print("Enter a number to insert:");
                    int num = sc.nextInt();
                    list.insert(num);
                    System.out.println("SUCCESS!");
                }
                case 2 -> list.display();
                case 3 -> {
                    long size = list.length();
                    System.out.println("Size is " + size);
                }
                case 4 -> {
                    System.out.println("Which element?");
                    int ele = sc.nextInt();
                    list.delete(ele);
                }
                case 5 -> list.reverse();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid Choice");
            }
            sc.nextLine();
            sc.nextLine();
        }
    }

    public static void menu() {
        System.out.println("\n\n\n\t\t1. Insert");
        System.out.println("\t\t2. Display");
        System.out.println("\t\t3. Size");
        System.out.println("\t\t4. Delete");
        System.out.println("\t\t5. Reverse");
        System.out.println("\t\t0. Exit");
        for (int i = 1; i <= 80; i++)
            System.out.print("-");
    }
}
