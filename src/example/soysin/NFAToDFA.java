package example.soysin;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class NFAToDFA {
    public static void main(String[] args) {

        //convertNFAtoDFA(Test.nfa());
        convertNFAtoDFA(Test.nfaE());
    }
    //function convert nfa to dfa
    public static JSONObject convertNFAtoDFA(JSONObject nfa){
        JSONObject jsonObject = new JSONObject();
        JSONArray transactions = (JSONArray) nfa.get("transactions");
//        transaction("q0","a",transactions);
//        transaction("q0","b",transactions);
//        transaction("q1","a",transactions);
//        transaction("q1","b",transactions);
        for (int i = 0; i < transactions.size(); i++) {
            JSONArray transaction = (JSONArray) transactions.get(i);
            isValidE((String) transaction.get(0),transactions);
          //  System.out.println(transaction.get(0)+"--->"+transaction.get(1)+"--->"+transaction.get(2));
        }
        return jsonObject;
    }
    //function find sate
    public static String transaction(String state, String alphabet,JSONArray transactions){
        String toState ="Empty";

        for (int i = 0; i < transactions.size() ; i++) {
            JSONArray transaction = (JSONArray) transactions.get(i);
            if (state.equals(transaction.get(0)) && alphabet.equals(transaction.get(1))){
                System.out.println(transaction.get(2));
                toState = (String) transaction.get(2);
                return toState;
            }
        }
        System.out.println(toState);
        return toState;
    }
    //function check is valid E transaction or not
    public static String isValidE(String state,JSONArray transactions){
        for (int i = 0; i < transactions.size(); i++) {
            JSONArray transaction = (JSONArray) transactions.get(i);
            if (state.equals(transaction.get(0)) && transaction.get(1).equals("o")){
                System.out.println(transaction.get(0)+"--->"+transaction.get(1)+"--->"+transaction.get(2));
                return "true";
            }
            System.out.println(state+"--->"+transaction.get(1));
        }
        return   "";
    }
}
