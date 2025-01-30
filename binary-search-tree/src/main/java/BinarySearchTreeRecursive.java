public class BinarySearchTreeRecursive implements BinarySearchTree {
    Node root;

    @Override
    public Node insert(int x) {
        root = insert(root, x);
        return root;
    }

    private Node insert(Node root, int x) {
        if (root == null) {
            root = new Node(x);
            return root;
        }
        if (x < root.val) {
            root.left = insert(root.left, x);
        } else if (x > root.val) {
            root.right = insert(root.right, x);
        }
        return root;
    }

    @Override
    public Node delete(int x) {
        root = delete(root, x);
        return root;
    }

    private Node delete(Node root, int x) {
        if (root == null) {
            return root;
        }
        if (x < root.val) {
            root.left = delete(root.left, x);
        } else if (x > root.val) {
            root.right = delete(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.val = minValue(root.right);
            root.right = delete(root.right, root.val);
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    @Override
    public boolean search(int x) {
        return search(root, x);
    }

    private boolean search(Node root, int x) {
        if (root == null) {
            return false;
        }
        if (root.val == x) {
            return true;
        }
        if (x < root.val) {
            return search(root.left, x);
        }
        return search(root.right, x);
    }

    @Override
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }
}