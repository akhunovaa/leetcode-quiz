package enumm;

import easy.ClassA;
import easy.ClassB;

public class ClassD {

    public static void main(String[] args) {

        System.out.println("ClassD");

        ClassA.testStatic();
        ClassB.testStatic();

        ClassA classA = new ClassA();
        ClassB classB = new ClassB();

        classA.testStatic();
        classB.testStatic();

        ClassA classC = new ClassB();
        ((ClassB)classC).testStatic();
//
//        ClassA classF = new ClassB();
//        ((ClassB)classF).testStatic();


    }
}
