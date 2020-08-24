import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader=ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //扩展类加载器;
        ClassLoader classLoader1=classLoader.getParent();
        System.out.println(classLoader1);
        //无法获取引导类加载器 ，主要加载核心类库 ，无法加载自定义类
        ClassLoader classLoader2 =classLoader1.getParent();
        System.out.println(classLoader2);
    }
    @Test
    //读取配置文件
    public void  test2() throws IOException {
        Properties pros = new Properties();
        //读取配置文件方式1 默认在module下
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);
        //classloader默认在src目录下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is =classLoader.getResourceAsStream("jdbc2.properties");
        pros.load(is);
        String user =pros.getProperty("user");
        String password =pros.getProperty("password");
        System.out.println("user = "+user+" password = "+password);
    }
}
