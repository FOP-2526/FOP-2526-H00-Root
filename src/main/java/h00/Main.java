package h00;

import fopbot.*;

/**
 * Main entry point in executing the program.
 */
public class Main {

    /**
     * The subtask to run.
     */
    public static int runToSubtask = -1;

    /**
     * The world speed in milliseconds.
     */
    public static int delay = 300;


    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {

        // This sets up the FOPBot World with a 4x4 grid. (DO NOT TOUCH)
        setupWorld();

        // TODO: H0.1 - Initializing FOPBot and move
        Robot robot = new Robot(0,0, Direction.UP,4, RobotFamily.SQUARE_BLUE);
        robot.move();
        robot.putCoin();

    }


    public static void setupWorld() {
        // variable representing width/size of world
        final int worldSize = 4;

        // setting world size symmetrical, meaning height = width
        World.setSize(worldSize, worldSize);

        // speed of how fast the world gets refreshed (e.g. how fast the robot(s) act)
        // the lower the number, the faster the refresh
        World.setDelay(delay);

        // make it possible to see the world window
        World.setVisible(true);
    }
}
