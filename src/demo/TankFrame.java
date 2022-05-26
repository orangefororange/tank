package demo;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author spiltMilk
 * @date 2022/5/21
 */
public class TankFrame extends Frame {
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    Tank myTank = new Tank(200, 200, Direction.DOWN, this);
    List<Bullet> bullets = new ArrayList<>();
//    Bullet bullet = new Bullet(300, 300, Direction.DOWN);

    public TankFrame() {
        this.setSize(GAME_WIDTH, GAME_HEIGHT);//设置大小，单位像素
        this.setResizable(false);//改变大小
        this.setTitle("tank demo");//标题
        this.setVisible(true);//显示
        //键盘事件
        this.addKeyListener(new MyKeyListener());
        //添加监听器，监听关闭事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        //todo 写完修改，用iterator删除元素，这个方式，在移除子弹的瞬间会丢失一颗子弹的绘制，后续正常
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
    }

    class MyKeyListener extends KeyAdapter {
        boolean bU = false, bD = false, bL = false, bR = false;//判断方向

        //按下一个key
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        //key抬起来
        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                //ctrl键抬起 发射子弹
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bU && !bD && !bL && !bR) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bU) myTank.setDirection(Direction.UP);
                if (bD) myTank.setDirection(Direction.DOWN);
                if (bL) myTank.setDirection(Direction.LEFT);
                if (bR) myTank.setDirection(Direction.RIGHT);
            }
        }
    }
}
