package org.usfirst.frc.team304.robot.systems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftingSystem {
	private Victor leftVictor;
	private Victor rightVictor;
	private final static double LIFT_DEFAULT = 0.5;

	public LiftingSystem(int leftVictor, int rightVictor) {
		this.leftVictor = new Victor(leftVictor);
		this.rightVictor = new Victor(rightVictor);
	}

	public double getKeepHeight() {
		return SmartDashboard.getNumber("DB/Slider 2") / 5;
	}

	public Victor getLeftVictor() {
		return leftVictor;
	}

	public Victor getRightVictor() {
		return rightVictor;
	}

	public LiftingSystem(Victor leftVictor, Victor rightVictor) {
		this.leftVictor = leftVictor;
		this.rightVictor = rightVictor;
	}

	public void liftUp() {
		leftVictor.set(getSpeedUp());
		rightVictor.set(getSpeedUp());
	}

	public void liftDown() {
		leftVictor.set(getSpeedDown());
		rightVictor.set(getSpeedDown());
	}

	public void keepSameHeight() {
		leftVictor.set(getKeepHeight());
		rightVictor.set(getKeepHeight());
	}

	private double getSpeedUp() {
		double speed = SmartDashboard.getNumber("DB/Slider 0") / 5;
		if (speed != 0) {
			return speed;
		} else {
			return LIFT_DEFAULT;
		}
	}

	private double getSpeedDown() {
		double speed = -SmartDashboard.getNumber("DB/Slider 1") / 5;
		if (speed != 0) {
			return speed;
		} else {
			return -LIFT_DEFAULT;
		}
	}

	public void stop() {
		leftVictor.set(0);
		rightVictor.set(0);
	}
}