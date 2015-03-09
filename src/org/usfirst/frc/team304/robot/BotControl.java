package org.usfirst.frc.team304.robot;

import org.usfirst.frc.team304.robot.data.DataPreprocessor;
import org.usfirst.frc.team304.robot.driving.DrivingBot;
import org.usfirst.frc.team304.robot.lifting.LiftingBot;

public class BotControl {
	private LiftingBot lift;
	private DrivingBot driver;
	private DataPreprocessor data;
	
	public BotControl(DrivingBot driver, LiftingBot lift, DataPreprocessor data) {
		this.lift = lift;
		this.driver = driver;
		this.data = data;
	}
	
	public void teleop() {
		
	}
}