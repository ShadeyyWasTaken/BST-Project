package view;

import datastructures.BinarySearchTree;
import datastructures.Node;
import helpers.OutputHelper;
import helpers.TextColours;
import model.DisplayOrder;
import model.StudentMarks;

/**
 * The taskListView class
 * provides printing functionality of the
 * Student Marks and the BST in the controller class
 *
 */

public class aView {

    /**
     *
     *
     * Display the values of all Nodes of type Student Marks in the BST on the console, in ascending order, through recursion
     *
     * @param root the current Node of the tree that is being displayed through recursion
     */

    public void displayBSTItemAsc(Node<StudentMarks> root){
        if (root.leftNode != null) {
            displayBSTItemAsc(root.leftNode);
        }
        System.out.format(TextColours.TEXT_YELLOW + "| %-18s | %-18s | %-18s | %3d | %3d | %3d | %11d |\n" + TextColours.TEXT_RESET, root.getNodeData().getStudentID(), root.getNodeData().getGivenName(), root.getNodeData().getLastname(),
                root.getNodeData().getCT1(), root.getNodeData().getCT2(), root.getNodeData().getCT3(), root.getNodeData().getModuleMark());
        if (root.rightNode != null) {
            displayBSTItemAsc(root.rightNode);
        }
    }

    /**
     *
     *
     * Display the values of all Nodes of type Student Marks in the BST on the console, in descending order, through recursion
     *
     * @param root the current Node of the tree that is being displayed through recursion
     */

    public void displayBSTItemDesc(Node<StudentMarks> root){
        if (root.rightNode != null) {
            displayBSTItemDesc(root.rightNode);
        }
        System.out.format(TextColours.TEXT_YELLOW + "| %-18s | %-18s | %-18s | %3d | %3d | %3d | %11d |\n" + TextColours.TEXT_RESET,  root.getNodeData().getStudentID(), root.getNodeData().getGivenName(), root.getNodeData().getLastname(),
                root.getNodeData().getCT1(), root.getNodeData().getCT2(), root.getNodeData().getCT3(), root.getNodeData().getModuleMark());
        if (root.leftNode != null) {
            displayBSTItemDesc(root.leftNode);
        }
    }

    /**
     *
     *
     * Display the Binary Search Tree on the console
     *
     * @param theBST the Binary Search Tree that will be displayed
     * @param order the order in which the BST will be displayed - Ascending or descending
     */

    public void displayBST(BinarySearchTree<StudentMarks> theBST, DisplayOrder order){
        System.out.println(TextColours.TEXT_CYAN + OutputHelper.repeat("-",96) + TextColours.TEXT_RESET);
        System.out.format(TextColours.TEXT_BLUE + "| %-18s | %-18s | %-18s | %-3s | %-3s | %-3s | %11s |\n", "Student ID", "Given Name", "Surname", "CT1", "CT2", "CT3", "Module Mark");
        System.out.println(TextColours.TEXT_CYAN + OutputHelper.repeat("-",96) + TextColours.TEXT_RESET);

        switch(order){
            case ASCENDING:
                displayBSTItemAsc(theBST.getRoot());
                break;
            case DESCENDING:
                displayBSTItemDesc(theBST.getRoot());
                break;
            default:
                System.out.println("Oops! Something has went wrong!");
                break;
        }
        System.out.println(TextColours.TEXT_CYAN + OutputHelper.repeat("-",96) + TextColours.TEXT_RESET);
    }

    /**
     *
     *
     * Display a Student Mark on the console
     *
     * @param anItem the Student Mark that will be displayed
     */

    public void displayABSTItem(StudentMarks anItem){
        System.out.println(TextColours.TEXT_CYAN + OutputHelper.repeat("-",96) + TextColours.TEXT_RESET);
        System.out.format(TextColours.TEXT_BLUE + "| %-18s | %-18s | %-18s | %-3s | %-3s | %-3s | %11s |\n" + TextColours.TEXT_RESET, "Student ID", "Given Name", "Surname", "CT1", "CT2", "CT3", "Module Mark");
        System.out.println(TextColours.TEXT_CYAN + OutputHelper.repeat("-",96) + TextColours.TEXT_RESET);
        System.out.format(TextColours.TEXT_YELLOW + "| %-18s | %-18s | %-18s | %3d | %3d | %3d | %11d |\n" + TextColours.TEXT_RESET, anItem.getStudentID(), anItem.getGivenName(), anItem.getLastname(),
                anItem.getCT1(), anItem.getCT2(), anItem.getCT3(), anItem.getModuleMark() );
        System.out.println(TextColours.TEXT_CYAN + OutputHelper.repeat("-",96) + TextColours.TEXT_RESET);
    }

    /**
     *
     *
     * Goes through all the Nodes of type Student Marks in the BST and display the student ID and the module mark value on the console, as a chart, through recursion
     *
     * @param root the current Node of the tree that is being displayed through recursion
     */

    public void displayStudentScoreInChart(Node<StudentMarks> root){
        if (root.leftNode != null) {
            displayStudentScoreInChart(root.leftNode);
        }
        System.out.format(TextColours.TEXT_BLUE + "| %-11s | %-100s \n" + TextColours.TEXT_RESET, root.getNodeData().getStudentID(), OutputHelper.repeat("*", root.getNodeData().getModuleMark()));
        if (root.rightNode != null) {
            displayStudentScoreInChart(root.rightNode);
        }
    }

    /**
     *
     *
     * Display the final chart of the module mark value of all Nodes of type Student Marks in the BST on the console.
     *
     * @param theBST the Binary Search Tree
     */

    public void displayAsChart(BinarySearchTree<StudentMarks> theBST){
        System.out.println(TextColours.TEXT_CYAN + OutputHelper.repeat("-",37) + TextColours.TEXT_RESET);
        displayStudentScoreInChart(theBST.getRoot());
        StringBuilder lastLine1 = new StringBuilder(TextColours.TEXT_CYAN + OutputHelper.repeat("-", 16));
        StringBuilder lastLine2 = new StringBuilder(TextColours.TEXT_CYAN + OutputHelper.repeat(" ", 17));
        for (int i = 1; i <= 107; i++) {
            if (i == 1)
            {
                lastLine1.append("1");
            }
            if ((i + 1)% 10 == 0)
            {
                if ((i+1) != 100)
                {
                    lastLine1.append((i + 1)/10);
                }
                else
                {
                    lastLine1.append("1");
                }
                lastLine2.append("0");
            }
            else
            {
                lastLine1.append("-");
                lastLine2.append(" ");
            }
        }
        System.out.println(lastLine1);
        System.out.println(lastLine2);
        System.out.println(TextColours.TEXT_CYAN + OutputHelper.repeat(" ", 115) + "0" + TextColours.TEXT_RESET);
    }
}
