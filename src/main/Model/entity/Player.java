package main.Model.entity;

import main.Controller.KeyHandler;
import main.View.Screen;

public class Player extends Entity {

    Screen screen;
    KeyHandler keyH;

    public Player(KeyHandler keyH) {
        this.keyH = keyH;

        setDefaultValues();
    }

    private String up1;
    private String up2;
    private String right1;
    private String right2;
    private String left1;
    private String left2;
    private String down1;
    private String down2;

    public String getUp1() {
        return up1;
    }

    public void setDefaultValues() {
        super.setDefaultValues();
//        size = 64;
        up1 = "/res/player/run/B_witch_run_1.png";
        up2 = "/res/player/run/B_witch_run_2.png";
        right1 = "/res/player/run/B_witch_run_3.png";
        right2 = "/res/player/run/B_witch_run_4.png";
        left1 = "/res/player/run/B_witch_run_5.png";
        left2 = "/res/player/run/B_witch_run_6.png";
        down1 = "/res/player/run/B_witch_run_7.png";
        down2 = "/res/player/run/B_witch_run_8.png";
        imageSrc = down1;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getJumpingDistance() {
        return jumpingDistance;
    }

    public void setJumpingDistance(int jumpingDistance) {
        this.jumpingDistance = jumpingDistance;
    }

    public String getUp2() {
        return up2;
    }

    public String getRight1() {
        return right1;
    }

    public String getRight2() {
        return right2;
    }

    public String getLeft1() {
        return left1;
    }

    public String getLeft2() {
        return left2;
    }

    public String getDown1() {
        return down1;
    }

    public String getDown2() {
        return down2;
    }
}
