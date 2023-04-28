package main.Model.entity;

import java.awt.image.BufferedImage;

public abstract class Entity {

    private int x, y, speedX, speedY;
//    int size = 48;
    private int width, height;
    NodeImage image;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNumber = 1;
    int jumpingDistance;

    protected class NodeImage {
        BufferedImage image;
        NodeImage prevNode;
        NodeImage nextNode;

        public NodeImage(BufferedImage image) {
            this.image = image;
        }
    }

    public BufferedImage getImage() {
        return image.image;
    }

    public void setImage() {
        this.image = image.nextNode;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

//    public String getDirection() {
//        return direction;
//    }
//
//    public void setDirection(String direction) {
//        this.direction = direction;
//        if (speedX > 0 && width < 0) {
//            width *= -1;
//        }
//        if (speedX < 0 && width > 0) {
//            width *= -1;
//        }
//    }

    public void moveRight() {
        if (speedX < 0) {
            speedX *= -1;
        }
        if (width < 0) {
            width *= -1;
            x -= width;
        }
    }

    public void moveLeft() {
        if (speedX > 0) {
            speedX *= -1;
        }
        if (width > 0) {
            width *= -1;
            x -= width;
        }
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public int getSpriteNumber() {
        return spriteNumber;
    }

    public void setSpriteNumber(int spriteNumber) {
        this.spriteNumber = spriteNumber;
    }

    public void setDefaultValues() {
        width = 48;
        height = 64;
        x = 0;
        y = 0;
        speedX = 4;
        speedY = 3;
        direction = "down";
        jumpingDistance = 64;
    }


    //    Rectangle rec = new Rectangle(x, y, size, size);

    @Override
    public String toString() {
        return String.format("x = %d; y = %d; direction = %s; speedX = %d; speedy = %d", x, y, direction,speedX, speedY);
    }
}
