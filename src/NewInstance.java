import org.junit.Test;

import java.util.Random;

public class NewInstance {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        Object o = clazz.newInstance();
        // newInstance() 调用此方法，创建对应的运行时类的对象
//        要想正常创建必须有无参构造器
//        空参构造器的访问权限的够。通常设置为public
//        综上 在javabean中最好要提供一个public的无参构造器 原因
//        1 便于通过反射2 继承便于super
        System.out.println(o);
    }
    @Test
    public void test2() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        int num = new Random().nextInt(2);
        String classPath="";
        switch(num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
        }
       Object o= getInstance(classPath);
        System.out.println(o);
    }
//    创建一个指定类的对象 classpath：指定类的全类名
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz =Class.forName(classPath);
        return  clazz.newInstance();
    }
}
