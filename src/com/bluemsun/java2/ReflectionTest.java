package com.bluemsun.java2;

import com.bluemsun.java.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void testField() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        //获取指定的属性
        Object p = (Person)clazz.newInstance();
        //要求属性为public
        Field id = clazz.getField("id");
        id.set(p,1);
        int pId = (int)id.get(p);
        System.out.println(pId);
    }
    @Test
    public void testField1() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;
        //获取指定的属性
        Person p = (Person)clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"贺嘉");
        String na = (String )name.get(p);
        System.out.println(na);
    }
    @Test
    public void testMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz =Person.class;
        Person p =(Person)clazz.newInstance();
//        参数1 知名获取方法的名称， 参数2：指明获取方法的形参列表
        Method show=clazz.getDeclaredMethod("show",String.class);
        show.setAccessible(true);
//        传实参
        show.invoke(p,"CHN");
        Object returnValue =show.invoke(p,"ChN");
        System.out.println(returnValue);
//        调用静态方法
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        showDesc.invoke(Person.class);
    }
   @Test
    public void testConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
       Class clazz = Class.forName("com.bluemsun.java.Person");
       Constructor constructor = clazz.getDeclaredConstructor(String.class);
       constructor.setAccessible(true);
       Person per=(Person)constructor.newInstance("Tom");
       System.out.println(per);
   }
}
