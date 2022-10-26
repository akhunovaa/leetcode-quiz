import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Runner {

    private static int INC_DATA = 0;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

//        Field f = ClassLoader.class.getDeclaredField("classes");
//        f.setAccessible(true);
//
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        Vector<Class> classes =  (Vector<Class>) f.get(classLoader);
//        System.out.println(classes);
        Solution solituion = new Solution();
//        int[] ansxwer = solituion.heapSort(new int[]{});
//        doRecursiveMethod();
//        Runner runner = new Runner();
//        runner.doRecursiveVirtualMethod();
        int  answer = solituion.singleNumber(new int[]{1, 1, 2, 2, 5, 7, 7, 9, 9});
        System.out.println(answer);

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

    public static final void doRecursiveMethod() {
        System.out.println(INC_DATA++);
        doRecursiveMethod(); //9320 9366 9341
    }

    void doRecursiveVirtualMethod(){
        System.out.println(INC_DATA++); // 9209
        this.doRecursiveVirtualMethod();
    }
}
