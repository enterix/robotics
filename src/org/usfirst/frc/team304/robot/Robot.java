package org.usfirst.frc.team304.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team304.robot.data.Sensors;
import org.usfirst.frc.team304.robot.systems.DrivingSystem;
import org.usfirst.frc.team304.robot.systems.LiftingSystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	PeriodicTester tester;
	DrivingSystem base;
	LiftingSystem lifter;
	Sensors sense;

	Joystick controller;

	RobotAI driver;

	public void robotInit() {
		base = new DrivingSystem(RobotMap.lfVictor, RobotMap.lrVictor,
				RobotMap.rfVictor, RobotMap.rrVictor);

		lifter = new LiftingSystem(RobotMap.liftingLeft, RobotMap.liftingRigth);

		sense = new Sensors(RobotMap.photoIn, RobotMap.photoLeftIn,
				RobotMap.photoRightIn, RobotMap.switchLeftIn,
				RobotMap.switchRightIn, RobotMap.lifterSensor,
				RobotMap.joystick);

		tester = new PeriodicTester(sense);
		driver = new RobotAI(sense, base, lifter);
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		driver.go();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();

		tester.toTest();
	}

}