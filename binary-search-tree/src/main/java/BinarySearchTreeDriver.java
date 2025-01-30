import java.util.Scanner;

public class BinarySearchTreeDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to execute recursive algorithms or iterative algorithms for BST?");
        System.out.println("1. Recursive");
        System.out.println("2. Iterative");
        int choice = sc.nextInt();
        BinarySearchTree tree = choice == 1 ? new BinarySearchTreeRecursive() : new BinarySearchTreeIterative();
        while (true) {
            menu();
            System.out.println("\nEnter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.print("Enter a number to insert:");
                    int key = sc.nextInt();
                    long start = System.currentTimeMillis();
                    tree.insert(key);
                    long end = System.currentTimeMillis();
                    System.out.println("Time taken to insert: " + (end - start) + "ms");
                }
                case 2 -> {
                    System.out.println("Inorder Traversal:");
                    long start = System.currentTimeMillis();
                    tree.inorderTraversal();
                    long end = System.currentTimeMillis();
                    System.out.println("Time taken to traverse: " + (end - start) + "ms");
                }
                case 3 -> {
                    System.out.print("Enter a number to search: ");
                    int key = sc.nextInt();
                    long start = System.currentTimeMillis();
                    if (tree.search(key))
                        System.out.println("FOUND!");
                    else
                        System.out.println("NOT FOUND!");
                    long end = System.currentTimeMillis();
                    System.out.println("Time taken to search: " + (end - start) + "ms");
                }
                case 4 -> {
                    System.out.print("Enter a number to delete: ");
                    int key = sc.nextInt();
                    long start = System.currentTimeMillis();
                    tree.delete(key);
                    long end = System.currentTimeMillis();
                    System.out.println("Time taken to delete: " + (end - start) + "ms");
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid Choice");
            }
            sc.nextLine();
            sc.nextLine();
        }
    }

    public static void menu() {
        System.out.println("\n\n\n\t\t1. Insert");
        System.out.println("\t\t2. Inorder");
        System.out.println("\t\t3. Search");
        System.out.println("\t\t4. Delete");
        System.out.println("\t\t0. Exit");
        for (int i = 1; i <= 80; i++)
            System.out.print("-");
    }
}
