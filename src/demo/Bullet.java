package demo;

import java.awt.*;

/**
 * @author spiltMilk
 * @date 2022/5/22
 */
public class Bullet {
    private static final int SPEED = 10;
    /**
     * 子弹宽度
     */
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    /**
     * 子弹高度
     */
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private Direction direction;
    private int x, y;
    private boolean live = true;
    private TankFrame tf;

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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Bullet(int x, int y, Direction direction, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tf = tf;
    }


    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }
//        Color color = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x, y, this.WIDTH, this.HEIGHT);
//        g.setColor(color);
        switch (direction) {
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            default:
                break;
        }
        this.move();
    }


    private void move() {
        switch (direction) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > tf.GAME_WIDTH || y > tf.GAME_HEIGHT) live = false;
    }

}
