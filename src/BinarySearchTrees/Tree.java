package BinarySearchTrees;

public class Tree {
    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }

        return null;
    }

    public void delete (int value) {
        root = delete(root, value); // passing the "root of the subtree" we wanna search for the "value"

    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) {
            return subtreeRoot;
        }

        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value)); // if value is less than subtreeRoot's value, then we wanna move to subtree's left child
        }
        else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value)); // if value is more than subtreeRoot's value, then we wanna move to subtree's right child
        } else { // we have found the node we want to delete
            // Cases 0 and 1: node to delete has 0 or 1 children
            if (subtreeRoot.getLeftChild() == null) {
                // 2 situations subtreeRoot.getLeftChild() == null
                // situation 1: the subtreeRoot is a leaf ==> both left and right child is null
                // situation 2: the subtreeRoot only has rightChild ==> left child is null
                return subtreeRoot.getRightChild(); // can be used for both situations, (situation 1 will return null and situation 2 will return rightChild)
            }
            else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }

            // Case 3: node to delete has 2 children (replaced with smallest value in the right sub-tree)
            // Replace the value in the subtreeRoot node with the smallest value from the right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min());
            // Delete the node that has the smallest value in the right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }
        return subtreeRoot; // this line means: this is not the subtreeRoot we want to delete, so we return the original subtreeRoot
    }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return root.max();
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traversesInOrder();
        }
    }

    public void traversePreOrder() {
        if (root != null) {
            root.traversePreOrder();
        }
    }

    public void traversePostOrder() {
        if (root != null) {
            root.traversePostOrder();
        }
    }
}
