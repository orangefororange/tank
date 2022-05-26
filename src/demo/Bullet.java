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
    private boolean living = true;
    private TankFrame tf;
    private Group group=Group.BAD;

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

    public Bullet(int x, int y, Direction direction, Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tf = tf;
        this.group=group;
    }


    public void paint(Graphics g) {
        if (!living) {
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
        if (x < 0 || y < 0 || x > tf.GAME_WIDTH || y > tf.GAME_HEIGHT) living = false;
    }

    public void collideWith(Tank tank){
        if(this.group==tank.getGroup())return;
        //todo 用一个rect记录子弹的位置
        Rectangle rect1=new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rect2=new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if(rect1.intersects(rect2)){
            tank.die();
            this.die();
            tf.explodes.add(new Explode(x,y,tf));
        }

    }

    private void die() {
        this.living =false;
    }

}
