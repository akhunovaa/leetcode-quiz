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
        //int  answer = solituion.singleNumber(new int[]{1, 1, 2, 2, 5, 7, 7, 9, 9});
//        int  answer = solituion.doMethod();

        Runner runner = new Runner();
//        System.out.println(runner.checkRecord("PPALLP")); // PPALLL
//        System.out.println(runner.checkRecord("PPALLL")); // PPALLP
//        System.out.println(runner.checkRecord("LALL")); // PPALLP
//        System.out.println(runner.checkRecord("LPLPLPLPLPL")); // PPALLP
        System.out.println(runner.checkRecord("LALL"));



        int r = 4;
        int t = 7;


//        System.out.println("r:" + r);
//        System.out.println("t:" + t);

        r = r ^ t;
        t = t ^ r;
        r = r ^ t;
//        System.out.println("r:" + r);
//        System.out.println("t:" + t);

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

    public boolean checkRecord(String s) {
        char[] charArray = s.toCharArray();
        int absentCount = 0;
        int lateCount = 0;
        for (char c : charArray) {
            if(c == 'A') {
                absentCount++;
                if (lateCount <= 2) {
                    lateCount = 0;
                }
            } else  if(c == 'L') {
                lateCount++;
            } else  if(c == 'P') {
                if (lateCount >= 3) {
                    return false;
                }
                lateCount = 0;
            }

        }
        return absentCount < 2 && lateCount < 3;
    }
}
