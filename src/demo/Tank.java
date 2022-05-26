package demo;

import java.awt.*;
import java.util.Random;

/**
 * @author spiltMilk
 * @date 2022/5/22
 */
public class Tank {
    /**
     * 坦克宽度
     */
    public static int WIDTH = ResourceMgr.tankU.getWidth();
    /**
     * 坦克高度
     */
    public static int HEIGHT = ResourceMgr.tankU.getHeight();
    private boolean living=true;
    //初始位置
    private int x = 200, y = 200;
    //方向
    private Direction direction = Direction.UP;
    //大小
    private int width=50,height=50;
    private TankFrame tf;
    private boolean moving=true;
    private static final int SPEED = 3;
    private Random random=new Random();
    private Group group=Group.BAD;

    public Tank(int x, int y, Direction direction,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tf=tf;
        this.group=group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g){
        if(!living) tf.tanks.remove(this);
        switch (direction){
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            default:
                break;
        }

        this.move();

    }

    private void move(){
        if(!moving) return;
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

        if(random.nextInt(10)>8) this.fire();
    }

    public void fire() {
        int bx=this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
        int by=this.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bx,by,direction,this.group,this.tf));
    }

    public void die() {
        this.living=false;
    }
}
