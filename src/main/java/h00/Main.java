package h00;

import fopbot.*;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;

/**
 * Main entry point in executing the program.
 */
public class Main {

    /**
     * The world speed in milliseconds.
     */
    @DoNotTouch
    public static int delay = 1000;

    /**
     * Whether the world is visible.
     */
    @DoNotTouch
    public static boolean isVisible = true;

    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {

        // This sets up the FOPBot World with a 4x4 grid. (DO NOT TOUCH)
        setupWorld();

        // TODO: H0.4 - Initializing FOPBot and move
        Robot robot = new Robot(1,2, Direction.UP,5, RobotFamily.SQUARE_GREEN);
        robot.move();
        robot.putCoin();
    }

    @DoNotTouch
    public static void setupWorld() {
        // variable representing width/size of world
        final int worldSize = 4;

        // setting world size symmetrical, meaning height = width
        World.setSize(worldSize, worldSize);

        // speed of how fast the world gets refreshed (e.g. how fast the robot(s) act)
        // the lower the number, the faster the refresh
        World.setDelay(delay);

        // make it possible to see the world window
        World.setVisible(isVisible);
    }
}
