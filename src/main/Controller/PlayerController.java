package main.Controller;

import main.Model.Map;
import main.Model.Tiles.Tile;
import main.Model.entity.Player;

public class PlayerController {

    Player player;
    KeyHandler keyH;

    Map map;
    private int initialY;
    private int jumpingHeight = 0;
    private int timer = 10;

    private boolean isCollisionTop = false,
            isCollisionBottom = false,
            isCollisionMove = false;

    private boolean isCollision(int x, int y) {
        Tile tile = map.getTile(x, y);
        if (tile == null) return false;
        return tile.isCollision();
    }

    ;

    private void updateCollision() {
        int vector = Math.abs(player.getX()),
//                right = Math.abs(player.getX() + player.getWidth()),
                bottom = player.getY(),
                top = Math.abs(player.getY() + player.getHeight());

//        if (direction == )

//        isCollisionBottom = isCollision(right, bottom);
//        isCollisionTop = isCollision(right, top);
//        isCollisionRight = isCollisionTop
    }

    public PlayerController(Player player, KeyHandler keyH, Map map) {
        this.player = player;
        this.keyH = keyH;
        this.map = map;
    }

    public void update() {
        moving();
    }

    private boolean jumping = false;

    private void moving() {
        moveDown();
        if (keyH.upPressed && !jumping) {
            player.setDirection("up");
            jumping = true;
            initialY = player.getY();
            jumpingHeight = initialY - player.getJumpingDistance();
        } else if (keyH.leftPressed) {
            moveLeft();
        } else if (keyH.rightPressed) {
            moveRight();
        }

        if (jumping) {
            player.setY(player.getY() - player.getSpeedY());

            Tile tile = map.getTile((int) player.getX(), (int) player.getY());
            boolean collision = false;
            if (tile != null) {
                collision = tile.isCollision();
            }

            if (player.getY() <= jumpingHeight) {
                player.setSpeedY(-player.getSpeedY());
            }

            if (player.getY() >= initialY || collision) {
                player.setY(initialY);
                jumping = false;
                player.setSpeedY(-player.getSpeedY());
            }

        }

        timer--;

        if (timer <= 0) {
//            player.spriteNumber = (player.spriteNumber) % 2 + 1;
            timer = 10;

//            switch (player.getDirection()) {
//                case "up":
//                    if (player.spriteNumber == 1) {
//                        player.setImageSrc(player.getUp1());
//                    } else {
//                        player.setImageSrc(player.getUp2());
//                    }
//                    break;
//                case "down":
//                    if (player.spriteNumber == 1) {
//                        player.setImageSrc(player.getDown1());
//                    } else {
//                        player.setImageSrc(player.getDown2());
//                    }
//                    break;
//                case "left":
//                    if (player.spriteNumber == 1) {
//                        player.setImageSrc(player.getLeft1());
//                    } else {
//                        player.setImageSrc(player.getLeft2());
//                    }
//                    break;
//                case "right":
//                    if (player.spriteNumber == 1) {
//                        player.setImageSrc(player.getRight1());
//                    } else {
//                        player.setImageSrc(player.getRight2());
//                    }
//                    break;
            }
        }
    }

    private void moveRight() {
        player.setDirection("right");
        player.setX(player.getX() + player.getSpeedX());
    }

    private void moveLeft() {
        player.setDirection("left");
        player.setX(player.getX() - player.getSpeedX());
    }

    private void moveDown() {
        Tile tile = map.getTile((int) player.getX(), (int) player.getY());
        if (!jumping && tile == null) {
            player.setY(player.getY() + player.getSpeedY());
            return;
        }
        if (!jumping && !tile.isCollision()) {
            player.setY(player.getY() + player.getSpeedY());
        }
    }
}
