package org.usfirst.frc.team304.robot.data;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	public double getLiftingUpSlider() {
		return SmartDashboard.getNumber("DB/Slider 0") / 5;
	}

	public double getLiftingDownSlider() {
		return SmartDashboard.getNumber("DB/Slider 1") / 5;
	}

	public double getKeepHeightSlider() {
		return SmartDashboard.getNumber("DB/Slider 2") / 5;
	}

	public void print(int n, String s) {
		SmartDashboard.putString("DB/String " + n, s);
	}
}
