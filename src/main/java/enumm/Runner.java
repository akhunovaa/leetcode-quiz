package enumm;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) throws ClassNotFoundException {
//        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
//
//        System.out.println(dayOfWeek);
//
//        if (dayOfWeek==DayO  fWeek.MONDAY) {
//            System.out.println(dayOfWeek);
//        }
//        Runner runner = new Runner();
//        runner.printClassLoaders();

    }

    public void printClassLoaders() throws ClassNotFoundException {

        System.out.println("Classloader of this class:"
                + Runner.class.getClassLoader());

        System.out.println("Classloader of Object:"
                + Object.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
        System.out.println("Classloader of ArrayList:"
                + ClassLoader.class.getClassLoader());
    }
}
