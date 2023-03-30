package daos;

import datastructures.Node;
import model.StudentMarks;

import java.io.FileWriter;

/**
 * An abstract Data Access Object class
 * which specifies the functionality required
 * to interact with a data store and implemented
 * in concrete subclasses
 */
public abstract class DAO<E> {

    /**
     *
     *
     * Loads an information about the tasks in the linked list from a txt file in csv format
     *
     * @param filename the name of the txt file the tasks are loaded from
     */

    public abstract void loadFromFile(String filename);

    /**
     *
     *
     * Writes the information about the tasks from the BST into a txt file in csv format
     *
     * @param filename the name of the file that the tasks from the linked list are going to be stored
     */

    public abstract void writeToFile(String filename);

    /**
     *
     *
     * Adds a new StudentMarks object to the linked list
     *
     * @param theData the StudentMarks object that is being added
     */

    public abstract void add(E theData);


    /**
     *
     *
     * Search for a StudentMarks object in the BST and if it is found, displays it
     *
     * @param theData the StudentMarks object that is being searched for
     */
    public abstract void findData(int theData);

    /**
     *
     *
     * Remove a StudentMarks from the BST on a given mark module value, if it exists
     *
     * @param theData the StudentMarks object that is being removed
     */
    public abstract void removeData(int theData);
}