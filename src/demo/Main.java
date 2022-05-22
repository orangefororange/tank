package demo;

/**
 * @author spiltMilk
 * @date 2022/5/21
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        //刷新窗口
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
