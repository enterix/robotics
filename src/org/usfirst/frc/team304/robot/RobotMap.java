package org.usfirst.frc.team304.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int joystick = 0;
	
	public static int lfVictor = 1;
	public static int rfVictor = 5;
	public static int lrVictor = 3;
	public static int rrVictor = 7;
	
	public static int liftingLeft = 2;
	public static int liftingRigth = 4;
	
	public static int photoIn = 5;
	public static int photoLeftIn = 1;
	public static int photoRightIn = 9;
	public static int switchLeftIn = 3;
	public static int switchRightIn = 7;
	public static int lifterSensor = 0;
}
