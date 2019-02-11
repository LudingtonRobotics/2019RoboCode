/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/*
PID Code for use with a Motor & Encoder
Written by: Conner Grant
Last change: February 9, 2019
*/
package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import  edu.wpi.first.wpilibj.PIDController;
//import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;

public class Robot extends TimedRobot  {

 
   
    double P = 0.0004;
    double I = 0;
    double D = 0;
    

    

 WPI_TalonSRX lift1 = new WPI_TalonSRX(5);
 WPI_TalonSRX lift2 = new WPI_TalonSRX(6);
 
 SpeedControllerGroup lift = new SpeedControllerGroup(lift1, lift2);

    Joystick leftJoy = new Joystick(1);
     Button button1 = new JoystickButton(leftJoy, 2);

CTREEncoder enc = new CTREEncoder(6);

 PIDController liftPID = new PIDController(P, I, D, enc, lift);


 

 // PlotThread

  @Override
  public void robotInit() {
  //  lift.set(ControlMode.PercentOutput,0);
    liftPID.reset();
    liftPID.setOutputRange(-0.5, 0.5);
    lift.setInverted(true);
    
  } 

 
  @Override
  public void robotPeriodic() {
  }

  
  @Override
  public void autonomousInit() {
 
  }

 
  @Override
  public void autonomousPeriodic() {
  
    
  }

  @Override
  public void teleopInit() {
    liftPID.reset();

   
  }
  @Override
  public void teleopPeriodic() {
      if(leftJoy.getRawButtonPressed(3)){
       
        liftPID.enable();
      
        liftPID.setSetpoint(-20000);

        
      
      
      }
      if(leftJoy.getRawButtonPressed(4)){
        liftPID.disable();
        
      }
    
        
      

      
      double distance = enc.pidGet();
      System.out.println(distance);


     

    }          
      
    
  
    
  

  @Override
  public void testPeriodic() {
  }
}
