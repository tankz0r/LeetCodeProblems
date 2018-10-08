package org.stepic.java.ROBOT;

public class module1 {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean flag = false;
        for (int i = 1; (!flag)&(i <= 3); i++) {
            try (RobotConnection rb = robotConnectionManager.getConnection()) {
                rb.moveRobotTo(toX, toY);
                flag = true;
            }
            catch (RobotConnectionException e) {}
        }
        if (!flag)
            throw new RobotConnectionException("abort");
    }
}
