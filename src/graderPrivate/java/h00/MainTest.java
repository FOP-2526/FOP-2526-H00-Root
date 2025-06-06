package h00;

import fopbot.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.assertions.Context;

import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.*;

@TestForSubmission
public class MainTest {

    @BeforeAll
    public static void setup() {
        Main.delay = 0;
        Main.isVisible = false;
    }

    @Test
    public void testConstructorCall() {
        call(() -> Main.main(new String[0]), emptyContext(), r -> "An exception occurred while invoking main method");

        Transition transition = World.getGlobalWorld().getTraces().getFirst().getTransitions().getFirst();

        assertEquals(1,
            transition.robot.getX(),
            emptyContext(),
            r -> "Robot was initialized with the wrong X coordinate");
        assertEquals(2,
            transition.robot.getY(),
            emptyContext(),
            r -> "Robot was initialized with the wrong Y coordinate");
        assertEquals(Direction.UP,
            transition.robot.getDirection(),
            emptyContext(),
            r -> "Robot was initialized with the wrong direction");
        assertEquals(5,
            transition.robot.getNumberOfCoins(),
            emptyContext(),
            r -> "Robot was initialized with the wrong number of coins");
        assertEquals(RobotFamily.SQUARE_GREEN,
            transition.robot.getRobotFamily(),
            emptyContext(),
            r -> "Robot was initialized with the wrong robot family");
    }
}
