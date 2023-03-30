/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import helpers.TextColours;

import java.util.ArrayList;

/**
 *
 * Implementation of the Binary Search Tree interface
 * which specifies the functionality of the
 * Binary Search Tree and its attributes
 * @author rla
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements IBSearchTree<E> {
    // <E extends Comparable<E>>

    /**
     * {@inheritDoc}
     * @param dataList the sorted datalist
     * @param leftCurrentRange the range for the left side of the BST
     * @param rightCurrentRange the range for the ride side of the BST
     */

    @Override
    public void createBalancedTree(ArrayList<E> dataList, int leftCurrentRange, int rightCurrentRange){
        root = balancedTree(dataList, leftCurrentRange, rightCurrentRange);
    }


    /**
     *
     * Helper method for the createBalancedTree function
     *
     * @param dataList the sorted datalist
     * @param leftCurrentRange the range for the left side of the BST
     * @param rightCurrentRange the range for the ride side of the BST
     */

    public Node<E> balancedTree(ArrayList<E> dataList, int leftCurrentRange, int rightCurrentRange){
        if(leftCurrentRange > rightCurrentRange)
        {
            return null;
        }
        int mid = (leftCurrentRange + rightCurrentRange)/2;
        Node<E> aNode = new Node<>(dataList.get(mid));
        aNode.leftNode = balancedTree(dataList, leftCurrentRange, mid - 1);
        aNode.rightNode = balancedTree(dataList, mid + 1, rightCurrentRange);
        return aNode;
    }

    /**
     * {@inheritDoc}
     * @param theItem the new Node that is being added to the BST
     */

    @Override
    public void addNode(E theItem)
    {
        root = addNode(root, theItem);
    }



    /**
     *
     * Helper method for the addNode function
     *
     * @param localRoot the specified current root of the BST
     * @param theItem the new Node that is being added to the BST
     * @return the newly added Node
     */

    private Node<E> addNode(Node<E> localRoot, E theItem) {
        if (localRoot == null)
        {
            System.out.println(TextColours.TEXT_GREEN + "Success!\n" + TextColours.TEXT_RESET);
            return new Node<>(theItem);
        }
        else if (theItem.compareTo(localRoot.getNodeData()) == 0)
        {
            System.out.println(TextColours.TEXT_RED +"Already exists in the BST!" + TextColours.TEXT_RESET);
            return localRoot;
        }
        else if
        (theItem.compareTo(localRoot.getNodeData()) < 0) {
            localRoot.leftNode = addNode(localRoot.leftNode, theItem);
            return localRoot;
        }
        else
        {
            localRoot.rightNode = addNode(localRoot.rightNode, theItem);
            return localRoot;
        }
    }

    /**
     *
     * {@inheritDoc}
     *
     * @param desiredItem the node that's module mark value is being search for
     * @return true if the module mark is found, false otherwise
     */

    @Override
    public boolean nodeContains(E desiredItem){
        return findItem(desiredItem)!= null;
    }

    /**
     *
     * {@inheritDoc}
     *
     * @param desiredItem the node that's module mark value is being search for
     * @return true if the module mark is found, false otherwise
     */

    @Override
    public E findItem(E desiredItem){
        return findItem(root, desiredItem);
    }

    /**
     *
     * Helper method for the findItem function
     *
     * @param desiredItem the node that's module mark value is being search for
     * @param localRoot the specified current root of the BST
     * @return true if the module mark is found, false otherwise
     */

    private E findItem(Node<E> localRoot, E desiredItem) {
        if (localRoot == null)
        {
            return null;
        }
        int result = desiredItem.compareTo(localRoot.getNodeData());
        if (result == 0)
        {
            return localRoot.getNodeData();
        }
        else if (result < 0)
        {
            return findItem(localRoot.leftNode, desiredItem);
        }
        else
        {
            return findItem(localRoot.rightNode, desiredItem);
        }
    }

    /**
     *
     * {@inheritDoc}
     *
     * @param desiredItem the Node that is being deleted to the BST
     * @return the deleted Node
     */

    @Override
    public E deleteNode(E desiredItem){
        root = deleteNode(root, desiredItem);
        return root.getNodeData();
    }

    /**
     *
     * Helper method for the deleteNode function
     *
     * @param desiredItem the Node that is being deleted to the BST
     * @param localRoot the specified current root of the BST
     * @return the deleted Node
     */

    private Node<E> deleteNode(Node<E> localRoot, E desiredItem){
        if (localRoot == null)
        {
            return localRoot;
        }
        int result = desiredItem.compareTo(localRoot.nodeData);
        if (result < 0) {
            localRoot.leftNode = deleteNode(localRoot.leftNode, desiredItem);
        }
        else if (result > 0)
        {
            localRoot.rightNode = deleteNode(localRoot.rightNode, desiredItem);
        }
        else
        {
            if (localRoot.leftNode == null)
            {
                return localRoot.rightNode;
            }
            else if (localRoot.rightNode == null)
            {
                return localRoot.leftNode;
            }
            localRoot.nodeData = inOrderSuccessor(localRoot.rightNode);
            localRoot.rightNode = deleteNode(localRoot.rightNode, localRoot.nodeData);
        }
        return localRoot;
    }

    /**
     *
     * Searches for the next in order successor in the BST
     *
     * @param localRoot the specified current root of the BST
     * @return the inOrderSuccessor
     */

    private E inOrderSuccessor(Node<E> localRoot) {
        // If the left child has no left child, it is
        // the inorder successor.
        if (localRoot.leftNode.leftNode == null) {
            E minimum = localRoot.leftNode.nodeData;
            localRoot.leftNode = localRoot.leftNode.rightNode;
            return minimum;
        }
        return inOrderSuccessor(localRoot.leftNode);
    }

    /**
     *
     * {@inheritDoc}
     *
     * @param desiredItem the Node that is being deleted to the BST
     * @return true if the node has been removed, false otherwise
     */

    @Override
    public boolean removeNode(E desiredItem){
        return deleteNode(desiredItem) != null;
    }

}
