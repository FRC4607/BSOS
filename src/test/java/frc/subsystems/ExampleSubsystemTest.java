package frc.subsystems;

import static org.junit.Assert.*;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import frc.robot.subsystems.ExampleSubsystem;
import org.junit.*;

public class ExampleSubsystemTest {
    private double delta = 1e-5;

    ExampleSubsystem exampleSubsystem;
    Encoder encoder;
    EncoderSim encoderSim;

    @Before // this method will run before each test
    public void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed

        exampleSubsystem = new ExampleSubsystem(true); // create our ExampleSubsystem.

        encoderSim = exampleSubsystem.mEncoderSim;
    }

    @After // this method will run after each test
    public void shutdown() throws Exception {
        // exampleSubsystem.close(); // destroy our exampleSubsystem object
        exampleSubsystem.close();
    }

    @Test // marks this method as a test
    public void hello_World() {
        System.out.print("Hello ");
        assertEquals("World", exampleSubsystem.helloWorld("World"));
    }

    @Test // Checks that Capsensitive fails if not Equal
    public void NOT_Hello_World() {
        System.out.print("Hello ");
        assertNotEquals("World", exampleSubsystem.helloWorld("world"));
    }

    @Test
    public void encoderTest() {
        encoderSim.setDistance(5);
        assertEquals(5.0, exampleSubsystem.getDistance_Inch(), delta);
    }
}
