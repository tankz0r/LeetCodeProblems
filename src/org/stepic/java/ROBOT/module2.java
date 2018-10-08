package org.stepic.java.ROBOT;

public class module2 {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.DOWN);
        moveRobot(robot, -10, 20);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            System.out.println("turnLeft()");
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            System.out.println("turnRight()");
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            System.out.println("StepForward()");
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        Direction trueDir;
        if (robot.getX() != toX) {
            if (robot.getX() > toX) trueDir = Direction.LEFT;
            else trueDir = Direction.RIGHT;

            while (robot.getDirection() != trueDir) {
                robot.turnLeft();
            }
            while (robot.getX() != toX) robot.stepForward();
        }

        if (robot.getY() != toY) {
            if (robot.getY() > toY) trueDir = Direction.DOWN;
            else trueDir = Direction.UP;

            while (robot.getDirection() != trueDir) {
                robot.turnLeft();
            }
            while (robot.getY() != toY) robot.stepForward();
        }
    }
}