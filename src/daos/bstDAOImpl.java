package daos;

import app.StudentMarksBST;
import datastructures.BinarySearchTree;
import datastructures.Node;
import helpers.OutputHelper;
import helpers.Sorts;
import helpers.TextColours;
import model.DisplayOrder;
import model.StudentMarks;
import view.aView;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of the abstract Data Access Object class
 * which specifies the functionality required
 * to interact with a data store and implemented
 * in concrete subclasses
 */

public class bstDAOImpl<E> extends DAO<E>{

    private BinarySearchTree<StudentMarks> theBST;
    private aView theView;
    public static final char DELIMITER = ',';
    public static final char EOLN='\n';
    public static final String QUOTE="\"";
    public static final String USERDIRECTORY = System.getProperty("user.dir");

    /**
     *
     *
     * Default constructor for the bstDAO object
     *
     */

    public bstDAOImpl() {
        this.theBST = new BinarySearchTree<>();
        this.theView = new aView();
    }


    /**
     *
     *
     * Getter for Binary Search Tree
     *
     * @return the Binary Search Tree
     */

    public BinarySearchTree<StudentMarks> getTheBST()
    {
        return theBST;
    }

    /**
     *
     *
     * Setter for Binary Search Tree
     *
     * @param theBST the Binary Search Tree
     */

    public void setTheBST(BinarySearchTree<StudentMarks> theBST) {
        this.theBST = theBST;
    }

    /**
     *
     *
     * Loads an information about the tasks in the linked list from a txt file in csv format
     *
     * @param filename the name of the txt file the tasks are loaded from
     */

