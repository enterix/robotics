package org.usfirst.frc.team304.robot.data;

import edu.wpi.first.wpilibj.DigitalInput;

public class Sensors {
	private DigitalInput photoIn, photoLeftIn, photoRightIn, switchLeftIn,
			switchRightIn, lifterSensor;

	public Sensors(int photoIn, int photoLeftIn, int photoRightIn,
			int switchLeftIn, int switchRightIn, int lifterSensor,
			int controller) {
		this.photoIn = new DigitalInput(photoIn);
		this.photoLeftIn = new DigitalInput(photoLeftIn);
		this.photoRightIn = new DigitalInput(photoRightIn);
		this.switchRightIn = new DigitalInput(switchRightIn);
		this.switchLeftIn = new DigitalInput(switchLeftIn);
		this.lifterSensor = new DigitalInput(lifterSensor);
	}

	public Sensors(DigitalInput photoIn, DigitalInput photoLeftIn,
			DigitalInput photoRightIn, DigitalInput switchLeftIn,
			DigitalInput switchRightIn, DigitalInput lifterSensor) {
		this.photoIn = photoIn;
		this.photoLeftIn = photoLeftIn;
		this.photoRightIn = photoRightIn;
		this.switchRightIn = switchRightIn;
		this.switchLeftIn = switchLeftIn;
		this.lifterSensor = lifterSensor;
	}

	public DigitalInput getPhotoIn() {
		return photoIn;
	}

	public boolean getPhotoInValue() {
		return !photoIn.get();
	}

	public DigitalInput getSwitchLeftIn() {
		return switchLeftIn;
	}

	public boolean getSwitchLeftInValue() {
		return !switchLeftIn.get();
	}

	public DigitalInput getSwitchRightIn() {
		return switchRightIn;
	}

	public boolean getSwitchRightInValue() {
		return !switchRightIn.get();
	}

	public boolean getPhotoLeftInValue() {
		return !photoLeftIn.get();
	}

	public DigitalInput getPhotoLeftIn() {
		return photoLeftIn;
	}

	public DigitalInput getPhotoRightIn() {
		return photoRightIn;
	}

	public boolean getPhotoRightInValue() {
		return !photoRightIn.get();
	}

	public DigitalInput getLifterSensor() {
		return lifterSensor;
	}

	public boolean getLifterSensorValue() {
		return !lifterSensor.get();
	}
}