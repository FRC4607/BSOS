package frc.subsystems;
import static org.junit.Assert.*;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.simulation.PWMSim;
import frc.robot.Constants.exampleSubsystem_Constants;
import frc.robot.subsystems.ExampleSubsystem;
import org.junit.*;

public class ExampleSubsystemTest {
   ExampleSubsystem exampleSubsystem;
   Encoder encoder;
   EncoderSim encoderSim;
   Spark spark;
   PWMSim sparkSim;

   @Before // this method will run before each test
   public void setup() {
      assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
      encoder = new Encoder(exampleSubsystem_Constants.encoderA,
                              exampleSubsystem_Constants.encoderB);
      encoderSim = new EncoderSim(encoder);
      spark = new Spark(exampleSubsystem_Constants.MOTOR_PWM);
      exampleSubsystem = new ExampleSubsystem(encoder,spark); // create our ExampleSubsystem.
   }

   @After // this method will run after each test
   public void shutdown() throws Exception {
      // exampleSubsystem.close(); // destroy our exampleSubsystem object
      encoder.close();
      spark.close();
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
}
