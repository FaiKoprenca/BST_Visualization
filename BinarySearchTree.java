package PROJECT;


import java.util.ArrayList;


class BinarySearchTree<E extends Comparable<E>>{

    private TreeNode<E> root;
    private int size = 0;

    public BinarySearchTree() {};


    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }


    public int getSize() {
        return size;
    }


    public TreeNode<E> getRoot() {
        return root;
    }


    public boolean search(E e) {
        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                return true;
        }

        return false;
    }


    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else {

            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;


            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return true;
    }




    public ArrayList<E> inorder() {
        ArrayList<E> list=new ArrayList<>();
        inorder(root,list);
        return list;
    }


    private void inorder(TreeNode<E> root,ArrayList<E> list) {
        if (root == null)
            return;
        inorder(root.left,list);
        list.add(root.element);
        inorder(root.right,list);
    }


    public ArrayList<E> postorder() {
        ArrayList<E> list=new ArrayList<>();
        postorder(root,list);
        return list;
    }


    private void postorder(TreeNode<E> root,ArrayList<E> list) {
        if (root == null)
            return;
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.element);
    }


    public ArrayList<E> preorder() {
        ArrayList<E> list=new ArrayList<>();
        preorder(root,list);
        return list;
    }



    private void preorder(TreeNode<E> root,ArrayList<E> list) {
        if (root == null)
            return;
        list.add(root.element);
        preorder(root.left,list);
        preorder(root.right,list);

    }



    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break;
        }

        if (current == null)
            return false; // Element is not in the tree

        // Case 1: current has no left child
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {
            // Case 2: The current node has a left child
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
        }

        size--;
        return true; // Element deleted successfully
    }


    public int height(){
        if(root==null)
            return 0;
        return getHeight(root);
    }

    private int getHeight(TreeNode root){
        if(root==null)
            return -1;

        int temp1=getHeight(root.right)+1;
        int temp2=getHeight(root.left)+1;

        return Math.max(temp1,temp2);
    }





    public E getMin(TreeNode<E> root){
        if(root==null)
            return null;
        if(root.left==null)
            return root.element;
        return getMin(root.left);
    }

    public E getMax(TreeNode<E> root){
        if (root==null)
            return null;
        if(root.right==null)
            return root.element;
        return getMax(root.right);
    }



    /** Remove all elements from the tree */
    public void clear() {
        root = null;
        size = 0;
    }
}
