package main.View;

import main.Model.entity.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PlayerRenderer {

    Player player;

    public PlayerRenderer(Player player) {
        this.player = player;
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(player.getImageSrc()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g2.setColor(Color.red);
        g2.drawOval(player.getX(), player.getY(), 5, 5);
//        g2.drawOval((player.getX() + player.getSize()), player.getY(), 5, 5);
        g2.drawOval(player.getX() + player.getWidth() - 16, player.getY() + player.getHeight() - 16, 5, 5);
        g2.drawImage(image, player.getX(), player.getY(), player.getWidth(), player.getHeight(), null);
    }
}
