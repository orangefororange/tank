package demo;

import java.awt.*;

/**
 * @author spiltMilk
 * @date 2022/5/22
 */
public class Tank {
    //初始位置
    private int x = 200, y = 200;
    //方向
    private Direction direction = Direction.UP;
    //大小
    private int width=50,height=50;
    private boolean moving=false;
    private static final int SPEED = 10;

    public Tank(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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
        g.fillRect(x, y, this.width, this.height);
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
    }
}
