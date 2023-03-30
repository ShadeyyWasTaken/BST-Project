package model;

/**
 * The StudentMarks class which consists of the personal student information and their grades
 *
 */


public class StudentMarks implements Comparable<StudentMarks>{
    private String studentId;
    private String givenName;
    private String lastName;
    private int CT1;
    private int CT2;
    private int CT3;
    private int moduleMark;

    /**
     *
     *
     * Default constructor for StudentMarks object
     *
     */

    public StudentMarks(){
        this.studentId = "";
        this.givenName = "";
        this.lastName = "";
        CT1 = 0;
        CT2 = 0;
        CT3 = 0;
        moduleMark = 0;
    }

    /**
     *
     *
     * Constructor for the StudentMarks object with
     * provided studentId , givenName, lastName(Surname) , Class Test 1, Class Test 2, Class Test 3 and moduleMark as parameters
     *
     * @param studentId the id of the student
     * @param givenName the first name of the student
     * @param lastName the last name of the student
     * @param CT1 the first class test
     * @param CT2 the second class test
     * @param CT3 the third and final class test
     * @param moduleMark the final module mark
     */

    public StudentMarks(String studentId, String givenName, String lastName, int CT1, int CT2, int CT3, int moduleMark){
        this.studentId = studentId;
        this.givenName = givenName;
        this.lastName = lastName;
        this.CT1 = CT1;
        this.CT2 = CT2;
        this.CT3 = CT3;
        this.moduleMark = moduleMark;
    }

    /**
     *
     *
     * Getter for the student id
     *
     * @return the student id
     */

    public String getStudentID() {
        return studentId;
    }

    /**
     *
     *
     * Setter for the student id
     *
     * @param studentID the student id
     */

    public void setStudentID(String studentID) {
        this.studentId = studentID;
    }

    /**
     *
     *
     * Getter for the given name
     *
     * @return the given name
     */

    public String getGivenName() {
        return givenName;
    }

    /**
     *
     *
     * Setter for the given name
     *
     * @param givenName the given name
     */

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     *
     *
     * Getter for the last name
     *
     * @return the last name
     */

    public String getLastname() {
        return lastName;
    }

    /**
     *
     *
     * Setter for the last name
     *
     * @param lastname the last name
     */

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    /**
     *
     *
     * Getter for the first class test
     *
     * @return the first class test
     */

    public int getCT1() {
        return CT1;
    }

    /**
     *
     *
     * Setter for the first class test
     *
     * @param CT1 the first class test
     */

    public void setCT1(int CT1) {
        this.CT1 = CT1;
    }

    /**
     *
     *
     * Getter for the second class test
     *
     * @return the second class test
     */

    public int getCT2() {
        return CT2;
    }

    /**
     *
     *
     * Setter for the second class test
     *
     * @param CT2 the second class test
     */

    public void setCT2(int CT2) {
        this.CT2 = CT2;
    }

    /**
     *
     *
     * Getter for the third class test
     *
     * @return the third class test
     */

    public int getCT3() {
        return CT3;
    }

    /**
     *
     *
     * Setter for the third class test
     *
     * @param CT3 the third class test
     */

    public void setCT3(int CT3) {
        this.CT3 = CT3;
    }

    /**
     *
     *
     * Getter for the final module mark
     *
     * @return the module mark
     */

    public int getModuleMark() {
        return moduleMark;
    }

    /**
     *
     *
     * Setter for the final module mark
     *
     * @param moduleMark  the module mark
     */

    public void setModuleMark(int moduleMark) {
        this.moduleMark = moduleMark;
    }

    /**
     *
     *
     * Calculates the final module mark based on the 3 class tests
     *
     *
     */

    public void calculateModuleMark(){
        moduleMark = (int)Math.round(((double)CT1 * 0.3) + ((double)CT2 * 0.3) + ((double)CT3 * 0.4));
        this.setModuleMark(moduleMark);
    }

    /**
     *
     *
     * Creates a String of csv format of the StudentMarks object
     *
     * @return String of the StudentMarks object in csv format
     */

    public String CSVFormat(){
        return this.studentId + "," + this.givenName + "," + this.lastName + "," +
                this.CT1 + "," + this.CT2 + "," + this.CT3 + "," + this.moduleMark + "\n";
    }

    /**
     *
     *
     * Standard toString function of the StudentMarks object
     *
     * @return String version of the stored data in the StudentMarks object
     */

    @Override
    public String toString() {
        return "StudentMarks{" +
                "studentId='" + studentId + '\'' +
                ", givenName='" + givenName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", CT1=" + CT1 +
                ", CT2=" + CT2 +
                ", CT3=" + CT3 +
                ", moduleMark=" + moduleMark +
                '}';
    }

    /**
     *
     *
     * Override method of the Comparable interface, that compares the moduleMark variable of two different StudentMarks objects
     *
     * @return 0 if the result of the comparison is equal, 1 if the result of the comparison is greater, -1 if the result of the comparison is less than
     */

    @Override
    public int compareTo(StudentMarks anEntry) {
        if(this.moduleMark == anEntry.getModuleMark()){
            return 0;
        }
        else{
            if(this.moduleMark > anEntry.getModuleMark()){
                return 1;
            }
            else {
                return -1;
            }
        }
    }
}
