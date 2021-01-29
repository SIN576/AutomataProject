package example.soysin;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class TestFA {
    //test case
    public static void main(String[] args) {
        JSONArray listFa = new JSONArray();
        listFa.add(Test.dfa());
        listFa.add(Test.nfa());
        listFa.add(Test.nfa1());
        listFa.add(Test.nfa2());

        for (int i = 0; i < listFa.size(); i++) {
            testFa((JSONObject) listFa.get(i));
        }
    }
    //function test fa
    protected static boolean testFa(JSONObject fa){
        JSONArray alphabets = (JSONArray) fa.get("alphabets");
        JSONArray transactions = (JSONArray) fa.get("transactions");
        Integer numberOfState = (Integer) fa.get("numberOfState");
       // checkDuplicateT(transactions,numberOfState);
        if (alphabets.size()*numberOfState != transactions.size()){//if total transaction not the number of alphabet * number of State
            System.out.println("NFa1");
        }else if (checkE(transactions)){//if have E transaction
            System.out.println("NFa2");
        }else if (checkTransaction(transactions,numberOfState) || checkDuplicateT(transactions,numberOfState)){
            System.out.println("NFa3");
        }
        else{
            System.out.println("DFa");
        }
        return false;
    }
    protected static boolean checkDuplicateT(JSONArray transactions, Integer numberOfState){
        ArrayList<String> stateTransactions = new ArrayList<>();
        for (int i = 0; i < numberOfState; i++) {
            stateTransactions.add("0");
        }
        for (int i = 0; i < transactions.size(); i++) {
            JSONArray transaction = (JSONArray) transactions.get(i);

            Object object = transaction.get(0);
            String string = object.toString();
            char[] arr = string.toCharArray();
            int num = Character.getNumericValue(arr[1]);
            if (stateTransactions.get(num).equals((String) transaction.get(1))){
                return true;
            }
            stateTransactions.set(num, (String) transaction.get(1));
        }
        return false;
    }
    protected static boolean checkTransaction(JSONArray transactions,Integer numberOfState){
        ArrayList<Integer> stateTransactions = new ArrayList<>();
        for (int i = 0; i < numberOfState; i++) {
            stateTransactions.add(0);
        }
        for (int i = 0; i < transactions.size(); i++) {
            JSONArray transaction = (JSONArray) transactions.get(i);

            Object object = transaction.get(0);
            String string = object.toString();
            char[] arr = string.toCharArray();
            int num = Character.getNumericValue(arr[1]);
            stateTransactions.set(num,stateTransactions.get(num)+1);
        }
        for (int i = 0; i < stateTransactions.size(); i++) {
            int num = stateTransactions.get(0);
            if (num != stateTransactions.get(i)){
                return true;
            }
        }
        return false;
    }
    protected static boolean checkE(JSONArray transactions){
        for (int i = 0; i < transactions.size(); i++) {
            JSONArray transaction = (JSONArray) transactions.get(i);
            if (transaction.get(1).equals("o")){
                return true;
            }
        }
        return false;
    }
}
