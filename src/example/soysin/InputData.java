package example.soysin;

import org.json.JSONArray;

import java.util.ArrayList; //import arraylist
import java.util.List; //import list
import java.util.Scanner; // import scanner for get argument from terminal

public class InputData {

    public static FAModel mainInputData(Integer num){
        JSONArray stringList = InputData.inputAlphabet();
        Integer numberOfState = InputData.inputNumberOfState();
        JSONArray listState = InputData.listStates(numberOfState);
        String startState = InputData.inputStartState(listState);
        JSONArray listFinalState = InputData.listFinalState(listState);
        JSONArray transactions = InputData.transactions(listState,stringList);

        FAModel faModel = new FAModel(stringList,numberOfState, listState, startState, listFinalState, transactions);

        System.out.println("w = "+faModel.getListAlphabet());
        System.out.println("number of state = "+faModel.getNumberOfState());
        System.out.println("list of state : "+ faModel.getListState());
        System.out.println("Start state is : "+faModel.getStartState());
        System.out.println("Final state is : "+faModel.getFinalState());
        System.out.println("transaction : "+faModel.getTransaction());
        System.out.println(transactions.get(1));
        if(num == 1){
            System.out.print("\nDo you want back?(yes/no): ");
            Scanner scanner = new Scanner(System.in);
            String ans = scanner.nextLine();
            if (ans.equals("no")){
                faModel = mainInputData(1);
            }
        }
        return faModel;
    }

    // function for user input Alphabet
    public static JSONArray inputAlphabet() {
        //create list for store all alphabet
        JSONArray strings = new JSONArray();

        //get argument use scanner
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter alphabets(a b ..): ");

        //create string for get data from user terminal
        String string = myObj.nextLine();

        //cut alphabet in string and add it to list
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                strings.put(string.charAt(i) + "");
            }
        }

        return strings;
    }

    //function for user input number of state
    public static Integer inputNumberOfState() {

        //get argument use scanner
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter number of State: ");

        //create variable for state
        Integer numberOfState;
        if (myObj.hasNextInt()) {
            numberOfState = myObj.nextInt();
        } else {
            System.out.println("Number of state is Integer!");
            System.out.print("Re-");
            numberOfState = inputNumberOfState();
        }
        return numberOfState;
    }

    //function for create state
    public static JSONArray listStates(Integer numberOfState) {
        //list store state
        JSONArray listStates = new JSONArray();
        for (int i = 0; i < numberOfState; i++) {
            String state = "q" + i;
            listStates.put(state);
        }
        System.out.println("list of state : " + listStates.toString());
        return listStates;
    }

    //function for user input start state
    public static String inputStartState(JSONArray listState) {

        //get argument use scanner
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter start state : ");

        //string store start state
        String startState = myObj.nextLine();
        // if state is not in listState re-enter again
        if (!stateIsValid(startState, listState)) {
            System.out.println(startState + " is invalid!");
            System.out.print("Re-");
            startState = inputStartState(listState);
        }
        return startState;

    }

    //function check state is valid or invalid
    public static boolean stateIsValid(Object state, JSONArray listState) {
        for (Object s : listState) {
            // if state is in listState
            if (s.equals(state)) {
                return true;
            }
        }
        //if state is not in listState
        return false;
    }

    //function for user input final state
    public static JSONArray listFinalState(JSONArray listState) {

        //get argument use scanner
        Scanner myObj = new Scanner(System.in);

        //list for store list of final state
        JSONArray listFinalState = new JSONArray();
        //variable test
        int test = 1;

        System.out.println("when you want finish your input pls input word | done |!");
        System.out.println("Enter final states: ");
        while (test == 1) {
            String finalState = myObj.nextLine();
            //if exit finish user input
            if (finalState.equals("done")) {
                test = 2;
            } else if (!stateIsValid(finalState, listState)) {
                System.out.println(finalState + " is not invalid");
            } else {
                listFinalState.put(finalState);
            }
        }
        return listFinalState;
    }

    //function for user input transaction
    public static JSONArray transactions(JSONArray listState,JSONArray listAlphabet) {

        //get argument use scanner
        Scanner myObj = new Scanner(System.in);
        System.out.println("when you want finish your input pls input word | done |!");
        System.out.println("example:q0 transaction by a to q1 you will input | q0 a q1 |");
        System.out.println("if q0 transaction by obsilon to q1 you will input | q0 o q1 |");
        System.out.println("Enter transactions : ");

        //create [][] store transactions
        JSONArray transactions = new JSONArray();
        int test = 1;
        while (test == 1) {
            String transaction = myObj.nextLine();
            //if exit finish user input
            if (transaction.equals("done")) {
                test = 2;
                continue;
            }

            JSONArray listTransaction = listCutString(transaction);
            if (!checkTransaction(listTransaction,listState,listAlphabet)){
                System.out.println(listTransaction.toString()+" is incorrect");
                continue;
            }
            transactions.put(listTransaction);
        }
        return transactions;
    }
    //function for check transaction
    public static boolean checkTransaction(JSONArray listTransaction,JSONArray listState,JSONArray listAlphabet){
        if(listTransaction.length() != 3){
            return false;
        }else if(!stateIsValid(listTransaction.get(0),listState) || !stateIsValid(listTransaction.get(2),listState)){
            return false;
        }
        else return checkAlphabet(listTransaction.get(1), listAlphabet);
    }
    //function for check alphabet
    public static boolean checkAlphabet(Object alphabet,JSONArray listAlphabet){
       // listAlphabet.add("o");
        for (Object s: listAlphabet) {
            if (s.equals(alphabet) || alphabet.equals("o")){
                return true;
            }
        }
        return false;
    }
    //function for cut string in string
    public static JSONArray listCutString(String string){
        //for store list cut string
       JSONArray  listCutString= new JSONArray();
        String subString="";
        for (int i = 0 ; i < string.length() ; i++){
            if(string.charAt(i) == ' '){
                listCutString.put(subString);
                subString ="";
            }else if(i == string.length()-1){
                subString = subString + string.charAt(i);
                listCutString.put(subString);
                subString ="";
            }
            else{
                subString = subString + string.charAt(i);
            }
        }
        return listCutString;
    }
}
