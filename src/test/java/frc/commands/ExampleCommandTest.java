package frc.commands;
import static org.junit.Assert.*;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import frc.robot.Constants.exampleSubsystem_Constants;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;

import org.junit.*;


/** Add your docs here. */
public class ExampleCommandTest {
    ExampleCommand exampleCommand;
    ExampleSubsystem subsystem;
    Encoder encoder;
    EncoderSim encoderSim; //Use this to drive encoder Value
    Spark motor;
   

    @Before // this method will run before each test
    public void setup() {
       assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
       encoder = new Encoder(exampleSubsystem_Constants.encoderA,
                                exampleSubsystem_Constants.encoderB);
       encoderSim = new EncoderSim(encoder);
       motor = new Spark(exampleSubsystem_Constants.MOTOR_PWM);
       subsystem = new ExampleSubsystem(encoder,motor); // create our ExampleSubsystem.
       
    }
 
    @After // this method will run after each test
    public void shutdown() throws Exception {
       // exampleSubsystem.close(); // destroy our exampleSubsystem object
       encoder.close();
       motor.close();
    }

    @Test // Is Initialized
    public void isInitialized(){
        exampleCommand = new ExampleCommand(2.0, 0.5, subsystem); // create our exampleCommand.
        exampleCommand.initialize();
    }

    @Test // is finished is false
    public void is_Finnished(){
        encoderSim.setDistance(0.0);
        exampleCommand = new ExampleCommand(2.0, 0.5, subsystem); // create our exampleCommand.
        assertEquals(exampleCommand.isFinished(), false);
        encoderSim.setDistance(2.0);
        exampleCommand = new ExampleCommand(2.0, 0.5, subsystem); // create our exampleCommand.
        assertEquals(exampleCommand.isFinished(), false);
        encoderSim.setDistance(3.0);
        exampleCommand = new ExampleCommand(2.0, 0.5, subsystem); // create our exampleCommand.
        assertEquals(exampleCommand.isFinished(), true);
        encoderSim.setDistance(-2.0);
        exampleCommand = new ExampleCommand(2.0, 0.5, subsystem); // create our exampleCommand.
        assertEquals(exampleCommand.isFinished(), false);
        encoderSim.setDistance(-3.0);
        exampleCommand = new ExampleCommand(2.0, 0.5, subsystem); // create our exampleCommand.
        assertEquals(exampleCommand.isFinished(), true);

    }

    @Test
    public void motorSpeed(){
        encoderSim.setDistance(0.0);
        exampleCommand = new ExampleCommand(2.0, 0.5, subsystem); // create our exampleCommand.
        exampleCommand.execute();
        assertEquals(0.5, motor.get(),0.0);
        exampleCommand.end(false);
        assertEquals(0.0, motor.get(),0.0);
        //Apply over 100% test that its clamps to %100
        exampleCommand = new ExampleCommand(2.0, 2, subsystem); // create our exampleCommand.
        exampleCommand.execute();
        assertEquals(1.0, motor.get(),0.0);
        exampleCommand.end(false);
        assertEquals(0.0, motor.get(),0.0);
    }

}
