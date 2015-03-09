package org.usfirst.frc.team304.robot;

import org.usfirst.frc.team304.robot.data.DataPreprocessor;
import org.usfirst.frc.team304.robot.driving.DrivingSystem;
import org.usfirst.frc.team304.robot.lifting.LiftingSystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManualControl {
	private DrivingSystem driver;
	private LiftingSystem lift;
	private DataPreprocessor data;
	private boolean keepHeightMarker = false;
	
	public ManualControl(DrivingSystem driver, LiftingSystem lift, DataPreprocessor data) {
		this.driver = driver;
		this.lift = lift;
		this.data = data;
	}
	
	public void teleop() {
		printDebug();
		
		lift();
		drive();
	}

	public void printDebug() {
		data.getDashboard().print(0, "PhotoL: " + data.getSensors().getPhotoLeftInValue());
		data.getDashboard().print(1,
				"PhotoR: " + data.getSensors().getPhotoRightInValue());
		data.getDashboard().print(2,
				"Lifter: " + data.getSensors().getLifterSensorValue());
	}
	
	public void autoPark() {
		if (!sense.seesLifter()) {
			lifter.liftUp();
			keepHeightMarker = false;
		} else {
			keepHeightMarker = true;
			lifter.keepSameHeight();

			if (!sense.isBoxVisible()) {
				base.driveForwardSlowly();
			} else {
				base.stop();

				if (sense.sideSensorsNotSee()) {
					if (sense.areBothSensorsTouched()) {
						// lifting
					} else if (sense.isLeftSensorTouched()) {
						base.rotateRightSlowly();
					} else if (sense.isRightSensorTouched()) {
						base.rotateLeftSlowly();
					} else {
						base.driveForwardSlowly();
					}
				} else { // if both sensors see it we approach
					if (sense.leftSideSees()) {
						base.driveSlowlyLeft();
					} else if (sense.rightSideSees()) {
						base.driveSlowlyRight();
					}
				}
			}
		}
	}

	public void lift() {
		if (sense.isKeepHeightPressed()) { // and if up or down pressed -
											// interrupt
			keepHeightMarker = true;
		}

		if (sense.isLiftingUpPressed()) {
			if (!sense.getLifterSensorValue()) {
				keepHeightMarker = false;
				lifter.liftUp();
			} else {
				lifter.stop();
			}
		} else if (sense.isLiftingDownPressed()) {
			keepHeightMarker = false;
			lifter.liftDown();
		} else if (keepHeightMarker) {
			lifter.keepSameHeight(); // add encoders, if box moves down -
										// move it up
		} else {
			lifter.stop();
		}
	}

	public void drive() {
		if (sense.isAutoParkingPressed()) {
			autoPark();
		} else if (sense.isForwardPressed()) {
			base.driveForward();
		} else if (sense.isBackwardPressed()) {
			base.driveBackward();
		} else if (sense.isLeftPressed()) {
			base.driveLeft();
		} else if (sense.isRightPressed()) {
			base.driveRight();
		} else {
			base.driveDirectly(Math.pow(sense.getMagnitude(), 2),
					sense.getDirection(), Math.pow(sense.getRotation(), 3));
		}
	}
}