    @Override
    public void loadFromFile(String filename) {
        String transactionFile = USERDIRECTORY +"\\" + filename;
        ArrayList<StudentMarks> dataSet = new ArrayList<>();
        Sorts<StudentMarks> sort = new Sorts<>();

        try (BufferedReader br = new BufferedReader(new FileReader(transactionFile))) {
            String studentId;
            String givenName;
            String lastName;
            int CT1;
            int CT2;
            int CT3;
            int moduleMark;

            String[] temp;
            String line = br.readLine();
            while(line!=null){
                temp=line.split(Character.toString(DELIMITER));
                studentId = temp[0];
                givenName = temp[1];
                lastName = temp[2];
                CT1 = Integer.parseInt(temp[3]);
                CT2 = Integer.parseInt(temp[4]);
                CT3 = Integer.parseInt(temp[5]);
                moduleMark = Integer.parseInt(temp[6]);

                StudentMarks anEntry = new StudentMarks(studentId, givenName, lastName, CT1, CT2, CT3, moduleMark);
                anEntry.calculateModuleMark();
                dataSet.add(anEntry);
                line = br.readLine();

            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(StudentMarksBST.class.getName()).log(Level.INFO, null, ex);
        }

        sort.BSort3(dataSet);
        this.theBST.createBalancedTree(dataSet,0, dataSet.size() - 1);
    }

    /**
     *
     *
     * Writes the information about the tasks from the BST into a txt file in csv format
     *
     * @param filename the name of the file that the tasks from the linked list are going to be stored
     */

    @Override
    public void writeToFile(String filename) {
        String transactionFile = USERDIRECTORY +"\\" + filename;
        Node<StudentMarks> root = theBST.getRoot();

        try {
            File myFile = new File(transactionFile);

            if(myFile.exists()){
                myFile.delete();
            }
            else if (myFile.createNewFile()) {
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myFile = new File(transactionFile);
            FileWriter myWriter = new FileWriter(myFile.getName(), true);
            if (root.leftNode != null) {
                writeItem(root.leftNode,myWriter);
            }

            myWriter.write(root.getNodeData().CSVFormat());

            if (root.rightNode != null) {
                writeItem(root.rightNode,myWriter);
            }
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     *
     *
     * Adds a new StudentMarks object to the linked list
     *
     * @param theData the StudentMarks object that is being added
     */

    @Override
    public void add(E theData) {
        this.theBST.addNode((StudentMarks) theData);
        writeToFile("ClassTestData.txt");
    }

    /**
     *
     *
     * Search for a StudentMarks object in the BST and if it is found, displays it
     *
     * @param theData the StudentMarks object that is being searched for
     */

    @Override
    public void findData(int theData) {
        StudentMarks dataToFind = new StudentMarks("","","",0,0,0, theData);
        StudentMarks found = theBST.findItem(dataToFind);

        if (found != null)
        {
            this.theView.displayABSTItem(found);
        }
        else
        {
            System.out.format(TextColours.TEXT_RED + "The entry %s was not found!\n", theData);
        }
    }

    /**
     *
     *
     * Remove a StudentMarks from the BST on a given mark module value, if it exists
     *
     * @param theData the StudentMarks object that is being removed
     */

    @Override
    public void removeData(int theData) {
        StudentMarks dataToFind = new StudentMarks("","","",0,0,0, theData);
        StudentMarks found = theBST.findItem(dataToFind);

        if(found != null){
            this.theBST.deleteNode(found);
            System.out.format("The entry below has been %s from the tree!\n", TextColours.TEXT_RED + "deleted" + TextColours.TEXT_RESET);
            this.theView.displayABSTItem(found);
        }
        else{
            System.out.format(TextColours.TEXT_RED + "The entry %s was not found!\n", theData);
        }
        writeToFile("ClassTestData.txt");
    }


    /**
     *
     *
     * Display the Binary Search Tree on the console
     *
     * @param order the order in which the BST will be displayed - Ascending or descending
     */

    public void displayBST(DisplayOrder order){
        this.theView.displayBST(this.theBST, order);
    }

    /**
     *
     *
     * Display the final chart of the module mark value of all Nodes of type Student Marks in the BST on the console.
     *
     */

    public void displayBSTChart(){
        this.theView.displayAsChart(theBST);
    }

    /**
     *
     * Helper method for the writeToFile function
     *
     * @param myWriter FileWriter object
     * @param root the specified current root of the BST
     */

    private void writeItem(Node<StudentMarks> root, FileWriter myWriter) throws IOException {
        if (root.leftNode != null) {
            writeItem(root.leftNode, myWriter);
        }

        myWriter.write(root.getNodeData().CSVFormat());

        if (root.rightNode != null) {
            writeItem(root.rightNode, myWriter);
        }
    }

    /**
     *
     * Displays the minimum and maximum values of the module marks in the BST on the console
     *
     */

    public void displayMinimumAndMaximumValue()
    {
        System.out.format(TextColours.TEXT_BLUE + "| %-18s | %-18s | %-18s | %-3s | %-3s | %-3s | %11s |\n" + TextColours.TEXT_RESET, "Student ID", "Given Name", "Surname", "CT1", "CT2", "CT3", "Module Mark");
        System.out.println(TextColours.TEXT_CYAN + OutputHelper.repeat("-", 96) + TextColours.TEXT_RESET);
        getMinimumValue(theBST.getRoot());
        getMaximumValue(theBST.getRoot());
    }

    /**
     *
     * Finds the minimum value of the module marks in the BST and prints it on the console
     *
     * @param root the specified current root of the BST
     */

    public void getMinimumValue(Node<StudentMarks> root)
    {
        if (root.leftNode != null) {
            getMinimumValue(root.leftNode);
        }
        else {
            System.out.format(TextColours.TEXT_YELLOW + "| %-18s | %-18s | %-18s | %3d | %3d | %3d | %11d |\n" + TextColours.TEXT_RESET, root.getNodeData().getStudentID(), root.getNodeData().getGivenName(), root.getNodeData().getLastname(),
                    root.getNodeData().getCT1(), root.getNodeData().getCT2(), root.getNodeData().getCT3(), root.getNodeData().getModuleMark());
        }
    }

    /**
     *
     * Finds the maximum value of the module marks in the BST and prints it on the console
     *
     * @param root the specified current root of the BST
     */

    public void getMaximumValue(Node<StudentMarks> root)
    {
        if (root.rightNode != null) {
            getMaximumValue(root.rightNode);
        }
        else {
            System.out.format(TextColours.TEXT_YELLOW + "| %-18s | %-18s | %-18s | %3d | %3d | %3d | %11d |\n" + TextColours.TEXT_RESET, root.getNodeData().getStudentID(), root.getNodeData().getGivenName(), root.getNodeData().getLastname(),
                    root.getNodeData().getCT1(), root.getNodeData().getCT2(), root.getNodeData().getCT3(), root.getNodeData().getModuleMark());
        }
    }
}
