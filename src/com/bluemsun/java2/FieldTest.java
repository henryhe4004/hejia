package com.bluemsun.java2;

import com.bluemsun.java.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {
    @Test
    public void test1(){
        //getFields（）获取当前运行时类及其父类中声明public访问权限的属性
        Class clazz = Person.class;
//        Field[] fields = clazz.getFields();
//        for(Field f:fields){
//            System.out.println(f);
//        }
        //获取当前运行时类声明的所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f :declaredFields){
            System.out.println(f);
        }
    }
    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f :declaredFields) {
            //权限修饰符
            int modifiers = f.getModifiers();//权限分配成了数
            System.out.println(Modifier.toString(modifiers)+"\t");
            //数据类型
            Class<?> type = f.getType();
            System.out.println(type+"\t");
            //变量名
            String name = f.getName();
            System.out.println(name);
        }
    }
}
