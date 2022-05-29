package demo;

import java.io.IOException;
import java.util.Properties;

/**
 * @author spiltMilk
 * @date 2022/5/26
 */
public class PropertyMgr {
    static Properties props=new Properties();
    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  Object get(String key){
        if(props==null) return null;
        return  props.get(key);
    }

    public static int getInt(String key){
        String s = (String)get(key);
        if(s== null) return 0;
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}
