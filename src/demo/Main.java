package demo;

/**
 * @author spiltMilk
 * @date 2022/5/21
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        //初始化地方坦克
        for(int i=0;i<5;i++){
            tankFrame.tanks.add(new Tank(50+i*60,200,Direction.DOWN,Group.BAD,tankFrame));
        }
        //刷新窗口
        while (true){
            Thread.sleep(25);
            tankFrame.repaint();
        }
    }
}
