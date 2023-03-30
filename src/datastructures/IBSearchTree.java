/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.ArrayList;

/**
 *
 * The Binary Search Tree interface
 * which specifies the functionality of the
 * Binary Search Tree and its attributes
 *
 *
 * @author rla
 * @param <E>
 */
public interface IBSearchTree<E extends Comparable<E>> {

    /**
    *
    * Creates a balanced Binary Search Tree from a sorted array of data
    *
    * @param dataList the sorted datalist
    * @param leftCurrentRange the range for the left side of the BST
    * @param rightCurrentRange the range for the ride side of the BST
    */

    void createBalancedTree(ArrayList<E> dataList, int leftCurrentRange, int rightCurrentRange);

    /**
     *
     * Adds a new Node to the BST
     *
     * @param theItem the new Node that is being added to the BST
     */

    void addNode(E theItem);

    /**
     *
     * Searches if a node with certain module mark value already exists in the tree
     *
     * @param desiredItem the node that's module mark value is being search for
     * @return true if the module mark is found, false otherwise
     */

    boolean nodeContains(E desiredItem);

    /**
     *
     * Helper method for the nodeContains function
     *
     * @param desiredItem the node that's module mark value is being search for
     * @return true if the module mark is found, false otherwise
     */

    E findItem(E desiredItem);

    /**
     *
     * Helper method for the removeNode function
     *
     * @param desiredItem the Node that is being deleted to the BST
     * @return the deleted Node
     */

    E deleteNode(E desiredItem);

    /**
     *
     * Deletes a Node to the BST
     *
     * @param desiredItem the Node that is being deleted to the BST
     * @return true if the node has been removed, false otherwise
     */

    boolean removeNode(E desiredItem);
}
