package easy;

import enumm.TestC;

import java.io.FileNotFoundException;
import java.sql.SQLDataException;

public class TestAB {

    public static void main(String[] args) throws FileNotFoundException {
        B tests = new B();

        tests.testR("5");

        InterfaceR rad = new TestC();
        rad.testMethod(tests);
    }
}
