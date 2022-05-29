package demo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author spiltMilk
 * @date 2022/5/26
 * @description 资源管理者
 */
public class ResourceMgr {
    public static BufferedImage goodTankU, goodTankD, goodTankL, goodTankR;
    public static BufferedImage badTankU, badTankD, badTankL, badTankR;
    public static  BufferedImage bulletU,bulletD,bulletL,bulletR;
    public static BufferedImage[] explodes=new BufferedImage[16];

    static {
        try {
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankD = ImageUtil.rotateImage(goodTankU,180);
            goodTankL = ImageUtil.rotateImage(goodTankU,-90);
            goodTankR =ImageUtil.rotateImage(goodTankU,90);
            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankD = ImageUtil.rotateImage(badTankU,180);
            badTankL = ImageUtil.rotateImage(badTankU,-90);
            badTankR =ImageUtil.rotateImage(badTankU,90);
            bulletU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletD= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletL= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            for (int i = 0; i < explodes.length; i++) {
                explodes[i]= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
