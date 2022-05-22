package demo;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author spiltMilk
 * @date 2022/5/21
 */
public class TankFrame extends Frame {
    int x=200,y=200;
    boolean bU=false,bD=false,bL=false,bR=false;//判断方向
    public TankFrame() {
        this.setSize(800, 600);//设置大小，单位像素
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

    @Override
    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
    }

    class MyKeyListener extends KeyAdapter {
        //按下一个key
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode=e.getKeyCode();
            switch (keyCode){
                case  KeyEvent.VK_UP:
                    bU=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    break;
                case KeyEvent.VK_LEFT:
                    bL=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    break;
                default:
                    break;
            }
        }

        //ke抬起来
        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode=e.getKeyCode();
            switch (keyCode){
                case  KeyEvent.VK_UP:
                    bU=false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=false;
                    break;
                case KeyEvent.VK_LEFT:
                    bL=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=false;
                    break;
                default:
                    break;
            }
        }
    }
}
