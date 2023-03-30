/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 *The Node class
 *which specifies the functionality of the
 *nodes in the BST and how they store the data
 *
 * @author rla
 * @param <E>
 */
public class Node<E> {
    /**
     * This is the data we want to store,
     * It can be of any type
     */
    public E nodeData;   // Data we want to store (could be int, string, Object etc.)
    /**
     * This will hold the pointer to the next node in the list
     */
    public Node<E> leftNode;  // A "pointer" to next node in the list
    /**
     * This will hold the pointer to the next node in the list
     */
    public Node<E> rightNode;  // A "pointer" to next node in the list

    /**
     *
     *
     * Default constructor for the Node object
     *
     */

    public Node(){
        this.nodeData = null;
        this.leftNode = null;
        this.rightNode = null;
    }

    /**
     *
     *
     * Constructor for the Node object with provided nodeData and nextNode
     *
     * @param data the data that is stored
     */

    public Node(E data){
        this.nodeData = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    /**
     *
     *
     * Getter for the nodeData
     *
     * @return the data that is stored in the node
     */

    public E getNodeData() {
        return this.nodeData;
    }

    /**
     *
     *
     * Setter for the nodeData
     *
     * @param nodeData the data that is being provided to be stored
     */

    public void setNodeData(E nodeData) {
        this.nodeData = nodeData;
    }

    /**
     *
     *
     * Getter for the leftNode
     *
     * @return the node that will be left from this one in the BST
     */

    public Node<E> getLeftNode() {
        return this.leftNode;
    }

    /**
     *
     *
     * Setter for the leftNode
     *
     * @param leftNode the node that will be left from this one in the BST
     */

    public void setLeftNode(Node<E> leftNode) {
        this.leftNode = leftNode;
    }

    /**
     *
     *
     * Getter for the rightNode
     *
     * @return the node that will be right from this one in the BST
     */

    public Node<E> getRightNode() {
        return this.rightNode;
    }

    /**
     *
     *
     * Setter for the rightNode
     *
     * @param rightNode the node that will be right from this one in the BST
     */

    public void setRightNode(Node<E> rightNode) {
        this.rightNode = rightNode;
    }

    /**
     *
     *
     * Standard toString function of the Node object
     *
     * @return String version of the stored data in the node
     */


    @Override
    public String toString() {
        return nodeData.toString();
    }
}