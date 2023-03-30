package helpers;

/**
 * The OutputHelper class, which provides helpful
 * functionality for repetition of a single character on the console
 *
 */

public class OutputHelper {

    /**
     *
     *
     * Creates a String of a character repeated a certain amount of times
     *
     *
     * @param character the character that will be repeated
     * @param times the number of times the character will be repeated
     * @return the String that will be returned from the repeated character
     */

    public static final String repeat(String character, int times){
        String theText = "";
        for(int num = 0; num < times; num++){
            theText += character;
        }
        return theText;
    }
}
