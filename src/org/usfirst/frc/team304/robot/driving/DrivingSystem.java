package org.usfirst.frc.team304.robot.driving;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

public class DrivingSystem {
	private Victor leftFrontVictor, leftRearVictor, rightFrontVictor,
			rightRearVictor;
	private RobotDrive driver;

	public final static double DRIVE_SLOWLY = 0.23;
	public final static double ROTATE_SLOWLY = 0.3;
	public final static double DRIVE_NORMAL = 0.6;
	
	public DrivingSystem(Victor lfVictor, Victor lrVictor, Victor rfVictor,
			Victor rrVictor) {
		leftFrontVictor = lfVictor;
		leftRearVictor = lrVictor;
		rightFrontVictor = rfVictor;
		rightRearVictor = rrVictor;
		driver = new RobotDrive(leftFrontVictor, leftRearVictor,
				rightFrontVictor, rightRearVictor);
		// inverting right motors
		this.driver.setInvertedMotor(MotorType.kFrontRight, true);
		this.driver.setInvertedMotor(MotorType.kRearRight, true);
	}
	
	public DrivingSystem(int lfVictor, int lrVictor, int rfVictor,
			int rrVictor) {
		leftFrontVictor = new Victor(lfVictor);
		leftRearVictor = new Victor(lrVictor);
		rightFrontVictor = new Victor(rfVictor);
		rightRearVictor = new Victor(rrVictor);
		driver = new RobotDrive(leftFrontVictor, leftRearVictor,
				rightFrontVictor, rightRearVictor);
		// inverting right motors
		this.driver.setInvertedMotor(MotorType.kFrontRight, true);
		this.driver.setInvertedMotor(MotorType.kRearRight, true);
	}
	
	public Victor getLeftFrontVictor() {
		return leftFrontVictor;
	}

	public Victor getLeftRearVictor() {
		return leftRearVictor;
	}

	public Victor getRightFrontVictor() {
		return rightFrontVictor;
	}

	public Victor getRightRearVictor() {
		return rightRearVictor;
	}

	public RobotDrive getDriver() {
		return driver;
	}

	public void driveSet(double leftFront, double leftRear, double rightFront,
			double rightRear) {
		leftFrontVictor.set(leftFront);
		leftRearVictor.set(leftRear);
		rightFrontVictor.set(rightFront);
		rightRearVictor.set(rightRear);
	}

	public void driveForwardSlowly(double speed) {
		driveSet(speed, speed, -speed, -speed);
	}

	public void stop() {
		driveSet(0, 0, 0, 0);
	}

	public void rotateRightSlowly(double speed) {
		driveSet(0, 0, -speed, -speed);
	}

	public void rotateLeftSlowly(double speed) {
		driveSet(speed, speed, 0, 0);
	}

	public void driveForward(double speed) {
		driveSet(speed, speed, -speed, -speed);
	}

	public void driveBackwardSlowly(double speed) {
		driveSet(-speed, -speed, speed, speed);
	}

	public void driveBackward(double speed) {
		driveSet(-speed, -speed, speed, speed);
	}

	public void driveLeft(double speed) {
		driveSet(-speed, speed, -speed, speed);
	}

	public void driveRight(double speed) {
		driveSet(speed, -speed, speed, -speed);
	}

	public void driveSlowlyLeft(double speed) {
		driveSet(-speed, speed, -speed, speed);
	}

	public void driveSlowlyRight(double speed) {
		driveSet(speed, -speed, speed, -speed);
	}

	public void driveDirectly(double magnitude, double direction,
			double rotation) {
		driver.mecanumDrive_Polar(magnitude, direction, rotation);
	}
}