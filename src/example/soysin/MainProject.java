package example.soysin;

import java.awt.*;
import java.util.Scanner;

public class MainProject {
    public static void main(String[] args){

        int num = 0;
        while (num != 6){
            menu();
            int num1 = choose();
            switch (num1){
                case 1:
                    FAModel faModel = InputData.mainInputData(1);
                    break;
                case 2:
                    TestFA.testFa();
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 6:
                    System.out.println("Thank YOU!");
                    num = num1;
                    break;
            }

        }
    }
    private static void menu(){
        System.out.println("*******Automata Project!********");
        System.out.println("=========Team 5 Cs G5!==========\n");
        System.out.println("1. Input your final automata");
        System.out.println("2. Test if FA is non-deterministic or deterministic");
        System.out.println("3. Test if a string is accept in FA");
        System.out.println("4. Construct an equivalent DFA from an NFA");
        System.out.println("5. Minimize a DFA");
        System.out.println("6. Exit\n");

    }
    private static int choose(){
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of menu: ");
        if (!scanner.hasNextInt()){
            System.out.println("number of menu is integer!");
            System.out.print("Re-");
            number = choose();
        }else {
            number = scanner.nextInt();

        }
        if (!(number >0 && number<= 6)){
            System.out.println("number of menu is in range(1 to 6)!");
            System.out.print("Re-");
            number = choose();
        }
        return number;
    }
}
