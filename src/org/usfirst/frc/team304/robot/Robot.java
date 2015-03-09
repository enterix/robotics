package org.usfirst.frc.team304.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team304.robot.data.Dashboard;
import org.usfirst.frc.team304.robot.data.DataPreprocessor;
import org.usfirst.frc.team304.robot.data.SensorSystem;
import org.usfirst.frc.team304.robot.driving.DrivingBot;
import org.usfirst.frc.team304.robot.driving.DrivingSystem;
import org.usfirst.frc.team304.robot.lifting.LiftingBot;
import org.usfirst.frc.team304.robot.lifting.LiftingSystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	PeriodicTester tester;
	DataPreprocessor data;
	
	ManualControl manual;
	BotControl bot;

	@Override
	public void robotInit() {
		DrivingSystem base = new DrivingSystem(RobotMap.lfVictor,
				RobotMap.lrVictor, RobotMap.rfVictor, RobotMap.rrVictor);

		LiftingSystem lifter = new LiftingSystem(RobotMap.liftingLeft,
				RobotMap.liftingRigth);

		SensorSystem sense = new SensorSystem(RobotMap.photoIn,
				RobotMap.photoLeftIn, RobotMap.photoRightIn,
				RobotMap.switchLeftIn, RobotMap.switchRightIn,
				RobotMap.lifterSensor);
		
		Dashboard dashboard = new Dashboard();
		
		Joystick controller = new Joystick(0);
		
		data = new DataPreprocessor(controller, sense, dashboard);
		
		DrivingBot dBot = new DrivingBot(base);
		
		LiftingBot lBot = new LiftingBot(lifter);
		
		manual = new ManualControl(dBot, lBot, data);
		bot = new BotControl(dBot, lBot, data);
	}

	@Override
	public void teleopPeriodic() {
		if (isBot())
			bot.teleop();
		else
			manual.teleop();
	}

	@Override
	public void testInit() {
		tester = new PeriodicTester(data);
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();

		tester.toTest();
	}
	
	public boolean isBot() {
		return false;
	}

}