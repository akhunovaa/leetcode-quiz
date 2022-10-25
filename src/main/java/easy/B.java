package easy;

import java.io.FileNotFoundException;
import java.net.ConnectException;

public class B extends A {

    @Override
    protected B testR(String x) {
        return this;
    }
}
