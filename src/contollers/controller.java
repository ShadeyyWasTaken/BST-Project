package contollers;

import daos.bstDAOImpl;
import helpers.InputHelper;
import helpers.OutputHelper;
import helpers.TextColours;
import model.DisplayOrder;
import model.StudentMarks;


public class controller {
    private bstDAOImpl<StudentMarks> bstDAO;
    private final InputHelper inputHelper;

    /**
     *
     *
     * Default constructor for the Controller object
     *
     */

    public controller() {
        this.bstDAO = new bstDAOImpl<>();
        this.inputHelper = new InputHelper();
    }

    /**
     * Displays the menu and uses an InputHelper object
     * to accept valid user choice.
     * An appropriate private method is called to implement the choice.
     */
    public void run() {
        boolean finished = false;

        int iChoice;
        this.setup();

        do {
            theMenu();
            iChoice = inputHelper.readInt(TextColours.TEXT_YELLOW + "Enter choice" + TextColours.TEXT_RESET, 8,1);
            switch (iChoice) {
                case 1:
                    this.findModuleMark();
                    System.out.println();
                    break;
                case 2:
                    this.addModuleMark();
                    System.out.println();
                    break;
                case 3:
                    this.deleteModuleMark();
                    System.out.println();
                    break;
                case 4:
                    this.displayModuleMark(DisplayOrder.ASCENDING);
                    System.out.println();
                    break;
                case 5:
                    this.displayModuleMark(DisplayOrder.DESCENDING);
                    System.out.println();
                    break;
                case 6:
                    this.displayAsChart();
                    System.out.println();
                    break;
                case 7:
                    this.displayMinimumAndMaximumValues();
                    break;
                case 8:
                    System.out.println(TextColours.TEXT_GREEN + "Thank you for using the application, have a nice day!" + TextColours.TEXT_RESET);
                    finished = true;
                    break;
                default: // invalid option
                    System.out.println(TextColours.TEXT_RED + "Oops! Something has went wrong!" + TextColours.TEXT_RESET);
                    break;
            }
        }while(!finished);
    }

    /**
     *
     *
     * Display the basic menu functions on the Console
     *
     */

    private void theMenu() {
        System.out.println(TextColours.TEXT_YELLOW + "Choose an option!");
        System.out.println("-----------------------"  + TextColours.TEXT_RESET);
        System.out.println(TextColours.TEXT_PURPLE + "1: Find a Module Mark" + TextColours.TEXT_RESET);
        System.out.println(TextColours.TEXT_CYAN + "2: Add a Module Mark" + TextColours.TEXT_RESET);
        System.out.println(TextColours.TEXT_BLUE + "3: Delete a Module Mark" + TextColours.TEXT_RESET);
        System.out.println(TextColours.TEXT_GREEN + "4: Display Module Marks in Ascending Order" + TextColours.TEXT_RESET);
        System.out.println(TextColours.TEXT_GREEN + "5: Display Module Marks in Descending Order" + TextColours.TEXT_RESET);
        System.out.println(TextColours.TEXT_GREEN + "6: Display Module Marks as a Chart View" + TextColours.TEXT_RESET);
        System.out.println(TextColours.TEXT_GREEN + "7: Display Lowest and Highest Module Marks" + TextColours.TEXT_RESET);
        System.out.println(TextColours.TEXT_RED + "8: Exit" + TextColours.TEXT_RESET);
        System.out.println();
    }

    /**
     *
     *
     * Displays a welcoming message to the user and loads the ClassTestData file
     *
     */

    private void setup(){
        System.out.println(TextColours.TEXT_YELLOW + "Welcome to the application!\n" + TextColours.TEXT_RESET);
        this.bstDAO.loadFromFile("ClassTestData.txt");
    }

    /**
     *
     *
     * Searches for StudentMarks object in the BST and if it finds it, then prints it
     *
     *
     */

    private void findModuleMark() {
        System.out.println();
        System.out.println(TextColours.TEXT_GREEN + "Find a Module Mark\n");
        int moduleMark = inputHelper.readInt(TextColours.TEXT_YELLOW + "Please enter the module mark to find" + TextColours.TEXT_RESET);
        System.out.println();
        this.bstDAO.findData(moduleMark);
    }

