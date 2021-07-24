package model;

import controller.NumberGenerator;

public class Main {

    public static void main(String[] args) {
        NumberGenerator numberGenerator=new NumberGenerator();
        System.out.println(numberGenerator.number("  -0.0+0.00i"));


    }
}
