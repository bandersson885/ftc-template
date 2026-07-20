package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    //192.168.43.1
    
    public DcMotor left;
    public DcMotor right;
    public Servo clawL;
    public Servo clawR;
    public DcMotor arm;

    public double clawRightClose = .063;
    public double clawRightOpen = .244;
    public double clawLeftClose = .978;
    public double clawLeftOpen = .774;

    public Hardware(HardwareMap hwMap) {
        //Drive motors
        left = hwMap.get(DcMotor.class, "lm");
        right = hwMap.get(DcMotor.class, "rm");

        arm = hwMap.get(DcMotor.class, "arm");
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Servos
        clawL = hwMap.get(Servo.class, "clawL");
        clawR = hwMap.get(Servo.class, "clawR");
    }

    public void init() {
        openClaw();
    }

    public void openClaw() {
        clawL.setPosition(clawLeftOpen);
        clawR.setPosition(clawRightOpen);
    }

    public void closeClaw() {
        clawL.setPosition(clawLeftClose);
        clawR.setPosition(clawRightClose);
    }

}