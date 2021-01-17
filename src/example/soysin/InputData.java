package example.soysin;

import java.util.ArrayList; //import arraylist
import java.util.List; //import list
import java.util.Scanner; // import scanner for get argument from terminal

public class InputData {

    public static void mainInputData(){
        List<String> stringList = InputData.inputAlphabet();
        Integer numberOfState = InputData.inputNumberOfState();
        List<String> listState = InputData.listStates(numberOfState);
        String startState = InputData.inputStartState(listState);
        List<String> listFinalState = InputData.listFinalState(listState);
        List<List<String>> transactions = InputData.transactions(listState,stringList);

        FAModel faModel = new FAModel(stringList,numberOfState, listState, startState, listFinalState, transactions);

        System.out.println("w = "+faModel.getListAlphabet());
        System.out.println("number of state = "+numberOfState);
        System.out.println("list of state : "+ listState.toString());
        System.out.println("Start state is : "+startState);
        System.out.println("Final state is : "+listFinalState.toString());
        System.out.println("transaction : "+transactions.toString());
        for (List<String> s: transactions) {
            System.out.println(s.get(0) + "----"+ s.get(1)+"--->"+ s.get(2));
        }
    }
    // function for user input Alphabet
    public static List<String> inputAlphabet() {
        //create list for store all alphabet
        List<String> strings = new ArrayList<>();

        //get argument use scanner
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter alphabets(a b ..): ");

        //create string for get data from user terminal
        String string = myObj.nextLine();

        //cut alphabet in string and add it to list
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                strings.add(string.charAt(i) + "");
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
    public static List<String> listStates(Integer numberOfState) {
        //list store state
        List<String> listStates = new ArrayList<>();
        for (int i = 0; i < numberOfState; i++) {
            String state = "q" + i;
            listStates.add(state);
        }
        System.out.println("list of state : " + listStates.toString());
        return listStates;
    }

    //function for user input start state
    public static String inputStartState(List<String> listState) {

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
    public static boolean stateIsValid(String state, List<String> listState) {
        for (String s : listState) {
            // if state is in listState
            if (s.equals(state)) {
                return true;
            }
        }
        //if state is not in listState
        return false;
    }

    //function for user input final state
    public static List<String> listFinalState(List<String> listState) {

        //get argument use scanner
        Scanner myObj = new Scanner(System.in);

        //list for store list of final state
        List<String> listFinalState = new ArrayList<>();
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
                listFinalState.add(finalState);
            }
        }
        return listFinalState;
    }

    //function for user input transaction
    public static List<List<String>> transactions(List<String> listState,List<String> listAlphabet) {

        //get argument use scanner
        Scanner myObj = new Scanner(System.in);
        System.out.println("when you want finish your input pls input word | done |!");
        System.out.println("example:q0 transaction by a to q1 you will input | q0 a q1 |");
        System.out.println("Enter transactions : ");

        //create [][] store transactions
        List<List<String>> transactions = new ArrayList<>();
        int test = 1;
        while (test == 1) {
            String transaction = myObj.nextLine();
            //if exit finish user input
            if (transaction.equals("done")) {
                test = 2;
                continue;
            }

            List<String> listTransaction = listCutString(transaction);
            if (!checkTransaction(listTransaction,listState,listAlphabet)){
                System.out.println(listTransaction.toString()+" is incorrect");
                continue;
            }
            transactions.add(listTransaction);
        }
        return transactions;
    }
    //function for check transaction
    public static boolean checkTransaction(List<String> listTransaction,List<String> listState,List<String> listAlphabet){
        if(listTransaction.size() != 3){
            return false;
        }else if(!stateIsValid(listTransaction.get(0),listState) || !stateIsValid(listTransaction.get(2),listState)){
            return false;
        }
        else return checkAlphabet(listTransaction.get(1), listAlphabet);
    }
    //function for check alphabet
    public static boolean checkAlphabet(String alphabet,List<String> listAlphabet){
        for (String s: listAlphabet) {
            if (s.equals(alphabet)){
                return true;
            }
        }
        return false;
    }
    //function for cut string in string
    public static List<String> listCutString(String string){
        //for store list cut string
        List<String>  listCutString= new ArrayList<>();
        String subString="";
        for (int i = 0 ; i < string.length() ; i++){
            if(string.charAt(i) == ' '){
                listCutString.add(subString);
                subString ="";
            }else if(i == string.length()-1){
                subString = subString + string.charAt(i);
                listCutString.add(subString);
                subString ="";
            }
            else{
                subString = subString + string.charAt(i);
            }
        }
        return listCutString;
    }
}
