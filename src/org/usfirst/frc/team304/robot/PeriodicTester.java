package org.usfirst.frc.team304.robot;

import org.usfirst.frc.team304.robot.data.DataPreprocessor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PeriodicTester {
	private DataPreprocessor data;
	
	public PeriodicTester(DataPreprocessor data) {
		this.data = data;
	}

	public void toTest() {
		print(0, getAxesDebugString());
		print(1, getButtonDebugString());
		print(2, "Axes #: " + data.getController().getAxisCount());

		print(3, "PhotoL: " + data.getSensors().getPhotoLeftInValue());
		print(4, "PhotoR: " + data.getSensors().getPhotoRightInValue());
		print(5, "Lifter: " + data.getSensors().getLifterSensorValue());

		print(6, "Photo: " + data.getSensors().getPhotoInValue());
		print(8, "SwitchRight: " + data.getSensors().getSwitchRightInValue());
		print(9, "SwitchLeft: " + data.getSensors().getSwitchLeftInValue());
	}

	private String getAxesDebugString() {
		String stixk = "Axes: ";

		for (int x = 0; x < 12; x++) { // maximum number of axes is 12
			double val = data.getController().getRawAxis(x);

			stixk = stixk + (Math.abs(val) > 0.1 ? "1" : "0");
		}

		return stixk;
	}

	private String getButtonDebugString() {
		String buttonDebug = "Buttons: ";
		for (int x = 1; x < 12; x++)
			buttonDebug = buttonDebug + ((data.getController().getRawButton(x)) ? 1 : 0);

		return buttonDebug;
	}

	private void print(int lineNumber, String text) {
		SmartDashboard.putString("DB/String " + lineNumber, text);
	}
}