package enumm;

import easy.A;
import easy.B;
import easy.InterfaceR;

public class TestC extends B implements InterfaceR  {

    @Override
    public void testMethod(String data) {

    }

    @Override
    public void testMethod(A data) {

    }

    @Override
    protected B testR(String x) {
        return super.testR(x);
    }
}
