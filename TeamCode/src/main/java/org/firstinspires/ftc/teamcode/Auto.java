package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Best Auto")
public class Auto extends LinearOpMode {
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
        robot.left.setPower(0);
        robot.right.setPower(0);
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

}
