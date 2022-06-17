import static org.junit.Assert.*;

import edu.wpi.first.hal.HAL;
import frc.robot.subsystems.ExampleSubsystem;
import org.junit.*;

public class ExampleSubsystemTest {
   ExampleSubsystem exampleSubsystem;

   @Before // this method will run before each test
   public void setup() {
      assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
      exampleSubsystem = new ExampleSubsystem(); // create our ExampleSubsystem.
   }

   @After // this method will run after each test
   public void shutdown() throws Exception {
      // exampleSubsystem.close(); // destroy our exampleSubsystem object
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
