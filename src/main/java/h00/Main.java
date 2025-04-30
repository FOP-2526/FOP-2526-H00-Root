package h00;

import fopbot.Robot;
import fopbot.World;

/**
 * Main entry point in executing the program.
 */
public class Main {

    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {



        System.out.println("Hello World!");

        World.setVisible(true);

        Robot r = new Robot(1,2);
        r.move();
        r.putCoin();



        World.setVisible(false);

    }
}
