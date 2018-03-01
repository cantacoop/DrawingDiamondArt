package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    // line count
    private int lineCount;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        // TODO -- add your code here

        // reset line count
        lineCount = 0;

        // Drawing top line
        drawingHorizontalLine(size);

        // Top section diamond
        drawingTopDiamond(size);

        // Drawing half diamond
        drawingHalfDiamond(size);

        // Bottom section diamond
        drawingBottomDiamond(size);

        // Drawing bottom line
        drawingHorizontalLine(size);
    }

    /**
     * Drawing horizontal line
     * @param size of diamond
     */
    private void drawingHorizontalLine(int size) {

        // update line count
        lineCount++;

        // calculate column size
        int colsSize = (size * 2) + 2;

        for (int i = 0; i < colsSize; i++) {

            if (i == 0) {
                mOut.print("+");
            } else if (i == colsSize - 1) {
                mOut.println("+");
            } else {
                mOut.print("-");
            }
        }
    }

    /**
     * Drawing top diamond
     * @param size of diamond
     */
    private void drawingTopDiamond(int size) {

        // Top section diamond
        for (int i  = 0; i < size - 1; i++) {

            // update line count
            lineCount++;

            // print left side
            mOut.print("|");

            // print spaces left side
            for (int j = 0; j < size - i - 1; j++) {
                mOut.print(" ");
            }
            mOut.print("/");

            // print inside
            for (int k = 0; k < i * 2; k++) {
                if (lineCount % 2 == 0) {
                    mOut.print("=");
                } else {
                    mOut.print("-");
                }
            }
            mOut.print("\\");

            // print spaces right side
            for (int l = 0; l < size - i - 1; l++) {
                mOut.print(" ");
            }
            mOut.println("|");
        }
    }

    /**
     * Drawing half diamond
     * @param size of diamond
     */
    private void drawingHalfDiamond(int size) {

        // update line count
        lineCount++;

        // print left side
        mOut.print("|");

        // calculate column size
        int colsSize = size * 2;

        for (int j = 0; j < colsSize; j++) {

            if (j == 0) { // print left angle bracket
                mOut.print("<");
            } else if (j == colsSize - 1) { // print right angle bracket
                mOut.print(">");
            } else {
                // calculate event or odd
                if (lineCount % 2 == 0) {
                    mOut.print("=");
                } else {
                    mOut.print("-");
                }
            }
        }

        // print right side
        mOut.println("|");
    }

    /**
     * Drawing bottom diamond
     * @param size of diamond
     */
    private void drawingBottomDiamond(int size) {

        // Top section diamond
        for (int i  = 0; i < size - 1; i++) {

            // update line count
            lineCount++;

            // print left side
            mOut.print("|");

            // print spaces left side
            for (int j = 0; j < i + 1; j++) {
                mOut.print(" ");
            }
            mOut.print("\\");

            int temp = size % 2 + i;

            // print inside
            for (int k = 0; k < (size * 2 - 4) - i * 2; k++) {

                if (lineCount % 2 == 0) {
                    mOut.print("=");
                } else {
                    mOut.print("-");
                }
            }
            mOut.print("/");

            // print spaces right side
            for (int l = 0; l < i + 1; l++) {
                mOut.print(" ");
            }
            mOut.println("|");
        }
    }
}
