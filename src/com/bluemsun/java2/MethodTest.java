package com.bluemsun.java2;

import com.bluemsun.java.Person;
import org.junit.Test;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class MethodTest {
    @Test
    public  void test1(){
        Class clazz = Person.class;
        Method[] methods = clazz.getMethods();
        //获取当前运行时类及其所有父类中声明为public权限的方法
        for (Method m :methods){
           System.out.println(m);
        }
        //获取当前运行时类中声明的所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method mm:methods){
            System.out.println(mm);
        }
    }
    @Test
    public void test2(){
        Class clazz =Person.class;
        //获取当前运行时类中为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c :constructors){
            System.out.println(constructors);
        }
        //获取当前声明类所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println(declaredConstructors);
        }
    }
    @Test
    public void test3(){
        Class clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
        //带泛型
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }
}
