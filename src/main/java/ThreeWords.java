
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeWords {

    private static volatile boolean needQuit = false;
    private static volatile boolean canQuit = false;
    private static volatile String currentPrompt = null;

    private static final String commandsLine = "You need to write down the true translation of these words:" + "\n Write the translation of - Dubious\n";

    public static final void main(String[] args) throws InterruptedException {
        // main loop
        while (!needQuit) {
            getCommand();
        }
        while (!canQuit) {
            Thread.sleep(1);
        }

    }

    private static void getCommand() {
        String command = promptString(commandsLine);
        try {
            switch (command) {
                case "сомнительный": {
                    System.out.println("Right");
                    needQuit = true;
                    canQuit = true;
                    break;
                }
                case "gc":
                    System.out.println("Wrong");
                    break;
                default:
                    System.err.println("Wrong");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            print("Not enough arguments");
        }
    }

    private static String promptString(String prompt) {
        System.out.print(prompt);
        currentPrompt = prompt;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentPrompt = null;
        return str;
    }

    private static void print(String str) {
        if (currentPrompt != null) {
            System.out.println("");
        }
        System.out.println(str);
        if (currentPrompt != null) {
            System.out.print(currentPrompt);
        }
    }

}
