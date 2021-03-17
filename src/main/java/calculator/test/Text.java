package calculator.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Text {

    private static volatile boolean needQuit = false;
    private static volatile boolean canQuit = false;
    private static volatile String currentPrompt = null;
    private static final String commandsLine = "You need to write down the true translation of these words:" + "\n Write the translation of - Dubious\n";


    public static void main(String[] args) throws IOException, InterruptedException {
        // main loop
        while (!needQuit) {
            getCommand();
        }
        while (!canQuit) {
            Thread.sleep(1);
        }
    }

    private static int sum(int x, int y){
        return x + y;
    }

    private static void getCommand() {
        String command = promptString(commandsLine);
        try {
            int x = Integer.parseInt(command.substring(0, 1));
            int y = Integer.parseInt(command.substring(1));
            System.out.println(sum(x, y));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
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
}
