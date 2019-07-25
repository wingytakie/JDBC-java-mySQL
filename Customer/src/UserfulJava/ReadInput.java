package UserfulJava;

import java.util.Scanner;

public class ReadInput {
    private Scanner scanner = new Scanner(System.in);
    private String userInput;
    private int intInput;

    public ReadInput() {

    }

    public String Input(){
        userInput = scanner.next();
        return userInput;
    }

    public int IntInput(){
        intInput = scanner.nextInt();
        return intInput;
    }
}
