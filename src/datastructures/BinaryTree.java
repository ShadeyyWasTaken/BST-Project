/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * The Binary Tree class
 * which specifies the functionality of the
 * Binary Tree its basic attributes, and the way it stores data
 *
 * @author rla
 */
public class BinaryTree<E> {
    protected Node<E> root;

    /**
     * Default Constructor
     * Creates an empty binary tree
     */
    public BinaryTree() {
        root = new Node<>();
    }
    /**
     * Construct a new binary tree with data in its root and
     * leftTree as the left subtree
     * rightTree as the right subtree
     * @param data The data to be stored
     * @param leftTree the left subtree
     * @param rightTree the right subtree
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        this.root = new Node<>(data);
        if (leftTree != null) {
            this.root.leftNode = leftTree.root;
        } else {
            this.root.leftNode = null;
        }
        if (rightTree != null) {
            this.root.rightNode = rightTree.root;
        } else {
            this.root.rightNode = null;
        }
    }


    /**
     *
     *
     * Getter for the root of the Binary Search Tree
     *
     * @return the specified root for binary tree
     */

    public Node<E> getRoot() {
        return root;
    }

    /**
     *
     *
     * Setter for the root of the Binary Search Tree
     *
     * @param root the specified root for binary tree
     */

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    /**
     * For subclass use only.
     * Creates a binary tree with a specified root
     * @param root specified root for binary tree
     */
    private BinaryTree(Node<E> root){
        this.root = root;
    }

    /**
     * Checks if the binary tree's specified root is empty
     *
     *
     * @return true if the tree is empty, false otherwise
     */

    public boolean isEmpty(){
        return this.root == null;
    }

    /**
     * Checks if the binary tree's specified root and the left part of the tree is empty, if not return the left side of the current tree
     *
     *
     * @return the left side of the current tree
     */

    public BinaryTree<E> getLeftTree(){
        if(this.root != null && this.root.leftNode != null){
            return new BinaryTree<>(this.root.leftNode);
        }
        else {
            return null;
        }
    }

    /**
     * Checks if the binary tree's specified root and the right part of the tree is empty, if not return the right side of the current tree
     *
     *
     * @return the right side of the current tree
     */

    public BinaryTree<E> getRightTree(){
        if(this.root != null && this.root.rightNode != null){
            return new BinaryTree<>(this.root.rightNode);
        }
        else {
            return null;
        }
    }

    /**
     * Checks if the binary tree's empty and if it is not, return the tree's data
     *
     *
     * @return the tree's data
     */

    public E getItemData(){
        if(!isEmpty()){
            return this.root.getNodeData();
        }
        else {
            return null;
        }
    }

    /**
     * Checks if the current node of the tree is a leaf
     *
     *
     * @return true if it is a leaf, false otherwise
     */

    public boolean isLeaf(){
        return (this.root == null || (this.root.leftNode == null && this.root.rightNode == null));
    }

    /**
     *
     *
     * Standard toString function of the BinaryTree object
     *
     * @return String version of the stored data in the BinaryTree object
     */
    
    @Override
    public String toString() {
        if (this.root == null){
            throw new NullPointerException("The tree is empty!");
        }
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(root, 1, sb);
        return sb.toString();
    }

    /**
     * Used by the toString method.
     * @param node
     * @param depth
     * @param sb 
     */
    private void preOrderTraversal(Node<E> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraversal(node.leftNode, depth + 1, sb);
            preOrderTraversal(node.rightNode, depth + 1, sb);
        }
    }
}
