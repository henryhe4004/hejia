import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    @Test
    public void test1(){
        Person p1 =new Person(12,"12");
    }
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;
        //反射构造对象
        Constructor constructor = clazz.getConstructor(int.class, String.class);
        Object obj = constructor.newInstance(12,"tom");
        Person p =(Person) obj;
        System.out.println(obj.toString());
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
        //通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person p1 =(Person)declaredConstructor.newInstance(12,"123");
        System.out.println(p1);

    }
    @Test
    public void test3() throws ClassNotFoundException {
        //调用运行时类的属性
        Class clazz1 =Person.class;
        System.out.println(clazz1);
        //方式2 ：通过运行时类的对象，调用getClass
        Person p1 = new Person();
        Class aClass = p1.getClass();
        System.out.println(aClass);
        //方式3：调用Class的静态方法：forName（String classPath）
        Class clazz3 = Class.forName("Person");
        System.out.println(clazz3);
        System.out.println(clazz3==clazz1);
//        方式4 使用类的加载器

    }
}