    /**
     *
     *
     * Adds a StudentMarks object from the BST
     *
     *
     */

    private void deleteModuleMark() {
        System.out.println();
        System.out.println(TextColours.TEXT_GREEN +"Delete a Module Mark\n");
        int moduleMark = inputHelper.readInt(TextColours.TEXT_YELLOW + "Please enter the module mark to find" + TextColours.TEXT_RESET);
        System.out.println();
        this.bstDAO.removeData(moduleMark);
    }

    /**
     *
     *
     * Adds a new StudentMarks object in the BST
     *
     *
     */

    private void addModuleMark() {
        System.out.println();
        System.out.println(TextColours.TEXT_GREEN +"Add a Module Mark\n" + TextColours.TEXT_RESET);
        String studentId;
        String givenName;
        String lastName;
        while(true)
        {
            studentId = inputHelper.readString(TextColours.TEXT_YELLOW + "Please enter the student id to add" + TextColours.TEXT_RESET);
            if (studentId.length() > 0)
            {
                break;
            }
            else
            {
                System.out.println(TextColours.TEXT_RED + "Student id cannot be empty field!\n" + TextColours.TEXT_RESET);
            }
        }
        while(true)
        {
            givenName = inputHelper.readString(TextColours.TEXT_YELLOW + "Please enter the given name to add" + TextColours.TEXT_RESET);
            if (givenName.length() > 0)
            {
                break;
            }
            else
            {
                System.out.println(TextColours.TEXT_RED + "Given name cannot be empty field!\n" + TextColours.TEXT_RESET);
            }
        }
        while(true)
        {
            lastName = inputHelper.readString(TextColours.TEXT_YELLOW + "Please enter the student last name to add" + TextColours.TEXT_RESET);
            if (lastName.length() > 0)
            {
                break;
            }
            else
            {
                System.out.println(TextColours.TEXT_RED + "Last name cannot be empty field!\n" + TextColours.TEXT_RESET);
            }
        }
        int CT1 = inputHelper.readInt(TextColours.TEXT_YELLOW + "Please enter the mark from the first test to add" + TextColours.TEXT_RESET);
        int CT2 = inputHelper.readInt(TextColours.TEXT_YELLOW + "Please enter the mark from the second test to add" + TextColours.TEXT_RESET);
        int CT3 = inputHelper.readInt(TextColours.TEXT_YELLOW + "Please enter the mark from the third test to add" + TextColours.TEXT_RESET);
        StudentMarks student = new StudentMarks(studentId, givenName, lastName, CT1, CT2, CT3, 0);
        student.calculateModuleMark();
        this.bstDAO.add(student);
    }

    /**
     *
     *
     * Display the Binary Search Tree on the console
     *
     * @param order the order in which the BST will be displayed - Ascending or descending
     */

    private void displayModuleMark(DisplayOrder order) {
        System.out.println();
        System.out.format(TextColours.TEXT_GREEN + "Display Module Marks in %s order\n" + TextColours.TEXT_RESET, order.toString() );
        this.bstDAO.displayBST(order);
    }

    /**
     *
     *
     * Display the final chart of the module mark value of all Nodes of type Student Marks in the BST on the console.
     *
     */

    private void displayAsChart() {
        System.out.println();
        System.out.println(TextColours.TEXT_GREEN + "Display Module Marks as a Chart View" + TextColours.TEXT_RESET);
        this.bstDAO.displayBSTChart();
    }

    /**
     *
     * Displays the minimum and maximum values of the module marks in the BST on the console
     *
     */

    private void displayMinimumAndMaximumValues()
    {
        System.out.println();
        System.out.println(TextColours.TEXT_GREEN + "Display Lowest and Highest Module Marks" + TextColours.TEXT_RESET);
        System.out.println(TextColours.TEXT_CYAN + OutputHelper.repeat("-", 96) + TextColours.TEXT_RESET);
        bstDAO.displayMinimumAndMaximumValue();
        System.out.println(TextColours.TEXT_CYAN + OutputHelper.repeat("-", 96) + TextColours.TEXT_RESET);
        System.out.println();
    }

}
