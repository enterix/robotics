package org.usfirst.frc.team304.robot.data;

import edu.wpi.first.wpilibj.Joystick;

public class DataPreprocessor {
	private Joystick controller;
	private Sensors sensors;

	public DataPreprocessor(Joystick controller, Sensors sensors) {
		this.controller = controller;
		this.sensors = sensors;
	}

	public boolean isLiftingUpPressed() {
		return controller.getRawButton(5);
	}

	public boolean isLiftingDownPressed() {
		return controller.getRawButton(6);
	}

	public boolean isAutoParkingPressed() {
		return controller.getRawButton(8);
	}

	public boolean isForwardPressed() {
		return controller.getRawButton(4);
	}

	public boolean isBackwardPressed() {
		return controller.getRawButton(1);
	}

	public boolean isLeftPressed() {
		return controller.getRawButton(3);
	}

	public boolean isRightPressed() {
		return controller.getRawButton(2);
	}

	public double getMagnitude() {
		return controller.getMagnitude();
	}

	public double getDirection() {
		return controller.getDirectionDegrees();
	}

	public double getRotation() {
		double rotationLeft = -controller.getRawAxis(2);
		double rotationRight = controller.getRawAxis(3);
		return (Math.abs(rotationLeft) > 0.1) ? rotationLeft : rotationRight;
	}

	public boolean isKeepHeightPressed() {
		return controller.getRawButton(7);
	}

	public boolean isBoxVisible() {
		return !sensors.getPhotoInValue();
	}

	public boolean leftSideSees() {
		return !sensors.getPhotoLeftInValue();
	}

	public boolean rightSideSees() {
		return !sensors.getPhotoRightInValue();
	}

	public boolean sideSensorsNotSee() {
		return !leftSideSees() && !rightSideSees();
	}

	public boolean areBothSensorsTouched() {
		return !sensors.getSwitchRightInValue()
				&& !sensors.getSwitchLeftInValue();
	}

	public boolean isLeftSensorTouched() {
		return !sensors.getSwitchLeftInValue();
	}

	public boolean isRightSensorTouched() {
		return !sensors.getSwitchRightInValue();
	}

	public boolean seesLifter() {
		return !sensors.getLifterSensorValue();
	}
}
