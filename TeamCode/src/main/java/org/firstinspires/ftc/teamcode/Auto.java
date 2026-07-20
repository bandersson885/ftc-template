package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Best Auto")
public class Auto extends LinearOpMode {
    public double ticksPerInch = 0;
    public double ticksPerDegree = 0;
    public Hardware robot;

    //When you press init
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Hardware(hardwareMap);
        robot.init();
        //Waits for u to press start button
        waitForStart();

        robot.left.setPower(0.6);
        robot.right.setPower(0.6);
        sleep(1000); //Waiting one second

        robot.left.setPower(0);
        robot.right.setPower(0);

        robot.closeClaw();

        //turn
        turnLeft(0.6, 500);
    }
    public void turnLeft(double power, long duration) {
        robot.left.setPower(-power);
        robot.right.setPower(power);
        sleep(duration);
    }

    public void turnRight(double power, long duration) {
        robot.left.setPower(power);
        robot.right.setPower(-power);
        sleep(duration);
        robot.left.setPower(0);
        robot.right.setPower(0);
    }

    public void forward(double power, long duration) {
        robot.left.setPower(power);
        robot.right.setPower(power);
        sleep(duration);
        robot.left.setPower(0);
        robot.right.setPower(0);
    }

    public void forwardEncoder(double power, double inches) {
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches * ticksPerInch);

        robot.left.setTargetPosition(ticks);
        robot.right.setTargetPosition(ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);

    }

    public void turnLeftEncoder(double power, double degrees) {
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (degrees * ticksPerDegree);

        robot.left.setTargetPosition(ticks);
        robot.right.setTargetPosition(-ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);

    }

    public void turnRightEncoder(double power, double degrees) {
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (degrees * ticksPerDegree);

        robot.left.setTargetPosition(-ticks);
        robot.right.setTargetPosition(ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);

    }

}
