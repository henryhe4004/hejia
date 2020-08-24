package com.bluemsun.java;

import java.io.Serializable;

public class Creature <T>implements Serializable {
    private char gender;
    public double weight;
    private void breath(){
        System.out.println("生物呼吸");
    }
    private void eat(){
        System.out.println("生物吃东西");
    }
}
