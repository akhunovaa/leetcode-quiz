import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Vector;

public class Runner {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Field f = ClassLoader.class.getDeclaredField("classes");
        f.setAccessible(true);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Vector<Class> classes =  (Vector<Class>) f.get(classLoader);
        System.out.println(classes);
        Solution solituion = new Solution();
        int[] answer = solituion.selectionSort(new int[]{});
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
