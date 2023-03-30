package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The InputHelper class, which provides helpful
 * functionality for easy processing of the input of the user
 *
 * @author mga
 */
public class InputHelper {
    private final Scanner reader;

    /**
     *
     *
     * Default constructor for the InputHelper object
     *
     */
    public InputHelper() {
        reader = new Scanner(System.in);
    }


    /**
     *
     *
     * Read Character from the user
     *
     *
     * @param prompt the user input String
     * @return the character from the user input
     */
    public char readCharacter(String prompt) {
        System.out.println(prompt + ": ");
        char inputText = reader.nextLine().charAt(0);
        return inputText;
    }

    /**
     *
     *
     * Read Character from the user from a set of valid values
     *
     *
     * @param prompt the user input String
     * @param validCharacters the set of valid characters that the user can input
     * @return the character from the user input
     */

    public char readCharacter(String prompt, String validCharacters) {
        char inputText;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");
            inputText = reader.nextLine().toUpperCase().charAt(0);
            if (validCharacters.indexOf(inputText) == -1) {
                inputError = true;
                System.out.println("Character out of range: please re-enter: ");
            }
        } while (inputError);
        return inputText;
    }

    /**
     *
     *
     * Read String from the user
     *
     *
     * @param prompt the user input String
     * @return the String from the user input
     */
    public String readString(String prompt) {

        System.out.println(prompt + ": ");
        String inputText = reader.nextLine();
        return inputText;
    }

    // Read Int

    /**
     *
     *
     * Read Integer from the user, between minimum and maximum value
     *
     *
     * @param prompt the user input String
     * @param max the maximum value of the integer
     * @param min the minimum value of the integer
     * @return the integer from the user input
     */

    public int readInt(String prompt, int max, int min) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
                if (inputNumber < min || inputNumber > max) {
                    inputError = true;
                    System.out.println("Number out of range: please re-enter\n");
                }
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    /**
     *
     *
     * Read Integer from the user
     *
     *
     * @param prompt the user input String
     * @return the integer from the user input
     */
    public int readInt(String prompt) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }


    /**
     *
     *
     * Read float number from the user
     *
     *
     * @param prompt the user input String
     * @return the double value from the user input
     */
    public double readDouble(String prompt) {
        double inputNumber = 0.0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Double.parseDouble(reader.nextLine());
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    /**
     *
     *
     * Read Date from the user
     *
     *
     * @param prompt the user input String
     * @param format the format of the date
     * @return the character from the user input
     */
    public Calendar readDate(String prompt, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = readString("Enter date yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException ex) {
            Logger.getLogger(InputHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
