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
        isCollisionTop = isCollision(player.getX(), player.getY());
        isCollisionBottom = isCollision(player.getX() + player.getWidth() / 2, player.getY() + player.getHeight());
        isCollisionMove = isCollision(player.getX() + player.getWidth() * 4 / 5, player.getY() + 48);
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
        updateCollision();
        moveDown();
        if (keyH.upPressed && !jumping && isCollisionBottom) {
//            player.setDirection("up");
            jumping = true;
            initialY = player.getY();
            jumpingHeight = initialY - player.getJumpingDistance();
        } else if (keyH.leftPressed) {
//            player.setX(player.getX() + player.getSpeedX());
            player.moveLeft();
            moveNext();
        } else if (keyH.rightPressed) {
            player.moveRight();
            moveNext();
        }

        if (jumping) {
            player.setY(player.getY() - player.getSpeedY());

            System.out.println(jumpingHeight);
            if (player.getY() <= jumpingHeight || isCollisionTop) {
                jumping = false;
            }
        }

        timer--;

        if (timer <= 0) {
            player.setImage();
            timer = 10;
        }
    }

    private void moveNext() {
        if (!isCollisionMove) {
            player.setX(player.getX() + player.getSpeedX());
        }
    }

    private void moveDown() {
        if (!jumping && !isCollisionBottom) {
            player.setY(player.getY() + player.getSpeedY());
        }
    }
}
