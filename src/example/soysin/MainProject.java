package example.soysin;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.*;
import java.util.Scanner;

public class MainProject {
    public static void main(String[] args){
        JSONArray FAs = Database.readDataFromFile();
        //System.out.println(FAs);

        int num = 0;
        while (num != 7){
            menu();
            int num1 = choose();
            switch (num1){
                case 1:
                    System.out.println("");
                    JSONObject jsonObject = InputData.mainInputData(1);
                    InputData.output(jsonObject);
                    FAs.add(jsonObject);
                    Database.writeDataToFile(FAs);
                    break;
                case 2:
                    JSONObject object = new JSONObject();
                    show(FAs);
                    while(true){
                        System.out.println("");
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Which FA that you want to test: ");

                        if (scanner.hasNextInt()){
                            int n = scanner.nextInt();
                            object = (JSONObject) FAs.get(n);
                        }

                        if (TestFA.testFa(object)) {
                            System.out.println("This is DFA");
                        }
                        else {
                            System.out.println("This is NFA");
                        }
                        if (test()){
                            num = 2;
                            continue;
                        }
                        break;
                    }
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
                    show(FAs);
                    break;
                case 7:
                    System.out.println("Thank YOU!");
                    num = num1;
                    break;
            }

        }
    }
    private static boolean test(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.print("Do you want to test again(yes or no)?:");
        String s = scanner.nextLine();
        if (s.equals("yes")){
            return true;
        }
        return false;
    }
    private static void show(JSONArray FAs){
        System.out.println("All FA's: ");
        for (int i = 0; i < FAs.size(); i++) {
            JSONObject jsonObject1 = (JSONObject) FAs.get(i);
            //System.out.println(jsonObject1);
            System.out.println("FA "+i+":");
            InputData.output(jsonObject1);
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
        System.out.println("6. Show all FA's");
        System.out.println("7. Exit\n");

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
