import java.util.Stack;

public class BinarySearchTreeIterative implements BinarySearchTree {
    Node root;

    @Override
    public Node insert(int x) {
        Node newNode = new Node(x);
        if (root == null) {
            root = newNode;
            return root;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (x < current.val) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return root;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return root;
                }
            }
        }
    }

    @Override
    public Node delete(int x) {
        root = deleteNode(root, x);
        return root;
    }

    private Node deleteNode(Node root, int value) {
        Node parent = null;
        Node current = root;

        // Find the node to be deleted and its parent
        while (current != null && current.val != value) {
            parent = current;
            if (value < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // If the node to be deleted is not found
        if (current == null) {
            return root;
        }

        // Case 1: Node to be deleted has at most one child
        if (current.left == null || current.right == null) {
            Node newCurrent = (current.left == null) ? current.right : current.left;

            // If the node to be deleted is the root node
            if (parent == null) {
                return newCurrent;
            }

            // Update the parent's reference
            if (current == parent.left) {
                parent.left = newCurrent;
            } else {
                parent.right = newCurrent;
            }
        } else {
            // Case 2: Node to be deleted has two children
            Node successorParent = null;
            Node successor = current.right;

            // Find the in-order successor (smallest in the right subtree)
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // If the successor has a right child, update the parent's reference
            if (successorParent != null) {
                successorParent.left = successor.right;
            } else {
                current.right = successor.right;
            }

            current.val = successor.val;
        }

        return root;
    }

    @Override
    public boolean search(int x) {
        Node current = root;
        while (current != null) {
            if (current.val == x) {
                return true;
            } else if (x < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    @Override
    public void inorderTraversal() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println(current.val);
            current = current.right;
        }
    }
}