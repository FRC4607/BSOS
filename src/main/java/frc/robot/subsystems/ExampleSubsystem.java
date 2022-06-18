// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.exampleSubsystem_Constants;

public class ExampleSubsystem extends SubsystemBase{
  /** Creates a new ExampleSubsystem. */
  private Encoder m_encoder;
  
  public ExampleSubsystem() {
    m_encoder = new Encoder(exampleSubsystem_Constants.encoderA,
                            exampleSubsystem_Constants.encoderB);
    
  }
  public ExampleSubsystem(Encoder encoder) {
    m_encoder = encoder;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public String helloWorld(String string){
    System.out.println(string);
    return string;
  }

public double getDistance_Inch() {
  System.out.println("Encoder Distance = " + m_encoder.getDistance());
    return m_encoder.getDistance();
}


}
