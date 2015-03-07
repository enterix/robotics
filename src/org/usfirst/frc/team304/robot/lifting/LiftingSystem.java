package org.usfirst.frc.team304.robot.lifting;

import edu.wpi.first.wpilibj.Victor;

public class LiftingSystem {
	private Victor leftVictor;
	private Victor rightVictor;
	public final static double LIFT_DEFAULT = 0.5;
	public final static double KEEP_HEIGHT_DEFAULT = 1.5;

	public LiftingSystem(int leftVictor, int rightVictor) {
		this.leftVictor = new Victor(leftVictor);
		this.rightVictor = new Victor(rightVictor);
	}
	
	public LiftingSystem(Victor leftVictor, Victor rightVictor) {
		this.leftVictor = leftVictor;
		this.rightVictor = rightVictor;
	}

	public Victor getLeftVictor() {
		return leftVictor;
	}

	public Victor getRightVictor() {
		return rightVictor;
	}

	public void liftUp(double speed) {
		leftVictor.set(speed);
		rightVictor.set(speed);
	}

	public void liftDown(double speed) {
		leftVictor.set(speed);
		rightVictor.set(speed);
	}

	public void keepSameHeight(double speed) {
		leftVictor.set(speed);
		rightVictor.set(speed);
	}

	public void stop() {
		leftVictor.set(0);
		rightVictor.set(0);
	}
}