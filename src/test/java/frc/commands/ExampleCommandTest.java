package frc.commands;
import static org.junit.Assert.*;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;

import org.junit.*;


/** Add your docs here. */
public class ExampleCommandTest {
    ExampleCommand exampleCommand;
    ExampleSubsystem subsystem;
    Encoder encoder;
    EncoderSim encoderSim;

    @Before // this method will run before each test
    public void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed

        subsystem = new ExampleSubsystem(true); // create our ExampleSubsystem.
        
       encoderSim = subsystem.mEncoderSim;
       
    }
 
    @After // this method will run after each test
    public void shutdown() throws Exception {
       subsystem.close(); // destroy our exampleSubsystem object
    }

    @Test // Is Initilized
    public void isInitized(){
        exampleCommand = new ExampleCommand(2.0, subsystem); // create our exampleCommand.
        exampleCommand.initialize();
    }

    @Test // is finished is false
    public void is_Finnished(){
        encoderSim.setDistance(0.0);
        exampleCommand = new ExampleCommand(2.0, subsystem); // create our exampleCommand.
        assertEquals(exampleCommand.isFinished(), false);
        encoderSim.setDistance(2.0);
        exampleCommand = new ExampleCommand(2.0, subsystem); // create our exampleCommand.
        assertEquals(exampleCommand.isFinished(), false);
        encoderSim.setDistance(3.0);
        exampleCommand = new ExampleCommand(2.0, subsystem); // create our exampleCommand.
        assertEquals(exampleCommand.isFinished(), true);
        encoderSim.setDistance(-2.0);
        exampleCommand = new ExampleCommand(2.0, subsystem); // create our exampleCommand.
        assertEquals(exampleCommand.isFinished(), false);
        encoderSim.setDistance(-3.0);
        exampleCommand = new ExampleCommand(2.0, subsystem); // create our exampleCommand.
        assertEquals(exampleCommand.isFinished(), true);

    }

}
