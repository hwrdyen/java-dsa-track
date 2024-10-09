package BinarySearchTrees;

public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public void insert(int value) {
        if (value == data) {
            return; // Tree doesn't support duplicate value
        }

        if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }

    }

    public TreeNode get(int value) {
        if (value == data) {
            return this;
        }

        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }

        return null;
    }

    public int min() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.min();
        }
    }

    public int max() {
        if (rightChild == null) {
            return data;
        } else {
            return rightChild.max();
        }
    }

    public void traversesInOrder() {
        if (leftChild != null) {
            leftChild.traversesInOrder();
        } // visit left subtree
        System.out.print(data + ", "); // visit node itself
        if (rightChild != null) {
            rightChild.traversesInOrder();
        } // visit right subtree
    }

    public void traversePreOrder() {
        System.out.print(data + ", "); // visit node first
        if (leftChild != null) {
            leftChild.traversePreOrder();
        } // visit left subtree

        if (rightChild != null) {
            rightChild.traversePreOrder();
        } // visit right subtree
    }

    public void traversePostOrder() {
        if (leftChild != null) {
            leftChild.traversePostOrder();
        } // visit left subtree

        if (rightChild != null) {
            rightChild.traversePostOrder();
        } // visit right subtree

        System.out.print(data + ", "); // visit node last
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
